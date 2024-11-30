package controller;
import modele.Medecin;
import modele.monstre.Monstre;
import modele.service.ServiceMedical;
import view.JoueurView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class JoueurController {

    private static final Scanner sc = new Scanner(System.in);
    private final JoueurView view = new JoueurView();

    public void afficheRegle() {
        JoueurView view = new JoueurView();
        System.out.println(view.presentationJeu());
    }

    public String choixTour() {
        this.view.demandeChoix();
        return sc.nextLine();
    }


    public int choixTourChoixMedecin(ArrayList<Medecin> listeMedecin) {
        this.view.demandeChoixMedecin(listeMedecin);
        int choix = sc.nextInt();
        sc.nextLine(); // Consomme le retour à la ligne restant
        return choix;
    }

    public String demandeAction(){
        this.view.demandeAction();
        return sc.nextLine();
    }

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

    public String demanderBudget() {
        this.view.demandeBudget();
        return sc.nextLine();
    }

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