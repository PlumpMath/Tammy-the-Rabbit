package gamejam.liu.se.tammytherabbit;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by rovanion on 2015-04-18.
 * <p/>
 * This class keeps track of time for us and spawns the appropriate
 */
public class Time extends Service {
    public Time() {
        super();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("RabbitTime", "Service started");
        //TODO: do something useful
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
