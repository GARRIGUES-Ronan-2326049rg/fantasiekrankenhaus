package modele.service;

public class CentreQuarantaine extends ServiceMedical {
    private int isolation;

    public CentreQuarantaine(String nom, int superficie, String budget, int max) {
        super(nom, superficie, budget, max);
    }

    public int getIsolation() {
        return this.isolation;
    }

    public void setIsolation(int isolation) {
        this.isolation = isolation;
    }

    @Override
    public String getBudget() {
        return super.getBudget() + ", Isolation = " + this.isolation;
    }

}