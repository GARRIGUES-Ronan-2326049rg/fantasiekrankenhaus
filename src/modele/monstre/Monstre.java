package modele.monstre;
import modele.Maladie;
import modele.service.ServiceMedical;
import sounds.AudioPlayer;

import java.util.ArrayList;
import java.util.Random;

public class Monstre {
	private String type;
	private String nom;
	private char sexe;
	private short poids;
	private short taille;
	private int age;
	private int indicateurMoral = 100;
	private ArrayList<Maladie> listeMaladie = new ArrayList<>();
	private boolean estMort = false;


	private static final String RESET = "\u001B[0m";
	private static final String GREEN = "\u001B[32m";
	private static final String RED = "\u001B[31m";




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
		return (byte) indicateurMoral;
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
	private ServiceMedical service; // Référence au service médical
	public ServiceMedical getService() {
		return service;
	}
	public void setService(ServiceMedical service) {
		this.service = service;
	}


	public boolean estMort(boolean b) {
		return this.estMort;
	}



	public void tomberMalade(Maladie maladie){
		this.listeMaladie.add(maladie);
	}






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

		// Progression aléatoire des maladies existantes
		System.out.println("Les maladies de " + nom +" qui est un  "+ type + " évoluent...");
		boolean auMoinsUneMaladieAEvolue = false; // Pour savoir si au moins une maladie a évolué

		for (Maladie maladie : listeMaladie) {
			// Décider aléatoirement si cette maladie doit progresser (30 % de chance)
			int chanceEvoluer = random.nextInt(100); // Nombre entre 0 et 99
			if (chanceEvoluer < 30) { // 30 % de chance
				maladie.setNiveauActuel(maladie.getNiveauActuel() + 1);
				System.out.println("⚠️ La maladie " + maladie.getNomComplet() + RED +" PROGRESSE " + RESET +" chez " + nom + ".");
				auMoinsUneMaladieAEvolue = true;

				// Vérifier si la maladie atteint son niveau max
				if (maladie.getNiveauActuel() >= maladie.getNiveauMax()) {
					System.out.println("💀 " + nom + " est" + RED +" MORT " + RESET +" à cause de " + maladie.getNomComplet() + ".");
					demoraliser(); // Démoraliser les autres créatures si c'est un Vampire ou un Elfe qui meurt
					Monstre.this.service.getListeCreature().remove(this); // Retirer le monstre du service quand il meurt
					return; // Arrêter toute évolution car le monstre est mort
				}
			} else {
				System.out.println("😌 La maladie " + maladie.getNomComplet() + " reste"+ GREEN + " STABLE" + RESET +" chez " + nom + ".");
			}
		}

		// Si aucune maladie n'a évolué, le moral diminue
		if (!auMoinsUneMaladieAEvolue) {
			diminuerMoral();
		}
	}

	// Méthode pour réduire le moral
	private void diminuerMoral() {
		int moralActuel = getIndicateurMoral();
		int reductionMoral = 10; // Réduction de moral en cas de stagnation des maladies
		int nouveauMoral = Math.max(0, moralActuel - reductionMoral); // Le moral ne peut pas être négatif
		setIndicateurMoral((byte) nouveauMoral);

		System.out.println("😟 Le moral de " + nom + " diminue de " + reductionMoral + "% (Moral actuel : " + nouveauMoral + "%).");

		// Si le moral atteint 0, joue un hurlement
		if (nouveauMoral == 0) {
			System.out.println("💀 " + nom + " hurle de désespoir !");
			AudioPlayer.jouerSon("src/sounds/hurlement.wav");
		}
	}



	private void demoraliser() {
		this.estMort = true;
		if (this instanceof Vampire || this instanceof Elfe) {
			if (this instanceof Vampire) {
				((Vampire) this).demoraliser(service);
			} else {
				((Elfe) this).demoraliser(service);
			}
		}
	}

	private void regenerer() {
		System.out.println("Le vampire se régénère.");
	}

	// Soigner une maladie spécifique
	public void soignerMaladie(String nomMaladie) {
		for (int i = 0; i < listeMaladie.size(); i++) {
			Maladie maladie = listeMaladie.get(i);

			if (maladie.getNomComplet().equalsIgnoreCase(nomMaladie)) {
				// Retire la maladie de la liste
				listeMaladie.remove(i);
				Monstre.this.indicateurMoral += 50;
				// System.out.println("La maladie " + maladie.getNomComplet() + " a été complètement soignée !");
				return;
			}
		}
		System.out.println("Aucune maladie correspondante trouvée pour " + nomMaladie + ".");
	}


	public Maladie getMaxMaladie() {
		Maladie maladie = getListeMaladie().getFirst();
		for (int i = 1; i < getListeMaladie().size(); ++i) {
			if (getListeMaladie().get(i).getNiveauActuel() / maladie.getNiveauMax() < getListeMaladie().get(i).getNiveauActuel() / maladie.getNiveauMax()) {
				maladie = getListeMaladie().get(i);
			}
		}
		return maladie;
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
