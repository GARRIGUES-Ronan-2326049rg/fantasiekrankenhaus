package modele.service;

public class Crypte extends ServiceMedical {
    private int ventilation;
    private int temperature;

    public Crypte(String nom, int superficie, String budget, int max) {
        super(nom, superficie, budget, max);
    }

    public int getTempérature() {
        return this.temperature;
    }

    public int getVentilation() {
        return this.ventilation;
    }

    public void setTempérature(int temperature) {
        this.temperature = temperature;
    }

    public void setVentilation(int ventilation) {
        this.ventilation = ventilation;
    }

    @Override
    public String getBudget() {
        return super.getBudget() + ", Ventilation = " + this.ventilation + ", Température = " + this.temperature;
    }

}
