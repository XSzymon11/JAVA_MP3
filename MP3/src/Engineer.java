public class Engineer implements Role {
    private int toolQuality;
    private int fortificationExperience;

    public Engineer() {
        this(75, 7);
    }

    public Engineer(int toolQuality, int fortificationExperience) {
        setToolQuality(toolQuality);
        setFortificationExperience(fortificationExperience);
    }

    private void setToolQuality(int toolQuality) {
        if (toolQuality < 0 || toolQuality > 100) {
            throw new IllegalArgumentException("Tool quality must be between 0 and 100");
        }
        this.toolQuality = toolQuality;
    }

    private void setFortificationExperience(int fortificationExperience) {
        if (fortificationExperience < 0) {
            throw new IllegalArgumentException("Fortification experience can't be negative");
        }
        this.fortificationExperience = fortificationExperience;
    }

    @Override
    public String getTitle() {
        return "Engineer";
    }

    @Override
    public int getReadinessScore() {
        return Math.min(100, toolQuality + fortificationExperience * 3);
    }

    @Override
    public int calculateMissionEffectiveness(int availableHours) {
        if (availableHours <= 0) {
            throw new IllegalArgumentException("Available hours must be positive");
        }
        return getReadinessScore() + availableHours * 5;
    }
}
