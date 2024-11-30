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
		if (this.indicateurMoral < 0) {
			this.indicateurMoral = 0;
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
			// Si le monstre n'a pas de maladies, il y a une chance d'en attraper
			int chance = random.nextInt(100); // Nombre entre 0 et 99
			if (chance < 10) { // 10% de chance
				System.out.println(nom + " est en pleine forme, mais contracte de nouvelles maladies !");
				MonstreFactory.ajouterMaladiesAleatoires(this);
			} else {
				System.out.println(nom + " est en pleine forme et reste en bonne santé !");
			}
			return;
		}

		// Progression des maladies existantes
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
		sb.append("\u001B[34m🔮 Monstre : \u001B[0m").append(nom).append("\n");
		sb.append("    • Sexe : ").append(sexe == 'M' ? "\u001B[32mMâle\u001B[0m" : "\u001B[31mFemelle\u001B[0m").append("\n");
		sb.append("    • Poids : \u001B[36m").append(poids).append(" kg\u001B[0m\n");
		sb.append("    • Taille : \u001B[36m").append(taille).append(" cm\u001B[0m\n");
		sb.append("    • Âge : \u001B[36m").append(age).append(" ans\u001B[0m\n");
		sb.append("    • Moral : \u001B[33m").append(indicateurMoral).append("%\u001B[0m\n");

		if (!listeMaladie.isEmpty()) {
			sb.append("⚠️ Maladies :\n");
			for (Maladie maladie : listeMaladie) {
				sb.append("      - \u001B[35m").append(maladie.getNomComplet())
						.append("\u001B[0m (Gravité : \u001B[33m").append(maladie.getNiveauActuel())
						.append("/").append(maladie.getNiveauMax()).append("\u001B[0m)\n");
			}
		} else {
			sb.append("✅ \u001B[32mCe monstre est en pleine santé !\u001B[0m\n");
		}

		return sb.toString();
	}




}
