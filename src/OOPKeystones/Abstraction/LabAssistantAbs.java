package OOPKeystones.Abstraction;

public class LabAssistantAbs extends AssistantAbs {

    public LabAssistantAbs(String name, String phoneNumber, String mail, String department, String title, String officeHours) {
        super(name, phoneNumber, mail, department, title, officeHours);
    }

    public void giveLabLesson(){
        System.out.println("Lab Assistant "+this.getName()+" is giving lab lesson!");
    }
}
