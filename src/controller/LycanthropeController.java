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

    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String RED = "\u001B[31m";

    public void lancerJeu() {
        initialiserColonie();
        joueur.afficheRegleLycanthrope();

        while (jeuEnCours) {
            String choix = joueur.choixTourLycanthrope();
            switch (choix.toLowerCase()) {
                case "agir":
                    agir();
                    break;
                case "fin":
                    jeuEnCours = false;
                    System.out.println(GREEN + "🌕 FIN DU JEU 🌕" + RESET);
                    break;
                default:
                    System.out.println(RED + "⚠️ Choix invalide. Réessayez." + RESET);
            }
        }
    }

    private void initialiserColonie() {
        colonie.initialiserColonie();
    }

    private void agir() {
        String choix = joueur.choixActionLycanthrope();
        if (choix.equals("Meute")) {
            int choixMeute = joueur.choixTourChoixMeute(colonie.getListeMeutes());
            if (choixMeute < 0 || choixMeute >= colonie.getListeMeutes().size()) {
                System.out.println(RED + "⚠️ Meute invalide." + RESET);
                return;
            }
            Meute meuteChoisi = colonie.getListeMeutes().get(choixMeute);
            Lycanthrope choixLycanthrope = joueur.choisirLycanthrope(meuteChoisi.getListeMembres());
            String action = joueur.demandeActionLycanthrope();
            switch (action.toLowerCase()) {
                case "dominer":
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
                    System.out.println(BLUE + choixLycanthrope.afficherCaracteristiques() + RESET);
                    break;
                default:
                    System.out.println(RED + "⚠️ Choix invalide. Réessayez." + RESET);
            }
        } else if (choix.equals("Seul")) {
            if (!colonie.getListeSolitaire().isEmpty()) {
                Lycanthrope choixLycanthrope = joueur.choisirLycanthrope(colonie.getListeSolitaire());
                String action = joueur.demandeActionLycanthrope();
                switch (action.toLowerCase()) {
                    case "meute":
                        meute(choixLycanthrope);
                        nouvelleJournee();
                        break;
                    case "observer":
                        System.out.println(BLUE + choixLycanthrope.afficherCaracteristiques() + RESET);
                        break;
                    default:
                        System.out.println(RED + "⚠️ Choix invalide. Réessayez." + RESET);
                }
            } else {
                System.out.println(RED + "❌ La colonie ne possède aucun solitaire dans ses rangs !" + RESET);
            }
        } else if (choix.equals("Description")) {
            System.out.println(GREEN + colonie.caracteristiquesColonie() + RESET);
        }
    }

    private void dominer(Meute meute, Lycanthrope lycanthrope) {
        ArrayList<Lycanthrope> liste = meute.rechercherLycanthrope(lycanthrope);
        meute.domination(liste);
        System.out.println(YELLOW + "🐺 " + lycanthrope.getNom() + " a dominé un autre lycanthrope !" + RESET);
    }

    private void hurler(Lycanthrope lycanthrope) {
        System.out.println(YELLOW + "🎶 " + lycanthrope.hurlementAppartenanceMeute() + RESET);
    }

    private void quitter(Meute meute, Lycanthrope lycanthrope) {
        Lycanthrope newLycanthrope = meute.devenirSolitaire(lycanthrope);
        if (newLycanthrope != null) {
            colonie.addSolitaire(newLycanthrope);
            System.out.println(YELLOW + lycanthrope.getNom() + " a décidé de quitter sa meute, mort de honte, la queue entre les jambes." + RESET);
        } else {
            System.out.println(RED + lycanthrope.getNom() + " ne peut pas quitter la meute, il a tant de choses à accomplir !" + RESET);
        }
    }

    private void meute(Lycanthrope lycanthrope) {
        colonie.nouvelleMeute(lycanthrope);
        System.out.println(YELLOW + "🎉 " + lycanthrope.getNom() + " a créé une nouvelle meute !" + RESET);
    }

    private void nouvelleJournee() {
        --nbActions;
        if (nbActions == 0) {
            Random random = new Random();
            int action = random.nextInt(5);
            if (action == 0) {
                colonie.hurlementMeute();
                System.out.println(YELLOW + "🌌 La meute hurle à la lune !" + RESET);
            } else if (action == 1) {
                colonie.evolutionHierarchie();
                System.out.println(YELLOW + "🔄 La hiérarchie de la meute a évolué." + RESET);
            } else if (action == 2) {
                colonie.viellissement();
                System.out.println(YELLOW + "⏳ Les lycanthropes vieillissent..." + RESET);
            } else if (action == 3) {
                colonie.nouvelleMeute();
                System.out.println(YELLOW + "🎊 Une nouvelle meute a été formée !" + RESET);
            }

            colonie.setJour(colonie.getJour() + 1);
            if (colonie.getJour() % 40 == 0) {
                colonie.setSaisonAmour(true);
                System.out.println(GREEN + "💖 C'est la saison des amours !" + RESET);
            } else if (colonie.isSaisonAmour()) {
                int naissance = random.nextInt(2);
                if (naissance == 1) {
                    colonie.reproductionSaisonAmour();
                    System.out.println(YELLOW + "👶 Une nouvelle portée de lycanthropes est née !" + RESET);
                }
            }
            nbActions = 3;
        }
    }
}
