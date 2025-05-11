package DesignPatterns.Structural.Adapter.Voltage;

public class Socket {

    public void giveElectricity(HomeAppliance homeAppliance) {
        int volt = homeAppliance.plugAndPlay();
        System.out.println("Electricity voltage is " + volt+" from socket");
    }
}
