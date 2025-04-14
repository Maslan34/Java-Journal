package OOPKeystones.Inheritance;

public class Assistant extends Academician{

    public String officeHours;

    public Assistant(String name, String phoneNumber, String mail, String department, String title, String officeHours) {
        super(name, phoneNumber, mail, department, title);
        this.officeHours = officeHours;
    }

    public void makeQuiz(){
        System.out.println("Assistant "+this.getName()+" is making quiz! ");
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
}
