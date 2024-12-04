package modele.monstre;

public class Nain extends Monstre{
    /**
     * Constructeur de la classe Nain
     * @param type
     * @param nom
     * @param sexe
     * @param poids
     * @param taille
     * @param age
     * @param indicateurMoral
     */
    public Nain(String type,String nom, char sexe, short poids, short taille, int age, int indicateurMoral) {
        super(type,nom, sexe, poids, taille, age, indicateurMoral);
    }
}
