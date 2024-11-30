package modele.service;

public class CentreQuarantaine extends ServiceMedical {
    private int isolation; //Simule un pourcentage.

    public CentreQuarantaine(String nom, int superficie, String budget, int max) {
        super(nom, superficie, budget, max);
        isolation = 100;
    }

    public int getIsolation() {
        return this.isolation;
    }

    public void setIsolation(int isolation) {
        if(isolation <= 100) this.isolation = isolation;
    }

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

    @Override
    public String getBudget() {
        return "Budget = " + super.getBudget() + ", Isolation = " + this.isolation + "%";
    }

}