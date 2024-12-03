package view;

import modele.lycanthrope.Lycanthrope;
import modele.lycanthrope.Meute;
import modele.monstre.Monstre;

import modele.Medecin;
import modele.service.ServiceMedical;

import java.util.ArrayList;

public class JoueurView {

    public String presentationJeu(){
        return "Bienvenue, nouveau directeur de l'Hôpital des Monstres !\n" +
                "Votre mission est de gérer un hôpital unique en son genre, où les patients sont... des monstres !\n" +
                "Ces créatures, bien qu'effrayantes, ont besoin de vos soins pour se rétablir et éviter la catastrophe.\n" +
                "Organisez les services, soignez les monstres et gérez les situations d'urgence avec sagesse.\n" +
                "Rappelez-vous : chaque décision compte et chaque monstre a sa propre spécificité. Bonne chance, Directeur !\n";
    }

    public String presentationJeuLycanthrope(){
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

    public void demandeChoix(){
        System.out.println( "Voulez vous :\n" +
                "Agir sur les médecins : 'agir'\n" +
                "Finir le jeu ? : 'finir'\n");
    }

    public void demanderChoixLycanthrope(){
        System.out.println( "Voulez vous :\n" +
                "Agir sur les lycanthropes : 'agir'\n" +
                "Finir le jeu ? : 'finir'\n");
    }

    public void demandeChoixMedecin(ArrayList<Medecin> listeMedecin){
        StringBuilder message = new StringBuilder("Voici la liste des medecins pouvant encore effectuer des actions.");
        for (int i = 0; i < listeMedecin.size(); ++i){
            if(listeMedecin.get(i).getActionPossible() > 0){
                message.append("\n").append(listeMedecin.get(i).getNom()).append(" : tapez ").append(String.valueOf(i));
            }
        }
        System.out.println(message.toString());
    }

    public void demanderChoixMeute(ArrayList<Meute> listeMeute){
        StringBuilder message = new StringBuilder("Voici les meutes sur lesquels vous pouvez agir.");
        for (int i = 0; i < listeMeute.size(); ++i){
            message.append("\n").append(listeMeute.get(i).getNom()).append(" : tapez ").append(String.valueOf(i));
        }
        System.out.println(message.toString());
    }

    public void demandeAction(){
        System.out.println("Pour ce médecin voulez vous : \n" +
                "Examiner un service ? Ne retire pas d'action. Tapez Examiner\n" +
                "Soigner un patient ? Tapez Soigner\n" +
                "Réviser le budget ? Tapez Reviser\n" +
                "Transférer le patient ? Tapez Tranferer\n");
    }


    public void demandeActionMeute() {
        System.out.println("Pour cette meute, voulez vous : \n" +
                "Tenter uen domination ? Tapez Dominer\n" +
                "Demander à un membre de hurler son appartenance à la meute ? Tapez Hurler" +
                "Demander à un membr de quitter la meute ? Tapez Quitter" +
                "Revenir en arrière ? Tapez Retour\n");
    }

    public void demanderActionLycanthropeMeute(){
        System.out.println("Pour ce lycanthrope, voulez vous : \n" +
                "Lui demander de tenter uen domination ? Tapez Dominer\n" +
                "Lui demander de hurler son appartenance à sa meute ? Tapez Hurler" +
                "Lui demander de quitter la meute ? Tapez Quitter" +
                "Revenir en arrière ? Tapez Retour\n");
    }

    public void demanderActionSolitaire(){
        System.out.println("Pour ce lycanthrope, voulez vous : \n" +
                "Lui demander de créer une nouvelle meute ? Tapez Meute\n" +
                "Revenir en arrière ? Tapez Retour\n");
    }

    public void choisirService(ArrayList<ServiceMedical> listeService) {
        System.out.println("Sur quel service voulez vous intervenir ? Tapez son nom \n");
        for (ServiceMedical serviceMedical : listeService) {
            System.out.println(serviceMedical.getNom() + "\n");
        }
    }

    public void choisirMeute(ArrayList<Meute> listeMeute){
        System.out.println("Sur quelle meute voulez vous intervenir ? Tapez son nom \n");
        for (Meute meute : listeMeute) {
            System.out.println(meute.getNom() + "\n");
        }
    }

    public void choisirMonstre(ArrayList<Monstre> listeCreature) {
        System.out.println("Sur quel monstre voulez vous intervenir ? Tapez son nom \n");
        for (Monstre monstre : listeCreature) {
            System.out.println(monstre.getNom() + "\n");
        }
    }

    public void choisirLycanthrope(ArrayList<Lycanthrope> listeLycanthrope) {
        System.out.println("Sur quel lycanthrope voulez vous intervenir ? Tapez son nom \n");
        for (Lycanthrope lycanthrope : listeLycanthrope) {
            System.out.println(lycanthrope.getNom() + "\n");
        }
    }

    public void demandeBudget() {
        System.out.println("Quel budget : ");
    }
}
