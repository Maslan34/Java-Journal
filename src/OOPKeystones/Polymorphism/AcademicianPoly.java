package OOPKeystones.Polymorphism;

public class AcademicianPoly extends EmployeePoly {
    private String department;
    private String title;

    public AcademicianPoly(String name, String phoneNumber, String mail, String department, String title ) {
        super(name,phoneNumber,mail);
        this.department = department;
        this.title = title;
    }

    public void teachLesson(){
        System.out.println("Academician "+this.getName()+" is teaching lesson!");
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
