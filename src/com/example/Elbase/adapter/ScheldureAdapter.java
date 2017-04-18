package com.example.Elbase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.Elbase.model.Lesson;
import com.example.Elbase.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Andrey Mikhailov on 21.02.2017.
 */
public class ScheldureAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    ArrayList<Lesson> objects;

    public ScheldureAdapter(Context context, ArrayList<Lesson> lessons){
        this.context = context;
        this.objects = lessons;
        this.layoutInflater = (LayoutInflater)
                this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.scheldure_item, parent, false);
        }
        Lesson l = getLesson(position);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        ((TextView) view.findViewById(R.id.name)).setText(l.getName());
        ((TextView) view.findViewById(R.id.start)).setText(sdf.format(l.getStart()));
        ((TextView) view.findViewById(R.id.end)).setText(sdf.format(l.getEnd()));
        ((TextView) view.findViewById(R.id.auditorium)).setText(l.getAuditorium());
        return view;
    }

    Lesson getLesson(int possition){
        return (Lesson) getItem(possition);
    }
}





































