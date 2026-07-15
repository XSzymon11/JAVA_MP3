public abstract class WaterVehicle {
    private String name;
    private double draft;

    public WaterVehicle(String name, double draft) {
        setName(name);
        setDraft(draft);
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be left empty");
        }
        this.name = name;
    }

    private void setDraft(double draft) {
        if (draft <= 0) {
            throw new IllegalArgumentException("Draft must be positive");
        }
        this.draft = draft;
    }

    public String getName() {
        return name;
    }

    public double getDraft() {
        return draft;
    }

    public abstract void sail();

    public abstract double calculateWaterRange(double fuelLiters);
}
