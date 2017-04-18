package com.example.Elbase.loader;

import com.example.Elbase.model.Lesson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Andrey Mikhailov on 21.02.2017.
 */
public class ScheldureLoader extends BaseSheldureLoader {

    public ScheldureLoader() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        lessons.add(new Lesson("Ин. яз.", sdf.parse("10:10"), sdf.parse("11:40"), "310"));
        lessons.add(new Lesson("Матан", sdf.parse("11:50"), sdf.parse("13:10"), "221"));
        lessons.add(new Lesson("Функан", sdf.parse("13:50"), sdf.parse("15:20"), "208"));
        lessons.add(new Lesson("Вычмат", sdf.parse("15:30"), sdf.parse("17:00"), "106"));
        lessons.add(new Lesson("Дискретка", sdf.parse("17:10"), sdf.parse("18:40"), "218"));
    }
}
