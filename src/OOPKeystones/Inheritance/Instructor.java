package OOPKeystones.Inheritance;

public class Instructor extends Academician{

    private String lesson;

    public Instructor(String name, String phoneNumber, String mail, String department, String title,String lesson) {
        super(name, phoneNumber, mail, department, title);
        this.lesson = lesson;
    }
    public void senateMeeting(){
        System.out.println("Instructor "+this.getName()+" is at meeting!");
    }

    public String getLesson() {
        return lesson;
    }

    @Override
    public void shiftStart(){
        System.out.println("Instructor " + this.getName() + " entered the school.");
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }
}
