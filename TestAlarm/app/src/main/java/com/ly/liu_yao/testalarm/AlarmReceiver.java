package com.ly.liu_yao.testalarm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, i, 0);

        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setContentTitle("Das Essen ist fertig!")
                .setContentText("Es wird schon kalt!")
                .addAction(android.R.drawable.sym_def_app_icon, "Essen gehen", pendingIntent);
        notificationManager.notify(0, builder.build());

        Log.i("AlarmReceiver", "Der Wecker klingelt!");
    }
}
