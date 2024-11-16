package controller;

import view.HopitalView;
import view.JoueurView;

public class JoueurController {

    public void afficheRegle(){
        JoueurView view = new JoueurView();
        view.presentationJeu();
    }

}
