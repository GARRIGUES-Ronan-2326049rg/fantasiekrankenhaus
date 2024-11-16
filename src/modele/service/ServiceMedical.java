package modele.service;

import java.util.ArrayList;
import java.util.Random;
import modele.monstre.Monstre;

public class ServiceMedical {
	private String nom;
	private int superficie;
	final int maxCreature = 0;
	private int nombreCreature;
	private ArrayList<Monstre> listeCreature;
	private String budget;

	public ServiceMedical(String nom, int superficie, String budget) {
		this.nom = nom;
		this.superficie = superficie;
		this.budget = budget;
		this.listeCreature = new ArrayList();
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getSuperficie() {
		return this.superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public int getNombreCreature() {
		return this.nombreCreature;
	}

	public void setNombreCreature(int nombreCreature) {
		this.nombreCreature = nombreCreature;
	}

	public ArrayList<Monstre> getListeCreature() {
		return this.listeCreature;
	}

	public void setListeCreature(ArrayList<Monstre> listeCreature) {
		this.listeCreature = listeCreature;
	}

	public String getBudget() {
		return this.budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public void ajouterPatient(Monstre patient) {
		if (!this.listeCreature.contains(patient)) {
			if (this.nombreCreature == 0) {
				Random chanceAjout = new Random();
				if (chanceAjout.nextInt(100) > 25) {
					this.listeCreature.add(patient);
					++this.nombreCreature;
				}
			} else if (this.nombreCreature < 0) {
				this.listeCreature.add(patient);
				++this.nombreCreature;
			}
		}

	}

	public static void main(String[] args) {
		ServiceMedical service = new ServiceMedical("test", 20, "faible");
		service.ajouterPatient(new Monstre("truc"));

		for(int i = 0; i < service.getNombreCreature(); ++i) {
			System.out.println(((Monstre)service.getListeCreature().get(i)).getNom());
		}

	}
}
