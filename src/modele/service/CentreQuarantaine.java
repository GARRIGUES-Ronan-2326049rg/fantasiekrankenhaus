package modele.service;

public class CentreQuarantaine extends ServiceMedical {
    private int isolation;

    public CentreQuarantaine(String nom, int superficie, String budget) {
        super(nom, superficie, budget);
    }

    public int getIsolation() {
        return this.isolation;
    }

    public void setIsolation(int isolation) {
        this.isolation = isolation;
    }

    public String getBudget() {
        String var10000 = super.getBudget();
        return "Budget = " + var10000 + ", Isolation = " + this.isolation;
    }
}
