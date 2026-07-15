public class Medic implements Role {
    private int medicalSupplies;
    private int triageSkill;

    public Medic() {
        this(70, 8);
    }

    public Medic(int medicalSupplies, int triageSkill) {
        setMedicalSupplies(medicalSupplies);
        setTriageSkill(triageSkill);
    }

    private void setMedicalSupplies(int medicalSupplies) {
        if (medicalSupplies < 0 || medicalSupplies > 100) {
            throw new IllegalArgumentException("Medical supplies must be between 0 and 100");
        }
        this.medicalSupplies = medicalSupplies;
    }

    private void setTriageSkill(int triageSkill) {
        if (triageSkill < 0) {
            throw new IllegalArgumentException("Triage skill can't be negative");
        }
        this.triageSkill = triageSkill;
    }

    @Override
    public String getTitle() {
        return "Medic";
    }

    @Override
    public int getReadinessScore() {
        return Math.min(100, medicalSupplies + triageSkill * 4);
    }

    @Override
    public int calculateMissionEffectiveness(int availableHours) {
        if (availableHours <= 0) {
            throw new IllegalArgumentException("Available hours must be positive");
        }
        return getReadinessScore() + availableHours * 6;
    }
}
