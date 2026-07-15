public class DeliveryTruck extends Vehicle {
    private double loadCapacity;

    public DeliveryTruck(String registrationNumber, String brand, int mileage, int createdYear, double loadCapacity) {
        super(registrationNumber, brand, mileage, createdYear);
        setLoadCapacity(loadCapacity);
    }

    private void setLoadCapacity(double loadCapacity) {
        if (loadCapacity <= 0) {
            throw new IllegalArgumentException("Load capacity must be positive");
        }
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public double calculateMonthlyMaintenanceCost() {
        double baseCost = 500.0;
        double mileageCost = getMileage() * 0.004;
        double ageCost = getVehicleAge() * 60.0;
        double loadCapacityCost = loadCapacity * 0.08;

        return baseCost + mileageCost + ageCost + loadCapacityCost;
    }
}
