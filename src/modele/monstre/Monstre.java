package modele.monstre;

import modele.Maladie;

import java.util.ArrayList;


public class Monstre {
	private String nom;
	private char sexe;
	private short poids;
	private short taille;
	private int age;
	private byte indicateurMoral = 100; // Représenté par un pourcentage
	private ArrayList<Maladie> listeMaladie;

	public Monstre(String nom) {
		this.nom = nom;
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
	public void attendre() {
		this.indicateurMoral -= 5;
	}
	
	public String hurler() {
		return "OSKOUUUUUUR";
	}
	

}
