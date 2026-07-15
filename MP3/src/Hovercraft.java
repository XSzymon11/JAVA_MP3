public class Hovercraft extends WaterVehicle implements LandVehicle {
    private double skirtPressure;
    private int wheelCount;

    public Hovercraft(String name) {
        this(name, 0.1, 1.3, 0);
    }

    public Hovercraft(String name, double draft, double skirtPressure, int wheelCount) {
        super(name, draft);
        setSkirtPressure(skirtPressure);
        setWheelCount(wheelCount);
    }

    private void setSkirtPressure(double skirtPressure) {
        if (skirtPressure <= 0) {
            throw new IllegalArgumentException("Skirt pressure must be positive");
        }
        this.skirtPressure = skirtPressure;
    }

    private void setWheelCount(int wheelCount) {
        if (wheelCount < 0) {
            throw new IllegalArgumentException("Wheel count can't be negative");
        }
        this.wheelCount = wheelCount;
    }

    @Override
    public void drive() {
        System.out.println(getName() + " moves over land on an air cushion");
    }

    @Override
    public void sail() {
        System.out.println(getName() + " slides on the water surface");
    }

    @Override
    public int getWheelCount() {
        return wheelCount;
    }

    @Override
    public double calculateLandRange(double fuelLiters) {
        if (fuelLiters <= 0) {
            throw new IllegalArgumentException("Fuel amount must be positive");
        }
        return fuelLiters * 4.5 / skirtPressure;
    }

    @Override
    public double calculateWaterRange(double fuelLiters) {
        if (fuelLiters <= 0) {
            throw new IllegalArgumentException("Fuel amount must be positive");
        }
        return fuelLiters * 5.2 / (getDraft() + skirtPressure);
    }

    @Override
    public String toString() {
        return "Hovercraft{name=" + getName() +
                ", wheels=" + getWheelCount() +
                ", draft=" + getDraft() +
                ", skirtPressure=" + skirtPressure + "}";
    }
}
