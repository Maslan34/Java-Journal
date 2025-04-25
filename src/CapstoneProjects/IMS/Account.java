package CapstoneProjects.IMS;


import java.util.ArrayList;

public abstract class Account implements Comparable<Account> {
    static Long accountCounter = 0L;

    private String accountNumber;
    private ArrayList<Insurance> insurances = new ArrayList<>();
    private AuthenticationStatus authenticationStatus=AuthenticationStatus.FAIL;
    User user;

    public abstract void addInsurance(Insurance insurance);


    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }


    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public static String getAccountNumberForRegister(){
        accountCounter++;
        return accountCounter.toString();
    }
    public String getAccountNumber() {
      return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public  void addAddress(User user, Address address) {
        user.adressList.add(address);
        System.out.println("Adress added user "+user.firstName+"'s  address list");
    }
    public  void removeAddress(User user, Address address) {
        user.adressList.remove(address);
        System.out.println("Adress removed user "+user.firstName+"'s  address list");
    }


    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if ( obj == null ||!(obj instanceof Account) )
            return false;

        Account acc = (Account) obj;
        return this.accountNumber == acc.accountNumber;

    }

    final void showUserInfo() {
        System.out.println("+---------------------+-------------------------------+");
        System.out.println("| Field               | Value                         |");
        System.out.println("+---------------------+-------------------------------+");
        System.out.printf("| Customer Name       | %-30s |\n", user.getFirstName() + " " + user.getLastName());
        System.out.printf("| Account Number      | %-30s |\n", accountNumber);
        System.out.printf("| Authentication      | %-30s |\n", authenticationStatus);
        System.out.printf("| Insurance Count     | %-30d |\n", insurances.size());
        System.out.printf("| Email               | %-30s |\n", user.getEmail());
        System.out.printf("| Occupation          | %-30s |\n", user.getOcupation());
        System.out.printf("| Age                 | %-30d |\n", user.getAge());
        System.out.printf("| Last Login          | %-30s |\n", user.getLastLogin());
        System.out.println("+---------------------+--------------------------+");

        System.out.println("\n+---------------+----------------+------------------+-------------+---------------+----------------------+");
        System.out.println("| Address Type  | Street         | City             | Postal Code | Country       | Extra Info           |");
        System.out.println("+---------------+----------------+------------------+-------------+---------------+----------------------+");

        for (Address address : user.getAdressList()) {
            String type = address instanceof BusinessAddress ? "Business" : "Home";
            String street = address.getStreet();
            String city = address.getCity();
            String postalCode = address.getPostalCode();
            String country = address.getCountry();
            String extra = "";

            if (address instanceof BusinessAddress) {
                BusinessAddress ba = (BusinessAddress) address;
                extra = "Company: " + ba.getCompanyName() + ", Phone: " + ba.getOfficePhoneNumber();
            }

            System.out.printf("| %-13s | %-14s | %-16s | %-11s | %-13s | %-20s |\n",
                    type, street, city, postalCode, country, extra);
        }

        System.out.println("+---------------+----------------+------------------+-------------+---------------+----------------------+");

    }

    final void getUserInsurancesInfo() {
        for(Insurance insurance : insurances){
            insurance.informInsurance();
        }
    }
}
