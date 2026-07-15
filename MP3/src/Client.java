public class Client {
    private Person person;
    private String clientId;

    public Client(Person person, String clientId) {
        setPerson(person);
        setClientId(clientId);
    }

    private void setPerson(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person can't null");
        }
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    private void setClientId(String clientId) {
        if (clientId == null || clientId.isBlank()) {
            throw new IllegalArgumentException("Client id can't be empty");
        }
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }
}

