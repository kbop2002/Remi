package com.example.dng;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder> {

    private List<Reminder> mReminders;

    public ReminderAdapter(List<Reminder> reminders) {
        mReminders = reminders;
    }

    @NonNull
    @Override
    public ReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reminder_item, parent, false);
        return new ReminderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReminderViewHolder holder, int position) {
        Reminder reminder = mReminders.get(position);
        holder.locationTextView.setText(reminder.getLocation());
        holder.reminderTextView.setText(reminder.getReminder());
    }

    @Override
    public int getItemCount() {
        return mReminders.size();
    }

    class ReminderViewHolder extends RecyclerView.ViewHolder {
        TextView locationTextView;
        TextView reminderTextView;

        public ReminderViewHolder(View itemView) {
            super(itemView);
            locationTextView = itemView.findViewById(R.id.location_text_view);
            reminderTextView = itemView.findViewById(R.id.reminder_text_view);
        }
    }
}

