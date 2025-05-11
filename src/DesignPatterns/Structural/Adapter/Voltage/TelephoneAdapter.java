package DesignPatterns.Structural.Adapter.Voltage;

public class TelephoneAdapter implements HomeAppliance{

    private Telephone telephone;

    public TelephoneAdapter(Telephone telephone) {
        this.telephone = telephone;
    }

    @Override
    public int plugAndPlay() {
        return telephone.charge();
    }
}
