import java.util.Scanner;

public class TerminalIO {
    public static String promptInput(int attemptCount, int letterCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[Attempt " + attemptCount + "] Enter a " + letterCount + " letter word: ");
        String word = scanner.nextLine();
        scanner.close();
        return word.toLowerCase();
    }

    public static void output(int correctLetter, int correctPosition) {
        System.out.print("Correct Letter: " + correctLetter + "\nCorrect Letter in Correct Position: " + correctPosition);
    }
}
