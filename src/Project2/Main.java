package Project2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        ServerCreation.start();

        // Delay to let server start before tge client connects
        try {
            Thread.sleep(200);
        } catch (InterruptedException ignored) {}

        // Launch UI
        KeyboardIO keyboard = new KeyboardIO();
        keyboard.go();
    }
}