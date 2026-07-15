public class Person {
    private Client client;
    private Employee employee;

    public Person(String clientId, double salary) {
        setClient(new Client(this, clientId));
        setEmployee(new Employee(this, salary));
    }

    public Person(String clientId) {
        setClient(new Client(this, clientId));
    }

    public Person(double salary) {
        setEmployee(new Employee(this, salary));
    }

    private void setClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client role can't be null");
        }
        this.client = client;
    }

    private void setEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee role can't be null");
        }
        this.employee = employee;
    }

    public Client getClient() {
        if (client == null) {
            throw new IllegalStateException("This person does not have the Client role");
        }
        return client;
    }

    public Employee getEmployee() {
        if (employee == null) {
            throw new IllegalStateException("This person does not have the Employee role");
        }
        return employee;
    }

    public boolean hasClientRole() {
        return client != null;
    }

    public boolean hasEmployeeRole() {
        return employee != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Person:");
        if (client != null) {
            sb.append("[Client: ID=").append(client.getClientId()).append("]");
        }
        if (employee != null) {
            sb.append("[Employee: pensja=").append(employee.getSalary()).append("]");
        }
        return sb.toString();
    }
}


