package CapstoneProjects;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        final int PASSWORD = 3453;
        final String USERNAME = "GOLDENDOG";
        int lock = 5, password;
        double balance = 21124.56, amount;
        int option = 0;

        System.out.println("Welcome to the ATM");

        while (lock > 0) {
            System.out.println("\nPlease Enter Your Password: ");
            password = input.nextInt();

            if (password == PASSWORD) {
                System.out.println("\nWelcome " + USERNAME);

                while (true) {
                    System.out.println("\nPlease Select an Option:");
                    System.out.println("1. Withdrawal");
                    System.out.println("2. Deposit");
                    System.out.println("3. See Your Balance");
                    System.out.println("4. Exit");
                    option = input.nextInt();

                    switch (option) {
                        case 1:
                            System.out.println("Please Enter the Amount to Withdraw: ");
                            amount = input.nextDouble();
                            if (amount > balance) {
                                System.out.println("Insufficient Balance");
                            } else {
                                balance -= amount;
                                System.out.println("Your New Balance is: " + balance);
                            }
                            break;
                        case 2:
                            System.out.println("Please Enter the Amount to Deposit: ");
                            amount = input.nextDouble();
                            balance += amount;
                            System.out.println("Your New Balance is: " + balance);
                            break;
                        case 3:
                            System.out.println("\nYour Balance is: " + balance + "\n");
                            break;
                        case 4:
                            System.out.println("\nExiting... Have a Nice Day!");
                            input.close();
                            return;
                        default:
                            System.out.println("Invalid Option");
                    }
                }
            } else {
                lock--;
                if (lock == 0) {
                    System.out.println("\nYou have no more attempts. Your card is locked.");
                } else {
                    System.out.println("Wrong Password. You have " + lock + " attempts left.");
                }
            }
        }
        input.close();
    }
}

