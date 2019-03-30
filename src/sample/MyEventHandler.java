package sample;

import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

import java.util.Calendar;

class MyEventHandler implements EventHandler<ActionEvent> {
    private Integer time;
    private Label clockLabel;
    private Timeline timeline;
    private Calendar calendar;

    MyEventHandler(Integer time, Label label, Timeline timeline) {
        this.time = time * 60;
        this.clockLabel = label;
        this.timeline = timeline;
        TimeCounter counter = new TimeCounter();
        calendar = counter.countTime(time);
    }

    @Override
    public void handle(ActionEvent event) {
        calendar.add(Calendar.SECOND, -1);
        time--;
        clockLabel.setText(calendar.get(Calendar.HOUR_OF_DAY) + ":"
                + calendar.get(Calendar.MINUTE) + ":"
                + calendar.get(Calendar.SECOND));
        if (time <= 0) {
            timeline.stop();
            clockLabel.setText("Timer end's");
            ShutDownManager.shutDownSystem();
            Platform.exit();
        }
    }
}
