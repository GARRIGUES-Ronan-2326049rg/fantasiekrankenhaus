package modele.service;

public class CentreQuarantaine extends ServiceMedical{
    private int isolation;

    public int getIsolation() {
        return this.isolation;
    }
    public void setIsolation(int isolation) {
        this.isolation = isolation;
    }

    @Override
    public String getBudget() {
        return "Budget = " +super.getBudget() + ", Isolation = " + this.isolation;
    }
}
