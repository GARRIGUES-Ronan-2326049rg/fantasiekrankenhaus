import modele.monstre.ColonieLycanthrope;
import modele.monstre.Lycanthrope;
import modele.monstre.MeuteLycanthrope;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CaseTestLycantrhope {

    private Lycanthrope lycan;
    private Lycanthrope lycane;
    private Lycanthrope soumis;
    private MeuteLycanthrope meute;
    private ColonieLycanthrope colonie;

    @BeforeEach
    void setUp() {
        lycan = new Lycanthrope("Lycan", 'M', 20, 'α');
        lycane = new Lycanthrope("Lycane", 'F', 17, 'α');
        soumis = new Lycanthrope("Soumis", 'M', 20, 'ω');

        ArrayList<Lycanthrope> liste = new ArrayList<>();
        liste.add(lycan);
        liste.add(lycane);
        liste.add(soumis);

        meute = new MeuteLycanthrope(liste);
        colonie = new ColonieLycanthrope();
    }

    @Test
    public void testCategorieAgeAdulte() {
        assertEquals("Adulte", lycan.getCategorieAge());
    }

    @Test
    public void testCategorieAgeJeune() {
        assertEquals("Jeune", lycane.getCategorieAge());
    }

}
