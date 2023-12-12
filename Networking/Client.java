package Networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to server.");

            // Create input and output streams for communication
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // Send a message to the server
            String clientMessage = "Hello, Server! This is the client.";
            out.writeObject(clientMessage);

            // Receive the server's response
            String serverResponse = (String) in.readObject();
            System.out.println("Received from server: " + serverResponse);

            // Close the connections
            in.close();
            out.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
