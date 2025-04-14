package OOPKeystones.Abstraction;

public abstract class EmployeeAbs {
    private String name;
    private String phoneNumber;
    private String mail;


    public EmployeeAbs(String name, String phoneNumber, String mail) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void shiftStart(){
        System.out.println("Employee " + this.name + " shift started.");
    }
    public void shiftEnd(){
        System.out.println("Employee " + this.name + " shift finished.");
    }
    public abstract void breakTime();
}
