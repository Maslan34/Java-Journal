package DesignPatterns.Behavioural.ChainOfResponsibility;

public abstract class CargoCompany {
    private CITIES city;
    private CargoCompany nextStation;


    public CargoCompany(CITIES city) {
        this.city = city;
    }

    public CargoCompany getNextStation() {
        return nextStation;
    }

    public CargoCompany setNextStation(CargoCompany nextStation) {
        this.nextStation = nextStation;
        return this;
    }

    public CITIES getCity() {
        return city;
    }

    public abstract void  ship(CITIES city);
}
