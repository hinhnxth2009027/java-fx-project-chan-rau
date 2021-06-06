package myapplication.view;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import myapplication.MainRoot;
import myapplication.enity.User;
import myapplication.models.Usermodels;

import java.util.Calendar;

public class Register extends Stage {
    //mesager
    private Text errUsername = new Text();
    private Text errpass = new Text();
    private Text errPhone = new Text();
    private Text errAddress = new Text();
    //mesager
    static Calendar calendar = Calendar.getInstance();
    private Label lbltitle;
    private Label lblUsername;
    private Label lblPassword;
    private Label lblPhoneNumber;
    private Label lblgender;
    private Label lbladdress;
    private Label lbl_backToLogin;
    private TextField txtUsername;
    private PasswordField pwdPassword;
    private TextField txtPhonenumber;
    private RadioButton gender_male;
    private RadioButton gender_female;
    private TextField txtAddress;
    private Button btnSupmit;
    private Button btnReset;
    private GridPane btnGrip;
    private GridPane radioGrip;
    private GridPane layOut;
    private Scene scene;
    private Stage stage;
    private MainRoot mainRoot;
    final ToggleGroup group_gender = new ToggleGroup();

    public Register(MainRoot mainRoot) {
        this.initComponent();
        this.mainRoot = mainRoot;
        this.scene = new Scene(layOut, 550, 700);
        this.stage = this;
        this.stage.setTitle("Register");
        this.stage.getIcons().add(new Image("file:///C:/Users/5470/IdeaProjects/javaFxtutorial2/src/main/java/img/food-icon-vector-1344301.jpg"));
        this.stage.setScene(scene);
    }

    public void initComponent() {
        this.lbltitle = new Label("Register");
        this.lbltitle.setFont(Font.font("Tahoma", 35));
        this.lbltitle.setTextFill(Color.RED);
        this.lblUsername = new Label("User name");
        this.lblPassword = new Label("Password");
        this.lblPhoneNumber = new Label("Phone number");
        this.lblgender = new Label("Gender");
        this.lbladdress = new Label("Address");
        this.lbl_backToLogin = new Label("Back to login");
        this.lbl_backToLogin.setTextFill(Color.BLUE);
        this.lbl_backToLogin.setUnderline(true);
        this.lbl_backToLogin.setOnMouseEntered(event -> {
            this.lbl_backToLogin.setTextFill(Color.ORANGE);
            this.scene.setCursor(Cursor.HAND);
        });
        this.lbl_backToLogin.setOnMouseExited(event -> {
            this.lbl_backToLogin.setTextFill(Color.BLUE);
            this.scene.setCursor(Cursor.DEFAULT);
        });
        this.lbl_backToLogin.setOnMouseClicked(event -> {
            loginStage loginStage = new loginStage(this.mainRoot);
            loginStage.show();
            this.close();
        });
        this.txtUsername = new TextField();
        this.txtUsername.setMinWidth(220);
        this.txtUsername.setMaxWidth(220);
        this.pwdPassword = new PasswordField();
        this.pwdPassword.setMinWidth(170);
        this.pwdPassword.setMaxWidth(170);
        this.txtPhonenumber = new TextField();
        this.txtPhonenumber.setMinWidth(150);
        this.txtPhonenumber.setMaxWidth(150);
        this.gender_male = new RadioButton("Male");
        this.gender_male.setTextFill(Color.BLUE);
        this.gender_male.setToggleGroup(group_gender);
        this.gender_male.setSelected(true);
        this.gender_male.setOnMouseEntered(event -> {
            this.scene.setCursor(Cursor.HAND);
        });
        this.gender_male.setOnMouseExited(event -> {
            this.scene.setCursor(Cursor.DEFAULT);
        });
        this.gender_female = new RadioButton("Female");
        this.gender_female.setTextFill(Color.DARKVIOLET);
        this.gender_female.setToggleGroup(group_gender);
        this.gender_female.setOnMouseEntered(event -> {
            this.scene.setCursor(Cursor.HAND);
        });
        this.gender_female.setOnMouseExited(event -> {
            this.scene.setCursor(Cursor.DEFAULT);
        });
        this.txtAddress = new TextField();
        this.txtAddress.setMinWidth(320);
        this.txtAddress.setMaxWidth(320);
        this.btnSupmit = new Button("Submit");
        this.btnSupmit.setMinWidth(80);
        this.btnSupmit.setMaxWidth(80);
        this.btnSupmit.setOnMouseClicked(event -> {
            String username = null;
            String password = null;
            String phoneNumber = null;
            String address = null;
            int gender;
            if (gender_male.isSelected() == true) {
                gender = 1;
            } else {
                gender = 2;
            }
            if (txtUsername.getText().length() <= 0) {
                this.errUsername.setText("User name is required !!!");
                this.errUsername.setFill(Color.RED);
            } else {
                username = txtUsername.getText();
            }
            if (pwdPassword.getText().length() <= 0) {
                this.errpass.setText("Password is required !!!");
                this.errpass.setFill(Color.RED);
            } else {
                password = pwdPassword.getText();
            }
            if (txtPhonenumber.getText().length() <= 0) {
                this.errPhone.setText("Phone number is required !!!");
                this.errPhone.setFill(Color.RED);
            } else {
                if (txtPhonenumber.getText().length() >= 9 && txtPhonenumber.getText().length() < 12) {
                    String[] phoneCheckvalidation = txtPhonenumber.getText().split("");
                    boolean check;
                    if (phoneCheckvalidation[0].equals("+") && phoneCheckvalidation[1].equals("8") && phoneCheckvalidation[2].equals("4")) {
                        check = true;
                    } else {
                        check = false;
                    }
                    if (check) {
                        for (int i = 3; i < phoneCheckvalidation.length; i++) {
                            if (phoneCheckvalidation[i].equals("0") || phoneCheckvalidation[i].equals("1") || phoneCheckvalidation[i].equals("2") || phoneCheckvalidation[i].equals("3") || phoneCheckvalidation[i].equals("4") || phoneCheckvalidation[i].equals("5") || phoneCheckvalidation[i].equals("6") || phoneCheckvalidation[i].equals("7") || phoneCheckvalidation[i].equals("8") || phoneCheckvalidation[i].equals("9")) {
                                this.errPhone.setText("Phone number okie");
                                this.errPhone.setFill(Color.GREEN);
                                phoneNumber=txtPhonenumber.getText();
                            } else {
                                this.errPhone.setText("Số điện thoại sai định dạng");
                                this.errPhone.setFill(Color.RED);
                                break;
                            }
                        }
                    } else if (phoneCheckvalidation[0].equals("0")) {
                        for (int i = 0; i < phoneCheckvalidation.length; i++) {
                            if (phoneCheckvalidation[i].equals("0") || phoneCheckvalidation[i].equals("1") || phoneCheckvalidation[i].equals("2") || phoneCheckvalidation[i].equals("3") || phoneCheckvalidation[i].equals("4") || phoneCheckvalidation[i].equals("5") || phoneCheckvalidation[i].equals("6") || phoneCheckvalidation[i].equals("7") || phoneCheckvalidation[i].equals("8") || phoneCheckvalidation[i].equals("9")) {
                                this.errPhone.setText("Phone number okie");
                                this.errPhone.setFill(Color.GREEN);
                                phoneNumber=txtPhonenumber.getText();
                            } else {
                                this.errPhone.setText("Số điện thoại sai định dạng");
                                this.errPhone.setFill(Color.RED);
                                break;
                            }
                        }
                    }
                } else {
                    String[] b = txtPhonenumber.getText().split("");
                    if (b[0].equals("0")) {
                        if (9 - txtPhonenumber.getText().length() <= 0) {
                            String txterr = String.format("-----sai định dạng----");
                            this.errPhone.setText(txterr);
                            this.errPhone.setFill(Color.RED);
                        } else {
                            String txterr = String.format("-----nhập ít nhất %d kí nự nữa----", 9 - txtPhonenumber.getText().length());
                            this.errPhone.setText(txterr);
                            this.errPhone.setFill(Color.RED);
                        }
                    } else if (b[0].equals("+")) {
                        if (12 - txtPhonenumber.getText().length() <= 0) {
                            String txterr = String.format("-----sai định dạng----");
                            this.errPhone.setText(txterr);
                            this.errPhone.setFill(Color.RED);
                        } else {
                            String txterr = String.format("-----nhập ít nhất %d kí nự nữa----", 12 - txtPhonenumber.getText().length());
                            this.errPhone.setText(txterr);
                            this.errPhone.setFill(Color.RED);
                        }
                    } else {
                        String txterr = String.format("----- Số điện thoại sai định dạng(+84 or 0) ----");
                        this.errPhone.setText(txterr);
                        this.errPhone.setFill(Color.RED);
                    }
                }
                phoneNumber = txtPhonenumber.getText();
            }
            if (txtAddress.getText().length() <= 0) {
                this.errAddress.setText("Address is required !!!");
                this.errAddress.setFill(Color.RED);
            } else {
                address = txtAddress.getText();
            }

            if (username != null && password != null && phoneNumber!= null && address!= null){
                User user1 = new User(username,password,phoneNumber,address,gender,calendar.getTime().toString());
                Usermodels usermodels = new Usermodels();
                boolean create = usermodels.addUser(user1);
                if (create == true){
                    loginStage loginStage = new loginStage(this.mainRoot);
                    loginStage.show();
                    this.close();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Create success !!!");
                    alert.setContentText("chúc mừng bạn đã đăng kí thành công tài khoản hội viên của fast food !! bây giờ hãy tiến hành đang nhập nhé");
                    alert.show();
                }
            }
        });
        txtUsername.setOnKeyReleased(event -> {
            if (txtUsername.getText().length() > 2) {
                this.errUsername.setText("User name ok");
                this.errUsername.setFill(Color.GREEN);
            }
        });
        pwdPassword.setOnKeyReleased(event -> {
            if (pwdPassword.getText().length() <= 5) {
                errpass.setText("Pass chưa đủ an toàn");
                errpass.setFill(Color.ORANGE);
            } else if (pwdPassword.getText().length() > 5) {
                errpass.setText("Password ok");
                errpass.setFill(Color.GREEN);
            }
        });
        txtPhonenumber.setOnKeyReleased(event -> {
            if (txtPhonenumber.getText().length() >= 9 && txtPhonenumber.getText().length() < 12) {
                String[] phoneCheckvalidation = txtPhonenumber.getText().split("");
                boolean check;
                if (phoneCheckvalidation[0].equals("+") && phoneCheckvalidation[1].equals("8") && phoneCheckvalidation[2].equals("4")) {
                    check = true;
                } else {
                    check = false;
                }
                if (check) {
                    for (int i = 3; i < phoneCheckvalidation.length; i++) {
                        if (phoneCheckvalidation[i].equals("0") || phoneCheckvalidation[i].equals("1") || phoneCheckvalidation[i].equals("2") || phoneCheckvalidation[i].equals("3") || phoneCheckvalidation[i].equals("4") || phoneCheckvalidation[i].equals("5") || phoneCheckvalidation[i].equals("6") || phoneCheckvalidation[i].equals("7") || phoneCheckvalidation[i].equals("8") || phoneCheckvalidation[i].equals("9")) {
                            this.errPhone.setText("Phone number okie");
                            this.errPhone.setFill(Color.GREEN);
                        } else {
                            this.errPhone.setText("Số điện thoại sai định dạng");
                            this.errPhone.setFill(Color.RED);
                            break;
                        }
                    }
                } else if (phoneCheckvalidation[0].equals("0")) {
                    for (int i = 0; i < phoneCheckvalidation.length; i++) {
                        if (phoneCheckvalidation[i].equals("0") || phoneCheckvalidation[i].equals("1") || phoneCheckvalidation[i].equals("2") || phoneCheckvalidation[i].equals("3") || phoneCheckvalidation[i].equals("4") || phoneCheckvalidation[i].equals("5") || phoneCheckvalidation[i].equals("6") || phoneCheckvalidation[i].equals("7") || phoneCheckvalidation[i].equals("8") || phoneCheckvalidation[i].equals("9")) {
                            this.errPhone.setText("Phone number okie");
                            this.errPhone.setFill(Color.GREEN);
                        } else {
                            this.errPhone.setText("Số điện thoại sai định dạng");
                            this.errPhone.setFill(Color.RED);
                            break;
                        }
                    }
                }
            } else {
                String[] b = txtPhonenumber.getText().split("");
                if (b[0].equals("0")) {
                    if (9 - txtPhonenumber.getText().length() <= 0) {
                        String txterr = String.format("-----sai định dạng----");
                        this.errPhone.setText(txterr);
                        this.errPhone.setFill(Color.RED);
                    } else {
                        String txterr = String.format("-----nhập ít nhất %d kí nự nữa----", 9 - txtPhonenumber.getText().length());
                        this.errPhone.setText(txterr);
                        this.errPhone.setFill(Color.RED);
                    }
                } else if (b[0].equals("+")) {
                    if (12 - txtPhonenumber.getText().length() <= 0) {
                        String txterr = String.format("-----sai định dạng----");
                        this.errPhone.setText(txterr);
                        this.errPhone.setFill(Color.RED);
                    } else {
                        String txterr = String.format("-----nhập ít nhất %d kí nự nữa----", 12 - txtPhonenumber.getText().length());
                        this.errPhone.setText(txterr);
                        this.errPhone.setFill(Color.RED);
                    }
                } else {
                    String txterr = String.format("----- Số điện thoại sai định dạng(+84 or 0) ----");
                    this.errPhone.setText(txterr);
                    this.errPhone.setFill(Color.RED);
                }
            }
        });
        txtAddress.setOnKeyReleased(event -> {
            if (txtAddress.getText().length() <= 20 && txtAddress.getText().length() > 0) {
                this.errAddress.setText("không thể tìm thấy địa chỉ này");
                this.errAddress.setFill(Color.DARKORANGE);
            } else {
                this.errAddress.setText("");
            }
        });
        this.btnReset = new Button("Reset !");
        this.btnReset.setMinWidth(80);
        this.btnReset.setMaxWidth(80);
        this.btnReset.setOnMouseClicked(event -> {
            this.txtUsername.clear();
            this.pwdPassword.clear();
            this.txtAddress.clear();
            this.txtPhonenumber.clear();
            this.errAddress.setText("");
            this.errpass.setText("");
            this.errUsername.setText("");
            this.errPhone.setText("");
            this.gender_male.setSelected(true);
        });
        this.radioGrip = new GridPane();
        this.radioGrip.setHgap(10);
        this.radioGrip.add(gender_male, 0, 0);
        this.radioGrip.add(gender_female, 1, 0);
        this.btnGrip = new GridPane();
        this.btnGrip.setHgap(10);
        this.btnGrip.add(btnSupmit, 0, 0);
        this.btnGrip.add(btnReset, 1, 0);
        this.layOut = new GridPane();
        this.layOut.setAlignment(Pos.CENTER);
        this.layOut.setHgap(10);
        this.layOut.setVgap(10);
        this.layOut.setPadding(new Insets(10, 10, 10, 10));
        this.layOut.add(lbltitle, 1, 0);
        this.layOut.add(lblUsername, 0, 1);
        this.layOut.add(txtUsername, 1, 1);
        this.layOut.add(this.errUsername, 1, 2);
        this.layOut.add(lblPassword, 0, 3);
        this.layOut.add(pwdPassword, 1, 3);
        this.layOut.add(this.errpass, 1, 4);
        this.layOut.add(lblPhoneNumber, 0, 5);
        this.layOut.add(txtPhonenumber, 1, 5);
        this.layOut.add(this.errPhone, 1, 6);
        this.layOut.add(lblgender, 0, 7);
        this.layOut.add(radioGrip, 1, 7);
        this.layOut.add(lbladdress, 0, 8);
        this.layOut.add(txtAddress, 1, 8);
        this.layOut.add(this.errAddress, 1, 9);
        this.layOut.add(btnGrip, 1, 10);
        this.layOut.add(lbl_backToLogin, 1, 12);
    }
}