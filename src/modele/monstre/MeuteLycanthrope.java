package modele.monstre;

import java.util.ArrayList;
import java.util.Random;

public class MeuteLycanthrope {

    private Lycanthrope maleAlpha;
    private Lycanthrope femelleAlpha;

    private ArrayList<Lycanthrope> listeMembres;

    private final String alphabetGrec = "αβγδεζηθικλµνξοπρστυϕχψω";

    /**
     * @param liste Une liste composée des membres de la meute.
     * */
    public MeuteLycanthrope(ArrayList<Lycanthrope> liste) throws IllegalArgumentException{
        // Initialisation des variables.
        boolean maleAlphaPresent = false;
        int rangMaleAlpha = 0;
        int compteurMaleAlpha = 0;
        boolean femelleAlphaPresent = false;
        int rangFemelleAlpha = 0;
        int compteurFemelleAlpha = 0;
        boolean rangOmicronPresent = false;

        // Vérification d'un mâle Alpha, d'une femelle Alpha et d'un membre au moins de niveau Omicron (ω) dans la liste.
        for(int i = 0; i < liste.size(); i++){
            if(liste.get(i).getRang() == 'α'){
                if(liste.get(i).getSexe() == 'M'){
                    maleAlphaPresent = true;
                    rangMaleAlpha = i;
                    compteurMaleAlpha++;
                }else if(liste.get(i).getSexe() == 'F'){
                    femelleAlphaPresent = true;
                    rangFemelleAlpha = i;
                    compteurFemelleAlpha++;
                }
            } else if(liste.get(i).getRang() == 'ω'){
                rangOmicronPresent = true;
            }
        }

        if (!maleAlphaPresent || !femelleAlphaPresent || !rangOmicronPresent
                || compteurMaleAlpha > 1 || compteurFemelleAlpha > 1) {
            throw new IllegalArgumentException("La liste doit contenir un seul mâle Alpha, " +
                    "une seule femelle Alpha et au moins un membre de rang ω.");
        } else{
            this.maleAlpha = liste.get(rangMaleAlpha);
            this.femelleAlpha = liste.get(rangFemelleAlpha);
            this.listeMembres = liste;
        }

    }

    public Lycanthrope getMaleAlpha() {
        return maleAlpha;
    }

    public void setMaleAlpha(Lycanthrope maleAlpha) {
        this.maleAlpha = maleAlpha;
    }

    public Lycanthrope getFemelleAlpha() {
        return femelleAlpha;
    }

    public void setFemelleAlpha(Lycanthrope femelleAlpha) {
        this.femelleAlpha = femelleAlpha;
    }

    public ArrayList<Lycanthrope> getListeMembres() {
        return listeMembres;
    }

    public void setListeMembres(ArrayList<Lycanthrope> listeMembres) {
        this.listeMembres = listeMembres;
    }

    public void domination(){
        // Création de la variable aléatoire permettant de choisir un loup de la meute.
        Random random = new Random();

        // Choix de deux lycanthropes dans la meute.
        Lycanthrope lycanthrope1 = listeMembres.get(random.nextInt(listeMembres.size()));
        Lycanthrope lycanthrope2 = listeMembres.get(random.nextInt(listeMembres.size()));
        char rangLy1 = lycanthrope1.getRang();
        char rangLy2 = lycanthrope2.getRang();
        int placeRangLy1 = 0;
        int placeRangLy2 = 0;

        // Recherche de l'emplacement de leur rang dans l'alphabet grec
        for(int i = 0; i < alphabetGrec.length()-1; i++){
            if(alphabetGrec.charAt(i) == rangLy1){
                placeRangLy1 = i + 1;
            } else if(alphabetGrec.charAt(i) == rangLy2){
                placeRangLy2 = i + 1;
            }
        }

        // Nous vérifions que les deux lycanthropes ne sont pas les mêmes, qu'ils ne sont identiques à la femelle alpha,
        // que le rang du premier est inférieur au rang du second et que le facteur d'impétuosité du premier et supérieur au second.
        while(lycanthrope1 == lycanthrope2 || lycanthrope1.equals(femelleAlpha) || lycanthrope2.equals(femelleAlpha)
                || placeRangLy1 < placeRangLy2 || lycanthrope1.getfacteurImpetuosite() < lycanthrope2.getfacteurImpetuosite()){
            lycanthrope1 = listeMembres.get(random.nextInt(listeMembres.size()));
            lycanthrope2 = listeMembres.get(random.nextInt(listeMembres.size()));

            for(int i = 0; i < alphabetGrec.length()-1; i++){
                if(alphabetGrec.charAt(i) == rangLy1){
                    placeRangLy1 = i + 1;
                } else if(alphabetGrec.charAt(i) == rangLy2){
                    placeRangLy2 = i + 1;
                }
            }
        }

        System.out.println(lycanthrope1.getNom() + " tente une domination contre " + lycanthrope2.getNom() + "!");

        // On regarde si lycanthrope1 arrive à dominer lycanthrope2.
        if(lycanthrope1.getNiveau() > lycanthrope2.getNiveau()){
            System.out.println(lycanthrope1.getNom() + " a réussi sa domination contre " + lycanthrope2.getNom() + "!");
            // On change les rangs des deux Lycanthropes.
            for(Lycanthrope membre : listeMembres){
                if (membre == lycanthrope1){
                    membre.setFacteurDomination(membre.getFacteurDomination() + 5);
                } else if(membre == lycanthrope2){
                    membre.setFacteurDomination(membre.getFacteurDomination() - 5);
                    // On regarde si lycanthrope 1 est le mâle alpha. Si c'est le cas, lycanthrope2 devient le nouveau mâle alpha.
                    if(lycanthrope2.getSexe() == 'M' && membre == maleAlpha){
                        System.out.println(lycanthrope2.getNom() + " devient le nouveau mâle Alpha de la meute !");
                        maleAlpha = membre;
                        // On regarde ensuite si uen femelle a un niveau plus haut que celui de la femelle Alpha.
                        int rangFemelleForte = -1;
                        int rangFemelleAlpha = -1;
                        for(int i = 0; i < listeMembres.size() - 1; i++){
                            if(listeMembres.get(i) == femelleAlpha){
                                rangFemelleAlpha = i;
                            }
                            if(listeMembres.get(i).getSexe() == 'F' && listeMembres.get(i).getNiveau() > femelleAlpha.getNiveau()){
                                rangFemelleForte = i;
                            }
                        }
                        if(rangFemelleForte != -1){
                            System.out.println(femelleAlpha.getNom() + " reste la femelle Alpha du groupe !");
                        } else {
                            System.out.println(listeMembres.get(rangFemelleForte).getNom() + " devient la nouvelle femelle Alpha !");
                            listeMembres.get(rangFemelleForte).setRang(femelleAlpha.getRang());
                            listeMembres.get(rangFemelleAlpha).setRang(listeMembres.get(rangFemelleForte).getRang());
                            femelleAlpha = listeMembres.get(rangFemelleForte);

                        }
                    }
                }
            }
        } else {
            System.out.println(lycanthrope1.getNom() + " a gouté à l'agressivité de " + lycanthrope2.getNom() + "!");
            for(Lycanthrope membre : listeMembres){
                if(membre == lycanthrope2){
                    membre.setFacteurDomination(membre.getFacteurDomination() - 5);
                }
            }
        }
    }
}