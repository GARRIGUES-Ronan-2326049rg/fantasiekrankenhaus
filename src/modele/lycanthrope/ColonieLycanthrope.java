package modele.lycanthrope;

import java.util.ArrayList;
import java.util.Random;

public class ColonieLycanthrope {

    private String nom;
    private ArrayList<MeuteLycanthrope> listeMeutes;
    private ArrayList<Lycanthrope> listeSolitaire;
    private boolean saisonAmour = false;

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

    public void nouvelleMeute(String nomMeute){
        if(listeSolitaire.size() >= 2){
            Random random = new Random();
            Lycanthrope lycanthrope1 = listeSolitaire.get(random.nextInt(listeSolitaire.size()));
            Lycanthrope lycanthrope2 = listeSolitaire.get(random.nextInt(listeSolitaire.size()));
            while(lycanthrope1 == lycanthrope2 || lycanthrope1.getSexe() == lycanthrope2.getSexe()){
                lycanthrope1 = listeSolitaire.get(random.nextInt(listeSolitaire.size()));
                lycanthrope2 = listeSolitaire.get(random.nextInt(listeSolitaire.size()));
            }
            listeSolitaire.remove(lycanthrope1);
            listeSolitaire.remove(lycanthrope2);


            lycanthrope1.setRang('α');
            lycanthrope2.setRang('α');

            ArrayList<Lycanthrope> newMeute = new ArrayList<Lycanthrope>();
            newMeute.add(lycanthrope1);
            newMeute.add(lycanthrope2);
            MeuteLycanthrope nouvelleMeute = new MeuteLycanthrope(nomMeute, newMeute);
            listeMeutes.add(nouvelleMeute);
        }
    }

    public boolean isSaisonAmour() {
        return saisonAmour;
    }

    public void setSaisonAmour(boolean saisonAmour) {
        this.saisonAmour = saisonAmour;
    }

    public void reproductionSaisonAmour(String[] listeNoms, char[] listeSexes){
        if(saisonAmour){
            Random random = new Random();
            listeMeutes.get(random.nextInt(listeMeutes.size())).reproduction(listeNoms, listeSexes);
        }
    }

    public void evolutionHierarchie(){
        Random random = new Random();
        int idMeute = random.nextInt(this.listeMeutes.size());
        this.listeMeutes.get(idMeute).domination();
        this.listeMeutes.get(idMeute).hierarchieLycanthropes();
    }

    public void viellissement(){
        Random random = new Random();
        int typeListe = random.nextInt(2);
        // Pour les meutes.
        if(typeListe == 0){
            int idMeute = random.nextInt(listeMeutes.size());
            MeuteLycanthrope meute = listeMeutes.get(random.nextInt(idMeute));
            int idLycanthrope = random.nextInt(meute.getListeMembres().size());
            Lycanthrope lycanthrope = meute.getListeMembres().get(random.nextInt(idLycanthrope));

            if(lycanthrope.getCategorieAge().equals("Jeune")){
                listeMeutes.get(idMeute).getListeMembres().get(idLycanthrope).setCategorieAge("Adulte");
            } else if(lycanthrope.getCategorieAge().equals("Adulte")){
                listeMeutes.get(idMeute).getListeMembres().get(idLycanthrope).setCategorieAge("Vieux");
            } else {
                listeMeutes.get(idMeute).getListeMembres().remove(idLycanthrope);
            }
        // Pour les solitaires.
        } else {
            int idSolitaire = random.nextInt(listeSolitaire.size());
            Lycanthrope solitaire = listeSolitaire.get(random.nextInt(idSolitaire));

            if(solitaire.getCategorieAge().equals("Jeune")){
                listeSolitaire.get(idSolitaire).setCategorieAge("Adulte");
            } else if(solitaire.getCategorieAge().equals("Adulte")){
                listeSolitaire.get(idSolitaire).setCategorieAge("Vieux");
            } else {
                listeSolitaire.remove(idSolitaire);
            }
        }
    }

    public void hurlementMeute(){
        Random random = new Random();
        int idMeute = random.nextInt(listeMeutes.size());
        MeuteLycanthrope meute = listeMeutes.get(random.nextInt(idMeute));
        int idLycanthrope = random.nextInt(meute.getListeMembres().size());
        Lycanthrope lycanthrope = meute.getListeMembres().get(random.nextInt(idLycanthrope));
        lycanthrope.hurlementAppartenanceMeute();
    }
}