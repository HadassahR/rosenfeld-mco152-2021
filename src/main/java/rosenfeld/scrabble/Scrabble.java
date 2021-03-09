package rosenfeld.scrabble;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Scrabble {

   private final Map<String, String> wordsToDefinitions = new HashMap<>();

    public Scrabble() {
        importDictionary();
    }

    private void importDictionary() {
        try {
            File wordFile = new File("dictionary.txt");
            Scanner reader = new Scanner(wordFile);
            while (reader.hasNext()) {
                wordsToDefinitions.put(
                        reader.next(), //key
                        reader.nextLine().trim() //value
                );
            }
            reader.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public boolean checkForWord(String word) {
        return wordsToDefinitions.containsKey(word.toUpperCase().trim());
    }

    public String getDefinition(String word) {
        String definition = wordsToDefinitions.get(word.toUpperCase().trim());
        return definition == null ? "" : definition;
    }

    public int size() {
        return wordsToDefinitions.size();
    }
}
