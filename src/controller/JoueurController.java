package controller;
import modele.Medecin;
import modele.monstre.Monstre;
import view.JoueurView;

import java.util.ArrayList;
import java.util.Scanner;

public class JoueurController {

    private Scanner sc = new Scanner(System.in);
    private JoueurView view = new JoueurView();

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

    public void soignerUneMaladie(Monstre monstre) {

        if (monstre.getListeMaladie().isEmpty()) {
            System.out.println("Le monstre " + monstre.getNom() + " n'a pas de maladies à soigner.");
            return;
        }

        System.out.println("Voici la liste des maladies du monstre " + monstre.getNom() + " :");
        for (int i = 0; i < monstre.getListeMaladie().size(); i++) {
            System.out.println((i + 1) + ". " + monstre.getListeMaladie().get(i));
        }

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
            monstre.soignerMaladie(nomMaladie);
        } else {
            System.out.println("Numéro invalide. Aucun soin effectué.");
        }

    }

}


