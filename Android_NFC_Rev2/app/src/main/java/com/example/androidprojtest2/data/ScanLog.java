package com.example.androidprojtest2.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "log_table")
public class ScanLog {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "tag")
    private String tag;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "date_logged")
    @TypeConverters(DateConverter.class)
    private Date dateLogged;

    public ScanLog(int id, String tag, String description, Date dateLogged) {
        this.id = id;
        this.tag = tag;
        this.description = description;
        this.dateLogged = dateLogged;
    }

    @Ignore
    public ScanLog(String tag, String description, Date dateLogged) {
        this.tag = tag;
        this.description = description;
        this.dateLogged = dateLogged;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() { return tag; }

    public void setTag(String tag) { this.tag = tag; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateLogged() {
        return dateLogged;
    }

    public void setDateLogged(Date dateLogged) {
        this.dateLogged = dateLogged;
    }
}
