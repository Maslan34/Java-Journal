package CapstoneProjects.BankSystem;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        DbManager db = new DbManager();
        Scanner scanner = new Scanner(System.in);
        Input input = new Input();
        System.out.println("Welcome to Bank System");


        int choice = 0;
        while (choice != 3) {
            System.out.println("1-Login\n2-Register\n3-Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    List<User> users = db.read();
                    boolean isLoginSuccess = false;

                    while (!isLoginSuccess) {
                        input.loginInput();

                        // Is user exist in db
                        isLoginSuccess = users.stream()
                                .anyMatch(user -> user.getNationalId().equals(input.nationalId) && user.getPassword().equals(input.password));

                        if (isLoginSuccess) {
                            // Success  Login


                            Optional<User> userLogged = users.stream()
                                    .filter(user -> user.getNationalId().equals(input.nationalId) && user.getPassword().equals(input.password))
                                    .findFirst();

                            if (userLogged.isPresent()) {
                                int selection = 0;
                                do {
                                    System.out.println("1-Transfer Money\n2-Pay Credit\n3-Pay Credit Card Recipt\n4-Exit");
                                    System.out.print("Please make a selection: ");
                                    try {
                                        selection = scanner.nextInt();
                                        switch (selection) {
                                            case 1:
                                                System.out.println("Please enter the account number for transfer");
                                                scanner.nextLine();
                                                String accountNumber = scanner.nextLine();
                                                if (userLogged.get().getNationalId().equals(accountNumber)) {
                                                    System.out.println("Invalid Input");
                                                    break;
                                                }

                                                System.out.println(" Please enter the amount to be transferred");
                                                int amount = scanner.nextInt();
                                                scanner.nextLine();
                                                bank.transferMoney(accountNumber, amount, userLogged.get());
                                                break;
                                            case 2:
                                                System.out.println("You have a debt of " + userLogged.get().getCreditLoan());
                                                System.out.println("1-Pay\n2-Exit");
                                                selection = scanner.nextInt();
                                                if (selection == 1)
                                                    bank.payCredit(userLogged.get().getNationalId());
                                                else if (selection == 2)
                                                    System.out.println("Aborting...");
                                                else
                                                    System.out.println("Invalid Input");
                                                break;
                                            case 3:
                                                System.out.println("You have a credit card debt of " + userLogged.get().getCreditCartRecipt());
                                                System.out.println("1-Pay\n2-Exit");
                                                selection = scanner.nextInt();
                                                if (selection == 1)
                                                    bank.payCreditCard(userLogged.get().getNationalId());
                                                else if (selection == 2)
                                                    System.out.println("Aborting...");
                                                else
                                                    System.out.println("Invalid Input");
                                                break;
                                            case 4:
                                                break;
                                            default:
                                                System.out.println("Invalid selection");
                                                break;
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Selection Must be Digit!");
                                        scanner.nextLine();
                                    }

                                } while (selection != 4);
                            }

                        } else {
                            //  Wrong Login
                            System.out.println("Invalid credentials, please try again.");
                        }
                    }
                    break;
                case 2:
                    User user = input.registerInput();
                    db.append(user);
                    break;
                case 3:
                    System.out.println("Dear customer, see you soon.");
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }

    }
}
