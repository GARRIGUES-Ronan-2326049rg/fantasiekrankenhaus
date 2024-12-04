package modele.service;

public class Crypte extends ServiceMedical {
    private int ventilation; // Simule un pourcentage.
    private int temperature; // En °C.

    /**
     * Constructeur pour la classe Crypte.
     *
     * @param nom Le nom de la crypte.
     * @param superficie La superficie de la crypte.
     * @param budget Le budget de la crypte.
     * @param max Le nombre maximum de patients que la crypte peut accueillir.
     */
    public Crypte(String nom, int superficie, String budget, int max) {
        super(nom, superficie, budget, max);
        this.ventilation = 100;
        this.temperature = 15;
    }

    /**
     * Obtient la température de la crypte.
     *
     * @return La température de la crypte.
     */
    public int getTemperature() {
        return this.temperature;
    }

    /**
     * Obtient la ventilation de la crypte.
     *
     * @return La ventilation de la crypte.
     */
    public int getVentilation() {
        return this.ventilation;
    }

    /**
     * Définit la température de la crypte.
     *
     * @param temperature La température à définir.
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    /**
     * Définit la ventilation de la crypte.
     *
     * @param ventilation La ventilation à définir.
     */
    public void setVentilation(int ventilation) {
        if(ventilation <= 100) this.ventilation = ventilation;
    }

    /**
     * Répare la ventilation de la crypte si cette dernière est au plus à 75%.
     * Le budget baisse à chaque achat.
     *
     * @version 1.0
     */
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

    /**
     * Obtient le budget de la crypte, incluant le pourcentage de ventilation et la température.
     *
     * @return Une chaîne de caractères représentant le budget, la ventilation et la température.
     */
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
     */
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