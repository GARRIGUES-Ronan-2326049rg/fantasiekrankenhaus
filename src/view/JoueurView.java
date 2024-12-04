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


    public String presentationJeuLycanthrope() {
        return "Bienvenue jeune lycanthrope solitaire!\n" +
                "Au cours d'une balade, vosu êtes tombé sur une colonie constitué d'une seule petite meute.\n" +
                "Pris d'un sentiment de pitié pour vos semblables, vous décidez de venir leur préter un coup de patte dans l'organisation de leur communauté\n" +
                "Observez votre meute évoluer, changer de hiérarchie, devenir le refuge de nouveau-nés.\n" +
                "Observez vos semblables se disputer, se soumettre entre eux, quitter leur meute pour peut-être en recréer une ?\n" +
                "Profitez simplement de vos beaux jours parmi eux !";

    }

    public void demandeJeu(){
        System.out.println("Voulez vous :\n" +
            "Vous occupez d'un hôpital : 'Hopital' \n" +
            "Vous occupez d'une colonie de lycanthropes : 'Loups' \n");
    }

    public void demanderChoixLycanthrope(){
        System.out.println( "Voulez vous :\n" +
                "Agir sur les lycanthropes : 'agir'\n" +
                "Finir le jeu ? : 'finir'\n");
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

    public void demandeActionLycanthrope(){
        System.out.println("Que voulez-vous faire avec ce loup ?\n" +
                "Dominer un autre loup : tapez 'Dominer' \n" +
                "Le faire hurler : tapez 'Hurler \n" +
                "Le forcer a quitté la meute : tapez 'Quitter' \n" +
                "Observer ses caractéristiques : tapez 'Observer'");
    }


    public void demanderChoixAgir(){
        System.out.println("Voulez-vous vous occuper : \n" +
                "D'une meute ? Tapez 'Meute' \n" +
                "D'un lycanthrope solitaire ? Tapez 'Seul'");
    }


    public void demanderChoixMeute(ArrayList<Meute> listeMeute){
        StringBuilder message = new StringBuilder("Voici les meutes sur lesquels vous pouvez agir.");
        for (int i = 0; i < listeMeute.size(); ++i){
            message.append("\n").append(listeMeute.get(i).getNom()).append(" : tapez ").append(String.valueOf(i));
        }
        System.out.println(message.toString());
    }

//    public void demandeActionMeute() {
//        System.out.println("Pour cette meute, voulez vous : \n" +
//                "Tenter uen domination ? Tapez Dominer\n" +
//                "Demander à un membre de hurler son appartenance à la meute ? Tapez Hurler" +
//                "Demander à un membr de quitter la meute ? Tapez Quitter" +
//                "Revenir en arrière ? Tapez Retour\n");
//    }

    public void demanderActionSolitaire(){
        System.out.println("Pour ce lycanthrope, voulez vous : \n" +
                "Lui demander de créer une nouvelle meute ? Tapez Meute\n" +
                "Revenir en arrière ? Tapez Retour\n");
    }

    public void choisirService(ArrayList<ServiceMedical> listeService) {
        System.out.println("Sur quel service voulez vous intervenir ? Tapez son nom \n");
        for (ServiceMedical serviceMedical : listeService) {
            System.out.println("  🏥 " + GREEN + serviceMedical.getNom() + RESET);
        }
    }

    public void choisirMeute(ArrayList<Meute> listeMeute){
        System.out.println("Sur quelle meute voulez vous intervenir ? Tapez son nom \n");
        for (Meute meute : listeMeute) {
            System.out.println(meute.getNom() + "\n");
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

    public void choisirLycanthrope(ArrayList<Lycanthrope> listeLycanthrope) {
        System.out.println("Sur quel lycanthrope voulez vous intervenir ? Tapez son nom \n");
        for (Lycanthrope lycanthrope : listeLycanthrope) {
            System.out.println(lycanthrope.getNom() + "\n");
        }
    }

    public void demandeNom() {
        System.out.println("Quel est votre nom ? : ");
    }

    /**
     * Demande au joueur de fournir un budget pour un service.
     */
    public void demandeBudget() {
        System.out.println("Quel budget souhaitez-vous allouer ? Entrez soit Inexistant / Médiocre / Insuffisant / Faible :");
    }
}
