package controller;

import modele.lycanthrope.Colonie;
import modele.lycanthrope.Meute;

import java.util.ArrayList;

public class LycanthropeController {
    private JoueurController joueur = new JoueurController();
    private boolean jeuEnCours = true;
    private Colonie colonie = new Colonie(new ArrayList<>());

    public void lancerJeu(){
        initialiserColonie();
        joueur.afficheRegleLycanthrope();

        while(jeuEnCours){
            String choix = joueur.choixTourLycanthrope();
            switch (choix.toLowerCase()){
                case "agir":
                    agir();
                    break;
                case "fin":
                    jeuEnCours = false;
                    System.out.println("FIN DU JEU");
                    break;
                default:
                    System.out.println("Choix invalide. Réessayez.");
            }
        }
    }

    private void initialiserColonie(){
        colonie.initialiserColonie();
    }

    private void agir(){
        int choixMeute = joueur.choixTourChoixMeute(colonie.getListeMeutes());
        if (choixMeute < 0 || choixMeute > colonie.getListeMeutes().size()) {
            System.out.println("Meute invalide.");
            return;
        }

        Meute meuteChoisi = colonie.getListeMeutes().get(choixMeute - 1);
        String action = joueur.demandeActionLycanthrope();
        switch (action.toLowerCase()){
            // --> Provoquer une provocation entre deux loups (limité dans une journée)
            // --> Demander à un loup de hurler son appartenance à une meute.
            // --> Forcer un loup ayant rater une domination ou de rang Omicron a quitter la meute (il devient un loup solitaire).
            // --> Forcer deux loups solitaires à fonder une nouvelle meute (limité entre plusieurs tours).
        }
    }

    private void dominer(){
        //TODO
    }

    private void hurler(){
        //TODO
    }

    private void quitter(){
        //TODO
    }

    private void meute(){
        //TODO
    }
}
