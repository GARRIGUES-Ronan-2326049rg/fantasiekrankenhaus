package modele.service;

public class Crypte extends ServiceMedical{
    public int ventilation;
    public int temperature;

    public int getTempérature() {
        return temperature;
    }

    public int getVentilation() {
        return ventilation;
    }

    public void setTempérature(int temperature) {
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
