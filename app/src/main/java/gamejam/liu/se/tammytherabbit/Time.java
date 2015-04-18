package gamejam.liu.se.tammytherabbit;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
 import static java.util.concurrent.TimeUnit.*;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by rovanion on 2015-04-18.
 * <p/>
 * This class keeps track of time for us and spawns the appropriate
 */
public class Time extends Service {
    Calendar c = Calendar.getInstance();
    long startTime;
    int notificationID = 1;
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public Time() {
        super();
    }

    @Override
    public void onCreate() {
        startTime = c.getTimeInMillis();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("RabbitTime", "Service started");

        createNotification("Tammy is hungry", "Feed me, bitch!");

        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
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
        // mId allows you to update the notification later on.

        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(this, 0, resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT );
        mBuilder.setContentIntent(resultPendingIntent);

        mNotificationManager.notify(notificationID, mBuilder.build());
    }
}
