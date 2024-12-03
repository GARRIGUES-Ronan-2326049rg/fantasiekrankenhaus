package controller;
import modele.Medecin;
import modele.lycanthrope.Lycanthrope;
import modele.lycanthrope.Meute;
import modele.monstre.Monstre;
import modele.service.ServiceMedical;
import view.JoueurView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JoueurController {

    private static final Scanner sc = new Scanner(System.in);
    private final JoueurView view = new JoueurView();

    public void afficheRegle() {
        JoueurView view = new JoueurView();
        System.out.println(view.presentationJeu());
    }

    public void afficheRegleLycanthrope() {
        JoueurView view = new JoueurView();
        System.out.println(view.presentationJeuLycanthrope());
    }

    public void choixJeu(){
        view.demandeJeu();
        String jeu = sc.nextLine();
        if(jeu.equals("Hopital")){
            HopitalController hopitalController = new HopitalController();
            hopitalController.lancerJeu();
        }else if(jeu.equals("Loups")){
            LycanthropeController lycanthropeController = new LycanthropeController();
            lycanthropeController.lancerJeu();
        }
    }

    public String choixTour() {
        this.view.demandeChoix();
        return sc.nextLine();
    }

    public String choixTourLycanthrope() {
        this.view.demanderChoixLycanthrope();
        return sc.nextLine();
    }

    public int choixTourChoixMedecin(ArrayList<Medecin> listeMedecin) {
        this.view.demandeChoixMedecin(listeMedecin);
        int choix = sc.nextInt();
        sc.nextLine(); // Consomme le retour à la ligne restant
        return choix;
    }

    public int choixTourChoixMeute(ArrayList<Meute> listeMeute) {
        this.view.demanderChoixMeute(listeMeute);
        int choix = sc.nextInt();
        sc.nextLine(); // Consomme le retour à la ligne restant
        return choix;
    }

    public String demandeAction(){
        this.view.demandeAction();
        return sc.nextLine();
    }

    public String demandeActionLycanthrope(){
        //this.view.demandeActionLycanthrope();
        return sc.nextLine();
    }

    public static void soignerUneMaladie(Monstre monstre) {
        if (monstre.getListeMaladie().isEmpty()) {
            System.out.println("Le monstre " + monstre.getNom() + " n'a pas de maladies à soigner.");
            return;
        }

        System.out.println("Voici la liste des maladies du monstre " + monstre.getNom() + " :");
        for (int i = 0; i < monstre.getListeMaladie().size(); i++) {
            System.out.println((i + 1) + ". " + monstre.getListeMaladie().get(i));
        }


        // Génère une chance aléatoire entre 30 % et 100 % pour chaque soin
        int chanceDeReussite = 30 + new Random().nextInt(31);
        System.out.println("Tentative de soin avec " + chanceDeReussite + "% de chance de réussite.");

        System.out.println("Choisissez un numéro pour soigner une maladie ou entrez 0 pour passer :");
        int choix;
        try {
            choix = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide. Veuillez entrer un numéro.");
            return;
        }

        if (choix == 0) {
            System.out.println("Vous avez décidé de ne pas soigner de maladie pour ce tour.");
        } else if (choix > 0 && choix <= monstre.getListeMaladie().size()) {
            String nomMaladie = monstre.getListeMaladie().get(choix - 1).getNomComplet();




            // Ajout de la chance de réussite
            Random random = new Random();
            int tirage = random.nextInt(100); // Nombre aléatoire entre 0 et 99
            if (Math.random() * 100 < chanceDeReussite) {
                monstre.soignerMaladie(nomMaladie);
                System.out.println("La maladie " + nomMaladie + " a été soignée avec succès !");
            } else {
                System.out.println("La tentative de soigner la maladie " + nomMaladie + " a échoué.");
            }
        } else {
            System.out.println("Numéro invalide. Aucun soin effectué.");
        }
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

    public Meute choisirMeute(ArrayList<Meute> listeMeute) {
        this.view.choisirMeute(listeMeute);
        String choix = sc.nextLine();
        for (Meute meute : listeMeute) {
            if (choix.equals(meute.getNom())) {
                return meute;
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

    public Lycanthrope choisirLycanthrope(ArrayList<Lycanthrope> listeLycanthrope) {
        this.view.choisirLycanthrope(listeLycanthrope);
        String choix = sc.nextLine();
        for (Lycanthrope lycanthrope : listeLycanthrope) {
            if (choix.equals(lycanthrope.getNom())) {
                return lycanthrope;
            }
        }
        return null;
    }
}