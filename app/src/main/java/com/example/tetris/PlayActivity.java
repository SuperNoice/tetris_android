package com.example.tetris;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.OnSwipe;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        TextView Score = findViewById(R.id.scoreText);
        TextView nextFig = findViewById(R.id.nextFigText);

        Game game = new Game(this, Score, nextFig);

        GameFieldAdapter adapter = new GameFieldAdapter(this, R.layout.game_field_item, game.gameField.getFlat());
        GridView gridView = findViewById(R.id.gameField);
        gridView.setAdapter(adapter);
        gridView.setOnTouchListener(new OnSwipeTouchListener(this, game));

        game.Start();

    }
}