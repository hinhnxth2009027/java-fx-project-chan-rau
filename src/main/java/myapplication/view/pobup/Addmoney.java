package myapplication.view.pobup;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import myapplication.enity.User;
import myapplication.models.Usermodels;
import myapplication.view.HomePage;

import java.lang.management.ThreadInfo;

public class Addmoney extends Stage {
    private int ID;
    private double balance;
    private double balanceInput;

    private Label title;
    private Label amount;
    private Button btnsubmit;
    private Button CanCel;
    private TextField inputAmount;
    private GridPane buttongroub;
    private GridPane layout;
    private Scene scene;
    private Stage stage;


    public Addmoney(int ID , double balance){
        this.ID = ID;
        this.balance = balance;
        this.initcomponet(this.ID,this.balance);
        this.scene = new Scene(layout,500,250);
        this.stage = this;
        this.stage.getIcons().add(new Image("file:///C:/Users/5470/IdeaProjects/javaFxtutorial2/src/main/java/img/food-icon-vector-1344301.jpg"));
        this.stage.setScene(scene);
    }
    public void initcomponet(int ID , double balance ){
        this.title = new Label("Recharge");
        this.title.setTextFill(Color.RED);
        this.title.setFont(Font.font("tahoma",30));
        this.amount = new Label("Amount");
        this.inputAmount = new TextField();
        this.btnsubmit = new Button("proceed");
        this.buttongroub = new GridPane();
        this.buttongroub.setHgap(10);
        this.buttongroub.add(this.btnsubmit,0,0);
        this.layout = new GridPane();
        this.layout.setHgap(10);
        this.layout.setVgap(10);
        this.layout.add(this.title,1,0);
        this.layout.add(this.amount,0,1);
        this.layout.add(this.inputAmount,1,1);
        this.layout.add(buttongroub,1,2);
        this.layout.setAlignment(Pos.CENTER);
        this.btnsubmit.setOnMouseClicked(event -> {
            String[] c = this.inputAmount.getText().split("");
            boolean check = false;
            int a = c.length;
            int b = 0;

            for (int i = 0; i < c.length; i++) {
                if (c[i].equals("-")||c[i].equals("0")||c[i].equals("1")||c[i].equals("2")||c[i].equals("3")||c[i].equals("4")||c[i].equals("5")||c[i].equals("6")||c[i].equals("7")||c[i].equals("8")||c[i].equals("9")){
                 b++;
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Nạp tài khoản thất bại");
                    alert.setContentText("vui lòng nhập vào số tiền bạn muốn thêm(ở dạng số ví dụ '123,43,123' .v.v.v)");
                    alert.show();
                    break;
                }
                if (b==a){
                    check=true;
                }
                if (check==true){
                    Usermodels usermodels = new Usermodels();
                    double balanenew = this.balance+Double.parseDouble(this.inputAmount.getText());
                    usermodels.addMoney(this.ID,balanenew);
                    this.close();
                }

            }

        });
    }
}
