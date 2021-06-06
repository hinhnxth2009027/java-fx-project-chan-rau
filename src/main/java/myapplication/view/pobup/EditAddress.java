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


public class EditAddress extends Stage {

    private Label title;
    private Label addresslbl;
    private TextField addresstxt;
    private Button btnsubmit;
    private Button btnCancel;
    private GridPane btngroup;
    private GridPane lay_out;
    private Scene scene;
    private Stage stage;
    private int ID;




    public EditAddress(int ID){
        this.ID = ID;
        this.initcomponet(this.ID);
        this.scene = new Scene(lay_out,500,250);
        this.stage=this;
        this.stage.getIcons().add(new Image("file:///C:/Users/5470/IdeaProjects/javaFxtutorial2/src/main/java/img/food-icon-vector-1344301.jpg"));
        this.stage.setScene(scene);
    }

    public void initcomponet(int ID){
        this.title = new Label("Edit My Address");
        this.title.setTextFill(Color.RED);
        this.title.setFont(Font.font("Tahoma",25));
        this.addresslbl = new Label("new address");
        this.addresstxt = new TextField();
        this.addresstxt.setMinWidth(270);
        this.btnsubmit = new Button("Apply");
        Usermodels usermodels = new Usermodels();
        User user =  usermodels.getuserbyID(ID);
        this.addresstxt.setText(user.getAddress());
        this.btnsubmit.setOnMouseClicked(event -> {
            String newaddress = this.addresstxt.getText();
            if (newaddress.length()>20){

                usermodels.editaddress(ID,newaddress);
                this.close();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thay đổi chưa được áp dụng");
                alert.setContentText("vui lòng điền địa chỉ chi tiết hơn để bên dịch vụ ship dồ không gặp khó khăn trong quá trình vận chuyển !!!");
                alert.show();
            }
        });
        this.btngroup = new GridPane();
        this.btngroup.setHgap(10);
        this.btngroup.add(btnsubmit,0,0);
        this.lay_out = new GridPane();
        this.lay_out.setVgap(10);
        this.lay_out.setHgap(10);
        this.lay_out.setAlignment(Pos.CENTER);
        this.lay_out.add(title,1,0);
        this.lay_out.add(addresslbl,0,1);
        this.lay_out.add(addresstxt,1,1);
        this.lay_out.add(btngroup,1,2);
    }
}
