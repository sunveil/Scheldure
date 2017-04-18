package com.example.Elbase.model;

import java.util.Date;

/**
 * Created by Andrey Mikhailov on 21.02.2017.
 */

public class Lesson {

    private String name;
    private Date start;
    private Date end;
    private String auditorium;

    public Lesson(String name, Date start, Date end,
                  String auditorium) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.auditorium = auditorium;
    }

    public String getName() {
        return name;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getAuditorium() {
        return auditorium;
    }
}
