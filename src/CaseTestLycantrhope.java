import modele.monstre.ColonieLycanthrope;
import modele.monstre.Lycanthrope;
import modele.monstre.MeuteLycanthrope;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CaseTestLycantrhope {

    private Lycanthrope lycanthrope;
    private MeuteLycanthrope meute;
    private ColonieLycanthrope colonie;

    @BeforeEach
    void setUp() {
        lycanthrope = new Lycanthrope("Lycan", 20);
        meute = new MeuteLycanthrope();
        colonie = new ColonieLycanthrope();
    }

    @Test
    public void testCategorieAge() {
        assertEquals("Adulte", lycanthrope.getCategorieAge());
    }

}
