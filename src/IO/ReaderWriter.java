package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class ReaderWriter {

    public static void main(String[] args) {
        char[] array = new char[100];


        // INPUT STREAM READER
        try {
            FileInputStream file1 = new FileInputStream("src/Inputs/input.txt");
            FileInputStream file2 = new FileInputStream("src/Inputs/input.txt");

            InputStreamReader input = new InputStreamReader(file1);
            InputStreamReader input2 = new InputStreamReader(file2);
            System.out.println(input.getEncoding());

            int data = input.read();
            while (data != -1) {
                System.out.print((char) data);
                data = input.read();
            }
            System.out.println();
            System.out.println("############");
            int data2 = input2.read();
            while (data2 != -1) {
                System.out.print(data2);
                data2 = input2.read();
            }

            input2.close();
        } catch (Exception e) {
            e.getStackTrace();
        }


        // OUTPUT STREAM WRITER

        String data = "Patika ile Java102 Dersleri";
        try {
            FileOutputStream file = new FileOutputStream("src/Outputs/outputWriter.txt");
            OutputStreamWriter output = new OutputStreamWriter(file);
            output.write(data);
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        try {
            FileOutputStream file = new FileOutputStream("src/Outputs/outputWriter.txt");
            OutputStreamWriter output1 = new OutputStreamWriter(file);
            OutputStreamWriter output2 = new OutputStreamWriter(file, StandardCharsets.ISO_8859_1);
            System.out.println("\nCharacter encoding of output1: " + output1.getEncoding());
            System.out.println("Character encoding of output2: " + output2.getEncoding());
            output1.close();
            output2.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}



