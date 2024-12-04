package view;

import modele.lycanthrope.Lycanthrope;
import modele.lycanthrope.Meute;
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
     * Présente le contexte du jeu pour un lycanthrope.
     *
     * @return Un message formaté décrivant le jeu et ses objectifs pour un lycanthrope.
     */
    public String presentationJeuLycanthrope() {
        return CYAN + "🌕 Bienvenue jeune lycanthrope solitaire !\n" + RESET +
                "Au cours d'une balade, vous êtes tombé sur une colonie composée d'une petite meute.\n" +
                "🌟 Pris de compassion pour vos semblables, vous avez décidé de les aider à organiser leur communauté.\n" +
                GREEN + "Observez votre meute évoluer : les hiérarchies se former, les nouveaux-nés trouver refuge.\n" + RESET +
                "🔄 Voyez vos compagnons se disputer, se soumettre, ou quitter la meute pour en fonder une nouvelle.\n" +
                "Profitez pleinement de vos jours parmi eux et de leur incroyable résilience !";
    }

    /**
     * Demande au joueur de choisir un type de jeu.
     */
    public void demandeJeu() {
        System.out.println(CYAN + "Que souhaitez-vous faire ?\n" + RESET +
                "  🏥 " + GREEN + "Gérer un hôpital" + RESET + " : tapez 'Hopital'\n" +
                "  🐺 " + YELLOW + "Prendre soin d'une colonie de lycanthropes" + RESET + " : tapez 'Loups'\n");
    }

    /**
     * Demande au joueur de choisir une action pour un lycanthrope.
     */
    public void demanderChoixLycanthrope() {
        System.out.println(CYAN + "Que souhaitez-vous faire ?" + RESET + "\n" +
                "  🐺 " + GREEN + "Agir sur les lycanthropes" + RESET + " : tapez 'agir'\n" +
                "  🛑 " + RED + "Mettre fin au jeu" + RESET + " : tapez 'finir'\n");
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
        message.append("  🔄 " + GREEN + "Passer la journée " + RESET + " : tapez 99 \n");
        System.out.println(message.toString());
    }

    /**
     * Demande au joueur de choisir une action spécifique pour un médecin.
     */
    public void demandeAction() {
        System.out.println("Que voulez-vous faire pour ce médecin ?\n" +
                "  🧐 " + GREEN + "Examiner un service" + RESET + " (ne consomme pas d'action) : tapez 'Examiner'\n" +
                "  🩺 " + YELLOW + "Soigner un patient" + RESET + " : tapez 'Soigner'\n" +
                "  💰 " + CYAN + "Réviser le budget" + RESET + " : tapez 'Reviser'\n" +
                "  🔄 " + MAGENTA + "Transférer un patient" + RESET + " : tapez 'Transferer'\n" );
    }

    /**
     * Demande au joueur de choisir une action pour un lycanthrope.
     */
    public void demandeActionLycanthrope() {
        System.out.println(CYAN + "Que voulez-vous faire avec ce loup ?" + RESET + "\n" +
                "  🐾 " + GREEN + "Dominer un autre loup" + RESET + " : tapez 'Dominer'\n" +
                "  🌕 " + YELLOW + "Le faire hurler" + RESET + " : tapez 'Hurler'\n" +
                "  ❌ " + RED + "Le forcer à quitter la meute" + RESET + " : tapez 'Quitter'\n" +
                "  🔍 " + MAGENTA + "Observer ses caractéristiques" + RESET + " : tapez 'Observer'\n");
    }

    /**
     * Demande au joueur de choisir une action pour gérer une meute ou un lycanthrope solitaire.
     */
    public void demanderChoixAgir() {
        System.out.println(CYAN + "Voulez-vous vous occuper :" + RESET + "\n" +
                "  🐺 " + GREEN + "D'une meute" + RESET + " : tapez 'Meute'\n" +
                "  🐾 " + YELLOW + "D'un lycanthrope solitaire" + RESET + " : tapez 'Seul'\n" +
                "  📜 " + MAGENTA + "Voir les caractéristiques de la colonie" + RESET + " : tapez 'Description'\n");
    }

    /**
     * Affiche les meutes disponibles pour que le joueur puisse en choisir une.
     *
     * @param listeMeute Liste des meutes disponibles.
     */
    public void demanderChoixMeute(ArrayList<Meute> listeMeute) {
        StringBuilder message = new StringBuilder(CYAN + "Voici les meutes sur lesquelles vous pouvez agir :" + RESET);
        for (int i = 0; i < listeMeute.size(); ++i) {
            message.append("\n  🐺 ").append(GREEN).append(listeMeute.get(i).getNom()).append(RESET)
                    .append(" : tapez ").append(i);
        }
        System.out.println(message.toString());
    }

    /**
     * Demande au joueur de choisir une action pour un lycanthrope solitaire.
     */
    public void demanderActionSolitaire() {
        System.out.println(GREEN + "Pour ce lycanthrope, voulez-vous :" + RESET + "\n" +
                "  ✨ Lui demander de créer une nouvelle meute ? Tapez 'Meute'\n" +
                "  🔙 Revenir en arrière ? Tapez 'Retour'\n");
    }

    /**
     * Affiche les services disponibles pour que le joueur puisse en choisir un.
     *
     * @param listeService Liste des services disponibles.
     */
    public void choisirService(ArrayList<ServiceMedical> listeService) {
        System.out.println(CYAN + "Sur quel service voulez-vous intervenir ? Tapez son nom :" + RESET);
        for (ServiceMedical serviceMedical : listeService) {
            System.out.println("  🏥 " + GREEN + serviceMedical.getNom() + RESET);
        }
    }

    /**
     * Affiche les meutes disponibles pour que le joueur puisse en choisir une.
     *
     * @param listeMeute Liste des meutes disponibles.
     */
    public void choisirMeute(ArrayList<Meute> listeMeute) {
        System.out.println(CYAN + "Sur quelle meute voulez-vous intervenir ? Tapez son nom :" + RESET);
        for (Meute meute : listeMeute) {
            System.out.println("  🐺 " + GREEN + meute.getNom() + RESET);
        }
    }

    /**
     * Affiche les monstres disponibles pour que le joueur puisse en choisir un.
     *
     * @param listeCreature Liste des monstres disponibles dans un service.
     */
    public void choisirMonstre(ArrayList<Monstre> listeCreature) {
        System.out.println("Sur quel monstre voulez vous intervenir ? Tapez son nom \n");
        for (Monstre monstre : listeCreature) {
            if (!monstre.getListeMaladie().isEmpty()){
                System.out.println("  👹 " + YELLOW + monstre.getNom() + RESET);
            }
        }
    }

    /**
     * Affiche les lycanthropes disponibles pour que le joueur puisse en choisir un.
     *
     * @param listeLycanthrope Liste des lycanthropes disponibles.
     */
    public void choisirLycanthrope(ArrayList<Lycanthrope> listeLycanthrope) {
        System.out.println(CYAN + "Sur quel lycanthrope voulez-vous intervenir ? Tapez son nom :" + RESET);
        for (Lycanthrope lycanthrope : listeLycanthrope) {
            System.out.println("  🐺 " + GREEN + lycanthrope.getNom() + RESET);
        }
    }

    /**
     * Demande au joueur de fournir son nom.
     */
    public void demandeNom() {
        System.out.println("Quel est votre nom ? : ");
    }

    /**
     * Demande au joueur de fournir un budget pour un service.
     */
    public void demandeBudget() {
        System.out.println("Quel budget souhaitez-vous allouer ? Entrez soit Inexistant -> Mediocre -> Insuffisant -> Faible -> Moyen -> Bon -> Super -> Parfait");
    }
}