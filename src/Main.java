import controller.JoueurController;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        JoueurController joueurController = new JoueurController();
        joueurController.choixJeu();
    }
}
