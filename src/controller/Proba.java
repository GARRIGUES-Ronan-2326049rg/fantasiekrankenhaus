package controller;

public class Proba {
    public double calculProba(String qualite, double r){
        double p = 0;
        switch (qualite){
            case "Inexistant":
                p = 0.35;
                break;
            case "Mediocre":
                p = 0.45;
                break;
            case "Insuffisant":
                p = 0.55;
                break;
            case "Faible":
                p = 0.65;
                break;
            case "Moyen":
                p = 0.75;
                break;
            case "Bon":
                p = 0.8;
                break;
            case "Super":
                p = 0.9;
                break;
            case "Parfait":
                p = 1.0;
                break;
        }

        return p*(1-r);
    }
}
