package com.example.tetris;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.DrawableRes;

public class FieldCell {
    private TextView view;
    private boolean isEmpty = true;

    public FieldCell(Context context) {
        view = (TextView) LayoutInflater.from(context).inflate(R.layout.game_field_item, null, false);
        view.setBackgroundResource(R.color.gameField);
    }

    public TextView getView() {
        return view;
    }

    public void setColor(@DrawableRes int color) {
        if (color != R.color.gameField) {
            isEmpty = false;
        } else {
            isEmpty = true;
        }
        view.setBackgroundResource(color);
    }

    public void setDefaultColor() {
        isEmpty = true;
        view.setBackgroundResource(R.color.gameField);
    }

    public boolean isEmpty(){
        return isEmpty;
    }
}
