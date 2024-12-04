package modele.monstre;
import modele.Maladie;
import modele.Recapitulatif;
import modele.service.ServiceMedical;
import sounds.AudioPlayer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

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

	/**
	 * Constructeur pour la classe Monstre.
	 *
	 * @param type Le type du monstre.
	 * @param nom Le nom du monstre.
	 * @param sexe Le sexe du monstre.
	 * @param poids Le poids du monstre.
	 * @param taille La taille du monstre.
	 * @param age L'âge du monstre.
	 * @param indicateurMoral L'indicateur de moral du monstre.
	 */
	public Monstre(String type, String nom, char sexe, short poids, short taille, int age, int indicateurMoral) {
		this.type = type;
		this.nom = nom;
		this.sexe = sexe;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
		this.indicateurMoral = 100;
	}

	/**
	 * Obtient le type du monstre.
	 *
	 * @return Le type du monstre.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Définit le type du monstre.
	 *
	 * @param type Le type à définir.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Obtient le nom du monstre.
	 *
	 * @return Le nom du monstre.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Définit le nom du monstre.
	 *
	 * @param nom Le nom à définir.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Obtient le sexe du monstre.
	 *
	 * @return Le sexe du monstre.
	 */
	public char getSexe() {
		return sexe;
	}

	/**
	 * Définit le sexe du monstre.
	 *
	 * @param sexe Le sexe à définir.
	 */
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	/**
	 * Obtient le poids du monstre.
	 *
	 * @return Le poids du monstre.
	 */
	public short getPoids() {
		return poids;
	}

	/**
	 * Définit le poids du monstre.
	 *
	 * @param poids Le poids à définir.
	 */
	public void setPoids(short poids) {
		this.poids = poids;
	}

	/**
	 * Obtient la taille du monstre.
	 *
	 * @return La taille du monstre.
	 */
	public short getTaille() {
		return taille;
	}

	/**
	 * Définit la taille du monstre.
	 *
	 * @param taille La taille à définir.
	 */
	public void setTaille(short taille) {
		this.taille = taille;
	}

	/**
	 * Obtient l'âge du monstre.
	 *
	 * @return L'âge du monstre.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Définit l'âge du monstre.
	 *
	 * @param age L'âge à définir.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Obtient l'indicateur de moral du monstre.
	 *
	 * @return L'indicateur de moral du monstre.
	 */
	public byte getIndicateurMoral() {
		return (byte) indicateurMoral;
	}

	/**
	 * Définit l'indicateur de moral du monstre.
	 *
	 * @param indicateurMoral L'indicateur de moral à définir.
	 */
	public void setIndicateurMoral(byte indicateurMoral) {
		this.indicateurMoral = indicateurMoral;
	}

	/**
	 * Obtient la liste des maladies du monstre.
	 *
	 * @return La liste des maladies du monstre.
	 */
	public ArrayList<Maladie> getListeMaladie() {
		return listeMaladie;
	}

	/**
	 * Définit la liste des maladies du monstre.
	 *
	 * @param listeMaladie La liste des maladies à définir.
	 */
	public void setListeMaladie(ArrayList<Maladie> listeMaladie) {
		this.listeMaladie = listeMaladie;
	}

	private ServiceMedical service; // Référence au service médical

	/**
	 * Obtient le service médical du monstre.
	 *
	 * @return Le service médical du monstre.
	 */
	public ServiceMedical getService() {
		return service;
	}

	/**
	 * Définit le service médical du monstre.
	 *
	 * @param service Le service médical à définir.
	 */
	public void setService(ServiceMedical service) {
		this.service = service;
	}

	/**
	 * Vérifie si le monstre est mort.
	 *
	 * @param b Un booléen indiquant si le monstre est mort.
	 * @return True si le monstre est mort, sinon false.
	 */
	public boolean estMort(boolean b) {
		return this.estMort;
	}

	/**
	 * Ajoute une maladie à la liste des maladies du monstre.
	 *
	 * @param maladie La maladie à ajouter.
	 */
	public void tomberMalade(Maladie maladie){
		this.listeMaladie.add(maladie);
	}

	/**
	 * Fait évoluer les maladies du monstre.
	 */
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
					agirApresTrepas(service); // Actions spécifiques après le trépas en suivant le type de monstre
					Monstre.this.service.getListeCreature().remove(this); // Retirer le monstre du service quand il meurt
					Recapitulatif.getInstance().incrementerMort();
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

	/**
	 * Réduit le moral du monstre.
	 */
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

	/**
	 * Effectue des actions spécifiques après la mort du monstre.
	 *
	 * @param service Le service médical associé.
	 */
	public void agirApresTrepas(ServiceMedical service) {
		// Groupes des types de monstres par comportement
		Set<String> demoraliseurs = Set.of("Elfe", "Vampire");
		Set<String> contaminateurs = Set.of("Orque", "HommeBete", "Lycanthrope", "Vampire");
		Set<String> regenerateurs = Set.of("Zombie", "Vampire");

		if (demoraliseurs.contains(type)) {
			demoraliser(service);
		}
		if (contaminateurs.contains(type)) {
			contaminer(service);
		}
		if (regenerateurs.contains(type)) {
			regenerer(service);
		}

		// Si pas action possible
		if (!demoraliseurs.contains(type) && !contaminateurs.contains(type) && !regenerateurs.contains(type)) {
			System.out.println("Aucune action spéciale pour ce type de monstre.");
		}
	}

	/**
	 * Démoralise les autres créatures du service.
	 *
	 * @param service Le service médical associé.
	 */
	private void demoraliser(ServiceMedical service) {
		System.out.println("💔 " + type + " démoralise les autres créatures.");
		ArrayList<Monstre> monstres = new ArrayList<>(service.getListeCreature());
		monstres.remove(this);
		int nombreAffectes = monstres.size() / 2;
		for (int i = 0; i < nombreAffectes; i++) {
			Monstre monstre = monstres.get(i);
			int nouveauMoral = Math.max(0, monstre.getIndicateurMoral() - 10);
			monstre.setIndicateurMoral((byte) nouveauMoral);
		}
	}

	/**
	 * Contamine une autre créature du service avec une maladie.
	 *
	 * @param service Le service médical associé.
	 */
	private void contaminer(ServiceMedical service) {
		// Vérifie si le monstre a des maladies à transmettre
		if (this.getListeMaladie().isEmpty()) {
			System.out.println(this.getNom() + " n'a aucune maladie à transmettre.");
			return;
		}

		// Récupère une maladie random du monstre
		Random random = new Random();
		Maladie maladieOrigine = this.getListeMaladie().get(random.nextInt(this.getListeMaladie().size()));

		// Récupère la liste des créatures du service
		ArrayList<Monstre> autresMonstres = new ArrayList<>(service.getListeCreature());
		autresMonstres.remove(this); // Retirer le monstre actuel de la liste

		// Vérifie s'il y a d'autres créatures à contaminer
		if (autresMonstres.isEmpty()) {
			System.out.println("Aucune autre créature dans le service pour être contaminée.");
			return;
		}

		// Sélectionne une créature aléatoire
		Monstre cible = autresMonstres.get(random.nextInt(autresMonstres.size()));

		// Réinitialise le niveau de la maladie avant de l'ajouter
		maladieOrigine.setNiveauActuel(1); // Remet au niveau initial

		// Ajoute la maladie (modifiée) à la liste des maladies de la créature
		cible.tomberMalade(maladieOrigine);

		// Message de confirmation
		System.out.println(this.getNom() + " a transmis une maladie " +
				maladieOrigine.getNomComplet() + " à " +
				cible.getNom() + ".");
	}

	/**
	 * Régénère le monstre.
	 *
	 * @param service Le service médical associé.
	 */
	private void regenerer(ServiceMedical service) {
		System.out.println("🧟 " + type + " se régénère.");
		this.estMort = false; // Revient à la vie
		this.setIndicateurMoral((byte) 80);
	}

	/**
	 * Soigne une maladie spécifique du monstre.
	 *
	 * @param nomMaladie Le nom de la maladie à soigner.
	 */
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

	/**
	 * Obtient la maladie la plus grave du monstre.
	 *
	 * @return La maladie la plus grave.
	 */
	public Maladie getMaxMaladie() {
		Maladie maladie = getListeMaladie().get(0);
		for (int i = 1; i < getListeMaladie().size(); ++i) {
			if (getListeMaladie().get(i).getNiveauActuel() / maladie.getNiveauMax() < getListeMaladie().get(i).getNiveauActuel() / maladie.getNiveauMax()) {
				maladie = getListeMaladie().get(i);
			}
		}
		return maladie;
	}

	/**
	 * Retourne une représentation sous forme de chaîne de caractères du monstre.
	 *
	 * @return Une chaîne de caractères représentant le monstre.
	 */
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