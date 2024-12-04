package modele.monstre;

import modele.service.ServiceMedical;

import java.util.ArrayList;

public class Elfe extends Monstre{


    public Elfe(String type,String nom, char sexe, short poids, short taille, int age, int indicateurMoral) {
        super(type,nom, sexe, poids, taille, age, indicateurMoral);
    }

    // cette méthode permet de faire baisser le moral des créatures si l'Elfe est mort
    public void demoraliser(ServiceMedical service) {
        System.out.println("L'Elfe a démoralisé les créatures.");
        ArrayList<Monstre> monstres = new ArrayList<>(service.getListeCreature());
        monstres.remove(this); // on retire l'Elfe de la liste des monstres

        if (monstres.isEmpty()) {
            System.out.println("Il n'y a pas de créatures à démoraliser.");
            return;
        }

        // Applique la baisse de moral à tous les monstres restants
        for (Monstre monstre : monstres) {
            int nouveauMoral = Math.max(0, monstre.getIndicateurMoral() - 10); // Baisse de moral de 10, minimum 0
            monstre.setIndicateurMoral((byte) nouveauMoral);
            System.out.println(monstre.getNom() + " est affecté par la mort de l'Elfe et voit son moral baisser à " + nouveauMoral + ".");
        }
    }


}
