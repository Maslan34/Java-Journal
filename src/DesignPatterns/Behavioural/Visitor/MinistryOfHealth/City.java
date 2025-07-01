package DesignPatterns.Behavioural.Visitor.MinistryOfHealth;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;
    private List<Hospital> hospitals;

    public City(String name) {
        this.name = name;
        this.hospitals = new ArrayList<Hospital>();
    }

    public String accept(Visitor visitor) {
        return visitor.visitCity(this);
    }

    public void addHospital(Hospital hospital) {
        hospitals.add(hospital);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
}
