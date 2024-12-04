package modele.lycanthrope;

import java.util.ArrayList;
import java.util.Random;

public class Meute {

    private String nom;
    private Lycanthrope maleAlpha;
    private Lycanthrope femelleAlpha;

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String MAGENTA = "\u001B[35m";

    private ArrayList<Lycanthrope> listeMembres;

    private final String alphabetGrec = "αβγδεζηθικλµνξοπρστυϕχψω";

    /**
     * Constructeur pour la classe Meute.
     *
     * @param nomMeute Le nom de la meute.
     * @param liste Une liste composée des membres de la meute.
     * @throws IllegalArgumentException Si la liste ne contient pas un seul mâle Alpha et une seule femelle Alpha.
     */
    public Meute(String nomMeute, ArrayList<Lycanthrope> liste) throws IllegalArgumentException {
        // Initialisation des variables.
        boolean maleAlphaPresent = false;
        int rangMaleAlpha = 0;
        int compteurMaleAlpha = 0;
        boolean femelleAlphaPresent = false;
        int rangFemelleAlpha = 0;
        int compteurFemelleAlpha = 0;


        // Vérification d'un mâle Alpha, d'une femelle Alpha et d'un membre au moins de niveau Omicron (ω) dans la liste.
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getRang() == 'α') {
                if (liste.get(i).getSexe() == 'M') {
                    maleAlphaPresent = true;
                    rangMaleAlpha = i;
                    compteurMaleAlpha++;
                } else if (liste.get(i).getSexe() == 'F') {
                    femelleAlphaPresent = true;
                    rangFemelleAlpha = i;
                    compteurFemelleAlpha++;
                }
            }
        }

        // Si une des conditions n'est pas respectée, erreur, sinon, on ajoute les variables.
        if (!maleAlphaPresent || !femelleAlphaPresent
                || compteurMaleAlpha > 1 || compteurFemelleAlpha > 1) {
            throw new IllegalArgumentException("La liste doit contenir un seul mâle Alpha et " +
                    "une seule femelle Alpha.");
        } else {
            this.nom = nomMeute;
            this.maleAlpha = liste.get(rangMaleAlpha);
            this.maleAlpha.setMeute(nomMeute);
            this.femelleAlpha = liste.get(rangFemelleAlpha);
            this.femelleAlpha.setMeute(nomMeute);
            this.listeMembres = liste;
            // On inscrit bien le nom de la meute pour chacun des membres la composant.
            for (int i = 0; i < this.listeMembres.size(); i++) {
                listeMembres.get(i).setMeute(nomMeute);
            }
        }
    }

    /**
     * Obtient le mâle Alpha de la meute.
     *
     * @return Le mâle Alpha.
     */
    public Lycanthrope getMaleAlpha() {
        return maleAlpha;
    }

    /**
     * Obtient le nom de la meute.
     *
     * @return Le nom de la meute.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la meute.
     *
     * @param nomMeute Le nom de la meute à définir.
     */
    public void setNom(String nomMeute) {
        this.nom = nomMeute;
    }

    /**
     * Définit le mâle Alpha de la meute.
     *
     * @param maleAlpha Le mâle Alpha à définir.
     */
    public void setMaleAlpha(Lycanthrope maleAlpha) {
        this.maleAlpha = maleAlpha;
    }

    /**
     * Obtient la femelle Alpha de la meute.
     *
     * @return La femelle Alpha.
     */
    public Lycanthrope getFemelleAlpha() {
        return femelleAlpha;
    }

    /**
     * Définit la femelle Alpha de la meute.
     *
     * @param femelleAlpha La femelle Alpha à définir.
     */
    public void setFemelleAlpha(Lycanthrope femelleAlpha) {
        this.femelleAlpha = femelleAlpha;
    }

    /**
     * Obtient la liste des membres de la meute.
     *
     * @return La liste des membres.
     */
    public ArrayList<Lycanthrope> getListeMembres() {
        return listeMembres;
    }

    /**
     * Définit la liste des membres de la meute.
     *
     * @param listeMembres La liste des membres à définir.
     */
    public void setListeMembres(ArrayList<Lycanthrope> listeMembres) {
        this.listeMembres = listeMembres;
    }

    /**
     * Recherche un lycanthrope dans la meute.
     *
     * @param lycanthrope Le lycanthrope à rechercher.
     * @return Une liste contenant le lycanthrope recherché et un autre lycanthrope de la meute.
     */
    public ArrayList<Lycanthrope> rechercherLycanthrope(Lycanthrope lycanthrope) {
        // Création de la variable aléatoire permettant de choisir un loup de la meute.
        Random random = new Random();

        // Choix d'un lycanthrope dans la meute.
        Lycanthrope lycanthrope1 = listeMembres.get(random.nextInt(listeMembres.size()));
        char rangLy1 = lycanthrope1.getRang();
        int placeRangLy1 = 0;
        int placeRangLy = 0;

        // Recherche de l'emplacement de leur rang dans l'alphabet grec.
        for (int i = 0; i < alphabetGrec.length() - 1; i++) {
            if (alphabetGrec.charAt(i) == rangLy1) {
                placeRangLy1 = i + 1;
            } else if (alphabetGrec.charAt(i) == lycanthrope.getRang()) {
                placeRangLy = i + 1;
            }
        }

        // Nous vérifions que les deux lycanthropes ne sont pas les mêmes, qu'ils ne sont identiques à la femelle alpha,
        // que le rang du premier est inférieur au rang du second et que le facteur d'impétuosité du premier et supérieur au second.
        while (lycanthrope1 == lycanthrope || lycanthrope1.equals(femelleAlpha) || lycanthrope.equals(femelleAlpha)
                || placeRangLy1 < placeRangLy || lycanthrope1.getfacteurImpetuosite() < lycanthrope.getfacteurImpetuosite()) {
            lycanthrope1 = listeMembres.get(random.nextInt(listeMembres.size()));

            for (int i = 0; i < alphabetGrec.length() - 1; i++) {
                if (alphabetGrec.charAt(i) == rangLy1) {
                    placeRangLy1 = i + 1;
                }
            }
        }
        ArrayList<Lycanthrope> arrayLycanthropes = new ArrayList<>();
        arrayLycanthropes.add(lycanthrope);
        arrayLycanthropes.add(lycanthrope1);
        return arrayLycanthropes;
    }

    /**
     * Permet de trouver deux lycanthropes aptes à exercer une domination sur l'autre.
     *
     * @return ArrayList<Lycanthrope> Un array contenant les deux lycanthropes aptes à se soumettre.
     */
    public ArrayList<Lycanthrope> rechercherDeuxLycanthropes() {
        // Création de la variable aléatoire permettant de choisir un loup de la meute.
        Random random = new Random();

        // Choix de deux lycanthropes dans la meute.
        Lycanthrope lycanthrope1 = listeMembres.get(random.nextInt(listeMembres.size()));
        Lycanthrope lycanthrope2 = listeMembres.get(random.nextInt(listeMembres.size()));
        char rangLy1 = lycanthrope1.getRang();
        char rangLy2 = lycanthrope2.getRang();
        int placeRangLy1 = 0;
        int placeRangLy2 = 0;

        // Recherche de l'emplacement de leur rang dans l'alphabet grec.
        for (int i = 0; i < alphabetGrec.length() - 1; i++) {
            if (alphabetGrec.charAt(i) == rangLy1) {
                placeRangLy1 = i + 1;
            } else if (alphabetGrec.charAt(i) == rangLy2) {
                placeRangLy2 = i + 1;
            }
        }

        // Nous vérifions que les deux lycanthropes ne sont pas les mêmes, qu'ils ne sont identiques à la femelle alpha,
        // que le rang du premier est inférieur au rang du second et que le facteur d'impétuosité du premier et supérieur au second.
        while (lycanthrope1 == lycanthrope2 || lycanthrope1.equals(femelleAlpha) || lycanthrope2.equals(femelleAlpha)
                || placeRangLy1 < placeRangLy2 || lycanthrope1.getfacteurImpetuosite() < lycanthrope2.getfacteurImpetuosite()) {
            lycanthrope1 = listeMembres.get(random.nextInt(listeMembres.size()));
            lycanthrope2 = listeMembres.get(random.nextInt(listeMembres.size()));

            for (int i = 0; i < alphabetGrec.length() - 1; i++) {
                if (alphabetGrec.charAt(i) == rangLy1) {
                    placeRangLy1 = i + 1;
                } else if (alphabetGrec.charAt(i) == rangLy2) {
                    placeRangLy2 = i + 1;
                }
            }
        }

        // Nous créons un array avec les deux Lycanthropes sélectionnés
        ArrayList<Lycanthrope> arrayLycanthropes = new ArrayList<>();
        arrayLycanthropes.add(lycanthrope1);
        arrayLycanthropes.add(lycanthrope2);
        return arrayLycanthropes;
    }

    /**
     * Gère la domination entre deux lycanthropes.
     *
     * @param arrayLycanthropes Une liste contenant les deux lycanthropes impliqués dans la domination.
     */
    public void domination(ArrayList<Lycanthrope> arrayLycanthropes) {
        Lycanthrope lycanthrope1 = arrayLycanthropes.get(0);
        Lycanthrope lycanthrope2 = arrayLycanthropes.get(1);

        Random random = new Random();

        System.out.println(lycanthrope1.getNom() + " tente une domination contre " + lycanthrope2.getNom() + "!");

        // On regarde si lycanthrope1 arrive à dominer lycanthrope2.
        if (lycanthrope1.getNiveau() > lycanthrope2.getNiveau()) {
            System.out.println(lycanthrope1.getNom() + " a réussi sa domination contre " + lycanthrope2.getNom() + "!");
            int hurlement = random.nextInt(2);
            if (hurlement == 1) lycanthrope1.exprimerDomination(lycanthrope2);
            // On change les rangs des deux Lycanthropes.
            for (Lycanthrope membre : listeMembres) {
                if (membre == lycanthrope1) {
                    membre.setFacteurDomination(membre.getFacteurDomination() + 5);
                } else if (membre == lycanthrope2) {
                    membre.setFacteurDomination(membre.getFacteurDomination() - 5);
                    // On regarde si lycanthrope 1 est le mâle alpha. Si c'est le cas, lycanthrope2 devient le nouveau mâle alpha.
                    if (lycanthrope2.getSexe() == 'M' && lycanthrope1 == maleAlpha) {
                        System.out.println(lycanthrope2.getNom() + " devient le nouveau mâle Alpha de la meute !");
                        maleAlpha = membre;
                        // On regarde ensuite si une femelle a un niveau plus haut que celui de la femelle Alpha.
                        int rangFemelleForte = -1;
                        int rangFemelleAlpha = -1;
                        for (int i = 0; i < listeMembres.size() - 1; i++) {
                            if (listeMembres.get(i) == femelleAlpha) {
                                rangFemelleAlpha = i;
                            }
                            if (listeMembres.get(i).getSexe() == 'F' && listeMembres.get(i).getNiveau() > femelleAlpha.getNiveau()) {
                                rangFemelleForte = i;
                            }
                        }
                        if (rangFemelleForte != -1) {
                            System.out.println(femelleAlpha.getNom() + " reste la femelle Alpha du groupe !");
                        } else {
                            System.out.println(listeMembres.get(rangFemelleForte).getNom() + " devient la nouvelle femelle Alpha !");
                            listeMembres.get(rangFemelleForte).setRang(femelleAlpha.getRang());
                            listeMembres.get(rangFemelleAlpha).setRang(lycanthrope2.getRang());
                            femelleAlpha = listeMembres.get(rangFemelleForte);
                        }
                    }
                }
            }
            System.out.println("La meute a une nouvelle hiérarchie ! \n" +
                    hierarchieLycanthropes());
        } else {
            System.out.println(lycanthrope1.getNom() + " a goûté à l'agressivité de " + lycanthrope2.getNom() + "!");
            int hurlement = random.nextInt(3);
            if (hurlement == 0) lycanthrope1.exrpimerSoumission(lycanthrope2);
            else if (hurlement == 1) lycanthrope2.exprimerAgressivite(lycanthrope1);
            for (Lycanthrope membre : listeMembres) {
                if (membre == lycanthrope2) {
                    membre.setFacteurDomination(membre.getFacteurDomination() - 5);
                }
            }
        }
    }

    /**
     * Transforme un lycanthrope en solitaire.
     *
     * @return Le lycanthrope devenu solitaire, ou null s'il ne peut pas devenir solitaire.
     */
    public Lycanthrope devenirSolitaire() {
        Random random = new Random();
        Lycanthrope newLycanthrope = null;
        int num = random.nextInt(listeMembres.size());
        if (listeMembres.get(num).getRang() == 'ω' || !listeMembres.get(num).isReussiteDomination()) {
            newLycanthrope = listeMembres.get(num);
            newLycanthrope.setMeute(null);
            listeMembres.remove(num);
        }
        return newLycanthrope;
    }

    /**
     * Transforme un lycanthrope spécifique en solitaire.
     *
     * @param lycanthrope Le lycanthrope à transformer en solitaire.
     * @return Le lycanthrope devenu solitaire, ou null s'il ne peut pas devenir solitaire.
     */
    public Lycanthrope devenirSolitaire(Lycanthrope lycanthrope) {
        if (lycanthrope.getRang() == 'ω' || !lycanthrope.isReussiteDomination()) {
            Lycanthrope newLycanthrope = lycanthrope;
            newLycanthrope.setMeute(null);
            listeMembres.remove(lycanthrope);

            return newLycanthrope;
        }
        return null;
    }

    /**
     * Gère la reproduction dans la meute.
     *
     * @param noms Les noms possibles pour les nouveaux lycanthropes.
     * @param sexe Les sexes possibles pour les nouveaux lycanthropes.
     */
    public void reproduction(String[] noms, char[] sexe) {
        Random random = new Random();
        int nbJeunes = random.nextInt(7);
        for (int i = 0; i < nbJeunes; i++) {
            Lycanthrope bebe = new Lycanthrope(noms[random.nextInt(noms.length)], sexe[random.nextInt(sexe.length)],
                    "Jeune", alphabetGrec.charAt(random.nextInt(alphabetGrec.length())), nom);
            if (bebe.getRang() == 'α') {
                bebe.setRang(alphabetGrec.charAt(random.nextInt(alphabetGrec.length())));
            }
            listeMembres.add(bebe);
            System.out.println(bebe.getNom() + " est né dans la meute " + this.nom + " !");
        }
    }

    /**
     * Obtient les caractéristiques de la meute.
     *
     * @return Les caractéristiques de la meute sous forme de chaîne de caractères.
     */
    public String caracteristiqueMeute() {
        return "La meute " + this.nom + " a pour caractéristiques : \n"
                + "Mâle α : " + this.maleAlpha.getNom() + "\n"
                + "Femelle α : " + this.femelleAlpha.getNom() + "\n"
                + "Nombre de membres : " + this.listeMembres.size() + "\n";
    }

    /**
     * Obtient les caractéristiques des membres de la meute.
     *
     * @return Les caractéristiques des membres sous forme de chaîne de caractères.
     */
    public String carateristiquesMembre() {
        String texte = "La meute " + this.nom + " est constituée de : \n";
        for (Lycanthrope membre : listeMembres) {
            texte = texte + membre.afficherCaracteristiques();
        }
        return texte;
    }

    /**
     * Obtient la hiérarchie des lycanthropes dans la meute.
     *
     * @return La hiérarchie des lycanthropes sous forme de chaîne de caractères.
     */
    public String hierarchieLycanthropes() {
        StringBuilder texte = new StringBuilder("La meute " + CYAN + this.nom + RESET + " possède la hiérarchie suivante : \n" +
                "Le couple α " + GREEN + this.maleAlpha.getNom() + RESET + " et " + GREEN + this.femelleAlpha.getNom() + RESET + "\n");

        for (int i = 1; i < alphabetGrec.length(); i++) {
            texte.append("Les membres ").append(YELLOW).append(alphabetGrec.charAt(i)).append(" : ").append(RESET);
            boolean premier = true;
            for (Lycanthrope membre : listeMembres) {
                if (membre.getRang() == alphabetGrec.charAt(i)) {
                    if (!premier) {
                        texte.append(", ");
                    }
                    texte.append(membre.getNom());
                    premier = false;
                }
            }
            texte.append("\n");
        }
        return texte.toString();
    }


    public String caracteristiquesCoupleAlpha(){
        return "Le couple α est constitué des lycanthropes suivants : \n" + maleAlpha.afficherCaracteristiques()
                + femelleAlpha.afficherCaracteristiques();
    }

}