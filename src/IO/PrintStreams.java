package IO;

import java.io.PrintStream;

public class PrintStreams {

    // The output data is transferred as a String, not as bytes.

    public static void main(String[] args) {
        // FileOutputStream FileOutputStream file = new FileOutputStream(String file);
        // PrintStream PrintStream output = new PrintStream(file, autoFlush);
        String data = "Hello World.";
        System.out.print(data); // Bu printStream yapısıdır.

        try {
            PrintStream output = new PrintStream("src/Outputs/output.txt");
            output.print(data);
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}

