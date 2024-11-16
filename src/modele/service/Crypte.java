package modele.service;

public class Crypte extends ServiceMedical{
    public int ventilation;
    public int temperature;

    public Crypte(String nom, int superficie, String budget) {
        super(nom, superficie, budget);
    }

    public int getTemperature() {
        return temperature;
    }

    public int getVentilation() {
        return ventilation;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setVentilation(int ventilation) {
        this.ventilation = ventilation;
    }

    @Override
    public String getBudget() {
        return "Budget = " +super.getBudget() + ", Ventilation = "+ventilation
                + ", Température = "+temperature;
    }
}
