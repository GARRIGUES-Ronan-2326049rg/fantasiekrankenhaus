package controller;
import modele.Medecin;
import modele.monstre.Monstre;
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

    public String choixTour() {
        this.view.demandeChoix();
        return sc.nextLine();
    }


    public int choixTourChoixMedecin(ArrayList<Medecin> listeMedecin){
        this.view.demandeChoixMedecin(listeMedecin);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public String demandeAction(){
        this.view.demandeAction();
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
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
}