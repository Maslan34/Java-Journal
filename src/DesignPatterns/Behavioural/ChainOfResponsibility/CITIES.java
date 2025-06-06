package DesignPatterns.Behavioural.ChainOfResponsibility;

public enum CITIES {
    ISTANBUL("ISTANBUL"),
    ANKARA("ANKARA"),
    IZMIR("IZMIR"),
    ANTALYA("ANTALYA"),
    ADIYAMAN("ADIYAMAN"),
    AGRI("AGRI"),
    RIZE("RIZE"),
    EDIRNE("EDIRNE"),
    HAKKARI("HAKKARI"),;


    private String name;

    CITIES(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CITIES{" +
                "name='" + name + '\'' +
                '}';
    }
}
