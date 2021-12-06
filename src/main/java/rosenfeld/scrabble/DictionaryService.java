package rosenfeld.scrabble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DictionaryService {

    public Map<String, String> createDictionaryMap() throws IOException {
        Map<String, String> dictionaryMap = new HashMap<>();
        InputStream in;
        BufferedReader reader = null;

        try {
            in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
            reader = new BufferedReader(new InputStreamReader(in));

            while (reader.ready()){
                String line = reader.readLine();
                String word = line.substring(0, line.indexOf(" "));
                String definition = line.substring(line.indexOf(" "));
                dictionaryMap.put(word, definition);
            }
                reader.close();
        }
        catch (Exception exc)
        {
//            dictionaryMap.put("Error", "true");
            exc.printStackTrace();
        }
        finally
        {
//            dictionaryMap.put("finally", "complete");
            if (reader != null) {
                reader.close();
            }
        }
        return dictionaryMap;
    }
}
