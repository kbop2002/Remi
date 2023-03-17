package com.example.dng;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class AddReminderActivity extends AppCompatActivity {

    private EditText mLocationEditText;
    private EditText mReminderEditText;
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        mLocationEditText = (EditText) findViewById(R.id.location_edit_text);
        mReminderEditText = (EditText) findViewById(R.id.reminder_edit_text);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        Button saveButton = (Button) findViewById(R.id.save_button);
        saveButton.setOnClickListener(view -> {
            String location = mLocationEditText.getText().toString();
            String reminder = mReminderEditText.getText().toString();

            // Save the reminder to the database
            // ...

            // Return to the main activity
            Intent intent = new Intent(AddReminderActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}

