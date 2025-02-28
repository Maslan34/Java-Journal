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
        if (email == null || email.isEmpty()) return false;

        if (email.contains("@")) {
            String[] parts = email.split("@");

            // "@" sembolü birden fazla olmamalı ve iki parçaya ayrılmalı
            if (parts.length != 2) return false;

            String localPart = parts[0].trim(); // "@" sembolünün sol tarafı
            String domainPart = parts[1].trim(); // "@" sembolünün sağ tarafı

            // Local ve domain kısmı boş olamaz
            if (localPart.isEmpty() || domainPart.isEmpty()) return false;

            // Domain kısmında en az bir "." olmalı ve son karakter "." olamaz
            if (!domainPart.contains(".") || domainPart.startsWith(".") || domainPart.endsWith(".")) {
                return false;
            }

            // Domain kısmının uzantısını kontrol et (.com, .net gibi en az 2 harfli bir uzantı olmalı)
            String[] domainParts = domainPart.split("\\.");
            if (domainParts.length < 2) return false; // "example.com" gibi en az iki parça olmalı
            if (domainParts[domainParts.length - 1].length() < 2) return false; // ".c" gibi geçersiz uzantıları engelle

            return true; // Eğer tüm kontroller geçtiyse, e-posta geçerlidir
        }
        return true;
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

        }

    }
}
