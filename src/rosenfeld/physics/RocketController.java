package rosenfeld.physics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RocketController {
    @FXML
    TextField velocityField, angleField, secondsField;
    @FXML
    Label xLabel, yLabel, flightTimeLabel;

    public void calculateRocket(ActionEvent actionEvent) {

        try {
            double velocity = Double.parseDouble(velocityField.getText());
            double angle = Double.parseDouble(angleField.getText());
            double seconds = Double.parseDouble(secondsField.getText());

            Rocket rocket = new Rocket(velocity, angle);
            xLabel.setText("X: " + rocket.getX(seconds));
            yLabel.setText("Y: " + rocket.getY(seconds));
            flightTimeLabel.setText("Flight time: " + rocket.getFlightTime(seconds));
        } catch (Exception exc) {
            System.out.println("ERROR!");
        }

    }
}
