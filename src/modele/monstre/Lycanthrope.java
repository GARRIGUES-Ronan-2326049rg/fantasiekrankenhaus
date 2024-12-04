package modele.monstre;

/**
 * Classe représentant un lycanthrope, qui est un type spécifique de monstre.
 */
public class Lycanthrope extends Monstre {

    /**
     * Constructeur pour la classe Lycanthrope.
     *
     * @param nom Le nom du lycanthrope.
     */
    public Lycanthrope(String nom) {
        super(nom, "Lycanthrope", 'M', (short) 100, (short) 200, 30, 100);
    }
}