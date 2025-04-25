package CapstoneProjects.IMS;

public interface Address {

    String getStreet();
    String getCity();
    String getPostalCode();
    String getCountry();

    void setStreet(String street);
    void setCity(String city);
    void setPostalCode(String postalCode);
    void setCountry(String country);
}
