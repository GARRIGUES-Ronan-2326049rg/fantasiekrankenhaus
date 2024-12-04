package modele.monstre;


import modele.Maladie;
import modele.service.ServiceMedical;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Vampire extends Monstre{

    /**
     * Constructeur de la classe Vampire
     * @param type
     * @param nom
     * @param sexe
     * @param poids
     * @param taille
     * @param age
     * @param indicateurMoral
     */
    public Vampire(String type, String nom, char sexe, short poids, short taille, int age, int indicateurMoral) {
        super(type, nom, sexe, poids, taille, age, indicateurMoral);
    }
}
