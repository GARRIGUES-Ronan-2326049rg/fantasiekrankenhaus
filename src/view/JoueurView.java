package view;

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

    public void demandeChoix(){
        System.out.println( "Voulez vous :\n" +
                "Agir sur les médecins : 'agir'\n" +
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

    public void demandeAction(){
        System.out.println("Pour ce médecin voulez vous : \n" +
                "Examiner un service ? Ne retire pas d'action. Tapez Examiner\n" +
                "Soigner un patient ? Tapez Soigner\n" +
                "Réviser le budget ? Tapez Reviser\n" +
                "Transférer le patient ? Tapez Tranferer\n");
    }

    public void choisirService(ArrayList<ServiceMedical> listeService) {
        System.out.println("Sur quel service voulait vous intervenir ? Tapez son nom \n");
        for (ServiceMedical serviceMedical : listeService) {
            System.out.println(serviceMedical.getNom() + "\n");
        }

    }

    public void choisirMonstre(ArrayList<Monstre> listeCreature) {
        System.out.println("Sur quel monstre voulait vous intervenir ? Tapez son nom \n");
        for (Monstre monstre : listeCreature) {
            System.out.println(monstre.getNom() + "\n");
        }
    }

    public void demandeBudget() {
        System.out.println("Quel budget : ");
    }
}
