package com.example.edate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import java.util.List;



public class memadapter extends ArrayAdapter{
    private final int resourceId;

    public memadapter(Context context, int textViewResourceId, List<mem> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mem mem0 = (mem) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView fruitImage = (TextView) view.findViewById(R.id.date1);
        TextView fruitName = (TextView) view.findViewById(R.id.mem1);
        fruitImage.setText(mem0.getdate().toString());
        fruitName.setText(mem0.getmemo());
        return view;
    }
}