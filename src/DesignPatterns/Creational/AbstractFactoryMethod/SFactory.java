package DesignPatterns.Creational.AbstractFactoryMethod;

public class SFactory implements TelephoneFactory {


    @Override
    public Telephone createTelephone(String type) {
        if (type.equalsIgnoreCase("S8"))
            return new S("S8",60,80);
        else if (type.equalsIgnoreCase("S10"))
            return new S("S10",80,100);
        else
            return null;
    }
}
