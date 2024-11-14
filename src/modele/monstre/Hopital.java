package modele.monstre;
import modele.Medecin;
import modele.service.ServiceMedical;

import java.util.ArrayList;

public class Hopital {
	private String nom = "fantasiekrankenhaus";
	final int maxService = 20;
	private ArrayList<ServiceMedical> listeService;
	private ArrayList<Medecin> listeMedecin;
	
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
	
	

}
