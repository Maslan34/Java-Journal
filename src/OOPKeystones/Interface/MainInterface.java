package OOPKeystones.Interface;

import java.util.Scanner;

public class MainInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String terminalID="12312312";
        final String terminalPassword="1232345312";

        System.out.println("Enter a price: ");
        double price = sc.nextDouble();
        System.out.println("Enter a card number: ");
        String cardNumber = sc.next();
        System.out.println("Enter expiry date: ");
        String expiryDate = sc.next();
        System.out.println("Enter a cvv: ");
        String cvv = sc.next();

        System.out.println("Select a bank");

        System.out.println("1. A Bank");
        System.out.println("2. B Bank");
        System.out.println("3. C Bank");
        System.out.println("4. D Bank");
        System.out.println("5. E Bank");
        sc.nextLine();
        int option = sc.nextInt();
        switch (option) {
            case 1:
                ABank aPos = new ABank("A Bank", terminalID, terminalPassword);
                aPos.connect(IBanka.hostIpAddress,IBanka.portNumber);
                aPos.payment(price, cardNumber, expiryDate, cvv);
                break;
            case 2:
                BBank bPos = new BBank("B Bank", terminalID, terminalPassword);
                bPos.connect(IBanka.hostIpAddress,IBanka.portNumber);
                bPos.payment(price, cardNumber, expiryDate, cvv);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

    }
}
