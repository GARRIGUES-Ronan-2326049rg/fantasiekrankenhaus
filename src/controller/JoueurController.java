package controller;

import modele.Medecin;
import view.HopitalView;
import view.JoueurView;

import java.util.ArrayList;
import java.util.Scanner;

public class JoueurController {
    JoueurView view = new JoueurView();

    public void afficheRegle(){
        this.view.presentationJeu();
    }

    public String choixTour(){
        this.view.demandeChoix();
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public String choixTourChoixMedecin(ArrayList<Medecin> listeMedecin){
        this.view.demandeChoixMedecin(listeMedecin);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public String demandeAction(){
        this.view.demandeAction();
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }



}
