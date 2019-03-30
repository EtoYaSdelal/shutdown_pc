package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class Controller {
    @FXML
    private TextField textField;
    @FXML
    private Label outLabel;
    @FXML
    Button startButton;
    @FXML
    Button stopButton;
    @FXML
    Label infoLabel;
    private Timeline timeline;
    private Integer sec;

    public void numericOnly(KeyEvent event) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    } // https://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx

    public void timerCountdown(ActionEvent event) {
        sec = Integer.parseInt(textField.getText());

        textField.clear();
        startButton.setDisable(true);
        textField.setDisable(true);
        infoLabel.setText("Your pc will\n" + "tern off");
        if (timeline != null) {
            timeline.stop();
        }
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new MyEventHandler(sec, outLabel, timeline)));
        timeline.playFromStart();
    }

    public void timerStop(ActionEvent event) {
        textField.clear();
        startButton.setDisable(false);
        infoLabel.setText("Enter shutdown\n" + "timer in minutes");
        if (timeline != null) {
            timeline.stop();
            outLabel.setText("");
            textField.setDisable(false);
        }
    }
}

