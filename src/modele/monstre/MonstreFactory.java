package modele.monstre;

import modele.ListeMaladies;
import modele.Maladie;

import java.util.List;
import java.util.Random;

public class MonstreFactory {

    private static final String[] noms = {
            "Gork", "Mork", "Zagreb", "Thranduil", "Balrog", "Fenrir", "Dracula", "Ragnar", "Smeagol", "Azog", "Atreus", "Mevis", "Shrek", "Jlark",
            "Hucle", "Klorlcus", "Doume", "Guglukuss", "Poutikos", "Hitlamus", "Zeukros", "Athos", "Ronalus", "Doriione", "Mannaon", "Flopidus",
            "Galactrusse", "Frankestrouc", "Jululusse", "Arnaunurding", "Cyrilouxano", "Sorenbapt", "Emedeuxpierre", "Hestelle", "Zackus", "Drackitlos",
            "Thébaro", "Tittit", "Kirolex", "Colayko", "Medhidonc", "Youyou", "Evianzaks", "Thomatopesto", "Leheffe", "Skibididimitri", "Soregrory", "Bibou",
            "Troulaloupe", "Zekromas", "Salabot", "Nashtaul", "Enderlouis", "Cedrifox", "Tahino", "Nevot", "Hadjene", "Davina", "Wagatas", "Casali", "Shirotozor",
            "Cursetieu", "Kevinus", "Arthurus" , "Poupidis", "Jouinax", "Salalou", "Maksadoude", "Flouvix", "Prostas", "Couloute", "Anninis", "Gouillou", "Soufiannoc",
            "Agathor", "Ronark", "Lauragore", "Lowelith", "Solanox", "Yohar", "Matteor","Dracula", "Frankenstein", "Cthulhu", "Jaws", "Shrek", "Medusa", "Wendigo",
            "Chucky", "Behemoth", "Hydra", "Sasquatch", "Zombie", "Phantom", "Cerberus", "Gorgon", "Chimera", "Kong",
            "Slimer", "Beetlejuice", "Werewolf", "Harpy", "Banshee", "Manticore", "Roc", "Ogre", "Basilisk", "Leprechaun", "Nessie",
            "Scarecrow", "Krampus", "Mothman", "Doppelgänger", "Chupacabra", "Basilisk", "Wraith", "Nymph", "Ghast", "Quetzalcoatl", "Tatzelwurm", "Bunyip", "Manitou", "Incubus", "Succubus",
            "Mogwai", "Kitsune", "Aswang", "Jotun", "Hobbit", "Skinwalker", "Tiamat", "Yuki-onna", "Charybdis", "Ymir", "Zoltar", "Salamander", "Fenrir", "Pixie", "Poltergeist", "Shapeshifter",
            "Gargoyle", "Kappa", "Grendel", "Charybdis", "Draugr", "Siren", "Manticore",
            "Imp", "Mummy", "Naga", "Lamia", "Pooka", "Cyclops", "Golem", "Basilisk", "Wight"
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

        // Ajoute des maladies aléatoires
        ajouterMaladiesAleatoires(monstre);
        return monstre;
    }

    // Méthode privée pour ajouter des maladies aléatoires à un monstre
    static void ajouterMaladiesAleatoires(Monstre monstre) {
        List<Maladie> maladiesDisponibles = ListeMaladies.getMaladies(); // Liste des maladies
        int nombreMaladies = random.nextInt(2) + 1; // Entre 1 et 3 maladies

        for (int i = 0; i < nombreMaladies; i++) {
            Maladie maladieAleatoire;
            boolean maladieAjoutee;

            do {
                maladieAleatoire = maladiesDisponibles.get(random.nextInt(maladiesDisponibles.size()));
                Maladie finalMaladieAleatoire = maladieAleatoire;
                maladieAjoutee = monstre.getListeMaladie().stream()
                        .anyMatch(m -> m.getNomComplet().equals(finalMaladieAleatoire.getNomComplet()));
            } while (maladieAjoutee); // Réessaye si la maladie est déjà présente

            // Génère un niveau initial pour la maladie
            int niveauInitial = random.nextInt(maladieAleatoire.getNiveauMax() - 1) + 1;

            // Crée une copie de la maladie avec le niveau
            Maladie maladieAvecNiveau = new Maladie(
                    maladieAleatoire.getNomComplet(),
                    maladieAleatoire.getNomAbrege(),
                    niveauInitial,
                    maladieAleatoire.getNiveauMax()
            );

            // Ajoute la maladie au monstre
            monstre.tomberMalade(maladieAvecNiveau);
            }

            return;
        }
    }
