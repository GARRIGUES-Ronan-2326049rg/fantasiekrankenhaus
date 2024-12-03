package modele;

/**
 * La classe Recapitulatif permet de suivre les statistiques de fin de partie,
 * telles que le nombre de maladies guéries et le nombre de morts.
 * Elle implémente le pattern Singleton pour garantir une seule instance.
 */
public class Recapitulatif {
    private static Recapitulatif instance;
    private int nombreMaladies;
    private int nombreMorts;

    /**
     * Constructeur privé pour empêcher l'instanciation directe de la classe.
     * Initialise les compteurs de maladies et de morts à 0.
     */
    private Recapitulatif() {
        this.nombreMaladies = 0;
        this.nombreMorts = 0;
    }

    /**
     * Retourne l'unique instance de la classe Recapitulatif.
     * Si l'instance n'existe pas encore, elle est créée.
     *
     * @return l'instance unique de Recapitulatif
     */
    public static Recapitulatif getInstance() {
        if (instance == null) {
            instance = new Recapitulatif();
        }
        return instance;
    }

    /**
     * Incrémente le compteur du nombre de maladies guéries.
     */
    public void incrementerMaladie() {
        nombreMaladies++;
    }

    /**
     * Incrémente le compteur du nombre de morts.
     */
    public void incrementerMort() {
        nombreMorts++;
    }

    /**
     * Affiche un récapitulatif des statistiques de fin de partie dans le terminal,
     * avec des couleurs pour une meilleure lisibilité.
     */
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
