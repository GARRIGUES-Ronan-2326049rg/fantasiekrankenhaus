package modele.monstre;

public class Lycanthrope extends Monstre{

    private String categorieAge;
    private int force;
    private int facteurDomination;
    private char rang;
    private int niveau;
    private int facteurImpetuosite;
    private String meute = null;

    public Lycanthrope(String nom, char sexe, int age, char rang) {
        super(nom, "Lycanthrope", sexe, (short) 100, (short) 200, age, 100);

        this.rang = rang;

        //Attribution de la catégorie d'âge.
        if(age < 18) this.categorieAge = "Jeune";
        else if (age < 65) this.categorieAge = "Adulte";
        else this.categorieAge = "Vieux";
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

    public void quitterMeute(){
        //TODO
    }

    public void entendreHurlement(){
        //TODO
    }

    public void transformation(){
        //TODO
    }

    public String afficherCaracteristiques(){
        return this.getNom() + "a pour caractéristiques : \n"
                + "Sexe : " + this.getSexe() + "\n"
                + "Age : " + this.getAge() + "\n"
                + "Force : " + this.force + "\n"
                + "FacteurDomination : " + this.facteurDomination + "\n"
                + "Rang : " + this.rang + "\n"
                + "Niveau : " + this.niveau + "\n"
                + "facteurImpetuosite : " + this.facteurImpetuosite + "\n"
                + "Meute : " + this.meute + "\n";
    }
}
