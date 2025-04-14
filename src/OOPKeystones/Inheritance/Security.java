package OOPKeystones.Inheritance;

public class Security extends  Staff{
    private String document;

    public Security(String name, String phoneNumber, String mail,String area,String shif,String document) {
        super(name, phoneNumber, mail, area, shif);
        this.document = document;
    }

    @Override
    public void shiftStart(){

        System.out.println("Guard " + this.getName() + " is ready to quard.");
    }
    public void guard(){
        System.out.println("Security "+this.getName()+" is guarding!");
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
