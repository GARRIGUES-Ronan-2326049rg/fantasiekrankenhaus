package modele.service;

/**
 * Classe représentant un centre de quarantaine, qui est un type spécifique de service médical.
 */
public class CentreQuarantaine extends ServiceMedical {
    private int isolation; // Simule un pourcentage.

    /**
     * Constructeur pour la classe CentreQuarantaine.
     *
     * @param nom Le nom du centre de quarantaine.
     * @param superficie La superficie du centre de quarantaine.
     * @param budget Le budget du centre de quarantaine.
     * @param max Le nombre maximum de patients que le centre peut accueillir.
     */
    public CentreQuarantaine(String nom, int superficie, String budget, int max) {
        super(nom, superficie, budget, max);
        isolation = 100;
    }

    /**
     * Obtient le pourcentage d'isolation du centre de quarantaine.
     *
     * @return Le pourcentage d'isolation.
     */
    public int getIsolation() {
        return this.isolation;
    }

    /**
     * Définit le pourcentage d'isolation du centre de quarantaine.
     *
     * @param isolation Le pourcentage d'isolation à définir.
     */
    public void setIsolation(int isolation) {
        if(isolation <= 100) this.isolation = isolation;
    }

    /**
     * Répare l'isolation du centre de quarantaine.
     * Si l'isolation est inférieure ou égale à 75% et que le budget n'est pas "Inexistant",
     * l'isolation est augmentée de 25% et le budget est ajusté en conséquence.
     */
    public void reparerIsolation(){
        if(this.isolation <= 75 && !super.getBudget().equals("Inexistant")){
            this.isolation += 25;
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
     * Obtient le budget du centre de quarantaine, incluant le pourcentage d'isolation.
     *
     * @return Une chaîne de caractères représentant le budget et l'isolation.
     */
    @Override
    public String getBudget() {
        return "Budget = " + super.getBudget() + ", Isolation = " + this.isolation + "%";
    }

}