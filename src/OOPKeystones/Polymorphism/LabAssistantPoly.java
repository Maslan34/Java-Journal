package OOPKeystones.Polymorphism;

public class LabAssistantPoly extends AssistantPoly {

    public LabAssistantPoly(String name, String phoneNumber, String mail, String department, String title, String officeHours) {
        super(name, phoneNumber, mail, department, title, officeHours);
    }

    public void giveLabLesson(){
        System.out.println("Lab Assistant "+this.getName()+" is giving lab lesson!");
    }
}
