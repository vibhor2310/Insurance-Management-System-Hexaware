package entity;

public class Policy {
    private int policyId;
    private String policyName;
    private String policyType;
    private double coverageAmount;

    // Constructor
    public Policy(){

    }
    public Policy(int policyId,String policyName,String policyType,double coverageAmount){
        this.policyId = policyId;
        this.policyName = policyName;
        this.policyType = policyType;
        this.coverageAmount = coverageAmount;

    }
    // getter and setter

    public int getPolicyId() {
        return policyId;
    }
    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }
    public String getPolicyName() {
        return policyName;
    }
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }
    public String getPolicyType() {
        return policyType;
    }
    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }
    public double getCoverageAmount() {
        return coverageAmount;
    }
    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }
    @Override
    public String toString() {
        return "Policy [policyId = " + policyId + ", policyName = " + policyName + ", policyType = " + policyType
                + ", coverageAmount = " + coverageAmount + "]";
    }
}
