package modele.service;

import java.util.*;

import modele.Maladie;
import modele.monstre.Monstre;

/**
 * Classe représentant un service médical qui gère les soins et le suivi des monstres.
 */
public class ServiceMedical {
	private String nom;
	private int superficie;
	private int maxCreature;
	private int nombreCreature;
	private int tauxPropagation = 1;
	private ArrayList<Monstre> listeCreature;
	private String budget;
	private String budgetPred;

	private Map<String, Double> coefficientsBudget;

	/**
	 * Constructeur pour créer un nouveau service médical.
	 *
	 * @param nom        le nom du service
	 * @param superficie la superficie du service en m²
	 * @param budget     le budget actuel du service
	 * @param max        le nombre maximum de créatures pouvant être accueillies
	 */
	public ServiceMedical(String nom, int superficie, String budget, int max) {
		this.nom = nom;
		this.superficie = superficie;
		this.budget = budget;
		this.listeCreature = new ArrayList<>();
		this.nombreCreature = 0;
		this.maxCreature = max;
	}

	/**
	 * Vérifie si le budget peut être amélioré en fonction de sa valeur actuelle.
	 *
	 * @param valeur la nouvelle valeur de budget
	 * @return true si l'amélioration est possible, sinon false
	 */
	public boolean ameliorer(String valeur) {
		ArrayList<String> budget = new ArrayList<>();
		budget.add("Inexistant");
		budget.add("Mediocre");
		budget.add("Insuffisant");
		budget.add("Faible");
		budget.add("Moyen");
		budget.add("Bon");
		budget.add("Super");
		budget.add("Parfait");

		if (!budget.contains(valeur)) {
			System.out.println("Le budget n'existe pas");
			return false;
		}

		int indexActuel = budget.indexOf(getBudget());
		int indexValeur = budget.indexOf(valeur);

		return indexValeur - indexActuel <= 1;
	}

	/**
	 * Récupère le nom du service médical.
	 *
	 * @return le nom du service
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Définit un nouveau nom pour le service médical.
	 *
	 * @param nom le nouveau nom du service
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Récupère la superficie du service médical.
	 *
	 * @return la superficie en m²
	 */
	public int getSuperficie() {
		return this.superficie;
	}

	/**
	 * Définit une nouvelle superficie pour le service médical.
	 *
	 * @param superficie la nouvelle superficie en m²
	 */
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	/**
	 * Récupère le nombre actuel de créatures dans le service.
	 *
	 * @return le nombre de créatures
	 */
	public int getNombreCreature() {
		return this.nombreCreature;
	}

	/**
	 * Définit le nombre de créatures dans le service.
	 *
	 * @param nombreCreature le nouveau nombre de créatures
	 */
	public void setNombreCreature(int nombreCreature) {
		this.nombreCreature = nombreCreature;
	}

	/**
	 * Récupère la capacité maximale du service en nombre de créatures.
	 *
	 * @return la capacité maximale
	 */
	public int getMaxCreature() {
		return maxCreature;
	}

	/**
	 * Définit une nouvelle capacité maximale pour le service.
	 *
	 * @param maxCreature la nouvelle capacité maximale
	 */
	public void setMaxCreature(int maxCreature) {
		this.maxCreature = maxCreature;
	}

	/**
	 * Récupère la liste des créatures dans le service.
	 *
	 * @return une liste de monstres
	 */
	public ArrayList<Monstre> getListeCreature() {
		return this.listeCreature;
	}

	/**
	 * Définit une nouvelle liste de créatures pour le service.
	 *
	 * @param listeCreature la nouvelle liste de créatures
	 */
	public void setListeCreature(ArrayList<Monstre> listeCreature) {
		this.listeCreature = listeCreature;
		this.nombreCreature = listeCreature.size();
	}

	/**
	 * Récupère le budget actuel du service.
	 *
	 * @return le budget actuel
	 */
	public String getBudget() {
		return this.budget;
	}

	/**
	 * Définit un nouveau budget pour le service.
	 *
	 * @param budget le nouveau budget
	 */
	public void setBudget(String budget) {
		this.budgetPred = this.budget;
		this.budget = budget;
	}

	/**
	 * Récupère le budget précédent du service.
	 *
	 * @return le budget précédent
	 */
	public String getBudgetPred() {
		return budgetPred;
	}

	/**
	 * Définit un nouveau budget précédent pour le service.
	 *
	 * @param budgetPred le nouveau budget précédent
	 */
	public void setBudgetPred(String budgetPred) {
		this.budgetPred = budgetPred;
	}

	/**
	 * Récupère le taux de propagation des maladies dans le service.
	 *
	 * @return le taux de propagation
	 */
	public int getTauxPropagation() {
		return tauxPropagation;
	}

	/**
	 * Définit un nouveau taux de propagation des maladies.
	 *
	 * @param tauxPropagation le nouveau taux de propagation
	 */
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
				patient.setService(this); // Associe le service au monstre
				++this.nombreCreature;
			} else if (this.nombreCreature < maxCreature) {
				Random chanceAjout = new Random();
				if (chanceAjout.nextInt(100) >= 25) {
					this.listeCreature.add(patient);
					patient.setService(this); // Associe le service au monstre
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
		if (this.listeCreature.contains(patient)) {
			this.listeCreature.remove(patient);
			this.nombreCreature--;
			System.out.println("Le monstre " + patient.getNom() + " a été retiré du service.");
		}
	}

	/**
	 * Modifie le nombre maximum de créatures et le taux de propagation des maladies en
	 * fonction de l'évolution du budget du service.
	 *
	 * @version 1.0
	 * */
	public void variationBudget(){
		switch (this.budget) {
			case "Inexistant" -> {
				switch (this.budgetPred) {
					case "Faible" -> {
						this.maxCreature /= 8;
						this.tauxPropagation *= 8;
					}
					case "Insuffisant" -> {
						this.maxCreature /= 4;
						this.tauxPropagation *= 4;
					}
					case "Médiocre" -> {
						this.maxCreature /= 2;
						this.tauxPropagation *= 2;
					}
				}
			}
			case "Médiocre" -> {
				switch (this.budgetPred) {
					case "Faible" -> {
						this.maxCreature /= 4;
						this.tauxPropagation *= 4;
					}
					case "Insuffisant" -> {
						this.maxCreature /= 2;
						this.tauxPropagation *= 2;
					}
					case "Inexistant" -> {
						this.maxCreature *= 2;
						this.tauxPropagation /= 2;
					}
				}
			}
			case "Insuffisant" -> {
				switch (this.budgetPred) {
					case "Faible" -> {
						this.maxCreature /= 2;
						this.tauxPropagation *= 2;
					}
					case "Médiocre" -> {
						this.maxCreature *= 2;
						this.tauxPropagation /= 2;
					}
					case "Inexistant" -> {
						this.maxCreature *= 4;
						this.tauxPropagation /= 4;
					}
				}
			}
			case "Faible" -> {
				switch (this.budgetPred) {
					case "Insuffisant" -> {
						this.maxCreature *= 2;
						this.tauxPropagation /= 2;
					}
					case "Médiocre" -> {
						this.maxCreature *= 4;
						this.tauxPropagation /= 4;
					}
					case "Inexistant" -> {
						this.maxCreature *= 8;
						this.tauxPropagation /= 8;
					}
				}
			}
		}
	}

	/**
	 * Trie la liste des monstres par la gravité maximale de leurs maladies.
	 */
	public void trierPatientsParMaladie() {
		this.listeCreature.sort((monstre1, monstre2) -> {
			double gravite1 = monstre1.getListeMaladie().stream()
					.mapToDouble(m -> (double) m.getNiveauActuel() / m.getNiveauMax())
					.max()
					.orElse(0);

			double gravite2 = monstre2.getListeMaladie().stream()
					.mapToDouble(m -> (double) m.getNiveauActuel() / m.getNiveauMax())
					.max()
					.orElse(0);

			return Double.compare(gravite2, gravite1); // Tri décroissant
		});
	}

	/**
	 * Génère une représentation textuelle du service médical avec ses informations principales.
	 *
	 * @return une chaîne de caractères décrivant le service
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\u001B[35m🏥 Service Médical : \u001B[0m").append(nom).append("\n");
		sb.append("    • Superficie : \u001B[36m").append(superficie).append(" m²\u001B[0m\n");
		sb.append("    • Capacité : \u001B[36m").append(nombreCreature).append("/").append(maxCreature).append(" créatures\u001B[0m\n");
		sb.append("    • Taux de Propagation : \u001B[33m").append(tauxPropagation).append("x\u001B[0m\n");
		sb.append("    • Budget Actuel : \u001B[32m").append(budget).append("\u001B[0m\n");
		if (budgetPred != null) {
			sb.append("    • Budget Précédent : \u001B[32m").append(budgetPred).append("\u001B[0m\n");
		}

		if (!listeCreature.isEmpty()) {
			sb.append("\n🧟‍♂️ Liste des créatures en soin :\n");
			boolean vide = true;
			for (Monstre monstre : listeCreature) {
				if (!monstre.getListeMaladie().isEmpty()) {
					sb.append("      - \u001B[34m").append(monstre.getNom())
							.append("\u001B[0m (Âge : \u001B[36m").append(monstre.getAge())
							.append("\u001B[0m, Moral : \u001B[33m").append(monstre.getIndicateurMoral())
							.append("%\u001B[0m)\n");
					vide = false;
				}
			}
			if (vide) {
				sb.append("\n✅ \u001B[32mAucun monstre en soin actuellement !\u001B[0m\n");
			}
		} else {
			sb.append("\n✅ \u001B[32mAucun monstre en soin actuellement !\u001B[0m\n");
		}

		return sb.toString();
	}
}
