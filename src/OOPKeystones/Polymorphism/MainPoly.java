package OOPKeystones.Polymorphism;

public class MainPoly {
    public static void main(String[] args) {
        // Overrides
        EmployeePoly emp1 = new EmployeePoly("Muharrem Aslan","01234","muharrem@gmail.com");
        //emp1.shiftStart();
        InstructorPoly ins1 = new InstructorPoly("Ömer Faruk Aslan","0123","ömer@gmail.com","Computer","Dr","Data Science");
        //ins1.shiftStart();
        SecurityPoly sec1 = new SecurityPoly("Yusuf Aslan","01","yusuf@gmail.com","university campus","09-00/18-00","security");
        //ec1.shiftStart();


        /*
        EmployeePoly empIns = new InstructorPoly("Ömer Faruk Aslan","0123","ömer@gmail.com","Computer","Dr","Data Science");
        empIns.shiftStart();
        */



        // Here using polymorphism, all shiftStarts are triggered using a single ancestor variable.


        EmployeePoly[] empList = {emp1,ins1,sec1};

        for(EmployeePoly emp : empList) {
            emp.shiftStart();
        }
    }
}
