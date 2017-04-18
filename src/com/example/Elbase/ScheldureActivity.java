package com.example.Elbase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.Elbase.adapter.ScheldureAdapter;
import com.example.Elbase.loader.ScheldureLoader;
import com.example.Elbase.model.Lesson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by sun on 21.02.2017.
 */
public class ScheldureActivity extends Activity {

    private ArrayList<Lesson> lessons = new ArrayList();
    ScheldureAdapter sheldureAdapter;
    ScheldureLoader sl;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scheldure);
        /*try {
            sl = new ScheldureLoader();
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        sheldureAdapter = new ScheldureAdapter(this, ScheldureLoader.lessons);
        ListView scheldure = (ListView) findViewById(R.id.scheldure);
        scheldure.addHeaderView(createHeader());
        //scheldure.addFooterView(createFooter());
        scheldure.setAdapter(sheldureAdapter);
        scheldure.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), ScheldureEdit.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        sheldureAdapter.notifyDataSetChanged();
    }

    private View createHeader(){
        View v = getLayoutInflater().inflate(R.layout.sldr_header, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:mm:yy");
        String curDate = sdf.format(calendar.getTime());
        SimpleDateFormat sdf_ = new SimpleDateFormat("EEEE");
        String dayName = sdf_.format(calendar.getTime());
        textView.setText(curDate + " " + dayName);
        return v;
    }
}
