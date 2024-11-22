import modele.monstre.Monstre;
import modele.service.CentreQuarantaine;
import modele.service.Crypte;
import modele.service.ServiceMedical;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CaseTestService {

    private ServiceMedical service;
    private Crypte crypte;
    private CentreQuarantaine centreQuarantaine;
    private ArrayList<Monstre> listeMonstre = new ArrayList<>();
    private ArrayList<Monstre> listeMaxMonstre = new ArrayList<>();

    @BeforeEach
    void setUp() {
        this.service = new ServiceMedical("Service test", 20,   "Faible", 10);
        this.crypte = new Crypte("Crypte test", 20, "Faible", 10);
        this.centreQuarantaine = new CentreQuarantaine("Centre Quarantaine test", 20, "Faible", 10);

        listeMonstre.add(new Monstre("chouette"));
        listeMonstre.add(new Monstre("bidule"));
        listeMonstre.add(new Monstre("chose"));
        listeMonstre.add(new Monstre("machin"));

        listeMaxMonstre.add(new Monstre("chouette"));
        listeMaxMonstre.add(new Monstre("bidule"));
        listeMaxMonstre.add(new Monstre("chose"));
        listeMaxMonstre.add(new Monstre("machin"));
        listeMaxMonstre.add(new Monstre("truc"));
        listeMaxMonstre.add(new Monstre("truc chose"));
        listeMaxMonstre.add(new Monstre("bidule bidule"));
        listeMaxMonstre.add(new Monstre("chez"));
        listeMaxMonstre.add(new Monstre("tati"));
        listeMaxMonstre.add(new Monstre("tatou"));
    }

    @Test
    void testListVide() {
        assertTrue(service.getListeCreature().isEmpty());
    }

    @Test
    void testAjouterPatientSiListeVide() {
        if(service.getListeCreature().isEmpty()){
            service.ajouterPatient(new Monstre("machin"));
            assertTrue(service.getListeCreature().size() == 1);
        }
    }

    @Test
    void testAjouterPatient() {
        boolean ajout = false;
        while(!ajout){
            service.ajouterPatient(new Monstre("truc"));
            if(service.getListeCreature().size() == 2) ajout = true;
        }
        assertTrue(service.getListeCreature().size() == 2);
    }

    @Test
    void testAjouterPatientSiListePleine() {
        service.setListeCreature(listeMaxMonstre);
        Monstre monstre = new Monstre("prout");
        service.ajouterPatient(monstre);
        assertTrue(!service.getListeCreature().contains(monstre));
    }

    @Test
    void testRetirerPatient(){
        Monstre monstre = new Monstre("truc");
        listeMonstre.add(monstre);
        service.setListeCreature(listeMonstre);
        service.retirerPatient(monstre);
        assertTrue(!service.getListeCreature().contains(monstre));
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
}
