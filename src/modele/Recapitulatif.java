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

    private static final String DB_URL = "jdbc:postgresql://hopitalf.alwaysdata.net:5432/hopitalf";
    private static final String DB_USER = "hopitalf"; // Remplace par ton identifiant AlwaysData
    private static final String DB_PASSWORD = "ronanroot";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public  void creerTable() {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS recapitulatif (
                id SERIAL PRIMARY KEY,
                date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                nombreMaladies INTEGER NOT NULL,
                nombreMorts INTEGER NOT NULL,
            );
            """;

        try (Connection connection = getConnection();

             Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table 'recapitulatif' vérifiée/créée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void sauvegarderDansBaseDeDonnees() {
        String insertSQL = "INSERT INTO recapitulatif (nombreMaladies, nombreMorts) VALUES (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(insertSQL)) {
            ps.setInt(1, nombreMaladies);
            ps.setInt(2, nombreMorts);
            ps.executeUpdate();
            System.out.println("Récapitulatif enregistré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afficherTousLesRecaps() {
        String query = "SELECT * FROM recapitulatif";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Date : " + rs.getTimestamp("date"));
                System.out.println("Nombre de Maladies : " + rs.getInt("nombreMaladies"));
                System.out.println("Nombre de Morts : " + rs.getInt("nombreMorts"));
                System.out.println("-----------");
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
     * Getter du nombre de maladie
     * @return nombre de maladie
     */
    public int getNombreMaladies() {
        return nombreMaladies;
    }

    /**
     * Getter du nombre de mort
     * @return nombre de mort
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
