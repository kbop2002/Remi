package com.example.dng;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ReminderRepository {
    private ReminderDao mReminderDao;
    private LiveData<List<Reminder>> mAllReminders;

    public ReminderRepository(Application application) {
        ReminderRoomDatabase db = ReminderRoomDatabase.getDatabase(application);
        mReminderDao = db.reminderDao();
        mAllReminders = mReminderDao.getAllReminders();
    }

    public LiveData<List<Reminder>> getAllReminders() {
        return mAllReminders;
    }

    public void insert(final Reminder reminder) {
        ReminderRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mReminderDao.insert(reminder);
            }
        });
    }

    public void update(final Reminder reminder) {
        ReminderRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mReminderDao.update(reminder);
            }
        });
    }

    public void delete(final Reminder reminder) {
        ReminderRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mReminderDao.delete(reminder);
            }
        });
    }
}

