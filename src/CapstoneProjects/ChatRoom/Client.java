package CapstoneProjects.ChatRoom;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private static final String SERVER_IP = "localhost"; // Sunucu IP adresi
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in))) {

            // Thread that listening to messages from the server

            new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Connection Lost.");
                    System.exit(0);
                }
            }).start();

            // The process of sending user inputs to the server
            String userInput;
            while ((userInput = consoleIn.readLine()) != null) {
                out.println(userInput);
                if (userInput.equalsIgnoreCase("/quit")) {
                    break;
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Not Found Server: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }
}