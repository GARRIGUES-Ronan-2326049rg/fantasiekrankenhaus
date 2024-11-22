package modele.monstre;
import modele.Maladie;

import java.util.ArrayList;

public class Monstre {
	private String type;
	private String nom;
	private int pv = 100;
	private char sexe;
	private short poids;
	private short taille;
	private int age;
	private byte indicateurMoral = 100;
	private ArrayList<Maladie> listeMaladie = new ArrayList<>();
	private boolean estMort = false;


	public Monstre(String type, String nom, char sexe, short poids, short taille, int age, int indicateurMoral) {
		this.type = type;
		this.nom = nom;
		this.sexe = sexe;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
		this.indicateurMoral = 100;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	public short getPoids() {
		return poids;
	}
	public void setPoids(short poids) {
		this.poids = poids;
	}
	public short getTaille() {
		return taille;
	}
	public void setTaille(short taille) {
		this.taille = taille;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public byte getIndicateurMoral() {
		return indicateurMoral;
	}
	public void setIndicateurMoral(byte indicateurMoral) {
		this.indicateurMoral = indicateurMoral;
	}
	public ArrayList<Maladie> getListeMaladie() {
		return listeMaladie;
	}
	public void setListeMaladie(ArrayList<Maladie> listeMaladie) {
		this.listeMaladie = listeMaladie;
	}
	public int getPv(){
		return pv;
	}
	public void setPv(int pv){
		this.pv = pv;
	}

	public boolean estMort() {
		return this.estMort;
	}

	public void attendre() {
		this.indicateurMoral -= 5;
		if (this.indicateurMoral < 10) {
			System.out.println(this.hurler());
		}
	}

	public void tomberMalade(Maladie maladie){
		this.listeMaladie.add(maladie);
	}

	public String hurler() {
		return "OSKOUUUUUUR";
	}

	// Évolution des maladies à chaque tour
	public void evoluerMaladies() {
		for (Maladie maladie : listeMaladie) {
			// Augmente le niveau actuel de la maladie
			int nouveauNiveau = Math.min(maladie.getNiveauMax(), maladie.getNiveauActuel() + 1);
			maladie.setNiveauActuel(nouveauNiveau);

			System.out.println("La maladie " + maladie.getNomComplet() + " a augmenté à " + nouveauNiveau + "/" + maladie.getNiveauMax());
		}
		// Vérifie si le monstre doit mourir après l'évolution
		verifierMort();
	}

	// Vérifie si le monstre doit mourir
	private void verifierMort() {
		for (Maladie maladie : listeMaladie) {
			if (maladie.getNiveauActuel() == maladie.getNiveauMax()) {
				mourir(); // Le monstre meurt si une maladie atteint le niveau maximum
				break;
			}
		}
	}

	// Action de mourir
	private void mourir() {
		this.estMort = true;
		System.out.println("Le monstre " + this.nom + " est mort à cause de ses maladies !");
	}

	// Soigner une maladie spécifique
	public void soignerMaladie(String nomMaladie) {
		for (int i = 0; i < listeMaladie.size(); i++) {
			Maladie maladie = listeMaladie.get(i);

			if (maladie.getNomComplet().equalsIgnoreCase(nomMaladie)) {
				// Retire la maladie de la liste
				listeMaladie.remove(i);
				System.out.println("La maladie " + maladie.getNomComplet() + " a été complètement soignée !");
				return;
			}
		}

		System.out.println("Aucune maladie correspondante trouvée pour " + nomMaladie + ".");
	}

	public String toString() {
		return "Monstre [nom=" + nom + ", pv=" + pv + ", sexe=" + sexe + ", poids=" + poids + ", taille=" + taille + ", age=" + age + ", indicateurMoral=" + indicateurMoral + ", listeMaladie=" + listeMaladie + "]";
	}

}
