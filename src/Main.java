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
        Monstre monstre2 = MonstreFactory.creerMonstreAleatoire();
        Monstre monstre3 = MonstreFactory.creerMonstreAleatoire();


        joueur.afficheRegle();
        System.out.println("Monstre 1 : " + monstre1);
        System.out.println("Monstre 2 : " + monstre2);
        System.out.println("Monstre 3 : " + monstre3);

        joueur.afficheMonstre();
    }
}

