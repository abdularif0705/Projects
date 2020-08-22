public class Address {
    //Initialize private variables
    private String city;
    private String state;
    private String country;
    private String zip;

    public Address(String city, String state, String country, String zip) {//Constructor
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override public String toString() {
        return "Address [city=" + this.city + ", state=" + this.state + ", country=" + this.country + ", zip=" + this.zip + "]";
    }
}