package controller;

import modele.lycanthrope.ColonieLycanthrope;
import modele.lycanthrope.Lycanthrope;
import modele.lycanthrope.MeuteLycanthrope;

import java.util.ArrayList;

public class LycanthropeController {
    private JoueurController joueur = new JoueurController();
    private boolean jeuEnCours = true;
    private ColonieLycanthrope colonie = new ColonieLycanthrope(new ArrayList<>());

    public void lancerJeu(){
        initialiserColonie();
        joueur.afficheRegleLycanthrope();

        while(jeuEnCours){
            String choix = joueur.choixTour();
            //Switch case selon les actions possibles :
            // --> Provoquer une provocation entre deux loups (limité dans une journée)
            // --> Demander à un loup de hurler son appartenance à une meute.
            // --> Forcer un loup ayant rater une domination ou de rang Omicron a quitter la meute (il devient un loup solitaire).
            // --> Forcer deux loups solitaires à fonder une nouvelle meute (limité entre plusieurs tours).
        }
    }

    public void initialiserColonie(){
        colonie.initialiserColonie();
    }

    private void agir(){
        //TODO
    }
}
