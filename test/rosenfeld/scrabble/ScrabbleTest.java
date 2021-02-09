package rosenfeld.scrabble;
import org.junit.Assert;
import org.junit.Test;
public class ScrabbleTest {

    @Test
    public void checkForWord() {
        // given
        Scrabble test = new Scrabble();

        // when --> then

        // All caps
        Boolean testWord = test.checkForWord("ARGUMENT");
        Assert.assertTrue(testWord);

        // Lowercase
        testWord = test.checkForWord("argument");
        Assert.assertTrue(testWord);

        // Mixed upper and lower case
        testWord = test.checkForWord("arGuMENT");
        Assert.assertTrue(testWord);

        // Misspelled word
        testWord = test.checkForWord("plagarism");
        Assert.assertFalse(testWord);

        // Word with whitespace
        testWord = test.checkForWord("   plagiarism   ");
        Assert.assertTrue(testWord);

        // No entry or spaces
        testWord = test.checkForWord(" ");
        Assert.assertFalse(testWord);

        // First word in dictionary
        testWord = test.checkForWord("AA");
        Assert.assertTrue(testWord);

        // Last word in dictionary
        testWord = test.checkForWord("zoogeographical");
        Assert.assertTrue(testWord);

    }
}