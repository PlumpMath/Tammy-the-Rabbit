package gamejam.liu.se.tammytherabbit;

import android.util.Log;

/**
 * Created by rovanion on 2015-04-18.
 */
public class TimedEvent implements Runnable {
    Time time;

    TimedEvent(Time t) {
        this.time = t;
    }

    @Override
    public void run() {
        // Every 10 seconds.
        Log.d("RabbitTime", "");
        if((System.currentTimeMillis() - time.getStartTime()) / 1000 % 10 == 0) {
            time.addShit();
        }
    }
}
