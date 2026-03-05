package Project2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        ServerCreation.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException ignored) {}

        KeyboardIO keyboard = new KeyboardIO();
        keyboard.go();
    }
}