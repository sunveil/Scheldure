package com.example.Elbase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.Elbase.adapter.MenuAdapter;
import com.example.Elbase.loader.ScheldureLoader;
import com.example.Elbase.model.Lesson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sunveil on 02.03.2017.
 */

public class ScheldureEdit extends Activity  {

    EditText sName;
    EditText aNum;
    EditText start;
    EditText end;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scheldure_edit_form);
        Button btn = (Button) findViewById(R.id.add_btn);
        sName = (EditText) findViewById(R.id.scheldure_name);
        aNum = (EditText) findViewById(R.id.auditorium_number);
        start = (EditText) findViewById(R.id.start_time);
        end = (EditText) findViewById(R.id.end_time);
        Integer id = this.getIntent().getIntExtra("id",0);
        Lesson l = ScheldureLoader.lessons.get(id-1);
        sName.setText(l.getName());
        aNum.setText(l.getAuditorium());
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        start.setText(sdf.format(l.getStart()));
        end.setText(sdf.format(l.getEnd()));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
                try {
                    Date d1 = sdf.parse(start.getText().toString());
                    Date d2 = sdf.parse(end.getText().toString());
                    ScheldureLoader.lessons.add(new Lesson(
                            sName.getText().toString(), d1, d2, aNum.getText().toString()
                    ));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
