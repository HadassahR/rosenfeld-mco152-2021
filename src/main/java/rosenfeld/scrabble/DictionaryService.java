package rosenfeld.scrabble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DictionaryService {

    private Map<String, String> dictionary;

    public DictionaryService () throws IOException {
        dictionary = new HashMap<>();

        try {
            InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            while (reader.readLine() != null) {
                String line = reader.readLine();
                String word = line.substring(0, line.indexOf(" "));
                String definition = line.substring(line.indexOf(" ")).trim();
                dictionary.put(word, definition);
            }
            reader.close();
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    public String getDefinition (String word) {
        return dictionary.getOrDefault(word, "Invalid word");
    }
}
