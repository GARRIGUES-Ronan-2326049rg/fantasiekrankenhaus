package modele.monstre;

public class Zombie extends Monstre{

    /**
     * Constructeur de la classe Zombie
     * @param type
     * @param nom
     * @param sexe
     * @param poids
     * @param taille
     * @param age
     * @param indicateurMoral
     */
    public Zombie(String type,String nom, char sexe, short poids, short taille, int age, int indicateurMoral) {
        super(type,nom, sexe, poids, taille, age, indicateurMoral);
    }
}
