package rosenfeld.scrabble;

import javafx.scene.control.Label;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class ScrabbleControllerTest {

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }

    @Test
    public void initialize() {
        // given
        Letterbag letterBag = mock(Letterbag.class);
        Dictionary dictionary = mock(Dictionary.class);
        ScrabbleController controller = new ScrabbleController(dictionary, letterBag);
        controller.letterTiles = Arrays.asList(
                mock(Label.class),
                mock(Label.class),
                mock(Label.class)
        );
        doReturn("T",
                "G",
                "L")
                .when(letterBag).nextLetter();

        // when
        controller.initialize();

        // then
        verify(controller.letterTiles.get(0)).setText("T");
        verify(controller.letterTiles.get(1)).setText("G");
        verify(controller.letterTiles.get(2)).setText("L");
        verify(letterBag, times(3)).nextLetter();
    }
}