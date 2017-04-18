package com.example.Elbase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.Elbase.R;
import com.example.Elbase.model.MenuItem;

import java.util.ArrayList;

/**
 * Created by Andrey Mikhailov on 21.02.2017.
 */
public class MenuAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    ArrayList<MenuItem> objects;

    public MenuAdapter(Context context, ArrayList<MenuItem> items){
        this.context = context;
        this.objects = items;
        this.layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
            view = layoutInflater.inflate(R.layout.menu_item, parent, false);
        }
        MenuItem i = getMenuItem(position);
        ((TextView) view.findViewById(R.id.name)).setText(i.getName());
        return view;
    }

    MenuItem getMenuItem(int position) {
        return (MenuItem) getItem(position);
    }
}
