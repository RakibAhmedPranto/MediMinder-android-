package com.example.hp.mediminder;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import android.util.LongSparseArray;

import java.io.IOException;

public class ReminderService extends WakeReminderIntentService {

/*


        Notification note=new Notification(android.R.drawable.stat_sys_warning, getString(R.string.notify_new_task_message), System.currentTimeMillis());
        note.setLatestEventInfo(this, getString(R.string.notify_new_task_title), getString(R.string.notify_new_task_message), pi);
        note.defaults |= Notification.DEFAULT_SOUND;
        note.flags |= Notification.FLAG_AUTO_CANCEL;

        // An issue could occur if user ever enters over 2,147,483,647 tasks. (Max int value).
        // I highly doubt this will ever happen. But is good to note.
        int id = (int)((long)rowId);
        mgr.notify(id, note);
*/









    public ReminderService() {
        super("ReminderService");
    }

    @Override
    void doReminderWork(Intent intent) {

        Log.d("ReminderService", "Doing work.");
        Long rowId = intent.getExtras().getLong(RemindersDbAdapter.KEY_ROWID);

        Intent notificationIntent = new Intent(this, ReminderEditActivity.class);
        notificationIntent.putExtra(RemindersDbAdapter.KEY_ROWID, rowId);

        PendingIntent pi = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_ONE_SHOT);
        Notification.Builder builder = new Notification.Builder(this);
        builder
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.icon) //Any icon you want
                .setContentTitle("Medi Minder")
                .setContentText("Time to take medicine")
                .setSound(
                        RingtoneManager
                                .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setDefaults(Notification.FLAG_AUTO_CANCEL)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000 }) //set virbrate & color of led
                .setLights(Color.BLUE, 3000, 3000)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.icon));



            //Vibration
            /*builder.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });*/

            //LED
            /*builder.setLights(Color.RED, 3000, 3000);*/

            //Ton
            /*builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);*/

        NotificationManager NoMa = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        NoMa.notify(1, builder.build());
    }


}

