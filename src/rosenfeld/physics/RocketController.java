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
    @FXML
    RocketCanvas rocketCanvas;

    public void calculateRocket(ActionEvent actionEvent) {

            double velocity = Double.parseDouble(velocityField.getText());
            double angle = Double.parseDouble(angleField.getText());
            double seconds = Double.parseDouble(secondsField.getText());

            Rocket rocket = new Rocket(velocity, angle);
            String xLbl = String.format("X: %.2f", rocket.getX(seconds));
            String yLbl = String.format("Y: %.2f", rocket.getY(seconds));
            String fTLbl = String.format("Flight time: %.2f", rocket.getFlightTime());

            xLabel.setText(xLbl);
            yLabel.setText(yLbl);
            flightTimeLabel.setText(fTLbl);

            rocketCanvas.draw(rocket);

    }
}
