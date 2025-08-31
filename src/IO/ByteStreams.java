package IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteStreams {

    // Used in security operations or cryptography
    public static void main(String[] args) {

        byte[] array = {1, 2, 3, 4};
        try {
            ByteArrayInputStream input = new ByteArrayInputStream(array);
            System.out.println("Available bytes at the beginning: " + input.available());
            System.out.println("The bytes read from the input stream: ");
            int data = input.read();
            while(data != -1){
                System.out.print(data + ", ");
                data = input.read();
            }
            System.out.println("\nAvailable bytes at the beginning: " + input.available());
            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println("##################");
        byte[] arraySkip = {10, 20, 30, 40};
        try {
            ByteArrayInputStream input = new ByteArrayInputStream(arraySkip);

            // Data of 2 bytes will be skipped
            input.skip(2);

            int data = input.read();
            while (data != -1) {
                System.out.print(data + ", ");
                data = input.read();
            }

            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println();
        System.out.println("##################");
        byte[] arrayOffset = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        try {
            ByteArrayInputStream input = new ByteArrayInputStream(arrayOffset, 2, 4);

            int data = input.read();
            while (data != -1) {
                System.out.print(data + ", ");
                data = input.read();
            }

            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        System.out.println();
        System.out.println("##################");
        String data = "I'm Learning Java Streams!";
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] arrayJava = data.getBytes();

            out.write(arrayJava);
            System.out.println(out);
            String streamData = out.toString();
            System.out.println("Output Stream : " + streamData);

            out.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
