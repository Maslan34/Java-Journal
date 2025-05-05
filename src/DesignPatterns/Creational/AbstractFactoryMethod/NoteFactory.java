package DesignPatterns.Creational.AbstractFactoryMethod;

public class NoteFactory implements TelephoneFactory{
    @Override
    public Telephone createTelephone(String type) {
        if (type.equalsIgnoreCase("Note10"))
            return new Note("Note10",120,140);
        else if (type.equalsIgnoreCase("Note11"))
            return new Note("Note11",120,150);
        else
            return null;
    }
}
