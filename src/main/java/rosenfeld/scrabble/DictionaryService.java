package rosenfeld.scrabble;

import java.io.IOException;

public class DictionaryService {

    Dictionary dictionary;

    public DictionaryService () throws IOException {
        dictionary = new Dictionary();
    }

    public Dictionary getDictionary () {
        return this.dictionary;
    }

}
