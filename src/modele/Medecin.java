package modele;
import modele.monstre.*;
import modele.*;
import modele.service.ServiceMedical;

import java.security.Provider;
import java.util.Random;
import java.util.Scanner;

public class Medecin {
	private String nom;
	private char sexe;
	private byte age;
	private int actionPossible = 2;

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

	public void setActionPossible(int actionPossible) {
		this.actionPossible = actionPossible;
	}

	public int getActionPossible() {
		return actionPossible;
	}

	public void transfererPatient(Monstre monstre, ServiceMedical serviceDep, ServiceMedical serviceArr){

		if(serviceDep.getListeCreature().contains(monstre) && !serviceArr.getListeCreature().contains(monstre)){
			serviceArr.getListeCreature().add(monstre);
			serviceDep.getListeCreature().remove(monstre);
			--actionPossible;
		}

	}

	public void examineService(ServiceMedical service){
		service.trierPatientsParMaladie();
		System.out.println("Voici la liste des monstres et de leur caractérstisque.");
		for(int i = 0; i < service.getListeCreature().size(); ++i){
			System.out.println(service.getListeCreature().get(i) + "\n");
		}
		System.out.println("Voici les imformations global du service : " + service.toString());

		--actionPossible;
	}

	public void soignePatient(Monstre monstre) {
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

		int chanceDeReussite = 30 + new Random().nextInt(31);
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
				System.out.println(GREEN + "✅ La maladie " + nomMaladie + " a été soignée avec succès !" + RESET);
			} else {
				System.out.println(RED + "❌ La tentative de soigner la maladie " + nomMaladie + " a échoué." + RESET);
			}
		} else {
			System.out.println(RED + "Numéro invalide. Aucun soin effectué." + RESET);
		}

		--actionPossible;
	}



	public void reviseBudget(ServiceMedical service, String valeur){
		//service.setBudget(valeur);
		--actionPossible;
	}

}
