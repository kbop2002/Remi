package com.example.dng;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities = {Reminder.class}, version = 1)
public abstract class ReminderRoomDatabase extends RoomDatabase {

    private static final int NUMBER_OF_THREADS = 4;
    public static final Executor databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public abstract ReminderDao reminderDao();

    private static volatile ReminderRoomDatabase INSTANCE;

    static ReminderRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ReminderRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ReminderRoomDatabase.class, "reminder_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

