import modele.lycanthrope.ColonieLycanthrope;
import modele.lycanthrope.Lycanthrope;
import modele.lycanthrope.MeuteLycanthrope;
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
        this.lycan = new Lycanthrope("Lycan", 'M', "Adulte", 'α', "test");
        this.lycane = new Lycanthrope("Lycane", 'F', "Jeune", 'α', "test");
        this.soumis = new Lycanthrope("Soumis", 'M', "Adulte", 'ω', "test");

        ArrayList<Lycanthrope> liste = new ArrayList<>();
        liste.add(lycan);
        liste.add(lycane);
        liste.add(soumis);

        this.meute = new MeuteLycanthrope("test", liste);
        this.colonie = new ColonieLycanthrope();
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
