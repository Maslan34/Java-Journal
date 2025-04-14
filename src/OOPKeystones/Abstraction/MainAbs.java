package OOPKeystones.Abstraction;

public class MainAbs {
    public static void main(String[] args) {
        // Overrides

        // This class is now abstract so it can not be instantiated
        //EmployeeAbs emp1 = new EmployeeAbs("Muharrem Aslan","01234","muharrem@gmail.com");
        //emp1.shiftStart();
        InstructorAbs ins1 = new InstructorAbs("Ömer Faruk Aslan","0123","ömer@gmail.com","Computer","Dr","Data Science");
        ins1.shiftStart();
        SecurityAbs sec1 = new SecurityAbs("Yusuf Aslan","01","yusuf@gmail.com","university campus","09-00/18-00","security");
        sec1.shiftStart();


    }
}
