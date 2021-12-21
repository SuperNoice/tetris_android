package com.example.tetris;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameField {
    public final List<List<FieldCell>> field;
    private final int rowSize = 20;
    private final int colSize = 10;

    public GameField(Context context) {
        field = new ArrayList<List<FieldCell>>(rowSize);
        for (int i = 0; i < rowSize; ++i) {
            List<FieldCell> columns = new ArrayList<FieldCell>();

            for (int j = 0; j < colSize; ++j) {
                FieldCell cell = new FieldCell(context);
                //cell.getView().setText("Gays");
                columns.add(cell);
            }

            field.add(columns);
        }
    }

    public List<TextView> getFlat() {
        List<TextView> result = new ArrayList<>();
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                result.add(field.get(i).get(j).getView());
            }
        }
        return result;
    }

    private boolean CheckPredCord(int i, int j, List<List<Integer>> predFigCord) {
        if (predFigCord == null) {
            return false;
        }
        for (int ind = 0; ind < predFigCord.size(); ++ind) {
            if (predFigCord.get(ind).get(0).equals(i) && predFigCord.get(ind).get(1).equals(j)) {
                return true;
            }
        }
        return false;
    }

    public boolean tryPlace(int row, int col, Figure figure, List<List<Integer>> predFigCord) {
        if (col + figure.colSize - 1 >= colSize || row + figure.rowSize - 1 >= rowSize || row < 0 || col < 0) {
            return false;
        }

        for (int i = 0; i < figure.rowSize; ++i) {
            for (int j = 0; j < figure.colSize; ++j) {
                if (figure.figure.get(i).get(j) && !field.get(row + i).get(col + j).isEmpty() && !CheckPredCord(row + i, col + j, predFigCord)) {
                    return false;
                }
            }
        }

        return true;
    }

    public List<List<Integer>> Place(int row, int col, Figure figure) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < figure.rowSize; ++i) {
            for (int j = 0; j < figure.colSize; ++j) {
                if (figure.figure.get(i).get(j)) {
                    field.get(row + i).get(col + j).setColor(figure.color);
                    result.add(Arrays.asList(row + i, col + j));
                }
            }
        }

        return result;
    }
}
