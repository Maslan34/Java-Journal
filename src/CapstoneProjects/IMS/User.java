package CapstoneProjects.IMS;

import java.util.ArrayList;
import java.util.Date;

public class User {


    String firstName;
    String lastName;
    String email;
    String password;
    String ocupation;
    int age;
    ArrayList<Address> adressList=new ArrayList<>();
    Date lastLogin;

    public User(String firstName, String lastName, String email, String password, String ocupation, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.ocupation = ocupation;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOcupation() {
        return ocupation;
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public ArrayList<Address> getAdressList() {
        return adressList;
    }
}
