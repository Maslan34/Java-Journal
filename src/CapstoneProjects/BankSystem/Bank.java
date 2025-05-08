package CapstoneProjects.BankSystem;

import java.util.List;
import java.util.Scanner;

public class Bank {
    final DbManager db = new DbManager();
    final Scanner input = new Scanner(System.in);

    public void transferMoney(String id, int amount,User sender) {
        List<User> users= db.read();
        for(User user:users) {
            if(user.getNationalId().equals(id)){

                if(sender.getBalance()<amount)
                    System.out.println("Insufficient Balance");
                else if(amount<0)
                    System.out.println("Invalid Input");
                else {
                    user.setBalance(user.getBalance()+amount);
                    db.update(users);
                }

                return;
            }

        }
        System.out.println("No User Found");
    }

    public void payCredit(String nationalID) {
        List<User> users= db.read();
        for(User user:users) {
            if(user.getNationalId().equals(nationalID)){
                System.out.println("How much money do you want to pay?");
                int amount = input.nextInt();
                if(amount > user.getBalance()) {
                    System.out.println("Insufficient Balance");
                    return;
                }
                else if(amount<0) {
                    System.out.println("Invalid Input");
                }
                else{
                    user.setBalance(user.getBalance()-amount);
                    user.setCreditLoan(user.getCreditLoan()-amount);
                    db.update(users);
                }
                return;
            }
            System.out.println("No User Found");
        }

    }

    public void payCreditCard(String nationalID) {
        List<User> users= db.read();
        for(User user:users) {
            if(user.getNationalId().equals(nationalID)){
                System.out.println("How much money do you want to pay?");
                int amount = input.nextInt();
                if(amount > user.getBalance()) {
                    System.out.println("Insufficient Balance");
                    return;
                }
                else if(amount<0) {
                    System.out.println("Invalid Input");
                }
                else{
                    user.setBalance(user.getBalance()-amount);
                    user.setCreditLoan(user.getCreditCartRecipt()-amount);
                    db.update(users);
                }
                return;
            }
            System.out.println("No User Found");
        }

    }


}
