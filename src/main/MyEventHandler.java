package main;

import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class MyEventHandler implements EventHandler<ActionEvent> {
    private Integer time;
    private Label clockLabel;
    private Timeline timeline;
    private LocalTime timer = LocalTime.of(0, 0, 0, 0);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    MyEventHandler(Integer time, Label label, Timeline timeline) {
        this.time = time * 60;
        this.clockLabel = label;
        this.timeline = timeline;
        timer = timer.plusMinutes(time);

    }

    @Override
    public void handle(ActionEvent event) {
        timer = timer.minus(1, ChronoUnit.SECONDS);
        time--;
        clockLabel.setText(timer.format(formatter));
        if (time <= 0) {
            timeline.stop();
            clockLabel.setText("Timer end's");
            ShutDownManager.shutDownSystem();
            Platform.exit();
        }
    }
}
