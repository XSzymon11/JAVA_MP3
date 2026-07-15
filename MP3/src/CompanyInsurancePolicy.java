public class CompanyInsurancePolicy extends InsurancePolicy {
    private int employeeCount;
    private double annualRevenue;

    public CompanyInsurancePolicy(String policyNumber, CoverageVariant coverageVariant, int employeeCount, double annualRevenue) {
        super(policyNumber, coverageVariant);
        setEmployeeCount(employeeCount);
        setAnnualRevenue(annualRevenue);
    }

    private void setEmployeeCount(int employeeCount) {
        if (employeeCount <= 0) {
            throw new IllegalArgumentException("Employee count must be positive");
        }
        this.employeeCount = employeeCount;
    }

    private void setAnnualRevenue(double annualRevenue) {
        if (annualRevenue <= 0) {
            throw new IllegalArgumentException("Annual revenue must be positive");
        }
        this.annualRevenue = annualRevenue;
    }

    @Override
    protected double calculateBasePremium() {
        return 1200.0 + employeeCount * 45.0 + annualRevenue * 0.0015;
    }
}
