import java.util.ArrayList;
import modele.monstre.Monstre;
import modele.service.CentreQuarantaine;
import modele.service.Crypte;
import modele.service.ServiceMedical;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Assertions.assertTrue(this.service.getListeCreature().isEmpty());
    }

    @Test
    void testAjouterPatientSiListeVide() {
        if (this.service.getListeCreature().isEmpty()) {
            this.service.ajouterPatient(new Monstre("machin", "machin", 'm',(short) 0, (short) 0, 0, 0));
            Assertions.assertTrue(this.service.getListeCreature().size() == 1);
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

        Assertions.assertTrue(this.service.getListeCreature().size() == 2);
    }

    @Test
    void testAjouterPatientSiListePleine() {
        this.service.setListeCreature(this.listeMaxMonstre);
        Monstre monstre = new Monstre("toto", "toto", 'm', (short) 0, (short) 0, 0, 0);
        this.service.ajouterPatient(monstre);
        Assertions.assertTrue(!this.service.getListeCreature().contains(monstre));
    }

    @Test
    void testRetirerPatient() {
        Monstre monstre = new Monstre("truc", "truc", 'm', (short) 0, (short) 0, 0, 0);
        this.listeMonstre.add(monstre);
        this.service.setListeCreature(this.listeMonstre);
        this.service.retirerPatient(monstre);
        Assertions.assertTrue(!this.service.getListeCreature().contains(monstre));
    }

    @Test
    void testAncienBudget() {
        this.service.setBudget("Inexistant");
        Assertions.assertTrue(this.service.getBudgetPred().equals("Faible"));
    }

    @Test
    void testVariationBudget() {
        this.service.setBudget("Inexistant");
        this.service.variationBudget();
        Assertions.assertTrue(this.service.getTauxPropagation() == 8 && this.service.getMaxCreature() == 1);
    }
}