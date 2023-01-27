package lambda;

public class Member {

    private String firstName;
    private String name;
    private Address address;

    public Member(String firstName, String name, Address address) {
        this.firstName = firstName;
        this.name = name;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
