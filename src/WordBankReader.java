import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class WordBankReader {
    public static String getWord(int letterCount) {
        File wordBank = new File("WordBank.txt");
        Scanner scanner = new Scanner(wordBank);
        
        String lengthHeader = "-" + letterCount;
        boolean foundHeader = false;
        int wordCount = 0;
        
        while(scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            
            if (currentLine.startsWith("-")) { // Headers always start with a - (EX: -5 for a 5 letter word section)
                if(foundHeader) {
                    break;
                } else if (currentLine.equals(lengthHeader)) {
                    foundHeader = true;
                }
            } else if (foundHeader && !currentLine.trim().isEmpty()) {
                wordCount += 1;
            }
        }

        scanner.close();
        
    }
}
