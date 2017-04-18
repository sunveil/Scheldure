package com.example.Elbase.loader;

import android.os.AsyncTask;
import android.os.Handler;
import android.widget.ListView;

import com.example.Elbase.model.Lesson;
import com.example.Elbase.utils.HTTPHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andrey Mikhailov on 19.04.2017.
 */

public class JsonSheldureLoader extends BaseSheldureLoader {


    private String reqUrl;
    ListView listView;

    public JsonSheldureLoader(String reqUrl){

        this.reqUrl = reqUrl;
        ScheldureLoader sld = new ScheldureLoader();
        sld.execute();

    }

    class ScheldureLoader extends AsyncTask<Void, Void, String> {


        @Override
        protected String doInBackground(Void... params)  {
            HTTPHandler handler = new HTTPHandler();
            String json = handler.get(reqUrl);
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i <  jsonArray.length(); i++) {
                    JSONObject lecture = jsonArray.getJSONObject(i);
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
                    Date start = sdf.parse(lecture.getString("start"));
                    Date end = sdf.parse(lecture.getString("end"));
                    Integer id = lecture.getInt("id");
                    String auditorium = lecture.getString("auditorium");
                    String name = lecture.getString("name");
                    Lesson lesson = new Lesson(name, start, end, auditorium);
                    lessons.add(lesson);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

}
