package modele.monstre;

import modele.ListeMaladies;
import modele.Maladie;

import java.util.List;
import java.util.Random;

public class MonstreFactory {

    private static final String[] noms = {
            "Gork", "Mork", "Zagreb", "Thranduil", "Balrog", "Fenrir", "Dracula", "Ragnar", "Smeagol", "Azog"
    };

    private static final String[] types = {
            "Elfe", "Vampire", "Zombie", "Lycanthrope", "Orque", "Nain", "Reptilien"
    };

    private static final Random random = new Random();

    // Méthode pour créer un monstre aléatoire
    public static Monstre creerMonstreAleatoire() {
        char sexe = random.nextBoolean() ? 'M' : 'F'; // Sexe random
        short poids = (short) (30 + random.nextInt(150)); // Poids entre 30 et 180 kg
        short taille = (short) (100 + random.nextInt(100)); // Taille entre 100 et 200 cm
        int age = random.nextInt(500); // Âge aléatoire entre 0 et 500 ans
        int moral = 50 + random.nextInt(51); // Moral entre 50 et 100

        // Crée un nouveau monstre
        Monstre monstre = new Monstre(
                types[random.nextInt(types.length)],
                noms[random.nextInt(noms.length)],
                sexe,
                poids,
                taille,
                age,
                moral
        );

        // donne une ou plusieurs maladies aléatoires
        List<Maladie> maladies = ListeMaladies.getMaladies();
        int nombreMaladies = random.nextInt(3) + 1; // Chaque monstre peut avoir entre 1 et 3 maladies

        for (int i = 0; i < nombreMaladies; i++) {
            Maladie maladieAleatoire = maladies.get(random.nextInt(maladies.size()));

            // Ajuste le niveau actuel de la maladie de façon aléatoire
            int niveauInitial = random.nextInt(maladieAleatoire.getNiveauMax() - 1) + 1;
            Maladie maladieAvecNiveau = new Maladie(
                    maladieAleatoire.getNomComplet(),
                    maladieAleatoire.getNomAbrege(),
                    maladieAleatoire.getNiveauActuel(),
                    maladieAleatoire.getNiveauMax()
            );

            // Ajouter la maladie au monstre
            monstre.tomberMalade(maladieAvecNiveau);
        }

        return monstre;
    }
}
