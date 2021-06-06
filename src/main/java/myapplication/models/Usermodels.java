package myapplication.models;

import javafx.scene.control.Alert;
import myapplication.MainRoot;
import myapplication.enity.User;
import myapplication.view.HomePage;

import java.sql.*;

public class Usermodels implements UserFastfood{
    static Connection connection = null;
    static final String url = "jdbc:mysql://localhost:3306/fast_food";
    static final String userName = "root";
    static final String password = "nguyenxuanhjnh";
    static String SQL_addUser = String.format("insert into UserfastFood (username,password,phoneNumber,address,gender,createAt) values (?,?,?,?,?,?)");
    static String SQL_login = String.format("select * from UserfastFood where username = ? and password = ?");
    static String SQL_Addmoney = String.format("update UserfastFood set balance = ? where ID = ?");


    @Override
    public Connection connection() {
        try {
            if (connection == null){
                connection = DriverManager.getConnection(url,userName,password);
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

    @Override
    public boolean addUser(User user) {
        try {
            PreparedStatement preparedStatement = connection().prepareStatement(SQL_addUser);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getPhoneNumber());
            preparedStatement.setString(4,user.getAddress());
            preparedStatement.setInt(5,user.getGender());
            preparedStatement.setString(6,user.getCreateAt());
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create false");
            alert.setContentText("vui lòng kiểm tra lại dữ liệu đâng kí tài khoản");
            alert.show();
            return false;
        }
    }

    @Override
    public boolean addMoney(int ID, double money) {
        try {
            PreparedStatement preparedStatement = connection().prepareStatement(SQL_Addmoney);
            preparedStatement.setDouble(1,money);
            preparedStatement.setInt(2,ID);
            preparedStatement.execute();
            User user = getuserbyID(ID);
            HomePage homePage = new HomePage(user);
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }

    public User getuserbyID(int ID){
        try {
            PreparedStatement preparedStatement = connection().prepareStatement("select * from UserfastFood where ID = ?");
            preparedStatement.setInt(1,ID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()==true){
                int Id = rs.getInt("ID");
                String userName = rs.getString("username");
                String passworD = rs.getString("password");
                String phoneNumber = rs.getString("phoneNumber");
                String address = rs.getString("address");
                int gender = rs.getInt("gender");
                double balance = rs.getDouble("balance");
                String card = rs.getString("card");
                String lovefood = rs.getString("lovefood");
                String createAt = rs.getString("createAt");
                int Status = rs.getInt("status");
                User user = new User(Id,userName,passworD,phoneNumber,address,gender,Status,balance,card,lovefood,createAt);
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean addFoodTocard(int ID, String foodInfo) {
        return false;
    }

    @Override
    public boolean addFoodToListLoveFood(int ID, String foodInfo) {

        return false;
    }

    public boolean editaddress(int Id,String newaddress){
        try {
            PreparedStatement preparedStatement = connection().prepareStatement("update UserfastFood set address = ? where ID = ?");
            preparedStatement.setString(1,newaddress);
            preparedStatement.setInt(2,Id);
            preparedStatement.execute();
            User user = getuserbyID(Id);
            HomePage homePage = new HomePage(user);
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }

    @Override
    public User login(String username, String password) {
        try {
            PreparedStatement preparedStatement = connection().prepareStatement(SQL_login);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()==true){
                int ID = rs.getInt("ID");
                String userName = rs.getString("username");
                String passworD = rs.getString("password");
                String phoneNumber = rs.getString("phoneNumber");
                String address = rs.getString("address");
                int gender = rs.getInt("gender");
                double balance = rs.getDouble("balance");
                String card = rs.getString("card");
                String lovefood = rs.getString("lovefood");
                String createAt = rs.getString("createAt");
                int Status = rs.getInt("status");
                User user = new User(ID,userName,passworD,phoneNumber,address,gender,Status,balance,card,lovefood,createAt);
                return user;
            }else {
                return null;
            }
        } catch (SQLException throwables) {
            return null;
        }
    }
}
