package modele.service;
import modele.monstre.Monstre;

import java.util.ArrayList;

public class ServiceMedical {
	private String nom;
	private int superficie;
	final int maxCreature = 10;
	private int nombreCreature;
	private ArrayList<Monstre> listeCreature;
	private String budget;

	public ServiceMedical(String nom, int superficie, String budget) {
		this.nom = nom;
		this.superficie = superficie;
		this.budget = budget;
		this.listeCreature = new ArrayList<>();
		this.nombreCreature = getListeCreature().size();

	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public int getNombreCreature() {
		return nombreCreature;
	}
	public void setNombreCreature(int nombreCreature) {
		this.nombreCreature = nombreCreature;
	}
	public ArrayList<Monstre> getListeCreature() {
		return listeCreature;
	}
	public void setListeCreature(ArrayList<Monstre> listeCreature) {
		this.listeCreature = listeCreature;
	}
	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}
	
	
}