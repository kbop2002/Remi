package com.example.dng;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private ReminderRepository mRepository;
    private LiveData<List<Reminder>> mAllReminders;

    public MainViewModel (Application application) {
        super(application);
        mRepository = new ReminderRepository(application);
        mAllReminders = mRepository.getAllReminders();
    }

    public void addReminder(Reminder reminder) {
        mRepository.insert(reminder);
    }

    public LiveData<List<Reminder>> getAllReminders() {
        return mAllReminders;
    }
}

