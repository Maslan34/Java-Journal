package CapstoneProjects.IMS;

public class BusinessAddress implements Address {

    private String street;
    private String city;
    private String postalCode;
    private String country;
    private String companyName;
    private String officePhoneNumber;


    public BusinessAddress(String street, String city, String postalCode, String country, String companyName, String officePhoneNumber) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.companyName = companyName;
        this.officePhoneNumber = officePhoneNumber;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOfficePhoneNumber() {
        return officePhoneNumber;
    }

    public void setOfficePhoneNumber(String officePhoneNumber) {
        this.officePhoneNumber = officePhoneNumber;
    }
}
