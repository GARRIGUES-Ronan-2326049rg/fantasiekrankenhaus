package modele.monstre;

import modele.service.ServiceMedical;

import java.util.ArrayList;

public class Elfe extends Monstre{

    /**
     * Constructeur de la classe Elfe
     * @param type
     * @param nom
     * @param sexe
     * @param poids
     * @param taille
     * @param age
     * @param indicateurMoral
     */
    public Elfe(String type,String nom, char sexe, short poids, short taille, int age, int indicateurMoral) {
        super(type,nom, sexe, poids, taille, age, indicateurMoral);
    }

}
