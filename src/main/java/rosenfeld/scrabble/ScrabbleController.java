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
        String wordToCheck = wordField.getText();
        Scrabble scrabble = new Scrabble();
        if (scrabble.checkForWord(wordToCheck)) {
            trueFalseLabel.setText("Valid Word");
        } else {
            trueFalseLabel.setText("Invalid Word");
        }
    }
}
