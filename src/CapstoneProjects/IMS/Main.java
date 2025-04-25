package CapstoneProjects.IMS;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

        // Check User 1 and User 4 to see diffrence between  IndividualPolicy and EnterprisePolicy //


        // Users init
        User user1 = new User("Muharrem","Aslan","m@gmail.com","12345","Devoloper",25);
        User user2 = new User("Ömer Faruk","Aslan","o@gmail.com","12345","No Occupation",12);
        User user3 = new User("Güven","Özcan","g@gmail.com","12345","Statistic",24);
        User user4 = new User("Oğulcan","Güngör","og@gmail.com","12345","Teacher",25);
        User user5 = new User("Osman Sefa","Tercan","s@gmail.com","12345","Student",23);
        // ### Users init

        LoginInput loginInput = new LoginInput();
        AccountManager accountManager = new AccountManager();

        // IndividualPolicy and EnterprisePolicy init
        IndividualPolicy individualPolicy1 = new IndividualPolicy(user1);
        IndividualPolicy individualPolicy2 = new IndividualPolicy(user2);
        IndividualPolicy individualPolicy3 = new IndividualPolicy(user3);
        EnterprisePolicy enterprisePolicy1 = new EnterprisePolicy(user4);
        //### IndividualPolicy and EnterprisePolicy init


        // Account init
            accountManager.addAccount(individualPolicy1);
            accountManager.addAccount(enterprisePolicy1);
            //accountManager.addAccount(enterprisePolicy);
        // ### Account init


        // Address init

        HomeAddress homeAddress= new HomeAddress("Atatürk Cd","Ankara","11111","Türkiye");
        HomeAddress homeAddress1= new HomeAddress("Fatih Sultan Mehmet Cd","İstanbul","22222","Türkiye");

        BusinessAddress businessAddress = new BusinessAddress("Şirket Cd ","İstanbul","33333","Türkiye","Turkcell","0123456789");
        BusinessAddress businessAddress1 = new BusinessAddress("Para Cd","Ankara","444444","Türkiye",",Patika","9876543210");

        //### Address init

        individualPolicy1.addAddress(individualPolicy1.user,homeAddress);
        individualPolicy1.addAddress(individualPolicy1.user,businessAddress);

        enterprisePolicy1.addAddress(enterprisePolicy1.user,businessAddress1);





        //Insurance init
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        CarInsurance carInsurance=null;
        HealthInsurance healthInsurance=null;
        //ResidenceInsurance residenceInsurance = new ResidenceInsurance();
        //TravelInsurance travelInsurance = new TravelInsurance();
        //travelInsurance.informInsurance();

        //### Insurance init

        // Added try-catch due to formatter.parse function here.
        try {
            carInsurance = new CarInsurance("Full-Car-Insurance",25000.0,
                    formatter.parse("11/04/2024"),formatter.parse("11/04/2025"),3.0);
            healthInsurance =new HealthInsurance("Full-Health-Insurance",
                    40000.0,
                    formatter.parse("01/06/2023"),
                    formatter.parse("01/06/2025"),4.0);
        }catch (Exception e){

        }


        try {
            Account account = accountManager.login(loginInput.email, loginInput.password);
            account.addInsurance(carInsurance);
            account.addInsurance(healthInsurance);
            System.out.println("Welcome");
            account.showUserInfo();
            //account.getUserInsurancesInfo();

        }catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
}
