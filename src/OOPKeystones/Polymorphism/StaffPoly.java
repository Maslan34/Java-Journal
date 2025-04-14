package OOPKeystones.Polymorphism;

public class StaffPoly extends EmployeePoly {
    private String area;
    private String shift;

    public StaffPoly(String name, String phoneNumber, String mail, String area, String shift) {
        super(name, phoneNumber, mail);
        this.area = area;
        this.shift = shift;
    }

    public void work(){
        System.out.println("Staff "+this.getName()+" works!");
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
