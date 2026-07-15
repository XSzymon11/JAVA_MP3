public class Infantryman implements Role {
    private int ammunitionLevel;
    private int fieldExperience;

    public Infantryman() {
        this(80, 6);
    }

    public Infantryman(int ammunitionLevel, int fieldExperience) {
        setAmmunitionLevel(ammunitionLevel);
        setFieldExperience(fieldExperience);
    }

    private void setAmmunitionLevel(int ammunitionLevel) {
        if (ammunitionLevel < 0 || ammunitionLevel > 100) {
            throw new IllegalArgumentException("Ammunition level must be between 0 and 100");
        }
        this.ammunitionLevel = ammunitionLevel;
    }

    private void setFieldExperience(int fieldExperience) {
        if (fieldExperience < 0) {
            throw new IllegalArgumentException("Field experience can't be negative");
        }
        this.fieldExperience = fieldExperience;
    }

    @Override
    public String getTitle() {
        return "Infantryman";
    }

    @Override
    public int getReadinessScore() {
        return Math.min(100, ammunitionLevel + fieldExperience * 3);
    }

    @Override
    public int calculateMissionEffectiveness(int availableHours) {
        if (availableHours <= 0) {
            throw new IllegalArgumentException("Available hours must be positive");
        }
        return getReadinessScore() + availableHours * 4;
    }
}
