package modele.monstre;

public class Reptilien extends Monstre{

    /**
     * Constructeur de la classe Reptilien
     * @param type
     * @param nom
     * @param sexe
     * @param poids
     * @param taille
     * @param age
     * @param indicateurMoral
     */
    public Reptilien(String type,String nom, char sexe, short poids, short taille, int age, int indicateurMoral) {
        super(type,nom, sexe, poids, taille, age, indicateurMoral);
    }
}
