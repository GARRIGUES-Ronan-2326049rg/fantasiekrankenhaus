package controller;
import modele.monstre.Monstre;
import modele.monstre.MonstreFactory;
import view.JoueurView;

public class JoueurController {

    public void afficheRegle(){
        JoueurView view = new JoueurView();
        System.out.println(view.presentationJeu());
    }

    public void afficheMonstre(Monstre monstre1){
        Monstre monstre = MonstreFactory.creerMonstreAleatoire();
        JoueurView view = new JoueurView();
        view.afficheMonstre(monstre);
    }


}
