package com.example.Elbase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.Elbase.adapter.MenuAdapter;
import com.example.Elbase.loader.BaseSheldureLoader;
import com.example.Elbase.loader.JsonSheldureLoader;
import com.example.Elbase.loader.MenuLoader;
import com.example.Elbase.loader.ScheldureLoader;
import com.example.Elbase.model.MenuItem;

import java.text.ParseException;

public class MainActivity extends Activity {

    private MenuAdapter menuAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        BaseSheldureLoader sl = new JsonSheldureLoader("http://84.237.23.16/vlab/shld.php?get=all");
        MenuLoader menuLoader = new MenuLoader();
        menuAdapter = new MenuAdapter(this, menuLoader.getMenuItems());
        ListView mainMenu = (ListView) findViewById(R.id.main_menu);
        mainMenu.addHeaderView(createHeader());
        mainMenu.setAdapter(menuAdapter);
        mainMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuItem i = (MenuItem) parent.getAdapter().getItem(position);
                if (i instanceof MenuItem) {
                    if (i.getName().equals("Расписание")) {
                        Intent intent = new Intent(view.getContext(), ScheldureActivity.class);
                        intent.putExtra("name", i.getName());
                        startActivity(intent);
                    } else if (i.getName().equals("Выйти")) {
                        finish();
                    }

                }
            }
        });
    }

    private View createHeader(){
        View v = getLayoutInflater().inflate(R.layout.main_menu_header, null);
        return v;
    }
}
