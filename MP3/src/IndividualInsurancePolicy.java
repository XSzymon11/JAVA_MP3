public class IndividualInsurancePolicy extends InsurancePolicy {
    private int customerAge;
    private int insuredAssetsCount;

    public IndividualInsurancePolicy(String policyNumber, CoverageVariant coverageVariant,
                                     int customerAge, int insuredAssetsCount) {
        super(policyNumber, coverageVariant);
        setCustomerAge(customerAge);
        setInsuredAssetsCount(insuredAssetsCount);
    }

    private void setCustomerAge(int customerAge) {
        if (customerAge < 18) {
            throw new IllegalArgumentException("Customer must be an adult");
        }
        this.customerAge = customerAge;
    }

    private void setInsuredAssetsCount(int insuredAssetsCount) {
        if (insuredAssetsCount <= 0) {
            throw new IllegalArgumentException("Insured assets count must be positive");
        }
        this.insuredAssetsCount = insuredAssetsCount;
    }

    @Override
    protected double calculateBasePremium() {
        double ageRisk = customerAge > 60 ? 350.0 : 180.0;
        return 600.0 + ageRisk + insuredAssetsCount * 90.0;
    }
}
