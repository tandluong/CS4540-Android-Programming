package com.example.rkjc.news_app_2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

//import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.Driver;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;

public class NewsReminderUtils {
    /*
     * Interval at which to remind the user to drink water. Use TimeUnit for convenience, rather
     * than writing out a bunch of multiplication ourselves and risk making a silly mistake.
     */
    private static final int REMINDER_INTERVAL_SECONDS = 10;
    private static final int SYNC_FLEXTIME_SECONDS = 10;

    private static final String REMINDER_JOB_TAG = "news_reminder_tag";

    private static boolean sInitialized;

    synchronized public static void scheduleNewsReminder(@NonNull final Context context) {
        if (sInitialized) return;

        Driver driver = new GooglePlayDriver(context);
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(driver);

        Job constraintReminderJob = dispatcher.newJobBuilder()
                .setService(NewsFirebaseJobService.class)
                .setTag(REMINDER_JOB_TAG)
//                .setConstraints(Constraint.DEVICE_CHARGING)
                .setLifetime(Lifetime.FOREVER)
                .setRecurring(true)
                .setTrigger(Trigger.executionWindow(10, REMINDER_INTERVAL_SECONDS + SYNC_FLEXTIME_SECONDS))
                .setReplaceCurrent(true)
                .build();

        dispatcher.schedule(constraintReminderJob);

        sInitialized = true;
    }
}
