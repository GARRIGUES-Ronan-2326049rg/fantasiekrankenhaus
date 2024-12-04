package controller;

import modele.lycanthrope.Colonie;
import modele.lycanthrope.Lycanthrope;
import modele.lycanthrope.Meute;

import java.util.ArrayList;
import java.util.Random;

public class LycanthropeController {
    private JoueurController joueur = new JoueurController();
    private boolean jeuEnCours = true;
    private Colonie colonie = new Colonie(new ArrayList<>());
    private int nbActions = 3;

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
                    nouvelleJournee();
                    break;
                case "hurler":
                    hurler(choixLycanthrope);
                    nouvelleJournee();
                    break;
                case "quitter":
                    quitter(meuteChoisi, choixLycanthrope);
                    nouvelleJournee();
                    break;
                case "observer":
                    System.out.println(choixLycanthrope.afficherCaracteristiques());
                    break;
                default:
                    System.out.println("Choix invalide. Réessayez.");
            }
        } else if (choix.equals("Seul")) {
            if(!colonie.getListeSolitaire().isEmpty()){
                Lycanthrope choixLycanthrope = joueur.choisirLycanthrope(colonie.getListeSolitaire());

                String action = joueur.demandeActionLycanthrope(); // À changer.
                switch (action.toLowerCase()){
                    case "meute":
                        meute(choixLycanthrope);
                        nouvelleJournee();
                        break;
                    case "observer":
                        System.out.println(choixLycanthrope.afficherCaracteristiques());
                        break;
                    default:
                        System.out.println("Choix invalide. Réessayez.");
                }
            }else{
                System.out.println("La colonie ne possède aucun solitaire dans ses rangs !");
            }

        } else if(choix.equals("Description")){
            System.out.println(colonie.caracteristiquesColonie());
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
                    " ne peut pas quitter la meute, il a tant de choses à accomplir !");
        }
    }

    private void meute(Lycanthrope lycanthrope){
        colonie.nouvelleMeute(lycanthrope);
    }

    private void nouvelleJournee(){
        --nbActions;
        if(nbActions == 0){
            Random random = new Random();
            int action = random.nextInt(5);
            if(action == 0){
                colonie.hurlementMeute();
            } else if (action == 1) {
                colonie.evolutionHierarchie();
            } else if (action == 2) {
                colonie.viellissement();
            }else if(action == 4){
                colonie.nouvelleMeute();
            }


            colonie.setJour(colonie.getJour() + 1);
            if(colonie.getJour()%40 == 0){
                colonie.setSaisonAmour(true);
                System.out.println("C'est la saison des amours !");
            }else if(colonie.isSaisonAmour()){
                int naissance = random.nextInt(2);
                if(naissance == 1) {
                    colonie.reproductionSaisonAmour();
                }
            }
            nbActions = 3;
        }
    }
}
