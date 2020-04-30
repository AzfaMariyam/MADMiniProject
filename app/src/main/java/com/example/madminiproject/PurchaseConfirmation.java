package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PurchaseConfirmation extends AppCompatActivity {

    Button purchconf;
    Button cancel;
    public static final String CHANNEL_ID = "Purchase confirmation pg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_confirmation);


        purchconf = findViewById(R.id.confirmpay);
        cancel = findViewById(R.id.cancelorder);



        //notification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Purchase confirmation";
            String description = "Purchase confirmation";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);


        }








        purchconf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                addNotification();
              //  Intent continueIntent = new Intent(PurchaseConfirmation.this, Finalpg.class);
               // startActivity(continueIntent);
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continueIntent = new Intent(PurchaseConfirmation.this, MainActivity.class);
                startActivity(continueIntent);
            }
        });
    }



    public void addNotification(){


        Intent intent = new Intent(this, Finalpg.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Purchase Confirmation")
                .setContentText("You have successfully made your purchase!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, builder.build());
    }
}
