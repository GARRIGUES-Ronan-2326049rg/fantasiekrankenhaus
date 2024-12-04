package controller;

import modele.Hopital;
import modele.Recapitulatif;
import modele.service.ServiceMedical;
import modele.monstre.Monstre;
import modele.Medecin;
import modele.Maladie;
import view.JoueurView;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * La classe HopitalController gère la logique du jeu pour un hôpital de monstres.
 * Elle orchestre les interactions entre les joueurs, les médecins, les services et les monstres.
 */
public class HopitalController {
    private JoueurController joueur = new JoueurController();
    private Hopital hopital = new Hopital();
    private boolean jeuEnCours = true;


    /**
     * Démarre le jeu et exécute la boucle principale.
     */
    public void lancerJeu() {
        initialiserHopital();
        joueur.afficheRegle();

        while (jeuEnCours) {
            afficherEtatHopital();
            String choix = joueur.choixTour();
            switch (choix.toLowerCase()) {
                case "agir":
                    agir();
                    effectuerActionsServices();
                    break;
                case "finir":
                    jeuEnCours = false;
                    System.out.println("FIN DU JEU\n");
                    Recapitulatif.getInstance().afficherRecapitulatif();/*
                    Recapitulatif.getInstance().creerTable();
                    Recapitulatif.getInstance().sauvegarderDansBaseDeDonnees();
                    Recapitulatif.getInstance().afficherTousLesRecaps();*/
                    break;
                default:
                    System.out.println("Choix invalide. Réessayez.");
            }
        }
    }

    /**
     * Initialise l'hôpital avec des médecins, des services et des monstres.
     */
    private void initialiserHopital() {
        hopital.initialisationMedecin();
        hopital.initialisationService();
        hopital.initialisationMonstre(30, hopital.getListeService());
    }

    /**
     * Affiche l'état actuel de l'hôpital (à implémenter dans JoueurView).
     */
    private void afficherEtatHopital() {
        // joueur.afficherEtatHopital(services, medecins);
    }

    /**
     * Permet au joueur de réaliser des actions avec les médecins disponibles.
     */
    private void agir() {
        while (hopital.resteAction()) {
            int choixMedecin = joueur.choixTourChoixMedecin(hopital.getListeMedecin());
            if (choixMedecin == 99) {
                System.out.println("Fin de tours");
                hopital.nouvelleJournee();
                return;
            } else if (choixMedecin > hopital.getListeMedecin().size()) {
                System.out.println("Médecin invalide.");
                return;
            }

            Medecin medecinChoisi = hopital.getListeMedecin().get(choixMedecin);
            if (medecinChoisi.getActionPossible() > 0) {
                String action = joueur.demandeAction();
                switch (action.toLowerCase()) {
                    case "soigner":
                        soigner(medecinChoisi);
                        break;
                    case "reviser":
                        reviserBudget(medecinChoisi);
                        break;
                    case "transfert":
                        transfererPatient(medecinChoisi);
                        break;
                    case "examiner":
                        examiner(medecinChoisi);
                        break;
                    default:
                        System.out.println("Action invalide.");
                }
            }
        }
        hopital.nouvelleJournee();
    }

    /**
     * Permet à un médecin d'examiner un service.
     *
     * @param medecin Le médecin réalisant l'examen.
     */
    private void examiner(Medecin medecin) {
        ServiceMedical service = joueur.choisirService(hopital.getListeService());
        if (service != null) {
            medecin.examineService(service);
        }
    }

    /**
     * Permet à un médecin de soigner un patient.
     *
     * @param medecin Le médecin réalisant le soin.
     */
    private void soigner(Medecin medecin) {
        ServiceMedical service = joueur.choisirService(hopital.getListeService());
        if (service != null) {
            Monstre patient = joueur.choisirPatient(service.getListeCreature());
            if (patient != null) {
                medecin.soignePatient(patient, service);
            } else {
                System.out.println("Aucun patient sélectionné.");
            }
        } else {
            System.out.println("Aucun service sélectionné.");
        }
    }

    /**
     * Permet à un médecin de réviser le budget d'un service.
     *
     * @param medecin Le médecin réalisant la révision.
     */
    private void reviserBudget(Medecin medecin) {
        ServiceMedical service = joueur.choisirService(hopital.getListeService());
        if (service != null) {
            String nouveauBudget = joueur.demanderBudget();
            if (service.ameliorer(nouveauBudget)) {
                medecin.reviseBudget(service, nouveauBudget);
                service.variationBudget();
                System.out.println("Budget mis à jour.");
            }
            else {
                System.out.println("Impossible de reviser un budget si haut.");
            }

        }
    }

    /**
     * Permet à un médecin de transférer un patient entre deux services.
     *
     * @param medecin Le médecin réalisant le transfert.
     */
    private void transfererPatient(Medecin medecin) {
        ServiceMedical origine = joueur.choisirService(hopital.getListeService());
        if (origine != null && !origine.getListeCreature().isEmpty()) {
            Monstre patient = joueur.choisirPatient(origine.getListeCreature());
            if (patient != null) {
                ServiceMedical destination = joueur.choisirService(hopital.getListeService());
                if (destination != null && destination.getNombreCreature() < destination.getMaxCreature()) {
                    origine.retirerPatient(patient);
                    destination.ajouterPatient(patient);
                    System.out.println("Patient transféré.");
                } else {
                    System.out.println("Service destination plein ou invalide.");
                }
            } else {
                System.out.println("Aucun patient sélectionné.");
            }
        } else {
            System.out.println("Service origine vide ou invalide.");
        }
    }

    /**
     * Effectue des actions automatiques dans chaque service, telles que l'évolution des maladies.
     */
    private void effectuerActionsServices() {
        for (ServiceMedical service : hopital.getListeService()) {
            for (int i = 0; i < service.getListeCreature().size(); i++) {
                Monstre monstre = service.getListeCreature().get(i);
                monstre.evoluerMaladies();
            }
        }
    }
}
