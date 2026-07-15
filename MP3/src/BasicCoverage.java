public class BasicCoverage implements CoverageVariant {
    private double claimLimit;

    public BasicCoverage(double claimLimit) {
        setClaimLimit(claimLimit);
    }

    private void setClaimLimit(double claimLimit) {
        if (claimLimit <= 0) {
            throw new IllegalArgumentException("Claim limit must be positive");
        }
        this.claimLimit = claimLimit;
    }

    @Override
    public String getCoverageName() {
        return "Basic coverage";
    }

    @Override
    public double calculateCoverageMultiplier() {
        return 1.0 + claimLimit / 1000000.0;
    }

    @Override
    public double getClaimLimit() {
        return claimLimit;
    }
}
