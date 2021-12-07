package rosenfeld.scrabble;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

    private final Map<String, String> wordsToDefinitions = new HashMap<>();

    public Dictionary() {
        importDictionary();
    }

    public Dictionary (BufferedReader reader) throws IOException {
        try {
            while (reader.readLine() != null) {
                String line = reader.readLine();
                String word = line.substring(0, line.indexOf(" "));
                String definition = line.substring(line.indexOf(" ")).trim();
                wordsToDefinitions.put(word, definition);
            }
            reader.close();
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
        reader.close();
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

    public Map<String, String> getWordsToDefinitions() {
        return wordsToDefinitions;
    }
    public int size() {
        return wordsToDefinitions.size();
    }
}
