package modele.lycanthrope;

public class Lycanthrope{

    private String nom;
    private char sexe;
    private String categorieAge;
    private int force;
    private int facteurDomination;
    private char rang;
    private int niveau;
    private int facteurImpetuosite;
    private boolean reussiteDomination = true;
    private boolean devenirHumain = false;
    private String meute;

    public Lycanthrope(String nom, char sexe, String categorieAge, char rang, String meute) {
        this.nom = nom;
        this.sexe = sexe;
        this.categorieAge = categorieAge;
        this.rang = rang;
        this.meute = meute;
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

    public boolean isReussiteDomination() {
        return reussiteDomination;
    }

    public void setReussiteDomination(boolean reussiteDomination) {
        this.reussiteDomination = reussiteDomination;
    }

    public boolean isDevenirHumain() {
        return devenirHumain;
    }

    public void transformationHumain(){
        this.devenirHumain = true;
    }

//    public void transformationLycanthrope(){
//        this.devenirHumain = false;
//    }

    public String hurlementAppartenanceMeute(){
        return this.nom + " exprime son apparetenance à la meute " + this.meute + " !";
    }

    public String exprimerDomination(Lycanthrope lycanthrope){
        return this.nom + " a dominé " + lycanthrope.getNom() + " !";
    }

    public String exrpimerSoumission(Lycanthrope lycanthrope){
        return lycanthrope.getNom() + " a été soumis " + this.nom + " !";
    }

    public String exprimerAgressivite(Lycanthrope lycanthrope){
        return lycanthrope.getNom() + " se montre agressif " + this.nom + " !";
    }

    public String afficherCaracteristiques(){
        return this.nom + "a pour caractéristiques : \n"
                + "Sexe : " + this.sexe + "\n"
                + "Catégorie d'Âge : " + this.categorieAge + "\n"
                + "Force : " + this.force + "\n"
                + "FacteurDomination : " + this.facteurDomination + "\n"
                + "Rang : " + this.rang + "\n"
                + "Niveau : " + this.niveau + "\n"
                + "facteurImpetuosite : " + this.facteurImpetuosite + "\n"
                + "Meute : " + this.meute + "\n";
    }

}