import controller.HopitalController;
import controller.JoueurController;
import modele.monstre.*;
import modele.*;
import modele.service.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
       Hopital hopital = new Hopital();
       hopital.initialisationMedecin();
       hopital.initialisationService();

       JoueurController joueur = new JoueurController();
       HopitalController hopitalController = new HopitalController();

    }
}
