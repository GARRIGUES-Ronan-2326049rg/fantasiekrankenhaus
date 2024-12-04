import modele.Maladie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaladieTest {

    private Maladie maladie;

    @BeforeEach
    void setUp() {
        maladie = new Maladie("Grippe", "GRP", 2, 5);
    }

    @Test
    void getNomComplet_returnsCorrectName() {
        assertEquals("Grippe", maladie.getNomComplet());
    }

    @Test
    void setNomComplet_updatesNameCorrectly() {
        maladie.setNomComplet("Covid-19");
        assertEquals("Covid-19", maladie.getNomComplet());
    }

    @Test
    void getNomAbrege_returnsCorrectAbbreviation() {
        assertEquals("GRP", maladie.getNomAbrege());
    }

    @Test
    void setNomAbrege_updatesAbbreviationCorrectly() {
        maladie.setNomAbrege("CVD");
        assertEquals("CVD", maladie.getNomAbrege());
    }

    @Test
    void getNiveauActuel_returnsCorrectLevel() {
        assertEquals(2, maladie.getNiveauActuel());
    }

    @Test
    void setNiveauActuel_updatesLevelCorrectly() {
        maladie.setNiveauActuel(3);
        assertEquals(3, maladie.getNiveauActuel());
    }

    @Test
    void setNiveauActuel_doesNotExceedMaxLevel() {
        maladie.setNiveauActuel(6);
        assertEquals(5, maladie.getNiveauActuel());
    }

    @Test
    void setNiveauActuel_doesNotGoBelowZero() {
        maladie.setNiveauActuel(-1);
        assertEquals(0, maladie.getNiveauActuel());
    }

    @Test
    void getNiveauMax_returnsCorrectMaxLevel() {
        assertEquals(5, maladie.getNiveauMax());
    }

    @Test
    void setNiveauMax_updatesMaxLevelCorrectly() {
        maladie.setNiveauMax(10);
        assertEquals(10, maladie.getNiveauMax());
    }

    @Test
    void augmenterNiveau_increasesCurrentLevel() {
        maladie.augmenterNiveau(2);
        assertEquals(4, maladie.getNiveauActuel());
    }

    @Test
    void diminuerNiveau_decreasesCurrentLevel() {
        maladie.diminuerNiveau(1);
        assertEquals(1, maladie.getNiveauActuel());
    }

    @Test
    void estLetale_returnsTrueWhenCurrentLevelEqualsMaxLevel() {
        maladie.setNiveauActuel(5);
        assertTrue(maladie.estLetale());
    }

    @Test
    void estLetale_returnsFalseWhenCurrentLevelIsBelowMaxLevel() {
        maladie.setNiveauActuel(4);
        assertFalse(maladie.estLetale());
    }

    @Test
    void toString_returnsCorrectStringRepresentation() {
        String expected = "Maladie{nomComplet='Grippe', nomAbrege='GRP', niveauActuel=2, niveauMax=5}";
        assertEquals(expected, maladie.toString());
    }
}