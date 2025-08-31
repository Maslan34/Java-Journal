package IO;

import java.io.File;

public class Files {
    public static void main(String[] args) {
        File file = new File("./src/IO/Muharrem.txt");

        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("New File Created.");
            } else {
                System.out.println("File Already Exists.");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        File fileDelete = new File("./src/IO/deleteMe.txt");
        //System.out.println(fileDelete.exists());
        try {
            boolean value = fileDelete.delete();
            if (value) {
                System.out.println("The File is deleted.");
            } else {
                System.out.println("The File is not deleted.");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}
