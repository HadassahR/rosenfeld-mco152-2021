package rosenfeld.scrabble;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Scrabble {

    ArrayList<String> dictionary = new ArrayList<String>();

    public Scrabble() {
        importDictionary();
    }

    private void importDictionary() {
        try {
            File wordFile = new File("dictionary.txt");
            Scanner reader = new Scanner(wordFile);
            while (reader.hasNextLine()) {
                String word = reader.nextLine();
                if (word.contains(" ")) {
                    word = word.substring(0, word.indexOf(" ")).trim();
                }
                dictionary.add(word);
            }
            reader.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public boolean checkForWord(String word) {
        word = word.trim();
        for (String str : dictionary) {
            if (str.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}
