package modele.service;

import java.util.ArrayList;
import java.util.Random;

import modele.Maladie;
import modele.monstre.Monstre;

public class ServiceMedical {
	private String nom;
	private int superficie;
	private int maxCreature;
	private int nombreCreature;
	private int tauxPropagation = 1;
	private ArrayList<Monstre> listeCreature;
	private String budget;
	private String budgetPred;

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

	public int getMaxCreature() {
		return maxCreature;
	}

	public void setMaxCreature(int maxCreature) {
		this.maxCreature = maxCreature;
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
		this.budgetPred = this.budget;
		this.budget = budget;
	}

	public String getBudgetPred() {
		return budgetPred;
	}

	public void setBudgetPred(String budgetPred) {
		this.budgetPred = budgetPred;
	}

	public int getTauxPropagation() {
		return tauxPropagation;
	}

	public void setTauxPropagation(int tauxPropagation) {
		this.tauxPropagation = tauxPropagation;
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

	/**
	 * Modifie le nombre maximum de créatures et le taux de propagation des maladies en
	 * fonction de l'évolution du budget du service.
	 *
	 * @version 1.0
	 * */
	public void variationBudget(){
		if(this.budget.equals("Inexistant")){
			if(this.budgetPred.equals("Faible")){
				this.maxCreature /=8;
				this.tauxPropagation *=8;
			}else if(this.budgetPred.equals("Insuffisant")){
				this.maxCreature /= 4;
				this.tauxPropagation *=4;
			}else if(this.budgetPred.equals("Médiocre")){
				this.maxCreature /= 2;
				this.tauxPropagation *=2;
			}
		} else if (this.budget.equals("Médiocre")) {
			if(this.budgetPred.equals("Faible")){
				this.maxCreature /= 4;
				this.tauxPropagation *=4;
			}else if(this.budgetPred.equals("Insuffisant")){
				this.maxCreature /= 2;
				this.tauxPropagation *=2;
			}else if(this.budgetPred.equals("Inexistant")){
				this.maxCreature *= 2;
				this.tauxPropagation /=2;
			}
		} else if (this.budget.equals("Insuffisant")) {
			if(this.budgetPred.equals("Faible")){
				this.maxCreature /= 2;
				this.tauxPropagation *=2;
			}else if(this.budgetPred.equals("Médiocre")){
				this.maxCreature *= 2;
				this.tauxPropagation /=2;
			}else if(this.budgetPred.equals("Inexistant")){
				this.maxCreature *= 4;
				this.tauxPropagation /=4;
			}
		} else if (this.budget.equals("Faible")) {
			if(this.budgetPred.equals("Insuffisant")){
				this.maxCreature *= 2;
				this.tauxPropagation /=2;
			}else if(this.budgetPred.equals("Médiocre")){
				this.maxCreature *= 4;
				this.tauxPropagation /=4;
			}else if(this.budgetPred.equals("Inexistant")){
				this.maxCreature *= 8;
				this.tauxPropagation /=8;
			}
		}
	}
}
