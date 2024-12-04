import java.util.ArrayList;
import modele.monstre.Monstre;
import modele.service.CentreQuarantaine;
import modele.service.Crypte;
import modele.service.ServiceMedical;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CaseTestService {
    private ServiceMedical service;
    private Crypte crypte;
    private CentreQuarantaine centreQuarantaine;
    private ArrayList<Monstre> listeMonstre = new ArrayList();
    private ArrayList<Monstre> listeMaxMonstre = new ArrayList();

    public CaseTestService() {
    }

    @BeforeEach
    void setUp() {
        this.service = new ServiceMedical("Service test", 20, "Faible", 10);
        this.crypte = new Crypte("Crypte test", 20, "Faible", 10);
        this.centreQuarantaine = new CentreQuarantaine("Centre Quarantaine test", 20, "Faible", 10);
        this.listeMonstre.add(new Monstre("type", "chouette", 'm', (short) 0, (short) 0, 0, 0));
        this.listeMonstre.add(new Monstre("type","bidule", 'f',(short) 0, (short) 0, 0, 0));
        this.listeMonstre.add(new Monstre("type","chose", 'm',(short) 0, (short) 0, 0, 0));
        this.listeMonstre.add(new Monstre("type","machin", 'f',(short) 0, (short) 0, 0, 0));
        this.listeMaxMonstre.add(new Monstre("type","chouette", 'm',(short) 0, (short) 0, 0, 0));
        this.listeMaxMonstre.add(new Monstre("type","bidule", 'f',(short) 0, (short) 0, 0, 0));
        this.listeMaxMonstre.add(new Monstre("type","chose", 'm',(short) 0, (short) 0, 0, 0));
        this.listeMaxMonstre.add(new Monstre("type","machin", 'f',(short) 0, (short) 0, 0, 0));
        this.listeMaxMonstre.add(new Monstre("type","truc", 'm',(short) 0, (short) 0, 0, 0));
        this.listeMaxMonstre.add(new Monstre("type","truc chose", 'f',(short) 0, (short) 0, 0, 0));
        this.listeMaxMonstre.add(new Monstre("type","bidule bidule", 'm',(short) 0, (short) 0, 0, 0));
        this.listeMaxMonstre.add(new Monstre("type","cheh", 'f',(short) 0, (short) 0, 0, 0));
        this.listeMaxMonstre.add(new Monstre("type","tati", 'f',(short) 0, (short) 0, 0, 0));
        this.listeMaxMonstre.add(new Monstre("type","tatou", 'm',(short) 0, (short) 0, 0, 0));
    }

    @Test
    void testListVide() {
        assertTrue(this.service.getListeCreature().isEmpty());
    }

    @Test
    void testAjouterPatientSiListeVide() {
        if (this.service.getListeCreature().isEmpty()) {
            this.service.ajouterPatient(new Monstre("machin", "machin", 'm',(short) 0, (short) 0, 0, 0));
            assertTrue(this.service.getListeCreature().size() == 1);
        }

    }

    @Test
    void testAjouterPatient() {
        boolean ajout = false;

        while(!ajout) {
            this.service.ajouterPatient(new Monstre("truc", "truc", 'm',(short) 0, (short) 0, 0, 0));
            if (this.service.getListeCreature().size() == 2) {
                ajout = true;
            }
        }

        assertTrue(this.service.getListeCreature().size() == 2);
    }

    @Test
    void testAjouterPatientSiListePleine() {
        this.service.setListeCreature(this.listeMaxMonstre);
        Monstre monstre = new Monstre("toto", "toto", 'm', (short) 0, (short) 0, 0, 0);
        this.service.ajouterPatient(monstre);
        assertTrue(!this.service.getListeCreature().contains(monstre));
    }

    @Test
    void testRetirerPatient() {
        Monstre monstre = new Monstre("truc", "truc", 'm', (short) 0, (short) 0, 0, 0);
        this.listeMonstre.add(monstre);
        this.service.setListeCreature(this.listeMonstre);
        this.service.retirerPatient(monstre);
        assertTrue(!this.service.getListeCreature().contains(monstre));
    }

    @Test
    void testAncienBudget(){
        service.setBudget("Inexistant");
        assertTrue(service.getBudgetPred().equals("Faible"));
    }
    @Test
    void testVariationBudget(){
        service.setBudget("Inexistant");
        service.variationBudget();
        assertTrue(service.getTauxPropagation() == 8 && service.getMaxCreature() == 10/8);
    }

    @Test
    void testReparerIsolation(){
        centreQuarantaine.setIsolation(50);
        centreQuarantaine.reparerIsolation();
        assertTrue(centreQuarantaine.getBudget().equals("Budget = Insuffisant, Isolation = 75%")
                && centreQuarantaine.getIsolation() == 75);
    }

    @Test
    void testVariationBudgetCrypteSiTempInf10(){
        crypte.setVentilation(50);
        crypte.reparerVentilation();

        crypte.setTemperature(10);
        crypte.variationBudget();
        assertTrue(crypte.getVentilation() == 75 && crypte.getMaxCreature() == 10/2
                    && crypte.getTauxPropagation() == 2*2);
    }

}