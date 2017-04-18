package com.example.Elbase.loader;

import com.example.Elbase.model.Lesson;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Andrey Mikhailov on 19.04.2017.
 */

public abstract class BaseSheldureLoader {

    public static ArrayList<Lesson> lessons = new ArrayList();

    public ArrayList<Lesson> getScheldureItems(){
        return lessons;
    }

}
