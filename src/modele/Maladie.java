package modele;

/**
 * La classe Maladie représente une maladie avec un nom complet, un nom abrégé,
 * et des niveaux de gravité actuels et maximum.
 */
public class Maladie {
    private String nomComplet;
    private String nomAbrege;
    private int niveauActuel;
    private int niveauMax;

    /**
     * Constructeur pour initialiser une maladie avec ses caractéristiques.
     *
     * @param nomComplet  Le nom complet de la maladie.
     * @param nomAbrege   Le nom abrégé de la maladie.
     * @param niveauActuel Le niveau actuel de gravité de la maladie.
     * @param niveauMax   Le niveau maximal de gravité de la maladie.
     */
    public Maladie(String nomComplet, String nomAbrege, int niveauActuel, int niveauMax) {
        this.nomComplet = nomComplet;
        this.nomAbrege = nomAbrege;
        this.niveauActuel = niveauActuel;
        this.niveauMax = niveauMax;
    }

    /**
     * @return Le nom complet de la maladie.
     */
    public String getNomComplet() {
        return nomComplet;
    }

    /**
     * Modifie le nom complet de la maladie.
     *
     * @param nomComplet Le nouveau nom complet.
     */
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    /**
     * @return Le nom abrégé de la maladie.
     */
    public String getNomAbrege() {
        return nomAbrege;
    }

    /**
     * Modifie le nom abrégé de la maladie.
     *
     * @param nomAbrege Le nouveau nom abrégé.
     */
    public void setNomAbrege(String nomAbrege) {
        this.nomAbrege = nomAbrege;
    }

    /**
     * @return Le niveau actuel de gravité de la maladie.
     */
    public int getNiveauActuel() {
        return niveauActuel;
    }

    /**
     * Modifie le niveau actuel de gravité de la maladie, en s'assurant qu'il reste entre 0 et le niveau maximal.
     *
     * @param niveauActuel Le nouveau niveau actuel.
     */
    public void setNiveauActuel(int niveauActuel) {
        this.niveauActuel = Math.max(0, Math.min(niveauActuel, niveauMax));
    }

    /**
     * @return Le niveau maximal de gravité de la maladie.
     */
    public int getNiveauMax() {
        return niveauMax;
    }

    /**
     * Modifie le niveau maximal de gravité de la maladie.
     *
     * @param niveauMax Le nouveau niveau maximal.
     */
    public void setNiveauMax(int niveauMax) {
        this.niveauMax = niveauMax;
    }

    /**
     * Augmente le niveau actuel de gravité de la maladie par une valeur donnée.
     *
     * @param increment La valeur à ajouter au niveau actuel.
     */
    public void augmenterNiveau(int increment) {
        setNiveauActuel(this.niveauActuel + increment);
    }

    /**
     * Diminue le niveau actuel de gravité de la maladie par une valeur donnée.
     *
     * @param decrement La valeur à soustraire au niveau actuel.
     */
    public void diminuerNiveau(int decrement) {
        setNiveauActuel(this.niveauActuel - decrement);
    }

    /**
     * Détermine si la maladie est létale, c'est-à-dire si le niveau actuel atteint ou dépasse le niveau maximal.
     *
     * @return {@code true} si la maladie est létale, sinon {@code false}.
     */
    public boolean estLetale() {
        return this.niveauActuel >= this.niveauMax;
    }

    /**
     * @return Une représentation sous forme de chaîne de caractères des caractéristiques de la maladie.
     */
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
