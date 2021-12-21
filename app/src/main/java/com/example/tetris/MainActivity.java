package com.example.tetris;
import static com.example.tetris.R.layout.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(activity_main);
    }

    public void play_click(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }

    public void stat_click(View view) {
        Intent intent = new Intent(this, StatActivity.class);
        startActivity(intent);
    }

    public void settings_click(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}