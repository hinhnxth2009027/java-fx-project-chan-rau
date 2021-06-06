package myapplication.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import myapplication.models.modelsfood;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import myapplication.MainRoot;
import myapplication.enity.Food;
import myapplication.models.modelsfood;
import myapplication.enity.User;
import myapplication.view.pobup.Addmoney;
import myapplication.view.pobup.EditAddress;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.PrimitiveIterator;
public class HomePage extends Stage {
    //navbar
    private Label Usertxt;
    private Label Uservls;
    private Label balancetxt;
    private Label balancevls;
    private Label addresstxt;
    private Label addressvls;
    private Label logout_txt;
    private Label cardSize;
    private Button btnAddMoney;
    private Button btnEditAddress;
    private Button btnlogout;
    private Button btnCard;
    //null
    private Label nullforUservls;
    private Label nullforbalancevls;
    private Label nullforaddressvls;
    private Label nullforlogout_txt;
    //null
    //container
    private HBox navbarContainer;
    //container
    //navbar
    //Menu bar
    private Label newFood;
    private Label hotFood;
    private Label Drink;
    private HBox containerMenu;
    //Menu bar
    //content
    private GridPane content;
    private ScrollPane scrollPane;
    //content
     //appliation container
    private VBox container;
    private Scene scene;
    private Stage stage;
     //appliation container
    private MainRoot mainRoot = new MainRoot();
    private HashMap<Button,Integer> btnbuys;
    //enity
    private User user;
    //enity
    private static int index;
    public HomePage(User user) {
        this.user=user;
        initComponent(this.user);
        this.scene = new Scene(this.container);
        this.stage = this;
        this.stage.setScene(scene);
        this.stage.show();
        this.scene.getStylesheets().add("file:///C:/Users/5470/IdeaProjects/javaFxtutorial2/src/main/java/Styles/Style.css");
        this.stage.getIcons().add(new Image("file:///C:/Users/5470/IdeaProjects/javaFxtutorial2/src/main/java/img/food-icon-vector-1344301.jpg"));
        this.stage.setMaximized(true);

    }
    public void initComponent(User user){
        this.Usertxt = new Label(" "+" User : ");
        this.Usertxt.getStyleClass().add("title");
        this.Uservls = new Label(this.user.getUsername());
        this.Uservls.getStyleClass().add("vls");
        this.balancetxt = new Label("balance : ");
        this.balancetxt.getStyleClass().add("title");
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.FLOOR);
        double result = new Double(df.format(this.user.getBalance()));
        String rs = String.valueOf(result);
        this.balancevls = new Label("$ "+rs+" "+" ");
        this.balancevls.getStyleClass().add("vls");
        this.btnAddMoney = new Button("+");
        this.btnAddMoney.getStyleClass().add("btnaddmoney");
        this.btnAddMoney.setOnMouseClicked(event -> {
            Addmoney addmoney = new Addmoney(this.user.getID(),this.user.getBalance());
            addmoney.show();
            addmoney.setOnCloseRequest(event1 -> {
                addmoney.close();
                this.show();
            });
            this.close();
        });
        this.addresstxt = new Label("Address : ");
        this.addresstxt.getStyleClass().add("title");
        this.addressvls = new Label(this.user.getAddress()+" "+" ");
        this.addressvls.getStyleClass().add("vls");
        this.btnEditAddress = new Button(" <- Edit");
        this.btnEditAddress.setOnMouseClicked(event -> {
            EditAddress editAddress = new EditAddress(this.user.getID());
            editAddress.show();
            this.close();
            editAddress.setOnCloseRequest(event1 -> {
                this.show();
                editAddress.close();
            });
        });
        this.btnEditAddress.getStyleClass().add("btnedit");
        this.logout_txt = new Label("Log-out "+" ");
        this.logout_txt.getStyleClass().add("title");
        this.btnlogout = new Button("[->]");
        this.btnlogout.getStyleClass().add("btnlogout");
        this.btnlogout.setOnMouseClicked(event -> {
            loginStage loginStage = new loginStage(this.mainRoot);
            this.user=null;
            this.close();
            loginStage.show();
        });
        this.btnCard = new Button("card");
        this.btnCard.getStyleClass().add("card");
        this.cardSize = new Label(" "+" 0");
        this.cardSize.getStyleClass().add("title");
        this.nullforUservls = new Label("");
        this.nullforUservls.setMinWidth(100);
        this.nullforbalancevls = new Label("");
        this.nullforbalancevls.setMinWidth(100);
        this.nullforlogout_txt = new Label("");
        this.nullforlogout_txt.setMinWidth(100);
        this.nullforaddressvls = new Label("");
        this.nullforaddressvls.setMinWidth(520);
        this.navbarContainer = new HBox();
        this.navbarContainer.getChildren().addAll(this.Usertxt,this.Uservls,this.nullforUservls,this.balancetxt,this.balancevls,this.btnAddMoney,this.nullforbalancevls,this.addresstxt,this.addressvls,this.btnEditAddress,this.nullforaddressvls,this.logout_txt,this.btnlogout,this.nullforlogout_txt,this.btnCard,this.cardSize);
        this.navbarContainer.getStyleClass().add("navmenuContainer");
        this.hotFood = new Label("Hot Food");
        this.hotFood.setMinWidth(130);
        this.newFood = new Label("New food");
        this.newFood.setMinWidth(130);
        this.Drink = new Label("Drink");
        this.Drink.getStyleClass().add("fillter");
        this.newFood.getStyleClass().add("fillter");
        this.hotFood.getStyleClass().add("fillter");
        this.hotFood.getStyleClass().add("active");

        this.hotFood.setOnMouseEntered(event -> {
            this.scene.setCursor(Cursor.HAND);
        });
        this.hotFood.setOnMouseExited(event -> {
            this.scene.setCursor(Cursor.DEFAULT);
        });
        this.newFood.setOnMouseEntered(event -> {
            this.scene.setCursor(Cursor.HAND);
        });
        this.newFood.setOnMouseExited(event -> {
            this.scene.setCursor(Cursor.DEFAULT);
        });
        this.Drink.setOnMouseEntered(event -> {
            this.scene.setCursor(Cursor.HAND);
        });
        this.Drink.setOnMouseExited(event -> {
            this.scene.setCursor(Cursor.DEFAULT);
        });
        this.content = new GridPane();
        modelsfood modelsfood = new modelsfood();
        ArrayList<Food> conntents = modelsfood.getnewfood("select * from food where foodtype = 1");
        for (int i = 0; i < conntents.size(); i+=5) {
            Food foods = conntents.get(i);
            Label name = new Label(foods.getName());
            name.setTextFill(Color.GREEN);
            name.setFont(Font.font("Tahoma",15));
            Label price = new Label("$ "+String.valueOf(foods.getPrice()));
            price.setTextFill(Color.RED);
            price.setFont(Font.font("Tahoma",25));
            Button btnbuy = new Button("BUY");
            Button detail = new Button("Detail");
            btnbuy.setMinWidth(80);
            btnbuy.setOnMouseClicked(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                ButtonType buttonTypeyes = new ButtonType("OKe",ButtonBar.ButtonData.YES);
                ButtonType buttonTypecancel = new ButtonType("Cancel",ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(buttonTypeyes,buttonTypecancel);
                Optional<ButtonType> Result = alert.showAndWait();
                if (Result.get() == buttonTypeyes){
                    String[] balancevvs = String.valueOf(this.balancevls).split(" ");
                    if (foods.getPrice() <= Double.parseDouble(balancevvs[2])){
                        String[] balancev = String.valueOf(this.balancevls).split(" ");
                        double new_balance = Double.parseDouble(balancev[2])-foods.getPrice();
                        modelsfood modelsfood1 = new modelsfood();
                        if (modelsfood1.buyfood(this.user.getID(),new_balance) != 0){
                            double a = modelsfood1.buyfood(this.user.getID(),new_balance);
                            DecimalFormat df1 = new DecimalFormat("#.##");
                            df.setRoundingMode(RoundingMode.FLOOR);
                            double result1 = new Double(df1.format(this.user.getBalance()));
                            String rs1 = String.valueOf(a);
                            this.balancevls.setText("$ "+rs1+" "+" ");
                        }else {
                            Alert alert1 = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("thanh toán thất bại");
                            alert.setContentText("thanh toán thất bại vui lòng kiểm tra internet");
                            alert.show();
                        }
                    }else {
                        Alert alert1 = new Alert(Alert.AlertType.ERROR);
                        alert1.setTitle("không thể thanh toán");
                        alert1.setContentText("tài khoản của bạn không đủ để tiến hành thanh toán vui lòng nạp thêm");
                        alert1.show();
                    }
                }
            });
            detail.setMinWidth(80);
            VBox vBox = new VBox();
            vBox.getChildren().addAll(name,price,btnbuy,detail);
            vBox.setSpacing(5);
            vBox.setPadding(new Insets(10,0,0,0));
            Image image = new Image(foods.getImg());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(224);
            imageView.setFitHeight(150);
            imageView.getStyleClass().add("imgview");
            content.add(imageView,0,i);
            content.add(vBox,1,i);
            if (i+1<conntents.size()){
                Food foods1 = conntents.get(i+1);
                Label name1 = new Label(foods1.getName());
                name1.setTextFill(Color.GREEN);
                name1.setFont(Font.font("Tahoma",15));
                Label price1 = new Label("$ "+String.valueOf(foods1.getPrice()));
                price1.setTextFill(Color.RED);
                price1.setFont(Font.font("Tahoma",25));
                Button btnbuy1 = new Button("BUY");
                Button detail1 = new Button("Detail");
                btnbuy1.setMinWidth(80);
                btnbuy1.setOnMouseClicked(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    ButtonType buttonTypeyes = new ButtonType("OKe",ButtonBar.ButtonData.YES);
                    ButtonType buttonTypecancel = new ButtonType("Cancel",ButtonBar.ButtonData.CANCEL_CLOSE);
                    alert.getButtonTypes().setAll(buttonTypeyes,buttonTypecancel);
                    Optional<ButtonType> Result = alert.showAndWait();
                    if (Result.get() == buttonTypeyes){
                        String[] balancevvs = String.valueOf(this.balancevls).split(" ");
                        if (foods1.getPrice() <= Double.parseDouble(balancevvs[2])){
                            String[] balancev = String.valueOf(this.balancevls).split(" ");
                            double new_balance = Double.parseDouble(balancev[2])-foods1.getPrice();
                            modelsfood modelsfood1 = new modelsfood();
                            if (modelsfood1.buyfood(this.user.getID(),new_balance) != 0){
                                double a = modelsfood1.buyfood(this.user.getID(),new_balance);
                                DecimalFormat df1 = new DecimalFormat("#.##");
                                df.setRoundingMode(RoundingMode.FLOOR);
                                double result1 = new Double(df1.format(this.user.getBalance()));
                                String rs1 = String.valueOf(a);
                                this.balancevls.setText("$ "+rs1+" "+" ");
                            }else {
                                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("thanh toán thất bại");
                                alert.setContentText("thanh toán thất bại vui lòng kiểm tra internet");
                                alert.show();
                            }
                        }else {
                            Alert alert1 = new Alert(Alert.AlertType.ERROR);
                            alert1.setTitle("không thể thanh toán");
                            alert1.setContentText("tài khoản của bạn không đủ để tiến hành thanh toán vui lòng nạp thêm");
                            alert1.show();
                        }
                    }
                });
                detail1.setMinWidth(80);
                VBox vBox1 = new VBox();
                vBox1.getChildren().addAll(name1,price1,btnbuy1,detail1);
                vBox1.setSpacing(5);
                vBox1.setPadding(new Insets(10,0,0,0));
                Image image1 = new Image(foods1.getImg());
                ImageView imageView1 = new ImageView(image1);
                imageView1.setFitWidth(224);
                imageView1.setFitHeight(150);
                imageView1.getStyleClass().add("imgview");
                content.add(imageView1,2,i);
                content.add(vBox1,3,i);
            }
            if (i+2<conntents.size()){
                Food foods2 = conntents.get(i+2);
                Label name2 = new Label(foods2.getName());
                name2.setTextFill(Color.GREEN);
                name2.setFont(Font.font("Tahoma",15));
                Label price2 = new Label("$ "+String.valueOf(foods2.getPrice()));
                price2.setTextFill(Color.RED);
                price2.setFont(Font.font("Tahoma",25));
                Button btnbuy2 = new Button("BUY");
                Button detail2 = new Button("Detail");
                btnbuy2.setMinWidth(80);
                btnbuy2.setOnMouseClicked(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    ButtonType buttonTypeyes = new ButtonType("OKe",ButtonBar.ButtonData.YES);
                    ButtonType buttonTypecancel = new ButtonType("Cancel",ButtonBar.ButtonData.CANCEL_CLOSE);
                    alert.getButtonTypes().setAll(buttonTypeyes,buttonTypecancel);
                    Optional<ButtonType> Result = alert.showAndWait();
                    if (Result.get() == buttonTypeyes){
                        String[] balancevvs = String.valueOf(this.balancevls).split(" ");
                        if (foods2.getPrice() <= Double.parseDouble(balancevvs[2])){
                            String[] balancev = String.valueOf(this.balancevls).split(" ");
                            double new_balance = Double.parseDouble(balancev[2])-foods2.getPrice();
                            modelsfood modelsfood1 = new modelsfood();
                            if (modelsfood1.buyfood(this.user.getID(),new_balance) != 0){
                                double a = modelsfood1.buyfood(this.user.getID(),new_balance);
                                DecimalFormat df1 = new DecimalFormat("#.##");
                                df.setRoundingMode(RoundingMode.FLOOR);
                                double result1 = new Double(df1.format(this.user.getBalance()));
                                String rs1 = String.valueOf(a);
                                this.balancevls.setText("$ "+rs1+" "+" ");
                            }else {
                                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("thanh toán thất bại");
                                alert.setContentText("thanh toán thất bại vui lòng kiểm tra internet");
                                alert.show();
                            }
                        }else {
                            Alert alert1 = new Alert(Alert.AlertType.ERROR);
                            alert1.setTitle("không thể thanh toán");
                            alert1.setContentText("tài khoản của bạn không đủ để tiến hành thanh toán vui lòng nạp thêm");
                            alert1.show();
                        }
                    }
                });
                detail2.setMinWidth(80);
                VBox vBox2 = new VBox();
                vBox2.getChildren().addAll(name2,price2,btnbuy2,detail2);
                vBox2.setSpacing(5);
                vBox2.setPadding(new Insets(10,0,0,0));
                Image image2 = new Image(foods2.getImg());
                ImageView imageView2 = new ImageView(image2);
                imageView2.setFitWidth(224);
                imageView2.setFitHeight(150);
                imageView2.getStyleClass().add("imgview");
                content.add(imageView2,4,i);
                content.add(vBox2,5,i);
            }
            if (i+3<conntents.size()){
                Food foods2 = conntents.get(i+3);
                Label name2 = new Label(foods2.getName());
                name2.setTextFill(Color.GREEN);
                name2.setFont(Font.font("Tahoma",15));
                Label price2 = new Label("$ "+String.valueOf(foods2.getPrice()));
                price2.setTextFill(Color.RED);
                price2.setFont(Font.font("Tahoma",25));
                Button btnbuy2 = new Button("BUY");
                Button detail2 = new Button("Detail");
                btnbuy2.setMinWidth(80);
                btnbuy2.setOnMouseClicked(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    ButtonType buttonTypeyes = new ButtonType("OKe",ButtonBar.ButtonData.YES);
                    ButtonType buttonTypecancel = new ButtonType("Cancel",ButtonBar.ButtonData.CANCEL_CLOSE);
                    alert.getButtonTypes().setAll(buttonTypeyes,buttonTypecancel);
                    Optional<ButtonType> Result = alert.showAndWait();
                    if (Result.get() == buttonTypeyes){
                        String[] balancevvs = String.valueOf(this.balancevls).split(" ");
                        if (foods2.getPrice() <= Double.parseDouble(balancevvs[2])){
                            String[] balancev = String.valueOf(this.balancevls).split(" ");
                            double new_balance = Double.parseDouble(balancev[2])-foods2.getPrice();
                            modelsfood modelsfood1 = new modelsfood();
                            if (modelsfood1.buyfood(this.user.getID(),new_balance) != 0){
                                double a = modelsfood1.buyfood(this.user.getID(),new_balance);
                                DecimalFormat df1 = new DecimalFormat("#.##");
                                df.setRoundingMode(RoundingMode.FLOOR);
                                double result1 = new Double(df1.format(this.user.getBalance()));
                                String rs1 = String.valueOf(a);
                                this.balancevls.setText("$ "+rs1+" "+" ");
                            }else {
                                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("thanh toán thất bại");
                                alert.setContentText("thanh toán thất bại vui lòng kiểm tra internet");
                                alert.show();
                            }
                        }else {
                            Alert alert1 = new Alert(Alert.AlertType.ERROR);
                            alert1.setTitle("không thể thanh toán");
                            alert1.setContentText("tài khoản của bạn không đủ để tiến hành thanh toán vui lòng nạp thêm");
                            alert1.show();
                        }
                    }
                });
                detail2.setMinWidth(80);
                VBox vBox2 = new VBox();
                vBox2.getChildren().addAll(name2,price2,btnbuy2,detail2);
                vBox2.setSpacing(5);
                vBox2.setPadding(new Insets(10,0,0,0));
                Image image2 = new Image(foods2.getImg());
                ImageView imageView2 = new ImageView(image2);
                imageView2.setFitWidth(224);
                imageView2.setFitHeight(150);
                imageView2.getStyleClass().add("imgview");
                content.add(imageView2,6,i);
                content.add(vBox2,7,i);
            }
            if (i+4<conntents.size()){
                Food foods2 = conntents.get(i+4);
                Label name2 = new Label(foods2.getName());
                name2.setTextFill(Color.GREEN);
                name2.setFont(Font.font("Tahoma",15));
                Label price2 = new Label("$ "+String.valueOf(foods2.getPrice()));
                price2.setTextFill(Color.RED);
                price2.setFont(Font.font("Tahoma",25));
                Button btnbuy2 = new Button("BUY");
                Button detail2 = new Button("Detail");
                btnbuy2.setMinWidth(80);
                btnbuy2.setOnMouseClicked(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    ButtonType buttonTypeyes = new ButtonType("OKe",ButtonBar.ButtonData.YES);
                    ButtonType buttonTypecancel = new ButtonType("Cancel",ButtonBar.ButtonData.CANCEL_CLOSE);
                    alert.getButtonTypes().setAll(buttonTypeyes,buttonTypecancel);
                    Optional<ButtonType> Result = alert.showAndWait();
                    if (Result.get() == buttonTypeyes){
                        String[] balancevvs = String.valueOf(this.balancevls).split(" ");
                        if (foods2.getPrice() <= Double.parseDouble(balancevvs[2])){
                            String[] balancev = String.valueOf(this.balancevls).split(" ");
                            double new_balance = Double.parseDouble(balancev[2])-foods2.getPrice();
                            modelsfood modelsfood1 = new modelsfood();
                            if (modelsfood1.buyfood(this.user.getID(),new_balance) != 0){
                                double a = modelsfood1.buyfood(this.user.getID(),new_balance);
                                DecimalFormat df1 = new DecimalFormat("#.##");
                                df.setRoundingMode(RoundingMode.FLOOR);
                                double result1 = new Double(df1.format(this.user.getBalance()));
                                String rs1 = String.valueOf(a);
                                this.balancevls.setText("$ "+rs1+" "+" ");
                            }else {
                                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("thanh toán thất bại");
                                alert.setContentText("thanh toán thất bại vui lòng kiểm tra internet");
                                alert.show();
                            }
                        }else {
                            Alert alert1 = new Alert(Alert.AlertType.ERROR);
                            alert1.setTitle("không thể thanh toán");
                            alert1.setContentText("tài khoản của bạn không đủ để tiến hành thanh toán vui lòng nạp thêm");
                            alert1.show();
                        }
                    }
                });
                detail2.setMinWidth(80);
                VBox vBox2 = new VBox();
                vBox2.getChildren().addAll(name2,price2,btnbuy2,detail2);
                vBox2.setSpacing(5);
                vBox2.setPadding(new Insets(10,0,0,0));
                Image image2 = new Image(foods2.getImg());
                ImageView imageView2 = new ImageView(image2);
                imageView2.setFitWidth(224);
                imageView2.setFitHeight(150);
                imageView2.getStyleClass().add("imgview");
                content.add(imageView2,8,i);
                content.add(vBox2,9,i);
            }
        }
        this.content.setAlignment(Pos.CENTER);
        this.content.setPadding(new Insets(10,20,10,20));
        this.content.setVgap(20);
        this.content.setHgap(20);
        this.scrollPane = new ScrollPane();
        this.scrollPane.setContent(content);
        this.scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        this.scrollPane.getStyleClass().add("containerAll");
        this.content.getStyleClass().add("containerAll");
        this.Drink.setMinWidth(130);
        this.containerMenu = new HBox();
        this.containerMenu.setAlignment(Pos.CENTER);
        this.containerMenu.setPadding(new Insets(20,0,0,0));
        this.containerMenu.getChildren().addAll(this.hotFood,this.newFood,this.Drink);
        this.containerMenu.getStyleClass().add("containerAll");
        this.container = new VBox();
        this.container.getChildren().addAll(this.navbarContainer,this.containerMenu,this.scrollPane);
        this.Drink.setOnMouseClicked(event -> {
            this.Drink.getStyleClass().add("active");
            this.newFood.getStyleClass().remove("active");
            this.hotFood.getStyleClass().remove("active");
            ArrayList<Food> conntents2 = modelsfood.getnewfood("select * from food where foodtype = 2");
            for (int i = 0; i < conntents2.size(); i+=5) {
                Food foods = conntents2.get(i);
                Label name = new Label(foods.getName());
                name.setTextFill(Color.GREEN);
                name.setFont(Font.font("Tahoma",15));
                Label price = new Label("$ "+String.valueOf(foods.getPrice()));
                price.setTextFill(Color.RED);
                price.setFont(Font.font("Tahoma",25));
                Button btnbuy = new Button("BUY");
                Button detail = new Button("Detail");
                btnbuy.setMinWidth(80);
                detail.setMinWidth(80);
                VBox vBox = new VBox();
                vBox.getChildren().addAll(name,price,btnbuy,detail);
                vBox.setSpacing(5);
                vBox.setPadding(new Insets(10,0,0,0));
                Image image = new Image(foods.getImg());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(224);
                imageView.setFitHeight(150);
                imageView.getStyleClass().add("imgview");
                content.add(imageView,0,i);
                content.add(vBox,1,i);
                if (i+1<conntents2.size()){
                    Food foods1 = conntents2.get(i+1);
                    Label name1 = new Label(foods1.getName());
                    name1.setTextFill(Color.GREEN);
                    name1.setFont(Font.font("Tahoma",15));
                    Label price1 = new Label("$ "+String.valueOf(foods1.getPrice()));
                    price1.setTextFill(Color.RED);
                    price1.setFont(Font.font("Tahoma",25));
                    Button btnbuy1 = new Button("BUY");
                    Button detail1 = new Button("Detail");
                    btnbuy1.setMinWidth(80);
                    detail1.setMinWidth(80);
                    VBox vBox1 = new VBox();
                    vBox1.getChildren().addAll(name1,price1,btnbuy1,detail1);
                    vBox1.setSpacing(5);
                    vBox1.setPadding(new Insets(10,0,0,0));
                    Image image1 = new Image(foods1.getImg());
                    ImageView imageView1 = new ImageView(image1);
                    imageView1.setFitWidth(224);
                    imageView1.setFitHeight(150);
                    imageView1.getStyleClass().add("imgview");
                    content.add(imageView1,2,i);
                    content.add(vBox1,3,i);
                }
                if (i+2<conntents2.size()){
                    Food foods2 = conntents2.get(i+2);
                    Label name2 = new Label(foods2.getName());
                    name2.setTextFill(Color.GREEN);
                    name2.setFont(Font.font("Tahoma",15));
                    Label price2 = new Label("$ "+String.valueOf(foods2.getPrice()));
                    price2.setTextFill(Color.RED);
                    price2.setFont(Font.font("Tahoma",25));
                    Button btnbuy2 = new Button("BUY");
                    Button detail2 = new Button("Detail");
                    btnbuy2.setMinWidth(80);
                    detail2.setMinWidth(80);
                    VBox vBox2 = new VBox();
                    vBox2.getChildren().addAll(name2,price2,btnbuy2,detail2);
                    vBox2.setSpacing(5);
                    vBox2.setPadding(new Insets(10,0,0,0));
                    Image image2 = new Image(foods2.getImg());
                    ImageView imageView2 = new ImageView(image2);
                    imageView2.setFitWidth(224);
                    imageView2.setFitHeight(150);
                    imageView2.getStyleClass().add("imgview");
                    content.add(imageView2,4,i);
                    content.add(vBox2,5,i);
                }
                if (i+3<conntents2.size()){
                    Food foods2 = conntents2.get(i+3);
                    Label name2 = new Label(foods2.getName());
                    name2.setTextFill(Color.GREEN);
                    name2.setFont(Font.font("Tahoma",15));
                    Label price2 = new Label("$ "+String.valueOf(foods2.getPrice()));
                    price2.setTextFill(Color.RED);
                    price2.setFont(Font.font("Tahoma",25));
                    Button btnbuy2 = new Button("BUY");
                    Button detail2 = new Button("Detail");
                    btnbuy2.setMinWidth(80);
                    detail2.setMinWidth(80);
                    VBox vBox2 = new VBox();
                    vBox2.getChildren().addAll(name2,price2,btnbuy2,detail2);
                    vBox2.setSpacing(5);
                    vBox2.setPadding(new Insets(10,0,0,0));
                    Image image2 = new Image(foods2.getImg());
                    ImageView imageView2 = new ImageView(image2);
                    imageView2.setFitWidth(224);
                    imageView2.setFitHeight(150);
                    imageView2.getStyleClass().add("imgview");
                    content.add(imageView2,6,i);
                    content.add(vBox2,7,i);
                }
                if (i+4<conntents2.size()){
                    Food foods2 = conntents2.get(i+4);
                    Label name2 = new Label(foods2.getName());
                    name2.setTextFill(Color.GREEN);
                    name2.setFont(Font.font("Tahoma",15));
                    Label price2 = new Label("$ "+String.valueOf(foods2.getPrice()));
                    price2.setTextFill(Color.RED);
                    price2.setFont(Font.font("Tahoma",25));
                    Button btnbuy2 = new Button("BUY");

                    Button detail2 = new Button("Detail");
                    btnbuy2.setMinWidth(80);
                    detail2.setMinWidth(80);
                    VBox vBox2 = new VBox();
                    vBox2.getChildren().addAll(name2,price2,btnbuy2,detail2);
                    vBox2.setSpacing(5);
                    vBox2.setPadding(new Insets(10,0,0,0));
                    Image image2 = new Image(foods2.getImg());
                    ImageView imageView2 = new ImageView(image2);
                    imageView2.setFitWidth(224);
                    imageView2.setFitHeight(150);
                    imageView2.getStyleClass().add("imgview");
                    content.add(imageView2,8,i);
                    content.add(vBox2,9,i);
                }
            }
        });
        this.newFood.setOnMouseClicked(event -> {
            this.Drink.getStyleClass().remove("active");
            this.newFood.getStyleClass().add("active");
            this.hotFood.getStyleClass().remove("active");
        });
        this.hotFood.setOnMouseClicked(event -> {
            this.Drink.getStyleClass().remove("active");
            this.newFood.getStyleClass().remove("active");
            this.hotFood.getStyleClass().add("active");
        });
    }
}