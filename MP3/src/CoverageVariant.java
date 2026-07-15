public interface CoverageVariant {
    String getCoverageName();

    double calculateCoverageMultiplier();

    double getClaimLimit();
}
