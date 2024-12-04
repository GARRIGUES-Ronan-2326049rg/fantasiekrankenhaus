package modele;

import java.sql.*;

/**
 * La classe Recapitulatif permet de suivre les statistiques de fin de partie,
 * telles que le nombre de maladies guéries et le nombre de morts.
 * Elle implémente le pattern Singleton pour garantir une seule instance.
 */
public class Recapitulatif {
    private static Recapitulatif instance;
    private int nombreMaladies;
    private int nombreMorts;

    private static final String DB_URL = "jdbc:postgresql://postgresql-hopitalfa.alwaysdata.net:5432/hopitalfa_bd";
    private static final String DB_USER = "hopitalfa"; // Remplace par ton identifiant AlwaysData
    private static final String DB_PASSWORD = "ronan22";

    /**
     * Obtient une connexion à la base de données.
     *
     * @return Une connexion à la base de données.
     * @throws SQLException Si une erreur survient lors de la connexion.
     */
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Sauvegarde les statistiques dans la base de données.
     *
     * @param nom Le nom de la partie.
     * @param nb_morts Le nombre de morts.
     * @param nb_maladie Le nombre de maladies guéries.
     * @throws SQLException Si une erreur survient lors de la sauvegarde.
     */
    public void sauvegarderDansBaseDeDonnees(String nom, int nb_morts, int nb_maladie) throws SQLException {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO stat(nom, nb_mort, nb_maladie) VALUES (?, ?, ?)");
            preparedStatement.setString(1, nom);
            preparedStatement.setInt(2, nb_morts);
            preparedStatement.setInt(3, nb_maladie);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Affiche tous les récapitulatifs enregistrés dans la base de données.
     */
    public void afficherTousLesRecaps() {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stat");
            while (resultSet.next()) {
                System.out.println("Nom : " + resultSet.getString("nom") + " | Morts : " + resultSet.getInt("nb_mort") + " | Maladies : " + resultSet.getInt("nb_maladie"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
     * Getter du nombre de maladies guéries.
     *
     * @return Le nombre de maladies guéries.
     */
    public int getNombreMaladies() {
        return nombreMaladies;
    }

    /**
     * Getter du nombre de morts.
     *
     * @return Le nombre de morts.
     */
    public int getNombreMorts() {
        return nombreMorts;
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