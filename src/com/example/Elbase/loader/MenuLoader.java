package com.example.Elbase.loader;

import com.example.Elbase.model.MenuItem;

import java.util.ArrayList;

/**
 * Created by Andrey Mikhailov on 21.02.2017.
 */
public class MenuLoader {

    private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

    public MenuLoader(){
        menuItems.add(new MenuItem("Расписание"));
        menuItems.add(new MenuItem("Лента"));
        menuItems.add(new MenuItem("Сообщения"));
        menuItems.add(new MenuItem("Избранное"));
        menuItems.add(new MenuItem("Настройки"));
        menuItems.add(new MenuItem("Выйти"));
    }

    public ArrayList<MenuItem> getMenuItems(){
        return menuItems;
    }
}
