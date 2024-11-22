package modele.service;

public class Crypte extends ServiceMedical {
    private int ventilation; //Simule un pourcentage.
    private int temperature; // En °C.

    public Crypte(String nom, int superficie, String budget, int max) {
        super(nom, superficie, budget, max);
        this.ventilation = 100;
        this.temperature = 15;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public int getVentilation() {
        return this.ventilation;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setVentilation(int ventilation) {
        this.ventilation = ventilation;
    }

    @Override
    public String getBudget() {
        return super.getBudget() + ", Ventilation = " + this.ventilation + "%, Température = " + this.temperature + "%";
    }
}