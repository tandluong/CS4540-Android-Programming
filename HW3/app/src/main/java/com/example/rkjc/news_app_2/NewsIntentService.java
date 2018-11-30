package com.example.rkjc.news_app_2;

import android.app.IntentService;
import android.content.Intent;

public class NewsIntentService extends IntentService {

    public NewsIntentService() {
        super("NewsIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        NewsReminderTasks.executeTask(this, action);
    }
}
