package com.example.dng;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import androidx.annotation.NonNull;

@Entity(tableName = "reminder_table")
public class Reminder {


    @PrimaryKey(autoGenerate = true)
    private int locationId;
    @NonNull
    private String location;
    private String reminder;


    public Reminder(@NonNull String location, String reminder) {
        this.location = location;
        this.reminder = reminder;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }


    public @NonNull String getLocation() {
        return location;
    }
    public int getLocationId() {
        return locationId;
    }


    public String getReminder() {
        return reminder;
    }
}
