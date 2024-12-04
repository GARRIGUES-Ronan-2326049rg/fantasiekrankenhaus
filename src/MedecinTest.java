import modele.Maladie;
import modele.Medecin;
import modele.monstre.Monstre;
import modele.service.ServiceMedical;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedecinTest {

    private Medecin medecin;
    private Monstre monstre;
    private ServiceMedical service;

    @BeforeEach
    void setUp() {
        medecin = new Medecin("Dr. Test", 'M', (byte) 30);
        monstre = new Monstre("Monstre Test", "Type", 'M', (short) 0, (short) 0, 0, 0);
        service = new ServiceMedical("Service Test", 10, "Faible", 5);
    }

    @Test
    void getNom_returnsCorrectName() {
        assertEquals("Dr. Test", medecin.getNom());
    }

    @Test
    void setNom_updatesNameCorrectly() {
        medecin.setNom("Dr. Updated");
        assertEquals("Dr. Updated", medecin.getNom());
    }

    @Test
    void getSexe_returnsCorrectSex() {
        assertEquals('M', medecin.getSexe());
    }

    @Test
    void setSexe_updatesSexCorrectly() {
        medecin.setSexe('F');
        assertEquals('F', medecin.getSexe());
    }

    @Test
    void getActionPossible_returnsCorrectActionCount() {
        assertEquals(2, medecin.getActionPossible());
    }

    @Test
    void setActionPossible_updatesActionCountCorrectly() {
        medecin.setActionPossible(3);
        assertEquals(3, medecin.getActionPossible());
    }

    @Test
    void examineService_displaysServiceDetails() {
        service.ajouterPatient(monstre);
        medecin.examineService(service);
        // Assuming the method prints details, we can't assert print statements directly
    }

    @Test
    void soignePatient_handlesNoMaladies() {
        medecin.soignePatient(monstre, service);
        assertEquals(2, medecin.getActionPossible());
    }

    @Test
    void reviseBudget_updatesServiceBudget() {
        medecin.reviseBudget(service, "Moyen");
        assertEquals("Moyen", service.getBudget());
        assertEquals(1, medecin.getActionPossible());
    }

}