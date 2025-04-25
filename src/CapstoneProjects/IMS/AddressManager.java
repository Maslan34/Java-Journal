package CapstoneProjects.IMS;

public class AddressManager {
    public static void addAddress(User user, Address address) {
        user.adressList.add(address);
        System.out.println("Adress added user "+user.firstName+"'s  address list");
    }
    public static void removeAddress(User user, Address address) {
        user.adressList.remove(address);
        System.out.println("Adress removed user "+user.firstName+"'s  address list");
    }

}
