package CapstoneProjects.BankSystem;

import java.util.Date;

public class User {

    private String nationalId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth ;
    private String password;
    private Double balance;
    private Double creditLoan;
    private Double creditCartRecipt;

    public User() {

    }
    public User(String nationalId, String firstName, String lastName, Date dateOfBirth, String password) {
        this.nationalId = nationalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.balance = 0.0;
        this.creditLoan = 0.0;
        this.creditCartRecipt = 0.0;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getCreditLoan() {
        return creditLoan;
    }

    public void setCreditLoan(Double creditLoan) {
        this.creditLoan = creditLoan;
    }

    public Double getCreditCartRecipt() {
        return creditCartRecipt;
    }

    public void setCreditCartRecipt(Double creditCartRecipt) {
        this.creditCartRecipt = creditCartRecipt;
    }

    @Override
    public String toString() {
        return "{" +
                "nationalId='" + nationalId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", creditLoan=" + creditLoan +
                ", creditCartRecipt=" + creditCartRecipt +
                '}';
    }
}
