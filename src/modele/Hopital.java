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
		listeMedecin.add(medecin6);

	}

	public void initialisationService(){
		ServiceMedical serviceVampire = new ServiceMedical("Vampire", 1000, "Insuffisant");
		listeService.add(serviceVampire);
		ServiceMedical serviceOrque = new ServiceMedical("Orque", 2000, "Faible");
		listeService.add(serviceOrque);
		ServiceMedical serviceLycanthrope = new ServiceMedical("Lycanthrope", 1500, "Insuffisant");
		listeService.add(serviceLycanthrope);
		ServiceMedical serviceElfe = new ServiceMedical("Elfe",900, "Faible");
		listeService.add(serviceElfe);
		ServiceMedical serviceNain = new ServiceMedical("Nain", 100, "Insuffisant");
		listeService.add(serviceNain);
		ServiceMedical serviceZombie = new ServiceMedical("Zombie", 1500, "Mediocre");
		listeService.add(serviceZombie);
		ServiceMedical serviceReptilien = new ServiceMedical("Reptilien", 700, "Insuffisant");
		listeService.add(serviceReptilien);
		ServiceMedical serviceHommeBete = new ServiceMedical("Homme bete", 1700, "Inexistant");
		listeService.add(serviceHommeBete);
		Crypte crypte = new Crypte("Crypte", 870, "mediocre");
		listeService.add(crypte);
		CentreQuarantaine centreQuarantaine = new CentreQuarantaine("Centre 40", 439, "Faible");
	}

	public void nouvelleJournee(){
		// Remise à niveau des actions des médecins
		for (int i = 0; i < getListeMedecin().size(); ++i) {
			getListeMedecin().get(i).setActionPossible(true);
		}

	}

}
