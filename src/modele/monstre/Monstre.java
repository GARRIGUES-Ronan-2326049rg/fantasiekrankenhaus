package modele.monstre;
import modele.Maladie;

import java.util.ArrayList;
import java.util.Random;

public class Monstre {
	private String type;
	private String nom;
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
		Random random = new Random();

		if (listeMaladie.isEmpty()) {
			// Si le monstre est guéri, il y a 10% de chance qu'il attrape de nouvelles maladies
			int chance = random.nextInt(100); // Nombre entre 0 et 99
			if (chance < 10) { // 10% de chance
				System.out.println(nom + " a été guéri mais contracte de nouvelles maladies !");
				MonstreFactory.ajouterMaladiesAleatoires(this);
			} else {
				System.out.println(nom + " est en pleine forme et reste en bonne santé !");
			}
			return;
		}

		// Les maladies progressent si elles existent
		System.out.println("Les maladies de " + nom + " évoluent...");
		for (Maladie maladie : listeMaladie) {
			maladie.setNiveauActuel(maladie.getNiveauActuel() + 1);

			// Si une maladie atteint son niveau max, le monstre meurt
			if (maladie.getNiveauActuel() >= maladie.getNiveauMax()) {
				System.out.println(nom + " est mort à cause de " + maladie.getNomComplet() + ".");
				break;
			}
		}
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("🔮 Monstre : ").append(nom).append("\n");
		sb.append("    • Sexe : ").append(sexe == 'M' ? "Mâle" : "Femelle").append("\n");
		sb.append("    • Poids : ").append(poids).append(" kg\n");
		sb.append("    • Taille : ").append(taille).append(" cm\n");
		sb.append("    • Âge : ").append(age).append(" ans\n");
		sb.append("    • Moral : ").append(indicateurMoral).append("%\n");

		if (!listeMaladie.isEmpty()) {
			sb.append("⚠️ Maladies :\n");
			for (Maladie maladie : listeMaladie) {
				sb.append("      - ").append(maladie.getNomComplet())
						.append(" (Gravité : ").append(maladie.getNiveauActuel())
						.append("/").append(maladie.getNiveauMax()).append(")\n");
			}
		} else {
			sb.append("✅ Ce monstre est en pleine santé !\n");
		}

		return sb.toString();
	}


}
