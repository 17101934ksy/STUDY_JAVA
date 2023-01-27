package lambda;


public class Address {

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    private String country;
    private String city;

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
