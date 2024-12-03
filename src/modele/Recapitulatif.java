package modele;

public class Recapitulatif {
    private static Recapitulatif instance;
    private int nombreMaladies;
    private int nombreMorts;

    // Constructeur privé pour empêcher l'instanciation directe
    private Recapitulatif() {
        this.nombreMaladies = 0;
        this.nombreMorts = 0;
    }

    // Méthode pour récupérer l'unique instance
    public static Recapitulatif getInstance() {
        if (instance == null) {
            instance = new Recapitulatif();
        }
        return instance;
    }

    // Méthode pour incrémenter le nombre de maladies
    public void incrementerMaladie() {
        nombreMaladies++;
    }

    // Méthode pour incrémenter le nombre de morts
    public void incrementerMort() {
        nombreMorts++;
    }

    // Méthode pour afficher le récapitulatif
    public void afficherRecapitulatif() {
        final String RESET = "\u001B[0m";
        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        final String BLUE = "\u001B[34m";

        System.out.println(BLUE + "=== Récapitulatif de Fin de Partie ===" + RESET);
        System.out.println(GREEN + "Nombre de Maladies guéries : " + nombreMaladies + RESET);
        System.out.println(RED + "Nombre de Morts : " + nombreMorts + RESET);
        System.out.println(BLUE + "=====================================" + RESET);
    }
}
