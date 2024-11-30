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
        if(ventilation <= 100) this.ventilation = ventilation;
    }

    /**
     * Répare la ventilation de la crypte si cette dernière est au plus à 75%.
     * Le budget baisse à chaque achat.
     *
     * @version 1.0
     * */
    public void reparerVentilation(){
        if(ventilation <= 75 && !super.getBudget().equals("Inexistant")){
            this.ventilation += 25;
            if(super.getBudget().equals("Faible")){
                setBudget("Insuffisant");
            }else if(super.getBudget().equals("Insuffisant")){
                setBudget("Médiocre");
            }else if(super.getBudget().equals("Médiocre")){
                setBudget("Inexistant");
            }
        }
    }

    @Override
    public String getBudget() {
        return "Budget = " + super.getBudget() + ", Ventilation = " + this.ventilation
                + "%, Température = " + this.temperature + "%";
    }

    /**
     * Modifie le nombre maximum de créatures et le taux de propagation des maladies en
     * fonction de l'évolution du budget du service et de la température des lieux.
     *
     * @version 1.0
     * */
    @Override
    public void variationBudget(){
        if(this.temperature >= 25 || this.temperature <= 5){
            super.variationBudget();
            setTauxPropagation(getTauxPropagation() * 4);
        } else if (this.temperature >= 20 || this.temperature <= 10) {
            super.variationBudget();
            setTauxPropagation(getTauxPropagation() * 2);
        }
    }
}