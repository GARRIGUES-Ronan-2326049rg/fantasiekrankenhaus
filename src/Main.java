import controller.HopitalController;
import controller.JoueurController;
import modele.monstre.*;
import modele.*;
import modele.service.*;

import java.util.ArrayList;

public class Main {
    private boolean enJeu = true;

    public void main(String[] args) {
       Hopital hopital = new Hopital();
       hopital.initialisationMedecin();
       hopital.initialisationService();
       int jour = 1;

       JoueurController joueur = new JoueurController();
       HopitalController hopitalController = new HopitalController();
       joueur.afficheRegle();

       while (enJeu) {
           System.out.println("Vous êtes au jour : " + jour);

           // Partie sur le jeu du joueur

           String choixTour = joueur.choixTour();
           if (choixTour.equals("fin")) { this.enJeu = false;}
           else if (choixTour.equals("agir")){
               int choixTourMedecin = joueur.choixTourChoixMedecin(hopital.getListeMedecin());
               Medecin medecinTour = hopital.getListeMedecin().get(choixTourMedecin);
               String action = joueur.demandeAction();

               switch (action) {
                   case "Examiner":
                       //
                       break;
                   case "Soigner":

                       break;

                   case "Réviser":
                       break;

                   case "Transferer":

                       break;
               }


           }
           else{
               System.out.println("Incorrect choix");
           }



       }

    }
}
