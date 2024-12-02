package controller;

public class Proba {
    /**
     * Calcul de la probabilité de réussite d'une action en fonction de la qualité du service  et du ratio maladie.
     *
     * @param qualite La qualité de l'objet.
     * @param r       La rareté de l'objet.
     * @return La probabilité de réussite de l'action.
     */
    public double calculProba(String qualite, double r){
        double p = switch (qualite) {
            case "Inexistant" -> 0.35;
            case "Mediocre" -> 0.45;
            case "Insuffisant" -> 0.55;
            case "Faible" -> 0.65;
            case "Moyen" -> 0.75;
            case "Bon" -> 0.8;
            case "Super" -> 0.9;
            case "Parfait" -> 1.0;
            default -> 0;
        };

        return p*(1-(r-0.1));
    }
}
