package modele.service;

import java.util.ArrayList;
import java.util.Random;

import modele.Maladie;
import modele.monstre.Monstre;

public class ServiceMedical {
	private String nom;
	private int superficie;
	final int maxCreature;
	private int nombreCreature;
	private ArrayList<Monstre> listeCreature;
	private String budget;

	public ServiceMedical(String nom, int superficie, String budget, int max) {
		this.nom = nom;
		this.superficie = superficie;
		this.budget = budget;
		this.listeCreature = new ArrayList<>();
		this.nombreCreature = 0;
		this.maxCreature = max;
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
		this.nombreCreature = listeCreature.size();
	}

	public String getBudget() {
		return this.budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	/**
	 * @version 1.0
	 *
	 * @param patient
	 *
	 * Prends un objet de type Monstre et l'ajoute, s'il n'y est pas, dans la liste des patients si elle est vide ou si elle n'est pas complète.
	 * Si elle n'est pas complète, la fonction utilise un object Random pour savori si elle ajoute ou non ce patient.
	 */
	public void ajouterPatient(Monstre patient) {
		if (!this.listeCreature.contains(patient)) {
			if (this.nombreCreature == 0) {
				this.listeCreature.add(patient);
				++this.nombreCreature;
			} else if (this.nombreCreature < maxCreature) {
				Random chanceAjout = new Random();
				if (chanceAjout.nextInt(100) >=25) {
					this.listeCreature.add(patient);
					++this.nombreCreature;
				}
			}
		}
	}

	/**
	 * @version 1.0
	 *
	 * @param patient
	 *
	 * Prends un objet de type Monstre et le retire de la liste des patients s'il est présent et qu'il ne possède plus de maladies.
	 */
	public void retirerPatient(Monstre patient) {
		if (this.listeCreature.contains(patient) && patient.getListeMaladie().isEmpty()) {
			this.listeCreature.remove(patient);
			this.nombreCreature--;
		}
	}


	public void variationCapacité(){
		//TODO
	}

	/**
	 * Fonction de test pour les services.
	 * */
	public static void main(String[] args) {
		ServiceMedical service = new ServiceMedical("test", 20,   "faible", 10);

		//Test si la liste des patients est vide.
//		service.ajouterPatient(new Monstre("machin"));
//
//		for(int i = 0; i < service.getNombreCreature(); ++i) {
//			System.out.print(i+1 + " : " + service.getListeCreature().get(i).getNom() + " ");
//		}

		// Test d'ajout des patients lorsque la liste contient déjà des individus.
		ArrayList<Monstre> listeMonstre = new ArrayList<>();
		listeMonstre.add(new Monstre("truc"));
		listeMonstre.add(new Monstre("bidule"));
		listeMonstre.add(new Monstre("chose"));
		service.setListeCreature(listeMonstre);

		for(int i = 0; i < service.getNombreCreature(); ++i) {
			System.out.print(i+1 + " : " + service.getListeCreature().get(i).getNom() + " ");
		}
		System.out.println();

		Monstre machin = new Monstre("machin");

		service.ajouterPatient(machin);

		for(int i = 0; i < service.getNombreCreature(); ++i) {
			System.out.print(i+1 + " : " + service.getListeCreature().get(i).getNom() + " ");
		}
		System.out.println();

		// Test pour l'ajout du même patient.
		service.ajouterPatient(machin); // Si le patient a été ajouté précédemment, il ne sera pas ajouter une nouvelle fois (car même Object).

		// Test suppression d'un patient.
		ArrayList<Maladie> listeMaladie = new ArrayList<>();
		listeMaladie.add(new Maladie());
		machin.setListeMaladie(listeMaladie);

		service.retirerPatient(machin); // Si le patient a été ajouté précédemment, il pourra être supprimer sauf s'il a encore une maladie.

		for(int i = 0; i < service.getNombreCreature(); ++i) {
			System.out.print(i+1 + " : " + service.getListeCreature().get(i).getNom() + " ");
		}

	}
}
