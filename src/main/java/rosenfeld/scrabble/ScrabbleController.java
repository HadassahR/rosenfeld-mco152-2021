package rosenfeld.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.List;

public class ScrabbleController {

    @FXML
    private Text valid;
    private final Letterbag letterBag;
    private final Scrabble dictionary;
    private int score = 0;

    @FXML
    private Label points;
    @FXML
    private List<Label> blankTiles;
    @FXML
    List<Label> letterTiles;


    public ScrabbleController(
            Scrabble dictionary,
            Letterbag letterBag) {
        this.dictionary = dictionary;
        this.letterBag = letterBag;
    }

    @FXML
    public void initialize() {
        for (Label label : letterTiles) {
            if (label.getText().isEmpty() || label.getText().equals("")) {
                label.setText(letterBag.nextLetter());
            }
        }
    }

    public void onLetterClicked(javafx.scene.input.MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        String letter = label.getText();
        for (Label tile : blankTiles){
            if ("".equals(tile.getText())){
                tile.setText(letter);
                label.setText("");
                break;
            }
        }

    }

    public void onAnswerClicked(javafx.scene.input.MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        String letter = label.getText();
        for (Label tile : letterTiles) {
            if ("".equals(tile.getText())){
                tile.setText(letter);
                label.setText("");
                break;
            }
        }
    }

    public void submitWord() {
        valid.setText("");
        StringBuilder word = new StringBuilder();
        for (Label let : blankTiles) {
            word.append(let.getText());
        }

        if (dictionary.checkForWord(word.toString())) {
            calculatePoints(word.toString());
            clear();
            initialize();
        } else {
            valid.setText("Invalid Word");
            returnLetters();
            clear();
        }
    }

    private void returnLetters() {
        for (Label tile : blankTiles) {
            if (tile.getText().length() > 0) {
                toEmptyTile(tile.getText());
            }
        }
    }

    private void toEmptyTile(String text) {
        for (Label letter : letterTiles) {
            if ("".equals(letter.getText())){
                letter.setText(text);
                break;
            }
        }
    }

    private void clear() {
        for (Label tile : blankTiles) {
            tile.setText("");
        }
    }

    private void calculatePoints(String word) {
        switch (word.length()) {
            case 2:
                score += 1;
                break;
            case 3:
                score += 3;
                break;
            case 4:
                score += 5;
                break;
            case 5:
                score += 7;
                break;
            case 6:
                score += 11;
            case 7:
                score += 13;
        }
        points.setText("Points: " + String.valueOf(score));
    }


    public void clearTiles(ActionEvent actionEvent) {
        returnLetters();
        clear();
    }
}
