package gamejam.liu.se.tammytherabbit;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import static java.util.concurrent.TimeUnit.*;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by rovanion on 2015-04-18.
 * <p/>
 * This class keeps track of time for us and spawns the appropriate
 */
public class Time extends Service {
    private final IBinder binder = new TimeBinder();
    private long startTime;
    private int notificationID = 1;
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);
    private int numberOfShits = 0;

    public Time() {
        super();
    }

    @Override
    public void onCreate() {
        startTime = System.currentTimeMillis();
        scheduler.scheduleAtFixedRate(new TimedEvent(this), 1, 1, SECONDS);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("RabbitTime", "Service started");

        createNotification("Tammy is hungry", "Feed me, bitch!");

        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private void createNotification(String title, String message) {
        Intent resultIntent = new Intent(this, MainActivity.class);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.rabbit)
                        .setContentTitle(title)
                        .setContentText(message);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);

        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(this, 0, resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT );
        mBuilder.setContentIntent(resultPendingIntent);

        mNotificationManager.notify(notificationID, mBuilder.build());
    }
    public long getStartTime() {
        return startTime;
    }
    public void addShit(){
        numberOfShits++;
        Log.d("RabbitTime", "Shits added");
    }
    public int getShitCount(){
        return numberOfShits;
    }
    public void cleanShit() {
        numberOfShits--;
    }

    public class TimeBinder extends Binder {
        Time getService() {
            // Return this instance of Time so clients can call public methods
            return Time.this;
        }
    }
}


