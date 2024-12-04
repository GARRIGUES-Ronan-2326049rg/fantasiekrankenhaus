import modele.Maladie;
import modele.monstre.Monstre;
import modele.service.ServiceMedical;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MonstreTest {

    private Monstre monstre;
    private Maladie maladie;
    private ServiceMedical service;

    @BeforeEach
    void setUp() {
        monstre = new Monstre("Type", "Monstre Test", 'M', (short) 50, (short) 150, 10, 100);
        maladie = new Maladie("Grippe", "GRP", 2, 5);
        service = new ServiceMedical("Service Test", 10, "Faible", 5);
    }

    @Test
    void getType_returnsCorrectType() {
        assertEquals("Type", monstre.getType());
    }

    @Test
    void setType_updatesTypeCorrectly() {
        monstre.setType("New Type");
        assertEquals("New Type", monstre.getType());
    }

    @Test
    void getNom_returnsCorrectName() {
        assertEquals("Monstre Test", monstre.getNom());
    }

    @Test
    void setNom_updatesNameCorrectly() {
        monstre.setNom("Updated Name");
        assertEquals("Updated Name", monstre.getNom());
    }

    @Test
    void getSexe_returnsCorrectSex() {
        assertEquals('M', monstre.getSexe());
    }

    @Test
    void setSexe_updatesSexCorrectly() {
        monstre.setSexe('F');
        assertEquals('F', monstre.getSexe());
    }

    @Test
    void getPoids_returnsCorrectWeight() {
        assertEquals(50, monstre.getPoids());
    }

    @Test
    void setPoids_updatesWeightCorrectly() {
        monstre.setPoids((short) 60);
        assertEquals(60, monstre.getPoids());
    }

    @Test
    void getTaille_returnsCorrectHeight() {
        assertEquals(150, monstre.getTaille());
    }

    @Test
    void setTaille_updatesHeightCorrectly() {
        monstre.setTaille((short) 160);
        assertEquals(160, monstre.getTaille());
    }

    @Test
    void getAge_returnsCorrectAge() {
        assertEquals(10, monstre.getAge());
    }

    @Test
    void setAge_updatesAgeCorrectly() {
        monstre.setAge(20);
        assertEquals(20, monstre.getAge());
    }

    @Test
    void getIndicateurMoral_returnsCorrectMoral() {
        assertEquals(100, monstre.getIndicateurMoral());
    }

    @Test
    void setIndicateurMoral_updatesMoralCorrectly() {
        monstre.setIndicateurMoral((byte) 80);
        assertEquals(80, monstre.getIndicateurMoral());
    }

    @Test
    void getListeMaladie_returnsCorrectMaladieList() {
        assertTrue(monstre.getListeMaladie().isEmpty());
    }

    @Test
    void setListeMaladie_updatesMaladieListCorrectly() {
        ArrayList<Maladie> maladies = new ArrayList<>();
        maladies.add(maladie);
        monstre.setListeMaladie(maladies);
        assertEquals(1, monstre.getListeMaladie().size());
    }

    @Test
    void getService_returnsCorrectService() {
        monstre.setService(service);
        assertEquals(service, monstre.getService());
    }

    @Test
    void setService_updatesServiceCorrectly() {
        ServiceMedical newService = new ServiceMedical("New Service", 20, "Moyen", 10);
        monstre.setService(newService);
        assertEquals(newService, monstre.getService());
    }

    @Test
    void estMort_returnsFalseInitially() {
        assertFalse(monstre.estMort(false));
    }

    @Test
    void tomberMalade_addsMaladieToList() {
        monstre.tomberMalade(maladie);
        assertEquals(1, monstre.getListeMaladie().size());
    }

    @Test
    void evoluerMaladies_progressesMaladiesCorrectly() {
        monstre.tomberMalade(maladie);
        monstre.evoluerMaladies();
        assertTrue(monstre.getListeMaladie().get(0).getNiveauActuel() > 2);
    }

    @Test
    void diminuerMoral_reducesMoralCorrectly() {
        monstre.setIndicateurMoral((byte) 50);
        monstre.evoluerMaladies();
        assertTrue(monstre.getIndicateurMoral() < 50);
    }

    @Test
    void soignerMaladie_removesMaladieFromList() {
        monstre.tomberMalade(maladie);
        monstre.soignerMaladie("Grippe");
        assertTrue(monstre.getListeMaladie().isEmpty());
    }

    @Test
    void getMaxMaladie_returnsMostSevereMaladie() {
        Maladie severeMaladie = new Maladie("Covid-19", "CVD", 4, 5);
        monstre.tomberMalade(maladie);
        monstre.tomberMalade(severeMaladie);
        assertEquals(severeMaladie, monstre.getMaxMaladie());
    }

    @Test
    void toString_returnsCorrectStringRepresentation() {
        String expected = "\u001B[34m🔮 Monstre : \u001B[0mMonstre Test\n" +
                "    • Sexe : \u001B[32mMâle\u001B[0m\n" +
                "    • Poids : \u001B[36m50 kg\u001B[0m\n" +
                "    • Taille : \u001B[36m150 cm\u001B[0m\n" +
                "    • Âge : \u001B[36m10 ans\u001B[0m\n" +
                "    • Moral : \u001B[33m100%\u001B[0m\n" +
                "✅ \u001B[32mCe monstre est en pleine santé !\u001B[0m\n";
        assertEquals(expected, monstre.toString());
    }
}