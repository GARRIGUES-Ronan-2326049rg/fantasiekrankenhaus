package modele.lycanthrope;

import java.util.ArrayList;

public class ColonieLycanthrope {

    private String nom;
    private ArrayList<MeuteLycanthrope> listeMeutes;

    public ColonieLycanthrope(ArrayList<MeuteLycanthrope> listeMeutes, String nom) {
        this.listeMeutes = listeMeutes;
        this.nom = nom;
    }

    public String caracteristiquesColonie() {
        String texte = "Dans la colonie " + this.nom + ", il y a : \n";
        for(MeuteLycanthrope meute: listeMeutes){
            texte = texte + meute.carateristiquesMembre();
            texte = texte + "\n";
        }
        return texte;
    }
}