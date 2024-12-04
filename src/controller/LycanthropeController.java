package controller;

import modele.lycanthrope.Colonie;
import modele.lycanthrope.Lycanthrope;
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
        String choix = joueur.choixActionLycanthrope();
        if(choix.equals("Meute")){
            int choixMeute = joueur.choixTourChoixMeute(colonie.getListeMeutes());
            if (choixMeute < 0 || choixMeute > colonie.getListeMeutes().size()) {
                System.out.println("Meute invalide.");
                return;
            }
            Meute meuteChoisi = colonie.getListeMeutes().get(choixMeute);

            Lycanthrope choixLycanthrope = joueur.choisirLycanthrope(meuteChoisi.getListeMembres());

            String action = joueur.demandeActionLycanthrope();
            switch (action.toLowerCase()){
                case "dominer" :
                    dominer(meuteChoisi, choixLycanthrope);
                    break;
                case "hurler":
                    hurler(choixLycanthrope);
                    break;
                case "quitter":
                    quitter(meuteChoisi, choixLycanthrope);
                    break;
                case "observer":
                    System.out.println(choixLycanthrope.afficherCaracteristiques());
                    break;
                default:
                    System.out.println("Choix invalide. Réessayez.");
            }
        } else if (choix.equals("Seul")) {
            Lycanthrope choixLycanthrope = joueur.choisirLycanthrope(colonie.getListeSolitaire());

            String action = joueur.demandeActionLycanthrope(); // À changer.
            switch (action.toLowerCase()){
                case "meute":
                  //TODO
                    break;
                case "observer":
                    System.out.println(choixLycanthrope.afficherCaracteristiques());
                    break;
                default:
                    System.out.println("Choix invalide. Réessayez.");
            }
        }
    }

    private void dominer(Meute meute, Lycanthrope lycanthrope){
        ArrayList liste = meute.rechercherLycanthrope(lycanthrope);
        meute.domination(liste);
    }

    private void hurler(Lycanthrope lycanthrope){
        System.out.println(lycanthrope.hurlementAppartenanceMeute());
    }

    private void quitter(Meute meute, Lycanthrope lycanthrope){
        Lycanthrope newLycanthrope = meute.devenirSolitaire(lycanthrope);
        if(newLycanthrope != null){
            colonie.addSolitaire(newLycanthrope);
            System.out.println(lycanthrope.getNom() +
                    " a décidé de quitter sa meute, mort de honte, la queue entre les jambes.");
        }else{
            System.out.println(lycanthrope.getNom() +
                    " ne peut pas quitter la meute, il a tant de choses à accomplire !");
        }
    }

    private void meute(){
        //TODO
    }
}
