package modele.lycanthrope;

import java.util.Random;

public class Lycanthrope{

    private String nom;
    private char sexe;
    private String categorieAge;
    private int force;
    private int facteurDomination = 50;
    private char rang;
    private int niveau;
    private int facteurImpetuosite;
    private boolean reussiteDomination = true;
    private boolean devenirHumain = false;
    private String meute;

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String MAGENTA = "\u001B[35m";

    private static final Random random = new Random();

    /**
     * Constructeur pour la classe Lycanthrope.
     *
     * @param nom Le nom du lycanthrope.
     * @param sexe Le sexe du lycanthrope.
     * @param categorieAge La catégorie d'âge du lycanthrope.
     * @param rang Le rang du lycanthrope.
     * @param meute La meute à laquelle appartient le lycanthrope.
     */
    public Lycanthrope(String nom, char sexe, String categorieAge, char rang, String meute) {
        this.nom = nom;
        this.sexe = sexe;
        this.categorieAge = categorieAge;
        this.rang = rang;
        this.meute = meute;

        this.niveau = random.nextInt(20);
        this.facteurImpetuosite = random.nextInt(100);
    }

    /**
     * Obtient le nom du lycanthrope.
     *
     * @return Le nom du lycanthrope.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du lycanthrope.
     *
     * @param nom Le nom à définir.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le sexe du lycanthrope.
     *
     * @return Le sexe du lycanthrope.
     */
    public char getSexe() {
        return sexe;
    }

    /**
     * Définit le sexe du lycanthrope.
     *
     * @param sexe Le sexe à définir.
     */
    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    /**
     * Obtient le facteur d'impétuosité du lycanthrope.
     *
     * @return Le facteur d'impétuosité.
     */
    public int getFacteurImpetuosite() {
        return facteurImpetuosite;
    }

    /**
     * Définit le facteur d'impétuosité du lycanthrope.
     *
     * @param facteurImpetuosite Le facteur d'impétuosité à définir.
     */
    public void setFacteurImpetuosite(int facteurImpetuosite) {
        this.facteurImpetuosite = facteurImpetuosite;
    }

    /**
     * Obtient la catégorie d'âge du lycanthrope.
     *
     * @return La catégorie d'âge.
     */
    public String getCategorieAge() {
        return categorieAge;
    }

    /**
     * Définit la catégorie d'âge du lycanthrope.
     *
     * @param categorieAge La catégorie d'âge à définir.
     */
    public void setCategorieAge(String categorieAge) {
        this.categorieAge = categorieAge;
    }

    /**
     * Obtient la force du lycanthrope.
     *
     * @return La force du lycanthrope.
     */
    public int getForce() {
        return force;
    }

    /**
     * Définit la force du lycanthrope.
     *
     * @param force La force à définir.
     */
    public void setForce(int force) {
        this.force = force;
    }

    /**
     * Obtient le facteur de domination du lycanthrope.
     *
     * @return Le facteur de domination.
     */
    public int getFacteurDomination() {
        return facteurDomination;
    }

    /**
     * Définit le facteur de domination du lycanthrope.
     *
     * @param facteurDomination Le facteur de domination à définir.
     */
    public void setFacteurDomination(int facteurDomination) {
        this.facteurDomination = facteurDomination;
    }

    /**
     * Obtient le rang du lycanthrope.
     *
     * @return Le rang du lycanthrope.
     */
    public char getRang() {
        return rang;
    }

    /**
     * Définit le rang du lycanthrope.
     *
     * @param rang Le rang à définir.
     */
    public void setRang(char rang) {
        this.rang = rang;
    }

    /**
     * Obtient le niveau du lycanthrope.
     *
     * @return Le niveau du lycanthrope.
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * Définit le niveau du lycanthrope.
     *
     * @param niveau Le niveau à définir.
     */
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    /**
     * Obtient le facteur d'impétuosité du lycanthrope.
     *
     * @return Le facteur d'impétuosité.
     */
    public int getfacteurImpetuosite() {
        return facteurImpetuosite;
    }

    /**
     * Définit le facteur d'impétuosité du lycanthrope.
     *
     * @param facteurImpetuosite Le facteur d'impétuosité à définir.
     */
    public void setfacteurImpetuosite(int facteurImpetuosite) {
        this.facteurImpetuosite = facteurImpetuosite;
    }

    /**
     * Obtient la meute du lycanthrope.
     *
     * @return La meute du lycanthrope.
     */
    public String getMeute() {
        return meute;
    }

    /**
     * Définit la meute du lycanthrope.
     *
     * @param meute La meute à définir.
     */
    public void setMeute(String meute) {
        this.meute = meute;
    }

    /**
     * Vérifie si la domination a réussi.
     *
     * @return True si la domination a réussi, sinon false.
     */
    public boolean isReussiteDomination() {
        return reussiteDomination;
    }

    /**
     * Définit le statut de réussite de la domination.
     *
     * @param reussiteDomination True si la domination a réussi, sinon false.
     */
    public void setReussiteDomination(boolean reussiteDomination) {
        this.reussiteDomination = reussiteDomination;
    }

    /**
     * Vérifie si le lycanthrope est devenu humain.
     *
     * @return True si le lycanthrope est devenu humain, sinon false.
     */
    public boolean isDevenirHumain() {
        return devenirHumain;
    }

    /**
     * Transforme le lycanthrope en humain.
     */
    public void transformationHumain(){
        this.devenirHumain = true;
    }

    /**
     * Transforme l'humain en lycanthrope.
     */
    public void transformationLycanthrope(){
        this.devenirHumain = false;
    }

    /**
     * Exprime l'appartenance du lycanthrope à sa meute par un hurlement.
     *
     * @return Une chaîne de caractères représentant le hurlement.
     */
    public String hurlementAppartenanceMeute() {
        return GREEN + this.nom + " 🎤 exprime son appartenance à la meute " + CYAN + this.meute + " 🐺 !" + RESET;
    }


    /**
     * Exprime la domination du lycanthrope sur un autre lycanthrope.
     *
     * @param lycanthrope Le lycanthrope dominé.
     * @return Une chaîne de caractères représentant la domination.
     */
    public String exprimerDomination(Lycanthrope lycanthrope) {
        return GREEN + this.nom + " 🐺 hurle sa domination contre " + RED + lycanthrope.getNom() + " 👑 !" + RESET;
    }


    /**
     * Exprime la soumission d'un lycanthrope face à un autre.
     *
     * @param lycanthrope Le lycanthrope dominant.
     * @return Une chaîne de caractères représentant la soumission.
     */
    public String exrpimerSoumission(Lycanthrope lycanthrope){
        return RED + lycanthrope.getNom() + " 😱 hurle de soumission face à " + GREEN + this.nom + " 👑 !" + RESET;
    }

    /**
     * Exprime l'agressivité d'un lycanthrope envers un autre.
     *
     * @param lycanthrope Le lycanthrope agressé.
     * @return Une chaîne de caractères représentant l'agressivité.
     */
    public String exprimerAgressivite(Lycanthrope lycanthrope){
        return RED + lycanthrope.getNom() + " 😠 se hurle de manière agressive à l'égard de " + GREEN + this.nom + " 🔥 !" + RESET;
    }

    /**
     * Affiche les caractéristiques du lycanthrope.
     *
     * @return Une chaîne de caractères représentant les caractéristiques du lycanthrope.
     */
    public String afficherCaracteristiques() {
        return this.nom + " a pour caractéristiques : \n" +
                "Sexe : " + this.sexe + "\n" +
                "Catégorie d'Âge : " + this.categorieAge + "\n" +
                "Force : " + CYAN + this.force + RESET + "\n" +
                "Facteur Domination : " + YELLOW + this.facteurDomination + RESET + "\n" +
                "Rang : " + this.rang + "\n" +
                "Niveau : " + GREEN + this.niveau + RESET + "\n" +
                "Facteur Impétuosité : " + this.facteurImpetuosite + "\n" +
                "Réussite Domination : " + this.reussiteDomination + "\n" +
                "Devenir Humain : " + this.devenirHumain + "\n" +
                "Meute : " + this.meute + "\n";
    }


}