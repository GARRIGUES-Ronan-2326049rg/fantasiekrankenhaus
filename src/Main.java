import controller.HopitalController;
import controller.JoueurController;
import modele.monstre.*;
import modele.*;

public class Main {

    public static void main(String[] args) {
       Hopital hopital = new Hopital();
       hopital.initialisationMedecin();
       hopital.initialisationService();


       JoueurController joueur = new JoueurController();
       HopitalController hopitalController = new HopitalController();



        Monstre monstre1 = MonstreFactory.creerMonstreAleatoire();


        joueur.afficheRegle();
        System.out.println("Monstre 1 : " + monstre1);

        monstre1.evoluerMaladies();
        if (monstre1.estMort()) {
            System.out.println("Le monstre est mort");
        }

        while (!monstre1.estMort()) {
            joueur.soignerUneMaladie(monstre1);
            monstre1.evoluerMaladies();
            if (monstre1.estMort()) {
                System.out.println("Le monstre est mort");
            }
        }
    }
}

