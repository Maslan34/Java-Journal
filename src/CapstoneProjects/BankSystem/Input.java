package CapstoneProjects.BankSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Input {
    String nationalId = "";
    String password = "";
    private final Scanner input = new Scanner(System.in);


    public void loginInput() {
        System.out.println("Please Enter Your National ID");
        this.nationalId = input.nextLine();
        System.out.println("Please Enter Your Password");
        this.password = input.nextLine();
    }

    public User registerInput() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nationalIdInput = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print("National ID: ");
            nationalIdInput = input.nextLine();


            boolean isValidNationalId = true;
            for (char c : nationalIdInput.toCharArray()) {
                if (!Character.isDigit(c)) {
                    System.out.println("National ID can only contain digits.");
                    isValidNationalId = false;
                    break;
                }
            }


            if (isValidNationalId)
                isValid = true;

        }
        System.out.print("First Name: ");
        String firstName = input.nextLine();

        System.out.print("Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Date of Birth (yyyy-MM-dd): ");
        Date dateOfBirth = null;
        try {
            dateOfBirth = dateFormat.parse(input.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
        }

        String password;
        while (true) {
            System.out.print("Password: ");
            LocalDate localDate = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Integer year = localDate.getYear();
            password = input.nextLine();
            if (password.isEmpty()) {
                System.out.println("Please enter a valid password.");
            } else if (password.contains(year.toString()))
                System.out.println("Password can not contain your birth year.");

            else
                break;

        }

        return new User(nationalIdInput, firstName, lastName, dateOfBirth, password);

    }
}





