package com.example.tetris;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        ListView view = findViewById(R.id.recyclerView);
        List<Integer> scores = DB.getInstance(this).getScoreTable();
        MyAdapter adapter = new MyAdapter(this, R.layout.list_item, scores);
        view.setAdapter(adapter);
    }
}