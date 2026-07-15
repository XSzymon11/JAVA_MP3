public abstract class InsurancePolicy {
    private String policyNumber;
    private CoverageVariant coverageVariant;

    public InsurancePolicy(String policyNumber, CoverageVariant coverageVariant) {
        setPolicyNumber(policyNumber);
        setCoverageVariant(coverageVariant);
    }

    private void setPolicyNumber(String policyNumber) {
        if (policyNumber == null || policyNumber.isBlank()) {
            throw new IllegalArgumentException("Policy number can't be empty");
        }
        this.policyNumber = policyNumber;
    }

    private void setCoverageVariant(CoverageVariant coverageVariant) {
        if (coverageVariant == null) {
            throw new IllegalArgumentException("Coverage variant can't be null");
        }
        this.coverageVariant = coverageVariant;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public CoverageVariant getCoverageVariant() {
        return coverageVariant;
    }

    protected abstract double calculateBasePremium();

    public final double calculateAnnualPremium() {
        return calculateBasePremium() * getCoverageVariant().calculateCoverageMultiplier();
    }

    public String getPolicySummary() {
        return getClass().getSimpleName() + " " + getPolicyNumber() +
                " / " + getCoverageVariant().getCoverageName() +
                " / annual premium=" +
                String.format("%.2f", calculateAnnualPremium()) + " PLN";
    }
}
