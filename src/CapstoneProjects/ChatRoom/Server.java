package CapstoneProjects.ChatRoom;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server {
    private static final int PORT = 12345;
    private static Set<ClientHandler> clients = new HashSet<>();
    private static Set<String> clientNames = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Server Initializing...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port "+PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New User Connected: " + clientSocket);

                ClientHandler clientThread = new ClientHandler(clientSocket);
                clients.add(clientThread);
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }

    public static void broadcast(String message, ClientHandler excludeClient) {
        for (ClientHandler client : clients) {
            if (client != excludeClient) {
                client.sendMessage(message);
            }
        }
    }

    public static void addClientName(String name) {
        clientNames.add(name);
    }

    public static void removeClient(String name, ClientHandler client) {
        boolean removed = clientNames.remove(name);
        if (removed) {
            clients.remove(client);
            broadcast(name + " has left from chat.", null);
            System.out.println(name + " has left from chat. Active Users: " + clientNames);
        }
    }

    public static Set<String> getClientNames() {
        return new HashSet<>(clientNames);
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Please Enter Username:");
                clientName = in.readLine();

                // Username Validation
                synchronized (clientNames) {
                    while (clientName == null || clientNames.contains(clientName)) {
                        if (clientName == null) {
                            out.println("Invalid Username:");
                        } else {
                            out.println("The username is already taken. Please try another one.:");
                        }
                        clientName = in.readLine();
                    }
                    addClientName(clientName);
                }

                // Welcome message and online user list
                out.println("Welcome " + clientName + "!");
                out.println("Active Users: " + Server.getClientNames());

                // Announcing the new user to other users
                broadcast(clientName + " has joined the chat!\n", this);
                System.out.println("DEBUG>>>"+clientName + " has connected. Active Users: " + Server.getClientNames());

                // Listening messages
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.equalsIgnoreCase("/quit")) {
                        break;
                    }
                    broadcast(clientName + ": " + inputLine, this);
                }
            } catch (IOException e) {
                System.out.println(clientName + " connection error: " + e.getMessage());
            } finally {
                try {
                    if (clientName != null) {
                        removeClient(clientName, this);
                    }
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Closing Socket Error: " + e.getMessage());
                }
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }
}