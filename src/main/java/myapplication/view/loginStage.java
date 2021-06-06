package myapplication.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import myapplication.MainRoot;
import myapplication.enity.User;
import myapplication.models.Usermodels;
public class loginStage extends Stage {
    private GridPane layout;
    private GridPane btnGrip;
    private Label title;
    private Label lblUsername;
    private Label lblPassword;
    private Button btnLogin;
    private Button bntNextToregister;
    private TextField txtUsername;
    private PasswordField txtPassword;
    private MainRoot mainRoot;
    private Scene scene;
    private Stage stage;
    public loginStage(MainRoot mainRoot) {
        this.initComponent();
        this.mainRoot = mainRoot;
        this.scene = new Scene(this.layout, 550, 270);
        this.stage = this;
        this.stage.setTitle("Fast food login");
        this.stage.getIcons().add(new Image("file:///C:/Users/5470/IdeaProjects/javaFxtutorial2/src/main/java/img/food-icon-vector-1344301.jpg"));
        this.stage.setScene(this.scene);
    }
    public void initComponent() {
        this.layout = new GridPane();
        this.layout.setAlignment(Pos.CENTER);
        this.layout.setHgap(10);
        this.layout.setVgap(10);
        this.layout.setPadding(new Insets(10, 10, 10, 10));
        this.btnGrip = new GridPane();
        this.btnGrip.setHgap(10);
        this.title = new Label("Login");
        this.title.setFont(Font.font("tahoma", FontWeight.BOLD, 35));
        this.title.setTextFill(Color.RED);
        this.lblUsername = new Label("User name");
        this.lblUsername.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        this.lblPassword = new Label("Password");
        this.lblPassword.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        this.txtUsername = new TextField();
        this.txtUsername.setMinWidth(200);
        this.txtPassword = new PasswordField();
        this.txtPassword.setMinWidth(200);
        this.btnLogin = new Button("Login");
        this.btnLogin.setMinWidth(80);
        //event
        this.btnLogin.setOnMouseClicked(event -> {
            if (txtUsername.getText().length()<=0||txtPassword.getText().length()<=0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Không thể đang nhập khi để trắng thông tin bất kì trường nào ");
                alert.setContentText("bạn cần điền đầy đủ thông tin mà đã sử dụng để đang kí tài khoản nếu chưa có tài khoản hãy đến đăng kí");
                alert.show();
            }else if (txtUsername.getText().length()<=1||txtPassword.getText().length()<=5){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("tài khoản không tồn tạ");
                alert.setContentText("tài khoản này chưa được đang kí yêu cầu đăng kí tài khoản tại Register");
                alert.show();
            }else {
                String name = txtUsername.getText();
                String pass = txtPassword.getText();
                Usermodels usermodels = new Usermodels();
                User user = usermodels.login(name,pass);
                if (user==null){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("tài khoản không tồn tạ");
                    alert.setContentText("tài khoản này chưa được đang kí yêu cầu đăng kí tài khoản tại Register");
                    alert.show();
                }else {
                    HomePage homePage = new HomePage(user);
                    this.close();
                }
            }
        });
        this.bntNextToregister = new Button("Register");
        this.bntNextToregister.setMinWidth(80);
        this.bntNextToregister.setOnMouseClicked(event -> {
            Register register = new Register(this.mainRoot);
            register.show();
            this.close();
        });
        this.btnGrip.add(btnLogin, 0, 0);
        this.btnGrip.add(bntNextToregister, 1, 0);
        this.layout.add(title, 1, 0);
        this.layout.add(lblUsername, 0, 1);
        this.layout.add(txtUsername, 1, 1);
        this.layout.add(lblPassword, 0, 2);
        this.layout.add(txtPassword, 1, 2);
        this.layout.add(btnGrip, 1, 3);
    }
}