package com.example.rkjc.news_app_2;

public class NewsItem {
    private String title;
    private String name;
    private String url;
    private String description;
    private String date;

    public NewsItem(String title, String name, String url, String description, String date) {
        this.title = title;
        this.name = name;
        this.url = url;
        this.description = description;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }
}
