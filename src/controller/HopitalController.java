package controller;

import modele.Hopital;
import modele.service.ServiceMedical;
import modele.monstre.Monstre;
import modele.Medecin;
import modele.Maladie;
import view.JoueurView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class HopitalController {
    private JoueurController joueur = new JoueurController();
    private Hopital hopital = new Hopital();
    private boolean jeuEnCours = true;

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
                    System.out.println("Récap");
                    break;
                default:
                    System.out.println("Choix invalide. Réessayez.");
            }
        }
    }

    private void initialiserHopital() {
        hopital.initialisationMedecin();
        hopital.initialisationService();
        hopital.initialisationMonstre(80, hopital.getListeService());
    }



    private void afficherEtatHopital() {
        //joueur.afficherEtatHopital(services, medecins);
    }

    private void agir() {

        while (hopital.resteAction()){
            int choixMedecin = joueur.choixTourChoixMedecin(hopital.getListeMedecin());
            if (choixMedecin == 99) {
                System.out.println("Fin de tours");
                hopital.nouvelleJournee();
                return;
            }
            else if (choixMedecin > hopital.getListeMedecin().size()) {
                System.out.println("Médecin invalide.");
                return;
            }

            Medecin medecinChoisi = hopital.getListeMedecin().get(choixMedecin);
            String action = joueur.demandeAction();
            switch (action.toLowerCase()) {
                case "soigner":
                    soigner(medecinChoisi);
                    break;
                case "budget":
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
        hopital.nouvelleJournee();
    }

    private void examiner(Medecin medecin) {
        ServiceMedical service = joueur.choisirService(hopital.getListeService());
        if (service != null) {
            medecin.examineService(service);
        }
    }

    private void soigner(Medecin medecin) {
        ServiceMedical service = joueur.choisirService(hopital.getListeService());
        if (service != null) {
            Monstre patient = joueur.choisirPatient(service.getListeCreature());
            if (patient != null) {
                medecin.soignePatient(patient);
            } else {
                System.out.println("Aucun patient sélectionné.");
            }
        } else {
            System.out.println("Aucun service sélectionné.");
        }
    }

    private void reviserBudget(Medecin medecin) {
        ServiceMedical service = joueur.choisirService(hopital.getListeService());
        if (service != null) {
            String nouveauBudget = joueur.demanderBudget();
            service.setBudget(nouveauBudget);
            service.variationBudget();
            System.out.println("Budget mis à jour.");
        }
    }

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

    private void effectuerActionsServices() {
        for (ServiceMedical service : hopital.getListeService()) {
            ArrayList<Monstre> creatures = service.getListeCreature();
            Random random = new Random();
            int actions = Math.min(2, creatures.size());
            for (int i = 0; i < actions; i++) {
                Monstre monstre = creatures.get(random.nextInt(creatures.size()));
                monstre.evoluerMaladies();
            }
        }
    }
}
