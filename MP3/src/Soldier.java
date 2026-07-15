public class Soldier {
    private String name;
    private Role role;

    public Soldier(String name, Role initialRole) {
        setName(name);
        setInitialRole(initialRole);
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.name = name;
    }

    private void setInitialRole(Role initialRole) {
        if (initialRole == null) {
            throw new IllegalArgumentException("Initial role can't be null");
        }
        this.role = initialRole;
    }

    public void setRole(Role newRole) {
        if (newRole == null) {
            throw new IllegalArgumentException("New role can't be null");
        }
        System.out.println(name +
                " reassigned from " + role.getTitle() +
                " to " + newRole.getTitle());
        this.role = newRole;
    }

    public int calculateMissionEffectiveness(int availableHours) {
        return role.calculateMissionEffectiveness(availableHours);
    }

    public String getDutyReport(int availableHours) {
        return name + " as " + role.getTitle() +
                " readiness=" + role.getReadinessScore() +
                ", effectiveness=" + calculateMissionEffectiveness(availableHours);
    }

    @Override
    public String toString() {
        return "Soldier{name='" + name + "', role=" + role.getTitle() +
                ", readiness=" + role.getReadinessScore() + "}";
    }
}
