public interface Role {
    String getTitle();

    int getReadinessScore();

    int calculateMissionEffectiveness(int availableHours);
}
