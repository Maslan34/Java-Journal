package DesignPatterns.Creational.AbstractFactoryMethod;

public class TelephoneFactoryIMPL {

    public Telephone createTelephone(String type){

        if(type.equalsIgnoreCase("S")){
            return new S("S",60,80);
        }
        else if(type.equalsIgnoreCase("Note")){
            return new Note("Note",120,140);
        }
        else
            return null;
    }

}
