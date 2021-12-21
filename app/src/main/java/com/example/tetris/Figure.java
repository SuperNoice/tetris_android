package com.example.tetris;

import androidx.annotation.DrawableRes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Figure {
    public final List<List<Boolean>> figure;
    public final int colSize;
    public final int rowSize;
    @DrawableRes
    public final int color;
    public final String name;

    public Figure(String fig) {
        figure = new ArrayList<List<Boolean>>();
        name = fig;

        switch (fig) {
            case "I0":
                figure.add(Arrays.asList(true, true, true, true));
                colSize = 4;
                rowSize = 1;
                color = R.color.fig1;
                break;
            case "I1":
                figure.add(Arrays.asList(true));
                figure.add(Arrays.asList(true));
                figure.add(Arrays.asList(true));
                figure.add(Arrays.asList(true));
                colSize = 1;
                rowSize = 4;
                color = R.color.fig1;
                break;
            case "I2":
                figure.add(Arrays.asList(true, true, true, true));
                colSize = 4;
                rowSize = 1;
                color = R.color.fig1;
                break;
            case "I3":
                figure.add(Arrays.asList(true));
                figure.add(Arrays.asList(true));
                figure.add(Arrays.asList(true));
                figure.add(Arrays.asList(true));
                colSize = 1;
                rowSize = 4;
                color = R.color.fig1;
                break;
            case "O0":
                figure.add(Arrays.asList(true, true));
                figure.add(Arrays.asList(true, true));
                colSize = 2;
                rowSize = 2;
                color = R.color.fig2;
                break;
            case "O1":
                figure.add(Arrays.asList(true, true));
                figure.add(Arrays.asList(true, true));
                colSize = 2;
                rowSize = 2;
                color = R.color.fig2;
                break;
            case "O2":
                figure.add(Arrays.asList(true, true));
                figure.add(Arrays.asList(true, true));
                colSize = 2;
                rowSize = 2;
                color = R.color.fig2;
                break;
            case "O3":
                figure.add(Arrays.asList(true, true));
                figure.add(Arrays.asList(true, true));
                colSize = 2;
                rowSize = 2;
                color = R.color.fig2;
                break;
            case "T0":
                figure.add(Arrays.asList(true, true, true));
                figure.add(Arrays.asList(false, true, false));
                colSize = 3;
                rowSize = 2;
                color = R.color.fig3;
                break;
            case "T1":
                figure.add(Arrays.asList(false, true));
                figure.add(Arrays.asList(true, true));
                figure.add(Arrays.asList(false, true));
                colSize = 2;
                rowSize = 3;
                color = R.color.fig3;
                break;
            case "T2":
                figure.add(Arrays.asList(false, true, false));
                figure.add(Arrays.asList(true, true, true));
                colSize = 3;
                rowSize = 2;
                color = R.color.fig3;
                break;
            case "T3":
                figure.add(Arrays.asList(true, false));
                figure.add(Arrays.asList(true, true));
                figure.add(Arrays.asList(true, false));
                colSize = 2;
                rowSize = 3;
                color = R.color.fig3;
                break;
            case "L0":
                figure.add(Arrays.asList(true, true, true));
                figure.add(Arrays.asList(true, false, false));
                colSize = 3;
                rowSize = 2;
                color = R.color.fig4;
                break;
            case "L1":
                figure.add(Arrays.asList(true, true));
                figure.add(Arrays.asList(false, true));
                figure.add(Arrays.asList(false, true));
                colSize = 2;
                rowSize = 3;
                color = R.color.fig4;
                break;
            case "L2":
                figure.add(Arrays.asList(false, false, true));
                figure.add(Arrays.asList(true, true, true));
                colSize = 3;
                rowSize = 2;
                color = R.color.fig4;
                break;
            case "L3":
                figure.add(Arrays.asList(true, false));
                figure.add(Arrays.asList(true, false));
                figure.add(Arrays.asList(true, true));
                colSize = 2;
                rowSize = 3;
                color = R.color.fig4;
                break;
            case "J0":
                figure.add(Arrays.asList(true, true, true));
                figure.add(Arrays.asList(false, false, true));
                colSize = 3;
                rowSize = 2;
                color = R.color.fig5;
                break;
            case "J1":
                figure.add(Arrays.asList(false, true));
                figure.add(Arrays.asList(false, true));
                figure.add(Arrays.asList(true, true));
                colSize = 2;
                rowSize = 3;
                color = R.color.fig5;
                break;
            case "J2":
                figure.add(Arrays.asList(true, false, false));
                figure.add(Arrays.asList(true, true, true));
                colSize = 3;
                rowSize = 2;
                color = R.color.fig5;
                break;
            case "J3":
                figure.add(Arrays.asList(true, true));
                figure.add(Arrays.asList(true, false));
                figure.add(Arrays.asList(true, false));
                colSize = 2;
                rowSize = 3;
                color = R.color.fig5;
                break;
            case "Z0":
                figure.add(Arrays.asList(true, true, false));
                figure.add(Arrays.asList(false, true, true));
                colSize = 3;
                rowSize = 2;
                color = R.color.fig6;
                break;
            case "Z1":
                figure.add(Arrays.asList(false, true));
                figure.add(Arrays.asList(true, true));
                figure.add(Arrays.asList(true, false));
                colSize = 2;
                rowSize = 3;
                color = R.color.fig6;
                break;
            case "Z2":
                figure.add(Arrays.asList(true, true, false));
                figure.add(Arrays.asList(false, true, true));
                colSize = 3;
                rowSize = 2;
                color = R.color.fig6;
                break;
            case "Z3":
                figure.add(Arrays.asList(false, true));
                figure.add(Arrays.asList(true, true));
                figure.add(Arrays.asList(true, false));
                colSize = 2;
                rowSize = 3;
                color = R.color.fig6;
                break;
            case "S0":
                figure.add(Arrays.asList(false, true, true));
                figure.add(Arrays.asList(true, true, false));
                colSize = 3;
                rowSize = 2;
                color = R.color.fig7;
                break;
            case "S1":
                figure.add(Arrays.asList(true, false));
                figure.add(Arrays.asList(true, true));
                figure.add(Arrays.asList(false, true));
                colSize = 2;
                rowSize = 3;
                color = R.color.fig7;
                break;
            case "S2":
                figure.add(Arrays.asList(false, true, true));
                figure.add(Arrays.asList(true, true, false));
                colSize = 3;
                rowSize = 2;
                color = R.color.fig7;
                break;
            case "S3":
                figure.add(Arrays.asList(true, false));
                figure.add(Arrays.asList(true, true));
                figure.add(Arrays.asList(false, true));
                colSize = 2;
                rowSize = 3;
                color = R.color.fig7;
                break;
            default:
                colSize = 0;
                rowSize = 0;
                color = R.color.gameField;
                break;
        }
    }
}
