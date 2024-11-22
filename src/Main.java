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




       }

    }
}
