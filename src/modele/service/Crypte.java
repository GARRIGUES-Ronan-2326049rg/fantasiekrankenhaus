package modele.service;

public class Crypte extends ServiceMedical {
    public int ventilation;
    public int temperature;

    public Crypte(String nom, int superficie, String budget) {
        super(nom, superficie, budget);
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

    public String getBudget() {
        String var10000 = super.getBudget();
        return "Budget = " + var10000 + ", Ventilation = " + this.ventilation + ", Température = " + this.temperature;
    }
}
