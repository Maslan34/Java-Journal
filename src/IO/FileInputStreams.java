package IO;

import java.io.File;
import java.io.FileInputStream;

public class FileInputStreams {


    public static void main(String[] args) {
        try {
            File input = new File("./src/Inputs/input.txt");
            FileInputStream fis = new FileInputStream(input);
            System.out.println("Total Character in Txt File : " + fis.available());
            int i = fis.read();
            while (i != -1) {
                System.out.print((char) i);
                i = fis.read();
            }
            fis.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
