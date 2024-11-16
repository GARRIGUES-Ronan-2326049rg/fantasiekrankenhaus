package modele;
import modele.monstre.*;

public class Medecin {
	private String nom;
	private char sexe;
	private byte age;
	private boolean actionPossible = true;

    public Medecin(String nom, char sexe, byte age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}

	public void setActionPossible(boolean actionPossible) {
		this.actionPossible = actionPossible;
	}

	public boolean isActionPossible() {
		return actionPossible;
	}

	public void transfererPatient(Monstre monstre){

		actionPossible = false;
	}
}
