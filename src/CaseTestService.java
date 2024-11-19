import modele.monstre.Monstre;
import modele.service.ServiceMedical;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CaseTestService {

    private ServiceMedical service;

    @BeforeEach
    void setUp() {
        this.service = new ServiceMedical("Service test", 20,   "faible", 10);
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
        ArrayList<Monstre> listeMonstre = new ArrayList<>();
        listeMonstre.add(new Monstre("chouette"));
        listeMonstre.add(new Monstre("bidule"));
        listeMonstre.add(new Monstre("chose"));
        listeMonstre.add(new Monstre("machin"));
        listeMonstre.add(new Monstre("truc"));
        listeMonstre.add(new Monstre("truc chose"));
        listeMonstre.add(new Monstre("bidule bidule"));
        listeMonstre.add(new Monstre("chez"));
        listeMonstre.add(new Monstre("tati"));
        listeMonstre.add(new Monstre("tatou"));
        service.setListeCreature(listeMonstre);

        Monstre monstre = new Monstre("prout");
        service.ajouterPatient(monstre);
        assertTrue(!service.getListeCreature().contains(monstre));
    }

    @Test
    void testRetirerPatient(){
        ArrayList<Monstre> listeMonstre = new ArrayList<>();
        listeMonstre.add(new Monstre("chouette"));
        listeMonstre.add(new Monstre("bidule"));
        listeMonstre.add(new Monstre("chose"));
        listeMonstre.add(new Monstre("machin"));

        Monstre monstre = new Monstre("truc");
        listeMonstre.add(monstre);

        service.setListeCreature(listeMonstre);

        service.retirerPatient(monstre);
        assertTrue(!service.getListeCreature().contains(monstre));
    }
}
