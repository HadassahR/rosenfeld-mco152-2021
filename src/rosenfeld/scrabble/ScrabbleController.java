package rosenfeld.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ScrabbleController {
    @FXML
    TextField wordField;
    @FXML
    Label trueFalseLabel;

    public void checkDictionary(ActionEvent actionEvent) {
        try {
            String wordToCheck = wordField.getText();
            Scrabble scrabble = new Scrabble();
            trueFalseLabel.setText(String.valueOf(scrabble.checkForWord(wordToCheck)));
        } catch (Exception exc) {
            System.out.println("EXCEPTION!");
        }
    }
}
