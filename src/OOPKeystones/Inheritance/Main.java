package OOPKeystones.Inheritance;

public class Main {
    public static void main(String[] args) {
        // Overrides
        Employee emp1 = new Employee("Muharrem Aslan","01234","muharrem@gmail.com");
        emp1.shiftStart();
        Instructor ins1 = new Instructor("Ömer Faruk Aslan","0123","ömer@gmail.com","Computer","Dr","Data Science");
        ins1.shiftStart();
        Security sec1 = new Security("Yusuf Aslan","01","yusuf@gmail.com","university campus","09-00/18-00","security");
        sec1.shiftStart();


    }
}
