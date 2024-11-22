package modele;
import modele.monstre.*;
import modele.*;
import modele.service.ServiceMedical;

import java.security.Provider;
import java.util.Random;

public class Medecin {
	private String nom;
	private char sexe;
	private byte age;
	private boolean actionPossible = true;

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

	public void setActionPossible(boolean actionPossible) {
		this.actionPossible = actionPossible;
	}

	public boolean isActionPossible() {
		return actionPossible;
	}

	public void transfererPatient(Monstre monstre, ServiceMedical serviceDep, ServiceMedical serviceArr){

		if(serviceDep.getListeCreature().contains(monstre) && !serviceArr.getListeCreature().contains(monstre)){
			serviceArr.getListeCreature().add(monstre);
			serviceDep.getListeCreature().remove(monstre);
			actionPossible = false;
		}

	}

	public void examineService(ServiceMedical service){
		//todo
	}

	public void soignePatient(Monstre monstre){
		if (!monstre.getListeMaladie().isEmpty()){
			Random nombre = new Random();
			monstre.getListeMaladie().remove(nombre.nextInt(monstre.getListeMaladie().size()));
			if (monstre.getListeMaladie().isEmpty()){
				// Supprimer le patient
			}
			actionPossible = false;
		}
	}

	public void reviseBudget(ServiceMedical service){
		// Todo
	}

}
