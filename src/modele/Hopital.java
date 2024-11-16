package modele;
import modele.service.CentreQuarantaine;
import modele.service.Crypte;
import modele.service.ServiceMedical;

import java.util.ArrayList;

public class Hopital {
	private String nom = "fantasiekrankenhaus";
	final int maxService = 10;
	private ArrayList<ServiceMedical> listeService;
	private ArrayList<Medecin> listeMedecin;

	public Hopital(){
		this.listeService = new ArrayList<>();
		this.listeMedecin = new ArrayList<>();
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<ServiceMedical> getListeService() {
		return listeService;
	}
	public void setListeService(ArrayList<ServiceMedical> listeService) {
		this.listeService = listeService;
	}
	public ArrayList<Medecin> getListeMedecin() {
		return listeMedecin;
	}
	public void setListeMedecin(ArrayList<Medecin> listeMedecin) {
		this.listeMedecin = listeMedecin;
	}

	public void initialisationMedecin(){
		Medecin medecin = new Medecin("Dr Emmet Brown", 'M', (byte) 59);
		listeMedecin.add(medecin);
		Medecin medecin2 = new Medecin("Victor Frankenstein", 'M', (byte) 452);
		listeMedecin.add(medecin2);
		Medecin medecin3 = new Medecin("Dr Jekyll", 'M', (byte) 80);
		listeMedecin.add(medecin3);
		Medecin medecin4 = new Medecin("Dr Julia Hoffman", 'F', (byte) 23);
		listeMedecin.add(medecin4);
		Medecin medecin5 = new Medecin("Dr Harleen Quinzel", 'F', (byte) 19);
		listeMedecin.add(medecin5);
		Medecin medecin6 = new Medecin("Dr Samantha Grimm", 'F', (byte) 30);

	}

	public void initialisationService(){
		ServiceMedical serviceVampire = new ServiceMedical("Vampire", 1000, "Insuffisant", 80);
		listeService.add(serviceVampire);
		ServiceMedical serviceOrque = new ServiceMedical("Orque", 2000, "Faible",175);
		listeService.add(serviceOrque);
		ServiceMedical serviceLycanthrope = new ServiceMedical("Lycanthrope", 1500, "Insuffisant", 130);
		listeService.add(serviceLycanthrope);
		ServiceMedical serviceElfe = new ServiceMedical("Elfe",900, "Faible", 70);
		listeService.add(serviceElfe);
		ServiceMedical serviceNain = new ServiceMedical("Nain", 100, "Insuffisant", 10);
		listeService.add(serviceNain);
		ServiceMedical serviceZombie = new ServiceMedical("Zombie", 1500, "Mediocre", 130);
		listeService.add(serviceZombie);
		ServiceMedical serviceReptilien = new ServiceMedical("Reptilien", 700, "Insuffisant", 55);
		listeService.add(serviceReptilien);
		ServiceMedical serviceHommeBete = new ServiceMedical("Homme bete", 1700, "Inexistant", 150);
		listeService.add(serviceHommeBete);
		Crypte crypte = new Crypte("Crypte", 870, "Mediocre", 60);
		listeService.add(crypte);
		CentreQuarantaine centreQuarantaine = new CentreQuarantaine("Centre 40", 439, "Faible", 30);


	}

}
