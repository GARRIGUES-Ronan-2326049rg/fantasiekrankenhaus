package modele;

import java.util.ArrayList;
import java.util.List;

public class ListeMaladies {
    public static List<Maladie> getMaladies() {
        List<Maladie> maladies = new ArrayList<>();

        maladies.add(new Maladie("Maladie débilitante chronique", "MDC", 3, 10));
        maladies.add(new Maladie("Syndrome fear of missing out", "FOMO", 2, 8));
        maladies.add(new Maladie("Dépendance aux réseaux sociaux", "DRS", 1, 5));
        maladies.add(new Maladie("Porphyrie érythropoïétique congénitale", "PEC", 4, 7));
        maladies.add(new Maladie("Zoopathie paraphrénique lycanthropique", "ZPL", 6, 10));

        return maladies;
    }
}
