package Core;

import javax.swing.*;


public class Helper {

    public static void setTheme() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;

            }
        }
    }

    public static boolean isTextFieldEmpty(JTextField text) {
        return text.getText().trim().isEmpty();
    }

    public static boolean isTextFieldListEmpty(JTextField[] list) {
        for (JTextField text : list) {
            if (isTextFieldEmpty(text)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        // Check if the email is null or empty
        if (email == null || email.isEmpty()) return false;

        // Check if email contains "@"
        if (email.contains("@")) {
            String[] parts = email.split("@");

            // There must be exactly one "@" symbol and the email should split into two parts
            if (parts.length != 2) return false;

            String localPart = parts[0].trim();   // The part before "@"
            String domainPart = parts[1].trim();  // The part after "@"

            // Both local and domain parts must not be empty
            if (localPart.isEmpty() || domainPart.isEmpty()) return false;

            // Domain part must contain at least one ".", and must not start or end with "."
            if (!domainPart.contains(".") || domainPart.startsWith(".") || domainPart.endsWith(".")) {
                return false;
            }

            // Check the domain extension (e.g., .com, .net); it must be at least 2 characters
            String[] domainParts = domainPart.split("\\.");
            if (domainParts.length < 2) return false; // Must have at least two parts like "example.com"
            if (domainParts[domainParts.length - 1].length() < 2) return false; // Prevent invalid extensions like ".c"

            return true; // All checks passed, email is valid
        }
        // Email must contain "@"
        return false;
    }


    public static boolean confirmDelete(String str) {
        String title = "";
        String msg = "";

        switch (str) {
            case "sure_product":
                msg = "Are you sure you want to delete this product?";
                title = "Confirm Product Delete Process";
                break;
            case "sure_customer":
                msg = "Are you sure you want to delete this customer?";
                title = "Confirm Customer Delete Process";
                break;
        }

        return JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    public static void showMessage(String code) {

        switch (code) {
            case "SUCCESS_UPDATE_PRODUCT":
                JOptionPane.showMessageDialog(null, "Product Updated Successfuly!", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "FAIL_UPDATE_PRODUCT":
                JOptionPane.showMessageDialog(null, "Product  Not Updated Successfuly!", "Fail", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "PRODUCT_STOCK_INSUFFICIENT":
                JOptionPane.showMessageDialog(null, "Product Stock Insufficient!", "Fail", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "ADD_CART_SUCCESS":
                JOptionPane.showMessageDialog(null, "Product Added Cart!", "Fail", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "ADD_CART_FAIL":
                JOptionPane.showMessageDialog(null, "Product Not Added Cart!", "Fail", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "CART_SELECT_CUSTOMER":
                JOptionPane.showMessageDialog(null, "Please  Select a Customer!", "Fail", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "CART_EMPTY":
                JOptionPane.showMessageDialog(null, "Your Cart is Empty! Please add some product!", "Fail", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "ORDER_CREATED":
                JOptionPane.showMessageDialog(null, "Order Created!", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "VALIDATION_FAILED":
                JOptionPane.showMessageDialog(null, "Please enter a username and password!", "Error", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "LOGIN_SUCCESS":
                JOptionPane.showMessageDialog(null, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "INVALID_MAIL":
                JOptionPane.showMessageDialog(null, "Please enter valid mail! ", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case "INVALID_CREDENTIALS":
                JOptionPane.showMessageDialog(null, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case "PRODUCT_NOT_FOUND":
                JOptionPane.showMessageDialog(null, "Product Not Exist!", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case "CUSTOMER_NOT_FOUND":
                JOptionPane.showMessageDialog(null, "Customer Not Exist!", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case "FILL_PROPERLEY":
                JOptionPane.showMessageDialog(null, "Fill the field properley! ", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case "CUSTOMER_UPDATED_SUCCESSFULLY":
                JOptionPane.showMessageDialog(null, "Customer Updated Successfuly!", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "CUSTOMER_UPDATED_FAILED":
                JOptionPane.showMessageDialog(null, "Customer Not Added Successfuly!", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }

    }
}
