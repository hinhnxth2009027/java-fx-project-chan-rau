package myapplication.models;

import javafx.scene.control.Alert;
import myapplication.enity.Food;

import java.sql.*;
import java.util.ArrayList;


public class modelsfood implements foodmanager{
    ArrayList<Food> hotfood = new ArrayList<>();
    ArrayList<Food> newfood = new ArrayList<>();
    ArrayList<Food> drink = new ArrayList<>();
    static Connection connection = null;
    String SQLaddfood = "insert into food (foodname,price,img,foodtype) values (?,?,?,?)";



    @Override
    public Connection connection() {
        try {
            if (connection==null){
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fast_food","root","nguyenxuanhjnh");
            }
            return connection;
        } catch (SQLException throwables) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No internet");
            alert.setContentText("Please check internet befor try again");
            alert.show();
            return null;
        }
    }

    public static void main(String[] args) {

    }

    @Override
    public boolean newfood(Food food) {
        try {
            PreparedStatement preparedStatement = connection().prepareStatement(SQLaddfood);
            preparedStatement.setString(1,food.getName());
            preparedStatement.setDouble(2,food.getPrice());
            preparedStatement.setString(3,food.getImg());
            preparedStatement.setInt(4,food.getFoodType());
            preparedStatement.execute();
            System.out.println("insert thafnh cong");
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }

    @Override
    public void getall(String sql) {

    }

    @Override
    public void gethotfood(String sql) {

    }

    @Override
    public ArrayList<Food> getnewfood(String sql) {
        try {
            PreparedStatement preparedStatement = connection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()==true){
                int ID = rs.getInt("ID");
                String name = rs.getString("foodname");
                Double price = rs.getDouble("price");
                int buycount = rs.getInt("buycount");
                String img = rs.getString("img");
                int foodtype = rs.getInt("foodtype");
                int status = rs.getInt("status");
                Food food = new Food(ID,name,img ,price,buycount,status,foodtype);
                newfood.add(food);
            }
            return newfood;
        } catch (SQLException throwables) {
            return null;
        }
    }

    @Override
    public void getdrink(String sql) {

    }

    public double buyfood(int ID1 , double newbalance){
            Usermodels usermodels = new Usermodels();
        try {
            PreparedStatement preparedStatement = usermodels.connection().prepareStatement("update UserfastFood set balance = ? where ID = ?");
            preparedStatement.setDouble(1,newbalance);
            preparedStatement.setInt(2,ID1);
            preparedStatement.execute();
            return newbalance;
        } catch (SQLException throwables) {
            return 0;
        }
    }

}
