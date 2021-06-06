package myapplication.models;

import myapplication.enity.Food;

import java.sql.Connection;
import java.util.ArrayList;

public interface foodmanager {
    Connection connection();

    boolean newfood(Food food);

    void getall(String sql);

    void gethotfood(String sql);

    ArrayList<Food> getnewfood(String sql);

    void getdrink(String sql);
}