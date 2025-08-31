package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreams {

    public static void main(String[] args) {
        try {
            File output = new File("./src/Outputs/output.txt");
            output.createNewFile();

            String data = "Hi Java!\nI'm Muharrem Aslan";
            FileOutputStream fos = new FileOutputStream(output);
            fos.write(data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
