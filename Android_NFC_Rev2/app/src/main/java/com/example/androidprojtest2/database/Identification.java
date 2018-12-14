package com.example.androidprojtest2.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "identification_table")
public class Identification {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "tag")
    private String tag;

    @ColumnInfo(name = "description")
    private String description;

    public Identification(int id, String tag, String description) {
        this.id = id;
        this.tag = tag;
        this.description = description;
    }

    @Ignore
    public Identification(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() { return tag; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
