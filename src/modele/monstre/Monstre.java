package modele.monstre;
import modele.Maladie;

import java.util.ArrayList;

public class Monstre {
	private String nom;
	private int pv = 100;
	private char sexe;
	private short poids;
	private short taille;
	private int age;
	private byte indicateurMoral = 100; // Représenté par un pourcentage
	private ArrayList<Maladie> listeMaladie = new ArrayList<>();

	public Monstre(String nom, char sexe, short poids, short taille, int age) {
		this.nom = nom;
		this.sexe = sexe;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
		//this.listeMaladie.add();
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
	public short getPoids() {
		return poids;
	}
	public void setPoids(short poids) {
		this.poids = poids;
	}
	public short getTaille() {
		return taille;
	}
	public void setTaille(short taille) {
		this.taille = taille;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public byte getIndicateurMoral() {
		return indicateurMoral;
	}
	public void setIndicateurMoral(byte indicateurMoral) {
		this.indicateurMoral = indicateurMoral;
	}
	public ArrayList<Maladie> getListeMaladie() {
		return listeMaladie;
	}
	public void setListeMaladie(ArrayList<Maladie> listeMaladie) {
		this.listeMaladie = listeMaladie;
	}
	public int getPv(){
		return pv;
	}
	public void setPv(int pv){
		this.pv = pv;
	}

	public void attendre() {
		this.indicateurMoral -= 5;
		if (this.indicateurMoral < 10) {
			System.out.println(this.hurler());
		}
	}

	public void tomberMalade(Maladie maladie){
		this.listeMaladie.add(maladie);
	}

	public String hurler() {
		return "OSKOUUUUUUR";
	}
	

}
