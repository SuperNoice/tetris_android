package com.example.tetris;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class GameFieldAdapter extends ArrayAdapter<TextView> {
    private LayoutInflater inflater;
    private int layout;
    private List<TextView> fieldCells;
    private Context context;

    public GameFieldAdapter(Context context, int resource, List<TextView> cells) {
        super(context, resource, cells);
        this.context = context;
        this.fieldCells = cells;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        TextView label = (TextView) convertView;

        if (convertView == null) {
            //convertView = LayoutInflater.from(context).inflate(R.layout.game_field_item, null, false);
            convertView = fieldCells.get(position);
            label = (TextView) convertView;
        }
        label.setText(fieldCells.get(position).getText());

        return (convertView);
    }
}
