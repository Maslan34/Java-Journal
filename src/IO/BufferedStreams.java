package IO;

import java.io.*;

public class BufferedStreams {

    public static void main(String[] args) {

        // Reading
        try {
            FileInputStream file = new FileInputStream("src/Inputs/inputBuffer.txt");

            BufferedInputStream input = new BufferedInputStream(file);
            input.skip(2);
            System.out.println("Available bytes: " + input.available());
            System.out.println();
            int i = input.read();

            while (i != -1) {
                System.out.print((char) i);

                i = input.read();
            }
            System.out.println();
            System.out.println("Available bytes: " + input.available());

            input.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Writing

        String data = "This is Buffer Output Stream text.";

        try {
            // FileOutputStream
            FileOutputStream file = new FileOutputStream("src/Outputs/outputBuffer.txt");

            // BufferedOutputStream
            BufferedOutputStream output = new BufferedOutputStream(file);

            byte[] array = data.getBytes();

            output.write(array);
            output.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // FILE STREAMS VS BUFFERED STREAMS

        File file = new File("src/Outputs/FvsB.md");

        inputStream(file);

        bufferedInputStream(file);
    }

    static void inputStream(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            long startTime = System.nanoTime();

            int read = fileInputStream.read();

            while (read != -1) {
                System.out.print((char) read);

                read = fileInputStream.read();
            }

            long endTime = System.nanoTime();

            System.out.println("\nElapsed time: " + (endTime - startTime));

            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void bufferedInputStream(File file) {

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            long startTime = System.nanoTime();

            int readBuff = bufferedInputStream.read();

            while (readBuff != -1) {
                System.out.print((char) readBuff);

                readBuff = bufferedInputStream.read();
            }

            long endTime = System.nanoTime();

            System.out.println("\nElapsed time (with buffer): " + (endTime - startTime));

            bufferedInputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
