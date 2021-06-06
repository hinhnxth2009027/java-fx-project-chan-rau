package myapplication;

import javafx.application.Application;
import javafx.stage.Stage;
import myapplication.view.loginStage;

public class MainRoot extends Application {
    private MainRoot mainRoot;
    private loginStage loginStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.loginStage = new loginStage(this);
        this.loginStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}