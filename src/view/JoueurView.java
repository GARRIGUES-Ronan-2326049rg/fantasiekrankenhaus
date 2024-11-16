package view;

import modele.monstre.Monstre;

public class JoueurView {

    public String presentationJeu(){
        return "Bienvenue, nouveau directeur de l'Hôpital des Monstres !\n" +
                "Votre mission est de gérer un hôpital unique en son genre, où les patients sont... des monstres !\n" +
                "Ces créatures, bien qu'effrayantes, ont besoin de vos soins pour se rétablir et éviter la catastrophe.\n" +
                "Organisez les services, soignez les monstres et gérez les situations d'urgence avec sagesse.\n" +
                "Rappelez-vous : chaque décision compte et chaque monstre a sa propre spécificité. Bonne chance, Directeur !";
    }

    public void afficheMonstre(Monstre monstre){
        System.out.println("Le monstre est un : " + monstre.getType() + " et s'appelle : " + monstre.getNom());
    }

}
