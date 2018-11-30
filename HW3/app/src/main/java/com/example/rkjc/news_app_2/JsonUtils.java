package com.example.rkjc.news_app_2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class JsonUtils {

    public static ArrayList<NewsItem> parseNews(String jsonResult){
        ArrayList<NewsItem> newsList = new ArrayList<>();
        try {
            JSONObject mainJSONObject = new JSONObject(jsonResult);
            JSONArray items = mainJSONObject.getJSONArray("articles");

            for(int i = 0; i < items.length(); i++){
                JSONObject item = items.getJSONObject(i);
                Log.d("item", ""+item);
                newsList.add(new NewsItem(item.getString("title"), item.getString("author"), item.getString("url"),
                        item.getString("description"), item.getString("publishedAt"), item.getString("urlToImage")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newsList;
    }

}


