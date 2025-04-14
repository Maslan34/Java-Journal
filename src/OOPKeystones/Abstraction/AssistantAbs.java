package OOPKeystones.Abstraction;

public class AssistantAbs extends AcademicianAbs {

    public String officeHours;

    public AssistantAbs(String name, String phoneNumber, String mail, String department, String title, String officeHours) {
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
