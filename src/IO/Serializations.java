package IO;


import java.io.*;

public class Serializations {

    public static void main(String[] args) {
        // Creates a FileOutputStream where objects from ObjectOutputStream will be written
        FileOutputStream fileStream;

        // Creates the ObjectOutputStream
        ObjectOutputStream objStream;

        // Writing Object
        try {
            fileStream = new FileOutputStream("src/Outputs/outputSerial.txt");
            objStream = new ObjectOutputStream(fileStream);
            Car car = new Car("Hyundai", "Getz");
            FileOutputStream file = new FileOutputStream("src/Outputs/outputSerial.txt");
            ObjectOutputStream write = new ObjectOutputStream(file);
            write.writeObject(car);
            write.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Reading Object
        try {
            FileInputStream fileIn = new FileInputStream("src/Outputs/outputSerial.txt");
            ObjectInputStream read = new ObjectInputStream(fileIn);

            Car newCar = (Car) read.readObject();

            System.out.println("Car Brand : " + newCar.getBrand());
            System.out.println("Car Model: " + newCar.getModel());
            read.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}


