package Project2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCreation {

    public static final int LOCALPORT = 5000;

    public static void start() {
        Thread serverThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(LOCALPORT)) {
                System.out.println("Server started on port " + LOCALPORT);
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
                new ServerSession(clientSocket).run();
            } catch (IOException e) {
                System.out.println("Server error: " + e.getMessage());
            }
        });
        serverThread.setDaemon(true);
        serverThread.start();
    }
}