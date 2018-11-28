package com.example.rkjc.news_app_2;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class NewsRepository {

    private NewsItemDao mNewsItemDao;
    private LiveData<List<NewsItem>> mAllNews;

    public NewsRepository(Application application){
        NewsRoomDatabase db = NewsRoomDatabase.getDatabase(application.getApplicationContext());
        mNewsItemDao = db.newsItemDao();
        mAllNews = mNewsItemDao.loadAllNewsItems();
    }

    LiveData<List<NewsItem>> loadAllNewsItems() {
        return mAllNews;
    }

    public void sync() {
        new syncAsyncTask(mNewsItemDao).execute();
    }

    private static class syncAsyncTask extends AsyncTask<Void, Void, Void> {
        private NewsItemDao mAsyncTaskDao;
        syncAsyncTask(NewsItemDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.clearAll();

            URL newsSearch = NetworkUtils.buildUrl();
            String newsSearchResults = null;
            try {
                newsSearchResults = NetworkUtils.getResponseFromHttpUrl(newsSearch);
            } catch (IOException e) {
                e.printStackTrace();
            }

            List<NewsItem> news = JsonUtils.parseNews(newsSearchResults);

            mAsyncTaskDao.insert(news);

            return null;
        }
    }


}
