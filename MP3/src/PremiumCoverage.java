public class PremiumCoverage implements CoverageVariant {
    private double claimLimit;
    private boolean internationalProtection;

    public PremiumCoverage(double claimLimit, boolean internationalProtection) {
        setClaimLimit(claimLimit);
        setInternationalProtection(internationalProtection);
    }

    private void setClaimLimit(double claimLimit) {
        if (claimLimit <= 0) {
            throw new IllegalArgumentException("Claim limit must be positive");
        }
        this.claimLimit = claimLimit;
    }

    private void setInternationalProtection(boolean internationalProtection) {
        this.internationalProtection = internationalProtection;
    }

    @Override
    public String getCoverageName() {
        return "Premium coverage";
    }

    @Override
    public double calculateCoverageMultiplier() {
        double internationalMultiplier = internationalProtection ? 0.35 : 0.0;
        return 1.45 + claimLimit / 800000.0 + internationalMultiplier;
    }

    @Override
    public double getClaimLimit() {
        return claimLimit;
    }
}
