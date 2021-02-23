package rosenfeld.scrabble;
import org.junit.Assert;
import org.junit.Test;
public class ScrabbleTest {

    @Test
    public void validCaps_checkForWord(){
        Scrabble test = new Scrabble();
        boolean testWord = test.checkForWord("ARGUMENT");
        Assert.assertTrue(testWord);
    }

    @Test
    public void validLower_checkForWord() {
        Scrabble test = new Scrabble();
        boolean testWord = test.checkForWord("argument");
        Assert.assertTrue(testWord);
    }

    @Test
    public void validMixedCase_checkForWord(){
        Scrabble test = new Scrabble();
        boolean testWord = test.checkForWord("arGuMENT");
        Assert.assertTrue(testWord);
    }

    @Test
    public void invalid_checkForWord(){
        Scrabble test = new Scrabble();
        boolean testWord = test.checkForWord("hadassah");
        Assert.assertFalse(testWord);
    }

    @Test
    public void validWhitespace_checkForWord(){
        Scrabble test = new Scrabble();
        boolean testWord = test.checkForWord("   plagiarism   ");
        Assert.assertTrue(testWord);
    }
    @Test
    public void invalidEmptyInput_checkForWord(){
        Scrabble test = new Scrabble();
        boolean testWord = test.checkForWord(" ");
        Assert.assertFalse(testWord);
    }

    @Test
    public void validFirstWord_checkForWord() {
        Scrabble test = new Scrabble();
        boolean testWord = test.checkForWord("AA");
        Assert.assertTrue(testWord);
    }

    @Test
    public void validLastWord_checkForWord() {
        Scrabble test = new Scrabble();
        boolean testWord = test.checkForWord("zoogeographical");
        Assert.assertTrue(testWord);
    }
}