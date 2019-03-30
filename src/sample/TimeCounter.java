package sample;

import java.util.Calendar;
import java.util.GregorianCalendar;

class TimeCounter {
    private Calendar existTime;
    private Calendar futureTime;
    private Calendar deltaTime;

    TimeCounter() {
        existTime = new GregorianCalendar();
        futureTime = new GregorianCalendar();
        deltaTime = new GregorianCalendar();
        deltaTime.set(0, 0, 0, 0, 0, 0);
    }

    Calendar countTime(Integer minutes) {
        futureTime.add(Calendar.MINUTE, minutes);
        Long deltaMillis = futureTime.getTimeInMillis() - existTime.getTimeInMillis();
        deltaTime.add(Calendar.MILLISECOND, deltaMillis.intValue());

        return deltaTime;
    }
}
