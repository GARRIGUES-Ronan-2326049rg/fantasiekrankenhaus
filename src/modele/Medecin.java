package modele;

import controller.Proba;
import modele.monstre.*;
import modele.service.ServiceMedical;
import java.util.Scanner;

/**
 * La classe Medecin représente un médecin dans le jeu,
 * capable de soigner des monstres, de gérer des actions dans les services médicaux,
 * et d'influencer le gameplay à travers diverses interactions.
 */
public class Medecin {

	private String nom;
	private char sexe;
	private byte age;
	private int actionPossible = 2;

	/**
	 * Constructeur pour initialiser un médecin avec ses informations personnelles.
	 *
	 * @param nom  Le nom du médecin.
	 * @param sexe Le sexe du médecin ('M' pour masculin, 'F' pour féminin).
	 * @param age  L'âge du médecin.
	 */
	public Medecin(String nom, char sexe, byte age) {
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
	}

	/**
	 * @return Le nom du médecin.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modifie le nom du médecin.
	 *
	 * @param nom Le nouveau nom.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return Le sexe du médecin.
	 */
	public char getSexe() {
		return sexe;
	}

	/**
	 * Modifie le sexe du médecin.
	 *
	 * @param sexe Le nouveau sexe ('M' ou 'F').
	 */
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return L'âge du médecin.
	 */
	public byte getAge() {
		return age;
	}

	/**
	 * Modifie l'âge du médecin.
	 *
	 * @param age Le nouvel âge.
	 */
	public void setAge(byte age) {
		this.age = age;
	}

	/**
	 * Modifie le nombre d'actions possibles pour ce médecin.
	 *
	 * @param actionPossible Le nombre d'actions restantes.
	 */
	public void setActionPossible(int actionPossible) {
		this.actionPossible = actionPossible;
	}

	/**
	 * @return Le nombre d'actions possibles restantes pour ce médecin.
	 */
	public int getActionPossible() {
		return actionPossible;
	}

	/**
	 * Transfère un monstre d'un service médical à un autre.
	 *
	 * @param monstre   Le monstre à transférer.
	 * @param serviceDep Le service de départ.
	 * @param serviceArr Le service d'arrivée.
	 */
	public void transfererPatient(Monstre monstre, ServiceMedical serviceDep, ServiceMedical serviceArr) {
		if (serviceDep.getListeCreature().contains(monstre) && !serviceArr.getListeCreature().contains(monstre)) {
			serviceArr.getListeCreature().add(monstre);
			serviceDep.getListeCreature().remove(monstre);
			--actionPossible;
		}
	}

	/**
	 * Examine un service médical en affichant des informations sur ses monstres et ses statistiques globales.
	 *
	 * @param service Le service médical à examiner.
	 */
	public void examineService(ServiceMedical service) {
		service.trierPatientsParMaladie();
		System.out.println("Voici la liste des monstres et de leur caractéristique.");
		for (int i = 0; i < service.getListeCreature().size(); ++i) {
			if (!service.getListeCreature().get(i).getListeMaladie().isEmpty()) {
				System.out.println(service.getListeCreature().get(i) + "\n");
			}
		}
		System.out.println("Voici les informations globales du service : " + service.toString());
	}

	/**
	 * Tente de soigner une maladie d'un monstre dans un service médical.
	 * Affiche les chances de réussite basées sur le budget du service et le stade de la maladie.
	 *
	 * @param monstre Le monstre à soigner.
	 * @param service Le service médical où le soin est effectué.
	 */
	public void soignePatient(Monstre monstre, ServiceMedical service) {
		Scanner sc = new Scanner(System.in);

		String RESET = "\u001B[0m";
		String CYAN = "\u001B[36m";
		String YELLOW = "\u001B[33m";
		String GREEN = "\u001B[32m";
		String RED = "\u001B[31m";

		if (monstre.getListeMaladie().isEmpty()) {
			System.out.println("✅ Le monstre " + CYAN + monstre.getNom() + RESET + " n'a pas de maladies à soigner.");
			return;
		}

		System.out.println("Voici la liste des maladies du monstre " + CYAN + monstre.getNom() + RESET + " :");
		for (int i = 0; i < monstre.getListeMaladie().size(); i++) {
			System.out.println((i + 1) + ". " + YELLOW + monstre.getListeMaladie().get(i) + RESET);
		}

		Proba p = new Proba();
		Maladie maladieImportante = monstre.getMaxMaladie();
		int chanceDeReussite = (int) (p.calculProba(service.getBudget(),
				(double) maladieImportante.getNiveauActuel() / maladieImportante.getNiveauMax()) * 100);
		System.out.println("🩺 Tentative de soin avec " + GREEN + chanceDeReussite + "%" + RESET + " de chance de réussite.");
		System.out.println("Choisissez un numéro pour soigner une maladie ou entrez 0 pour passer :");

		int choix;
		try {
			choix = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(RED + "Entrée invalide. Veuillez entrer un numéro." + RESET);
			return;
		}

		if (choix == 0) {
			System.out.println("Vous avez décidé de ne pas soigner de maladie pour ce tour.");
		} else if (choix > 0 && choix <= monstre.getListeMaladie().size()) {
			String nomMaladie = monstre.getListeMaladie().get(choix - 1).getNomComplet();

			if (Math.random() * 100 < chanceDeReussite) {
				monstre.soignerMaladie(nomMaladie);
				if(monstre.getIndicateurMoral() <= 50){
					monstre.setIndicateurMoral((byte) (monstre.getIndicateurMoral()+50));
				}

				System.out.println(GREEN + "✅ La maladie " + nomMaladie + " a été soignée avec succès !" + RESET);
			} else {
				System.out.println(RED + "❌ La tentative de soigner la maladie " + nomMaladie + " a échoué." + RESET);
			}
		} else {
			System.out.println(RED + "Numéro invalide. Aucun soin effectué." + RESET);
		}

		--actionPossible;
	}

	/**
	 * Révise le budget d'un service médical.
	 *
	 * @param service Le service médical à modifier.
	 * @param valeur  La nouvelle valeur du budget.
	 */
	public void reviseBudget(ServiceMedical service, String valeur) {
		service.setBudget(valeur);
		--actionPossible;
	}
}
