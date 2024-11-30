package modele.monstre;

public class Lycanthrope extends Monstre{

    private String categorieAge;
    private int force;
    private int facteurDomination;
    private int rang;
    private int niveau;
    private int facteruImpetuosite;
    private String meute = null;

    public Lycanthrope(String nom, int age) {
        super(nom, "Lycanthrope", 'M', (short) 100, (short) 200, age, 100);

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

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getFacteruImpetuosite() {
        return facteruImpetuosite;
    }

    public void setFacteruImpetuosite(int facteruImpetuosite) {
        this.facteruImpetuosite = facteruImpetuosite;
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
                + "FacteruImpetuosite : " + this.facteruImpetuosite + "\n"
                + "Meute : " + this.meute + "\n";
    }
}
