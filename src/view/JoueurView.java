package view;

import modele.monstre.Monstre;
import modele.Medecin;
import modele.service.ServiceMedical;

import java.util.ArrayList;

/**
 * La classe JoueurView gère l'affichage et les interactions textuelles avec le joueur,
 * en fournissant des messages clairs et formatés.
 */
public class JoueurView {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String MAGENTA = "\u001B[35m";

    /**
     * Présente les règles et le contexte du jeu au joueur.
     *
     * @return Un message formaté décrivant le jeu et ses objectifs.
     */
    public String presentationJeu() {
        return CYAN + "Bienvenue, " + MAGENTA + "Directeur de l'Hôpital des Monstres" + RESET + " !\n" +
                "Votre mission : gérer un hôpital unique où les patients sont des créatures fantastiques.\n" +
                GREEN + "Organisez vos services, soignez vos patients et évitez les catastrophes !\n" + RESET +
                "Chaque décision compte.\n" + RED + "Bonne chance !\n";
    }

    /**
     * Demande au joueur de choisir une action principale pour le tour.
     */
    public void demandeChoix() {
        System.out.println("Que voulez-vous faire ?\n" +
                "  👉 " + GREEN + "Agir sur les médecins" + RESET + " : tapez 'agir'\n" +
                "  👉 " + RED + "Mettre fin à la partie" + RESET + " : tapez 'finir'\n");
    }

    /**
     * Affiche une liste des médecins disponibles pour agir,
     * ainsi que leurs actions restantes.
     *
     * @param listeMedecin Liste des médecins disponibles.
     */
    public void demandeChoixMedecin(ArrayList<Medecin> listeMedecin) {
        StringBuilder message = new StringBuilder("Médecins disponibles pour agir :\n");
        for (int i = 0; i < listeMedecin.size(); ++i) {
            if (listeMedecin.get(i).getActionPossible() > 0) {
                message.append("  ").append(i).append(" - ")
                        .append(CYAN).append(listeMedecin.get(i).getNom()).append(RESET)
                        .append(" (Actions restantes : ").append(GREEN)
                        .append(listeMedecin.get(i).getActionPossible()).append(RESET).append(")\n");
            }
        }
        System.out.println(message + "  99 - Passer à la journée suivante.\n");
    }

    /**
     * Demande au joueur de choisir une action spécifique pour un médecin.
     */
    public void demandeAction() {
        System.out.println("Que voulez-vous faire pour ce médecin ?\n" +
                "  🧐 " + GREEN + "Examiner un service" + RESET + " (ne consomme pas d'action) : tapez 'Examiner'\n" +
                "  🩺 " + YELLOW + "Soigner un patient" + RESET + " : tapez 'Soigner'\n" +
                "  💰 " + CYAN + "Réviser le budget" + RESET + " : tapez 'Reviser'\n" +
                "  🔄 " + MAGENTA + "Transférer un patient" + RESET + " : tapez 'Transferer'\n");
    }

    /**
     * Affiche les services disponibles pour que le joueur puisse en choisir un.
     *
     * @param listeService Liste des services disponibles.
     */
    public void choisirService(ArrayList<ServiceMedical> listeService) {
        System.out.println("Sur quel service voulez-vous intervenir ? Tapez son nom :\n");
        for (ServiceMedical serviceMedical : listeService) {
            System.out.println("  🏥 " + GREEN + serviceMedical.getNom() + RESET);
        }
    }

    /**
     * Affiche les monstres disponibles pour que le joueur puisse en choisir un.
     *
     * @param listeCreature Liste des monstres disponibles dans un service.
     */
    public void choisirMonstre(ArrayList<Monstre> listeCreature) {
        System.out.println("Sur quel monstre voulez-vous intervenir ? Tapez son nom :\n");
        for (Monstre monstre : listeCreature) {
            System.out.println("  👹 " + YELLOW + monstre.getNom() + RESET);
        }
    }

    /**
     * Demande au joueur de fournir un budget pour un service.
     */
    public void demandeBudget() {
        System.out.println("Quel budget souhaitez-vous allouer ? Entrez une valeur :");
    }
}
