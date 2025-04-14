package OOPKeystones.Polymorphism;

public class AssistantPoly extends AcademicianPoly {

    public String officeHours;

    public AssistantPoly(String name, String phoneNumber, String mail, String department, String title, String officeHours) {
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
