package modele.lycanthrope;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class ColonieLycanthrope {

    private ArrayList<MeuteLycanthrope> listeMeutes;
    private ArrayList<Lycanthrope> listeSolitaire;
    private boolean saisonAmour = false;
    private static final Random random = new Random();
    private final String alphabetGrec = "αβγδεζηθικλµνξοπρστυϕχψω";
    private static final char[] sexe = {'M', 'F'};
    private static final String[] categorieAge = {"Jeune", "Adulte", "Vieux"};

    private static final String[] nomLycanthrope = {
            //TODO
    };

    private static final String[] nomMeute = {
            //TODO
    };

    public ColonieLycanthrope(ArrayList<MeuteLycanthrope> listeMeutes) {
        this.listeMeutes = listeMeutes;
    }

    public void initialiserColonie(){
        ArrayList<Lycanthrope> listeLycanthrope = new ArrayList<>();

        IntStream.range(0, 5).forEach(i -> {
            if (i == 0) {
                listeLycanthrope.add(new Lycanthrope(
                        nomLycanthrope[random.nextInt(nomLycanthrope.length)],
                        'M',
                        "Adulte",
                        'α',
                        null
                ));
            } else if (i == 1) {
                listeLycanthrope.add(new Lycanthrope(
                        nomLycanthrope[random.nextInt(nomLycanthrope.length)],
                        'F',
                        "Adulte",
                        'α',
                        null
                ));
            } else {
                listeLycanthrope.add(new Lycanthrope(
                        nomLycanthrope[random.nextInt(nomLycanthrope.length)],
                        sexe[random.nextInt(sexe.length)],
                        categorieAge[random.nextInt(categorieAge.length)],
                        alphabetGrec.charAt(random.nextInt(alphabetGrec.length())),
                        null
                ));
            }
        });

        this.listeMeutes.add( new MeuteLycanthrope(
                nomMeute[random.nextInt(nomMeute.length)],
                listeLycanthrope));
    }

    public ArrayList<MeuteLycanthrope> getListeMeutes() {
        return listeMeutes;
    }

    public void setListeMeutes(ArrayList<MeuteLycanthrope> listeMeutes) {
        this.listeMeutes = listeMeutes;
    }

    public ArrayList<Lycanthrope> getListeSolitaire() {
        return listeSolitaire;
    }

    public void setListeSolitaire(ArrayList<Lycanthrope> listeSolitaire) {
        this.listeSolitaire = listeSolitaire;
    }

    public String caracteristiquesColonie() {
        String texte = "Dans la colonie, il y a : \n";
        for(MeuteLycanthrope meute: listeMeutes){
            texte = texte + meute.carateristiquesMembre();
            texte = texte + "\n";
        }
        return texte;
    }

    public void nouvelleMeute(String nomMeute){
        if(listeSolitaire.size() >= 2){
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

    public void reproductionSaisonAmour(String[] listeNoms){
        if(saisonAmour){
            listeMeutes.get(random.nextInt(listeMeutes.size())).reproduction(listeNoms,sexe);
        }
    }

    public void evolutionHierarchie(){
        int idMeute = random.nextInt(this.listeMeutes.size());
        this.listeMeutes.get(idMeute)/*.domination()*/;
        this.listeMeutes.get(idMeute).hierarchieLycanthropes();
    }

    public void viellissement(){
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
        int idMeute = random.nextInt(listeMeutes.size());
        MeuteLycanthrope meute = listeMeutes.get(random.nextInt(idMeute));
        int idLycanthrope = random.nextInt(meute.getListeMembres().size());
        Lycanthrope lycanthrope = meute.getListeMembres().get(random.nextInt(idLycanthrope));
        lycanthrope.hurlementAppartenanceMeute();
    }
}