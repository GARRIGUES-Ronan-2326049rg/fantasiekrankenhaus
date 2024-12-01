package modele;

import modele.monstre.Monstre;
import modele.monstre.MonstreFactory;
import modele.service.CentreQuarantaine;
import modele.service.Crypte;
import modele.service.ServiceMedical;

import java.util.ArrayList;

/**
 * La classe Hopital représente un hôpital dédié à la gestion et au traitement des monstres.
 * Elle gère les services médicaux, les médecins et les patients.
 */
public class Hopital {
	private String nom = "fantasiekrankenhaus";
	private final int maxService = 10;
	private ArrayList<ServiceMedical> listeService;
	private ArrayList<Medecin> listeMedecin;

	/**
	 * Constructeur pour initialiser un hôpital vide avec une liste de services et de médecins.
	 */
	public Hopital() {
		this.listeService = new ArrayList<>();
		this.listeMedecin = new ArrayList<>();
	}

	/**
	 * @return Le nom de l'hôpital.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modifie le nom de l'hôpital.
	 *
	 * @param nom Le nouveau nom de l'hôpital.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return La liste des services médicaux de l'hôpital.
	 */
	public ArrayList<ServiceMedical> getListeService() {
		return listeService;
	}

	/**
	 * Modifie la liste des services médicaux de l'hôpital.
	 *
	 * @param listeService La nouvelle liste des services.
	 */
	public void setListeService(ArrayList<ServiceMedical> listeService) {
		this.listeService = listeService;
	}

	/**
	 * @return La liste des médecins de l'hôpital.
	 */
	public ArrayList<Medecin> getListeMedecin() {
		return listeMedecin;
	}

	/**
	 * Modifie la liste des médecins de l'hôpital.
	 *
	 * @param listeMedecin La nouvelle liste des médecins.
	 */
	public void setListeMedecin(ArrayList<Medecin> listeMedecin) {
		this.listeMedecin = listeMedecin;
	}

	/**
	 * Initialise une liste prédéfinie de médecins avec des noms, sexes et âges spécifiques.
	 */
	public void initialisationMedecin() {
		listeMedecin.add(new Medecin("Dr Emmet Brown", 'M', (byte) 59));
		listeMedecin.add(new Medecin("Victor Frankenstein", 'M', (byte) 452));
		listeMedecin.add(new Medecin("Dr Jekyll", 'M', (byte) 80));
		listeMedecin.add(new Medecin("Dr Julia Hoffman", 'F', (byte) 23));
		listeMedecin.add(new Medecin("Dr Harleen Quinzel", 'F', (byte) 19));
		listeMedecin.add(new Medecin("Dr Samantha Grimm", 'F', (byte) 30));
	}

	/**
	 * Initialise une liste prédéfinie de services médicaux et leurs caractéristiques.
	 */
	public void initialisationService() {
		listeService.add(new ServiceMedical("Vampire", 1000, "Insuffisant", 100));
		listeService.add(new ServiceMedical("Orque", 2000, "Faible", 100));
		listeService.add(new ServiceMedical("Lycanthrope", 1500, "Insuffisant", 100));
		listeService.add(new ServiceMedical("Elfe", 900, "Faible", 100));
		listeService.add(new ServiceMedical("Nain", 100, "Insuffisant", 100));
		listeService.add(new ServiceMedical("Zombie", 1500, "Médiocre", 100));
		listeService.add(new ServiceMedical("Reptilien", 700, "Insuffisant", 100));
		listeService.add(new ServiceMedical("HommeBete", 1700, "Inexistant", 100));
		listeService.add(new Crypte("Crypte", 870, "Médiocre", 100));
		listeService.add(new CentreQuarantaine("Centre 40", 439, "Faible", 100));
	}

	/**
	 * Ajoute un nombre donné de monstres aléatoires à des services spécifiques en fonction de leur type.
	 *
	 * @param nombre       Le nombre de monstres à créer.
	 * @param listeService La liste des services où ajouter les monstres.
	 */
	public void initialisationMonstre(int nombre, ArrayList<ServiceMedical> listeService) {
		for (int i = 0; i < nombre; i++) {
			Monstre monstre = MonstreFactory.creerMonstreAleatoire();
			switch (monstre.getType()) {
				case "Vampire":
					listeService.get(0).ajouterPatient(monstre);
					break;
				case "Orque":
					listeService.get(1).ajouterPatient(monstre);
					break;
				case "Lycanthrope":
					listeService.get(2).ajouterPatient(monstre);
					break;
				case "Elfe":
					listeService.get(3).ajouterPatient(monstre);
					break;
				case "Nain":
					listeService.get(4).ajouterPatient(monstre);
					break;
				case "Zombie":
					listeService.get(5).ajouterPatient(monstre);
					break;
				case "Reptilien":
					listeService.get(6).ajouterPatient(monstre);
					break;
				case "HommeBete":
					listeService.get(7).ajouterPatient(monstre);
					break;
			}
		}
	}

	/**
	 * Réinitialise les actions possibles des médecins pour une nouvelle journée.
	 */
	public void nouvelleJournee() {
		for (Medecin medecin : listeMedecin) {
			medecin.setActionPossible(2);
		}
	}

	/**
	 * Vérifie s'il reste des actions possibles pour au moins un médecin.
	 *
	 * @return {@code true} s'il reste des actions disponibles, {@code false} sinon.
	 */
	public boolean resteAction() {
		for (Medecin medecin : listeMedecin) {
			if (medecin.getActionPossible() > 0) {
				return true;
			}
		}
		return false;
	}
}
