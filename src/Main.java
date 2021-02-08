import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner KBD = new Scanner(System.in);
        Scrabble test = new Scrabble();

        System.out.println("Enter a word to check or X to quit");

        while (!KBD.next().equalsIgnoreCase("X")){
            String wordToCheck = KBD.next();
            System.out.println(test.checkForWord(wordToCheck));
        }
    }
}
