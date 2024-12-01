package modele.lycanthrope;

public class Lycanthrope{

    private String nom;
    private char sexe;
    private int age;
    private String categorieAge;
    private int force;
    private int facteurDomination;
    private char rang;
    private int niveau;
    private int facteurImpetuosite;
    private String meute = null;

    public Lycanthrope(String nom, char sexe, int age, char rang) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
        this.rang = rang;

        //Attribution de la catégorie d'âge.
        if(age < 18) this.categorieAge = "Jeune";
        else if (age < 65) this.categorieAge = "Adulte";
        else this.categorieAge = "Vieux";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFacteurImpetuosite() {
        return facteurImpetuosite;
    }

    public void setFacteurImpetuosite(int facteurImpetuosite) {
        this.facteurImpetuosite = facteurImpetuosite;
    }

    public String getCategorieAge() {
        return categorieAge;
    }

    public void setCategorieAge(String categorieAge) {
        this.categorieAge = categorieAge;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getFacteurDomination() {
        return facteurDomination;
    }

    public void setFacteurDomination(int facteurDomination) {
        this.facteurDomination = facteurDomination;
    }

    public char getRang() {
        return rang;
    }

    public void setRang(char rang) {
        this.rang = rang;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getfacteurImpetuosite() {
        return facteurImpetuosite;
    }

    public void setfacteurImpetuosite(int facteurImpetuosite) {
        this.facteurImpetuosite = facteurImpetuosite;
    }

    public String getMeute() {
        return meute;
    }

    public void setMeute(String meute) {
        this.meute = meute;
    }

    public void transformation(){
        //TODO
    }

    public String afficherCaracteristiques(){
        return this.nom + "a pour caractéristiques : \n"
                + "Sexe : " + this.sexe + "\n"
                + "Age : " + this.age + "\n"
                + "Force : " + this.force + "\n"
                + "FacteurDomination : " + this.facteurDomination + "\n"
                + "Rang : " + this.rang + "\n"
                + "Niveau : " + this.niveau + "\n"
                + "facteurImpetuosite : " + this.facteurImpetuosite + "\n"
                + "Meute : " + this.meute + "\n";
    }
}
