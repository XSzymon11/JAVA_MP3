import java.time.Year;

public abstract class Vehicle {
    private String registrationNumber;
    private String brand;
    private int mileage;
    private int createdYear;

    public Vehicle(String registrationNumber, String brand, int mileage, int createdYear) {
        setRegistrationNumber(registrationNumber);
        setBrand(brand);
        setMileage(mileage);
        setCreatedYear(createdYear);
    }

    private void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isBlank()) {
            throw new IllegalArgumentException("Registration number can't be empty");
        }
        this.registrationNumber = registrationNumber;
    }

    private void setBrand(String brand) {
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("Brand can't be empty");
        }
        this.brand = brand;
    }

    private void setMileage(int mileage) {
        if (mileage < 0) {
            throw new IllegalArgumentException("Mileage can't be negative");
        }
        this.mileage = mileage;
    }

    private void setCreatedYear(int createdYear) {
        if (createdYear < 1950 || createdYear > Year.now().getValue()) {
            throw new IllegalArgumentException("Created year is outside the valid range");
        }
        this.createdYear = createdYear;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public int getMileage() {
        return mileage;
    }

    public int getCreatedYear() {
        return createdYear;
    }

    protected int getVehicleAge() {
        return Year.now().getValue() - createdYear;
    }

    public abstract double calculateMonthlyMaintenanceCost();

    public String getServiceSummary() {
        return getClass().getSimpleName() + " " + getRegistrationNumber() +
                " monthly maintenance cost: " +
                String.format("%.2f", calculateMonthlyMaintenanceCost()) + " PLN";
    }
}
