package com.example.rkjc.news_app_2;

import android.content.Context;
import android.util.Log;

public class NewsReminderTasks {
    public static final String ACTION_NOTIFY_NEW_NEWS = "notify-new-news";
    public static final String ACTION_DISMISS_NOTIFICATION = "dismiss-notification";

    public static void executeTask(Context context, String action) {
//        Log.d("Action", ""+action);
        if (ACTION_NOTIFY_NEW_NEWS.equals(action)) {
            syncNews(context);
        } else if (ACTION_DISMISS_NOTIFICATION.equals(action)) {
            NewsNotificationUtils.clearAllNotifications(context);
//            Log.d("Clear News", ""+action);
        }
    }

    private static void syncNews(Context context) {
//        Log.d("Sync News", context+"");
        NewsNotificationUtils.remindUserNewNews(context);
    }

}
