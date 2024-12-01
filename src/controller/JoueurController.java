package controller;

import modele.Medecin;
import modele.monstre.Monstre;
import modele.service.ServiceMedical;
import view.JoueurView;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * La classe JoueurController gère les interactions avec le joueur
 * et collecte les entrées nécessaires pour contrôler le jeu.
 */
public class JoueurController {

    private static final Scanner sc = new Scanner(System.in);
    private final JoueurView view = new JoueurView();

    /**
     * Affiche les règles du jeu en utilisant la vue associée.
     */
    public void afficheRegle() {
        JoueurView view = new JoueurView();
        System.out.println(view.presentationJeu());
    }

    /**
     * Demande au joueur de choisir l'action qu'il souhaite effectuer au cours du tour.
     *
     * @return La chaîne de caractères saisie par le joueur.
     */
    public String choixTour() {
        this.view.demandeChoix();
        return sc.nextLine();
    }

    /**
     * Demande au joueur de choisir un médecin parmi une liste de médecins disponibles.
     *
     * @param listeMedecin Liste des médecins disponibles.
     * @return L'indice du médecin choisi par le joueur.
     */
    public int choixTourChoixMedecin(ArrayList<Medecin> listeMedecin) {
        this.view.demandeChoixMedecin(listeMedecin);
        int choix = sc.nextInt();
        sc.nextLine(); // Consomme le retour à la ligne restant.
        return choix;
    }

    /**
     * Demande au joueur l'action qu'il souhaite que le médecin effectue.
     *
     * @return La chaîne de caractères représentant l'action choisie.
     */
    public String demandeAction() {
        this.view.demandeAction();
        return sc.nextLine();
    }

    /**
     * Permet au joueur de choisir un service parmi une liste de services disponibles.
     *
     * @param listeService Liste des services disponibles.
     * @return Le service choisi par le joueur, ou null si le choix est invalide.
     */
    public ServiceMedical choisirService(ArrayList<ServiceMedical> listeService) {
        this.view.choisirService(listeService);
        String choix = sc.nextLine();
        for (ServiceMedical serviceMedical : listeService) {
            if (choix.equals(serviceMedical.getNom())) {
                return serviceMedical;
            }
        }
        return null;
    }

    /**
     * Demande au joueur de saisir un nouveau budget pour un service.
     *
     * @return Le budget sous forme de chaîne de caractères.
     */
    public String demanderBudget() {
        this.view.demandeBudget();
        return sc.nextLine();
    }

    /**
     * Permet au joueur de choisir un monstre parmi une liste de créatures disponibles.
     *
     * @param listeCreature Liste des créatures disponibles.
     * @return Le monstre choisi par le joueur, ou null si le choix est invalide.
     */
    public Monstre choisirPatient(ArrayList<Monstre> listeCreature) {
        this.view.choisirMonstre(listeCreature);
        String choix = sc.nextLine();
        for (Monstre monstre : listeCreature) {
            if (choix.equals(monstre.getNom())) {
                return monstre;
            }
        }
        return null;
    }
}
