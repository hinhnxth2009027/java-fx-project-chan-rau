package myapplication.models;

import com.sun.xml.internal.bind.v2.model.core.ID;
import myapplication.MainRoot;
import myapplication.enity.User;

import java.sql.Connection;

public interface UserFastfood {
    Connection connection();
    boolean addUser(User user);
    boolean addMoney(int ID,double money);
    boolean addFoodTocard(int ID,String foodInfo);
    boolean addFoodToListLoveFood(int ID,String foodInfo);
    User login(String username,String password);
}