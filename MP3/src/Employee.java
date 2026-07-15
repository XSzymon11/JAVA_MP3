public class Employee {
    private Person person;
    private double salary;

    public Employee(Person person, double salary) {
        setPerson(person);
        setSalary(salary);
    }

    private void setPerson(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person can't be null");
        }
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        validateSalary(salary);
        this.salary = salary;
    }

    private void validateSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive");
        }
    }
}
