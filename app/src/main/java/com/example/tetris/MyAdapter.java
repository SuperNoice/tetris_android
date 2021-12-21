package com.example.tetris;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Integer> {
    private LayoutInflater inflater;
    private int layout;
    private List<Integer> scores;

    public MyAdapter(Context context, int resource, List<Integer> scores) {
        super(context, resource, scores);
        this.scores = scores;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
        Collections.sort(this.scores, Collections.reverseOrder());
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);

        TextView id = view.findViewById(R.id.id);
        TextView score = view.findViewById(R.id.score);

        Integer scoreVal = scores.get(position);

        id.setText(Integer.toString(position + 1));
        score.setText(scoreVal.toString());

        return view;
    }
}
