package DesignPatterns.Behavioural.ChainOfResponsibility;

public class IstanbulFranchise extends CargoCompany {


    public IstanbulFranchise() {
        super(CITIES.ISTANBUL);
    }

    @Override
    public void ship(CITIES transferredCity) {
        System.out.println("The cargo destined for " + transferredCity.getName() + " " +
                "has reached the " + this.getCity().getName() + " branch.");

        if (this.getCity().equals(transferredCity)) {
            System.out.println("The cargo has been received by the "+this.getCity().getName()+" branch.");
        } else if (this.getNextStation() != null) {

            this.getNextStation().ship(transferredCity);
        } else {
            System.out.println(transferredCity.getName()+" is currently out of service.");
        }
    }
}
