package com.example.frontendproject;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class chat extends AppCompatActivity {
    private TextView dataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat); // Corrected layout resource

        dataTextView = findViewById(R.id.dataTextView);

        // Sample data (replace this with your actual data retrieval logic)
        String fetchedData = "Sample Data from Database";

        // Display the fetched data or show a message if no data is available
        if (!fetchedData.isEmpty()) {
            dataTextView.setText("Data from the database: " + fetchedData);
            showNotification("Data Fetched", "Data from the database: " + fetchedData);
        } else {
            dataTextView.setText("No data available in the database.");
        }
    }

    private void showNotification(String title, String message) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "YourChannelId";
            String channelName = "YourChannelName";
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        Notification.Builder builder = new Notification.Builder(this)
                .setContentTitle(title)
                .setContentText(message);

        notificationManager.notify(1, builder.build());
    }
}
