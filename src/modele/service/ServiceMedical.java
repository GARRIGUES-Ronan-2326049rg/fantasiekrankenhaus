package modele.service;

import java.util.*;

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

	private Map<String, Double> coefficientsBudget;


	public ServiceMedical(String nom, int superficie, String budget, int max) {
		this.nom = nom;
		this.superficie = superficie;
		this.budget = budget;
		this.listeCreature = new ArrayList<>();
		this.nombreCreature = 0;
		this.maxCreature = max;
	}

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
			for (Monstre monstre : listeCreature) {
				sb.append("      - \u001B[34m").append(monstre.getNom())
						.append("\u001B[0m (Âge : \u001B[36m").append(monstre.getAge())
						.append("\u001B[0m, Moral : \u001B[33m").append(monstre.getIndicateurMoral())
						.append("%\u001B[0m)\n");
			}
		} else {
			sb.append("\n✅ \u001B[32mAucun monstre en soin actuellement !\u001B[0m\n");
		}

		return sb.toString();
	}

}
