package modele.monstre;

public class Elfe extends Monstre{


    public Elfe(String type,String nom, char sexe, short poids, short taille, int age, int indicateurMoral) {
        super(type,nom, sexe, poids, taille, age, indicateurMoral);
    }

    public void demoraliser(){
    }

    public Elfe(String nom) {
        super("Elfe", "Legolas", 'M', (short) 50, (short) 180, 100, (byte) 100);
    }
}
