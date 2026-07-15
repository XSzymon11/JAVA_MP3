public class Main {
    public static void main(String[] args) {

        // overlapping
        Person both = new Person("K789", 6000.0); // klient i pracownik (overlapping)
        Person onlyClient = new Person("K123"); // tylko klient
        Person onlyWorker = new Person(4500.0); //tylko pracownik

        System.out.println(both);
        System.out.println(onlyClient);
        System.out.println(onlyWorker);

        System.out.println("ID klienta (osoba z dwiema rolami): " +
                both.getClient().getClientId());
        System.out.println("Pensja pracownika (osoba z dwiema rolami): " +
                both.getEmployee().getSalary());
        try {
            onlyWorker.getClient();
        } catch (IllegalStateException exception) {
            System.out.println("Próba użycia roli klienta u pracownika: " + exception.getMessage());
        }
        System.out.println();

        // abstreact + polimorfizm
        Vehicle[] garage = {
                new Car("WPN12345", "Izera", 120000, 2015, 5, true),
                new DeliveryTruck("WND98765", "BMW", 80000, 2018, 1500.0),
                new Car("WPR54321", "Opel", 90000, 2017, 4, false)
        };

        for (Vehicle vehicle : garage) {
            System.out.println(vehicle.getServiceSummary());
        }
        System.out.println();

        // wielodziedziczenie
        Hovercraft h = new Hovercraft("HC-99", 0.15, 1.2, 0);

        System.out.println(h);
        showLandVehicleUsage(h);
        showWaterVehicleUsage(h);
        System.out.println();

        // dynamic
        Soldier john = new Soldier("John", new Infantryman(90, 5));
        Soldier jane = new Soldier("Jane", new Medic(65, 9));

        System.out.println(john);
        System.out.println(john.getDutyReport(6));

        System.out.println(jane);
        System.out.println(jane.getDutyReport(6));
        System.out.println();

        john.setRole(new Engineer(80, 9));
        System.out.println(john.getDutyReport(6));
        System.out.println();

        jane.setRole(new Infantryman(75, 4));
        System.out.println(jane.getDutyReport(6));
        System.out.println();

        // wieloaspektowe
        InsurancePolicy individualBasic = new IndividualInsurancePolicy(
                "POL-101",
                new BasicCoverage(100000.0),
                34,
                2
        );
        InsurancePolicy companyPremium = new CompanyInsurancePolicy(
                "POL-202",
                new PremiumCoverage(500000.0, true),
                25,
                3500000.0
        );

        System.out.println(individualBasic.getPolicySummary());
        System.out.println(companyPremium.getPolicySummary());
    }

    private static void showLandVehicleUsage(LandVehicle vehicle) {
        vehicle.drive();
        System.out.println("Zasięg lądowy przy 50 l paliwa: " +
                String.format("%.2f", vehicle.calculateLandRange(50)) + " km");
    }

    private static void showWaterVehicleUsage(WaterVehicle vehicle) {
        vehicle.sail();
        System.out.println("Zasięg wodny przy 50 l paliwa: " +
                String.format("%.2f", vehicle.calculateWaterRange(50)) + " km");
    }
}
