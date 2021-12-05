package rosenfeld.scrabble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryService {

    public Map<String, String> dictionary () throws IOException {
        Map<String, String> dictionaryMap = new HashMap<>();
        BufferedReader reader = null;

        try {
            File file = new File("dictionary.txt");
            reader = new BufferedReader(new FileReader(file));
            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                String word = parts[0].trim();
                String definition = parts[1].trim();

                if (!word.equals("") && !definition.equals("")){
                    dictionaryMap.put(word, definition);
                }
            }
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
        finally
        {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (Exception exc) {
                };
            }
        }
        return dictionaryMap;
    }
}
