import modele.lycanthrope.Colonie;
import modele.lycanthrope.Lycanthrope;
import modele.lycanthrope.Meute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CaseTestLycantrhope {

    private Lycanthrope lycan;
    private Lycanthrope lycane;
    private Lycanthrope soumis;
    private Meute meute;
    private Colonie colonie;

    @BeforeEach
    void setUp() {
        this.lycan = new Lycanthrope("Lycan", 'M', "Adulte", 'α', "test");
        this.lycane = new Lycanthrope("Lycane", 'F', "Jeune", 'α', "test");
        this.soumis = new Lycanthrope("Soumis", 'M', "Vieux", 'ω', "test");

        ArrayList<Lycanthrope> liste = new ArrayList<>();
        liste.add(lycan);
        liste.add(lycane);
        liste.add(soumis);

        this.meute = new Meute("test", liste);
        this.colonie = new Colonie(new ArrayList<>());
    }

    //Test sur la classe Lycanthrope
    @Test
    public void testCategorieAgeAdulte() {
        assertEquals("Adulte", lycan.getCategorieAge());
    }

    @Test
    public void testCategorieAgeJeune() {
        assertEquals("Jeune", lycane.getCategorieAge());
    }

    @Test
    public void testCategorieAgeVieux(){
        assertEquals("Vieux", soumis.getCategorieAge());
    }

    @Test
    public void testDevenirHumain(){
        lycan.transformationHumain();
        assertEquals(true, lycan.isDevenirHumain());
    }

    @Test
    public void testDevenirLycanthrope(){
        lycan.transformationLycanthrope();
        assertEquals(false, lycan.isDevenirHumain());
    }

    @Test
    public void hurlementAppartenance(){
        assertEquals(lycan.hurlementAppartenanceMeute(),
                lycan.getNom() + " exprime son apparetenance à la meute " + lycan.getMeute() + " !");
    }

    @Test
    public void hurlemantDomination(){
        assertEquals(lycan.exprimerDomination(soumis),
                lycan.getNom() + " a dominé " + soumis.getNom() + " !");
    }

    //Tests autres hurlements

    //Test sur la classe Meute



}
