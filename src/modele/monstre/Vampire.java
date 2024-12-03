package modele.monstre;


import modele.Maladie;
import modele.service.ServiceMedical;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Vampire extends Monstre{

    public Vampire(String type, String nom, char sexe, short poids, short taille, int age, int indicateurMoral) {
        super(type, nom, sexe, poids, taille, age, indicateurMoral);
    }

    // cette méthode permet de faire baisser le moral des créatures si le vampire est mort
    public void demoraliser(ServiceMedical service) {
        System.out.println("Le vampire a démoralisé les créatures.");
        ArrayList<Monstre> monstres = new ArrayList<>(service.getListeCreature());
        monstres.remove(this); // on retire le vampire de la liste des monstres

        if (monstres.isEmpty()) {
            System.out.println("Il n'y a pas de créatures à démoraliser.");
            return;
        }
        // prend la moitié des monstres
        int nombreAffectes = monstres.size() / 2;

        // Applique la baisse de moral à la moitié sélectionnée
        for (int i = 0; i < nombreAffectes; i++) {
            Monstre monstre = monstres.get(i);
            int nouveauMoral = Math.max(0, monstre.getIndicateurMoral() - 10); // Baisse de moral de 10, minimum 0
            monstre.setIndicateurMoral((byte) nouveauMoral);
            System.out.println(monstre.getNom() + " est affecté par la mort du vampire et voit son moral baisser à " + nouveauMoral + ".");
        }
    }


    public void regenerer() {
        System.out.println("Le vampire se régénère.");

    }
}
