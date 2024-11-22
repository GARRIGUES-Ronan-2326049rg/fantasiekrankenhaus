package view;

import modele.Medecin;

import java.util.ArrayList;

public class JoueurView {

    public void presentationJeu(){
        System.out.println( "Olalala, ne serai ce pas un nouveau dirigeant de service ??" +
                "Qui souhaite reprendre en main cette hopital de monstre" +
                "Il est fou, mais remarque il fou l'être " +
                "Bienvenue, dans ce jeu vous devrais soigner le plus de patient possible et éviter tout problème" +
                "bon courage");

    }

    public void demandeChoix(){
        System.out.println( "Voulez vous :\n" +
                "Agir sur les médecins : 'agir'\n" +
                "Finir le jeu ? : 'fin'\n");
    }

    public void demandeChoixMedecin(ArrayList<Medecin> listeMedecin){
        StringBuilder message = new StringBuilder("Voici la liste des medecins pouvant encore effectuer des actions.");
        for (int i = 0; i < listeMedecin.size(); ++i){
            if( listeMedecin.get(i).isActionPossible()){
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

}
