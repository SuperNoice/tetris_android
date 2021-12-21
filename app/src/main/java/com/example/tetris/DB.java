package com.example.tetris;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DB {

    private static DB instance = null;
    private SQLiteDatabase db;
    private Context context;

    private DB(Context context) {
        this.context = context;
        ConnOpen();
        initialize();
        ConnClose();
    }

    private void ConnOpen() {
        db = context.openOrCreateDatabase("app.db", 0, null);
    }

    private void ConnClose() {
        db.close();
    }

    private void initialize() {
        db.execSQL("CREATE TABLE IF NOT EXISTS score (id integer PRIMARY KEY AUTOINCREMENT, value integer);");
    }

    public static DB getInstance(Context context) {
        if (instance == null) {
            instance = new DB(context);
        }
        return instance;
    }

    public ArrayList<Integer> getScoreTable() {
        ArrayList<Integer> result = new ArrayList<>();
        ConnOpen();

        @SuppressLint("Recycle") Cursor query = db.rawQuery("SELECT * FROM score", null);
        while (query.moveToNext()) {
            result.add(query.getInt(1));
        }
        query.close();
        ConnClose();
        return result;
    }

    public void writeScore(Integer score) {
        ConnOpen();
        ContentValues values = new ContentValues();
        values.put("value", score);
        db.insert("score", null, values);
        ConnClose();
    }
}
