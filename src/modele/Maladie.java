package modele;

public class Maladie {
    private String nomComplet;
    private String nomAbrege;
    private int niveauActuel;
    private int niveauMax;

    public Maladie(String nomComplet, String nomAbrege, int niveauActuel, int niveauMax) {
        this.nomComplet = nomComplet;
        this.nomAbrege = nomAbrege;
        this.niveauActuel = niveauActuel;
        this.niveauMax = niveauMax;
    }

    // Getters et Setters
    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getNomAbrege() {
        return nomAbrege;
    }

    public void setNomAbrege(String nomAbrege) {
        this.nomAbrege = nomAbrege;
    }

    public int getNiveauActuel() {
        return niveauActuel;
    }

    public void setNiveauActuel(int niveauActuel) {
        this.niveauActuel = Math.max(0, Math.min(niveauActuel, niveauMax)); // Garde le niveau dans les limites 0 à niveauMax
    }

    public int getNiveauMax() {
        return niveauMax;
    }

    public void setNiveauMax(int niveauMax) {
        this.niveauMax = niveauMax;
    }

    // Méthodes pour augmenter ou diminuer le niveau actuel
    public void augmenterNiveau(int increment) {
        setNiveauActuel(this.niveauActuel + increment);
    }

    public void diminuerNiveau(int decrement) {
        setNiveauActuel(this.niveauActuel - decrement);
    }

    // Déterminer si la maladie est létale
    public boolean estLetale() {
        return this.niveauActuel >= this.niveauMax;
    }

    @Override
    public String toString() {
        return "Maladie{" +
                "nomComplet='" + nomComplet + '\'' +
                ", nomAbrege='" + nomAbrege + '\'' +
                ", niveauActuel=" + niveauActuel +
                ", niveauMax=" + niveauMax +
                '}';
    }
}
