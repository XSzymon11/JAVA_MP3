public class Car extends Vehicle {
    private int seatCount;
    private boolean airConditioning;

    public Car(String registrationNumber, String brand, int mileage, int createdYear, int seatCount, boolean airConditioning) {
        super(registrationNumber, brand, mileage, createdYear);
        setSeatCount(seatCount);
        setAirConditioning(airConditioning);
    }

    private void setSeatCount(int seatCount) {
        if (seatCount <= 0) {
            throw new IllegalArgumentException("Seat count must be positive");
        }
        this.seatCount = seatCount;
    }

    private void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    @Override
    public double calculateMonthlyMaintenanceCost() {
        double baseCost = 250.0;
        double mileageCost = getMileage() * 0.002;
        double ageCost = getVehicleAge() * 35.0;
        double seatCost = seatCount * 12.0;
        double airConditioningCost = airConditioning ? 80.0 : 0.0;

        return baseCost + mileageCost + ageCost + seatCost + airConditioningCost;
    }
}
