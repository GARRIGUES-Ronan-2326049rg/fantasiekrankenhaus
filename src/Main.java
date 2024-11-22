import controller.HopitalController;
import controller.JoueurController;
import modele.monstre.*;
import modele.*;
import modele.service.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final boolean enJeu = true;

    public static void main(String[] args) {
       Hopital hopital = new Hopital();
       hopital.initialisationMedecin();
       hopital.initialisationService();
       JoueurController joueurControlleur = new JoueurController();

       Scanner sc = new Scanner(System.in);

        // Génération d'un monstre aléatoire
        Monstre monstre = MonstreFactory.creerMonstreAleatoire();
        joueurControlleur.afficheRegle();
        System.out.println(monstre);

        int tours = 0;

        while (true) {
            tours++;
            System.out.println("\n--- Tour " + tours + " ---");
            System.out.println("État actuel du monstre :");
            System.out.println(monstre);

            // Vérification de la mort du monstre
            if (monstre.estMort()) {
                System.out.println("Le monstre " + monstre.getNom() + " est mort. Fin de la partie !");
                break;
            }

            // Options pour le joueur
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Soigner une maladie");
            System.out.println("2. Attendre un tour (aucune action)");
            System.out.println("3. Quitter le jeu");

            int choix;
            try {
                choix = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un numéro entre 1 et 3.");
                continue;
            }

            switch (choix) {
                case 1:
                    // Soigner une maladie avec 70 % de chance de succès
                    JoueurController.soignerUneMaladie(monstre);
                    break;
                case 2:
                    // Attente, les maladies évoluent
                    monstre.evoluerMaladies();
                    monstre.attendre();
                    break;
                case 3:
                    System.out.println("Merci d'avoir joué ! À bientôt.");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez entrer un numéro entre 1 et 3.");
            }
        }

        sc.close();
    }



//       while (enJeu) {
//           System.out.println("Vous êtes au jour : " + jour);
//
//           // Partie sur le jeu du joueur
//
//           String choixTour = joueur.choixTour();
//           if (choixTour.equals("fin")) { enJeu = false;}
//           else if (choixTour.equals("agir")){
//               int choixTourMedecin = joueur.choixTourChoixMedecin(hopital.getListeMedecin());
//               Medecin medecinTour = hopital.getListeMedecin().get(choixTourMedecin);
//               String action = joueur.demandeAction();
//
//               switch (action) {
//                   case "Examiner":
//                       //
//                       break;
//                   case "Soigner":
//
//                       break;
//
//                   case "Réviser":
//                       break;
//
//                   case "Transferer":
//
//                       break;
//               }
//
//
//           }
//           else{
//               System.out.println("Incorrect choix");
//           }





       }

