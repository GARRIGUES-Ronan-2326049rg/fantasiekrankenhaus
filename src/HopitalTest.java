import modele.Hopital;
import modele.Medecin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HopitalTest {

    private Hopital hopital;

    @BeforeEach
    void setUp() {
        hopital = new Hopital();
    }

    @Test
    void initialisationMedecin_createsPredefinedMedecins() {
        hopital.initialisationMedecin();

        assertEquals(6, hopital.getListeMedecin().size());
        assertEquals("Dr Emmet Brown", hopital.getListeMedecin().get(0).getNom());
    }

    @Test
    void initialisationService_createsPredefinedServices() {
        hopital.initialisationService();

        assertEquals(10, hopital.getListeService().size());
        assertEquals("Vampire", hopital.getListeService().get(0).getNom());
    }

    @Test
    void initialisationMonstre_addsMonstresToCorrectServices() {
        hopital.initialisationService();
        hopital.initialisationMonstre(10, hopital.getListeService());

        assertTrue(hopital.getListeService().get(0).getListeCreature().size() > 0);
    }

    @Test
    void nouvelleJournee_resetsMedecinActions() {
        hopital.initialisationMedecin();
        hopital.nouvelleJournee();

        for (Medecin medecin : hopital.getListeMedecin()) {
            assertEquals(2, medecin.getActionPossible());
        }
    }

    @Test
    void resteAction_returnsTrueIfAnyMedecinHasActions() {
        hopital.initialisationMedecin();
        hopital.getListeMedecin().get(0).setActionPossible(1);

        assertTrue(hopital.resteAction());
    }

    @Test
    void resteAction_returnsFalseIfNoMedecinHasActions() {
        hopital.initialisationMedecin();
        for (Medecin medecin : hopital.getListeMedecin()) {
            medecin.setActionPossible(0);
        }

        assertFalse(hopital.resteAction());
    }
}