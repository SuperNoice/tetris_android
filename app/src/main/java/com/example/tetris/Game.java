package com.example.tetris;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {
    public final GameField gameField;
    private List<List<Figure>> figures;
    private int rotation;
    private Figure nextFigure;
    public Figure currentFigure;
    private Random rand;
    private Context context;
    public int placeRowPos;
    public int placeColPos;
    private TextView scoreView;
    private TextView nextFigView;
    private int score = 0;

    public Game(Context context, TextView scoreView, TextView nextFigView) {
        this.scoreView = scoreView;
        this.nextFigView = nextFigView;
        this.context = context;
        gameField = new GameField(context);
        figures = new ArrayList<List<Figure>>();
        rotation = 0;
        rand = new Random();

        figures.add(Arrays.asList(new Figure("I0"), new Figure("I1"), new Figure("I2"), new Figure("I3")));
        figures.add(Arrays.asList(new Figure("O0"), new Figure("O1"), new Figure("O2"), new Figure("O3")));
        figures.add(Arrays.asList(new Figure("T0"), new Figure("T1"), new Figure("T2"), new Figure("T3")));
        figures.add(Arrays.asList(new Figure("L0"), new Figure("L1"), new Figure("L2"), new Figure("L3")));
        figures.add(Arrays.asList(new Figure("J0"), new Figure("J1"), new Figure("J2"), new Figure("J3")));
        figures.add(Arrays.asList(new Figure("Z0"), new Figure("Z1"), new Figure("Z2"), new Figure("Z3")));
        figures.add(Arrays.asList(new Figure("S0"), new Figure("S1"), new Figure("S2"), new Figure("S3")));

        currentFigure = figures.get(rand.nextInt(figures.size())).get(0);
        nextFigure = figures.get(rand.nextInt(figures.size())).get(0);
    }

    public synchronized void SetColPos(int pos) {
        placeColPos = pos;
    }

    private int findIndex(Figure fig) {
        for (int i = 0; i < figures.size(); ++i) {
            for (int j = 0; j < figures.get(i).size(); ++j) {
                if (figures.get(i).get(j) == fig) {
                    return i;
                }
            }
        }
        return 0;
    }

    public synchronized void Rotate() {
        if (placeRowPos != -1) {
            rotation += 1;
            currentFigure = figures.get(findIndex(currentFigure)).get(rotation % 4);
        }
    }

    public void Start() {
        Thread t = new Thread(() -> {

            ((Activity) context).runOnUiThread(() -> {
                scoreView.setText(context.getResources().getString(R.string.score) + "0");
            });

            ((Activity) context).runOnUiThread(() -> {
                nextFigView.setText(context.getResources().getString(R.string.nextFig) + nextFigure.name.substring(0, 1));
            });

            placeRowPos = -1;
            rotation = 0;
            SetColPos(4);
            List<List<Integer>> lastPositions = null;
            while (gameField.tryPlace(placeRowPos + 1, placeColPos, currentFigure, lastPositions)) {
                while (gameField.tryPlace(++placeRowPos, placeColPos, currentFigure, lastPositions)) {
                    try {


                        lastPositions = gameField.Place(placeRowPos, placeColPos, currentFigure);

                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException ignored) {
                        }
                        // clear last figure pos
                        if (gameField.tryPlace(placeRowPos + 1, placeColPos, currentFigure, lastPositions)) {
                            for (int i = 0; i < lastPositions.size(); ++i) {
                                gameField.field.get(lastPositions.get(i).get(0)).get(lastPositions.get(i).get(1)).setDefaultColor();
                            }
                        }
                    } catch (Exception ignored) {

                    }
                }
                rotation = 0;
                placeRowPos = -1;
                placeColPos = 4;
                try {


                    Integer sc = 0;
                    boolean f = true;
                    for (int i = 0; i < gameField.field.size(); ++i) {
                        for (int j = 0; j < gameField.field.get(0).size(); ++j) {
                            if (gameField.field.get(i).get(j).isEmpty()) {
                                f = false;
                            }
                        }
                        if (f) {
                            sc += 10;
                        }
                        f = true;
                    }
                    int nowsc = Integer.parseInt(scoreView.getText().toString().split(":")[1].trim());


                    //scoreView.setText(context.getResources().getString(R.string.score) + Integer.toString(nowsc - (sc - nowsc)));

                    currentFigure = nextFigure;
                    nextFigure = figures.get(rand.nextInt(figures.size())).get(0);
                    placeRowPos = -1;
                    Integer finalSc = sc;
                    score = sc;
                    ((Activity) context).runOnUiThread(() -> {
                        scoreView.setText(context.getResources().getString(R.string.score) + finalSc.toString());
                    });
                    ((Activity) context).runOnUiThread(() -> {
                        nextFigView.setText(context.getResources().getString(R.string.nextFig) + nextFigure.name.substring(0, 1));
                    });
                } catch (Exception ignored) {

                }
            }
            DB.getInstance(context).writeScore(score);

        });
        t.start();
    }
}
