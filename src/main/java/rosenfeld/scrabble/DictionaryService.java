package rosenfeld.scrabble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DictionaryService {

    private Dictionary dictionary;

    public DictionaryService () throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        BufferedReader reader = null;
        if (in != null) {
            reader = new BufferedReader(new InputStreamReader(in));
        }
        dictionary = new Dictionary (reader);
    }

    public Dictionary getDictionary () {
        return this.dictionary;
    }

}
