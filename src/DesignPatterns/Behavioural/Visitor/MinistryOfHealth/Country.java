package DesignPatterns.Behavioural.Visitor.MinistryOfHealth;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private String name;
    private List<City> cities;

    public Country(String name) {
        this.name = name;
        this.cities = new ArrayList<>();
    }


    public String accept(Visitor visitor) {
        return visitor.visitCountry(this);
    }

    public void addCity(City city) {
        this.cities.add(city);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
