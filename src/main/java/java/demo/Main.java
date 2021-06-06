package java.demo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    ArrayList<Image> images = new ArrayList<>();

    Image img = new Image("https://genk.mediacdn.vn/2019/11/2/screenshot8-1572665608314673918837.png");
    Image img1 = new Image("https://static2.yan.vn/YanNews/2167221/202011/le-bong-la-ai-tieu-su-doi-tu-su-nghiep-cua-co-057d0b59-4eceb02c.png");
    Image img2 = new Image("https://genk.mediacdn.vn/2019/11/2/screenshot8-1572665608314673918837.png");
    Image img4 = new Image("https://cdn.24h.com.vn/upload/2-2020/images/2020-06-05/Lo-doi-thuc-kho-ngo-cua-nu-sinh-phu-phang-tu-choi-le-bong-trung-ruoi--17--1591344502-617-width960height960.jpg");
    Image img3 = new Image("https://static2.yan.vn/YanNews/2167221/202011/le-bong-la-ai-tieu-su-doi-tu-su-nghiep-cua-co-057d0b59-4eceb02c.png");


    ArrayList<ImageView> imageViews = new ArrayList<>();


//    @Override
//    public void start(Stage primaryStage) {
//        images.add(img);
//        images.add(img1);
//        images.add(img2);
//        images.add(img3);
//        images.add(img4);
//        primaryStage.setTitle("Load Image");
//        HBox sp = new HBox();
//        for (int i = 0; i < images.size(); i++) {
//            ImageView imgView = new ImageView(images.get(i));
//            imgView.setFitHeight(250);
//            imgView.setFitWidth(200);
//            imageViews.add(imgView);
//        }
//        for (int i = 0; i < imageViews.size(); i++) {
//            sp.getChildren().add(imageViews.get(i));
//        }
//        //Adding HBox to the scene
//        Scene scene = new Scene(sp,800,250);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

        @Override public void start(Stage stage) throws Exception {
//        System.out.println("enter URL");
//        Scanner scanner = new Scanner(System.in);
//        String URL = scanner.nextLine();
//        WebView webview = new WebView();
//        webview.getEngine().load(URL);
//        webview.setPrefSize(640, 390);
//
//        stage.setScene(new Scene(webview));
//        stage.show();
//    }
    Circle circle = new Circle();

    //Setting the position of the circle
      circle.setCenterX(300.0f);
      circle.setCenterY(135.0f);

    //Setting the radius of the circle
      circle.setRadius(25.0f);

    //Setting the color of the circle
      circle.setFill(Color.BROWN);

    //Setting the stroke width of the circle
      circle.setStrokeWidth(20);

    //Setting the text
    Text text = new Text("Click on the circle to change its color");

    //Setting the font of the text
      text.setFont(Font.font("Tahoma", FontWeight.BOLD,15));

    //Setting the color of the text
      text.setFill(Color.CRIMSON);

    //setting the position of the text
      text.setX(150);
      text.setY(50);

    //Creating the mouse event handler
    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            System.out.println("Hello World");
            circle.setFill(Color.DARKSLATEBLUE);
        }
    };

    //Registering the event filter
//      circle.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
      circle.setOnMousePressed(event -> {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setContentText("day la alert box");
          alert.setTitle("day la title");
          alert.show();
      });

    //Creating a Group object
    Group root = new Group(circle, text);

    //Creating a scene object
    Scene scene = new Scene(root, 600, 300);

    //Setting the fill color to the scene
      scene.setFill(Color.LAVENDER);

    //Setting title to the Stage
      stage.setTitle("Event Filters Example");

    //Adding scene to the stage
      stage.setScene(scene);

    //Displaying the contents of the stage
      stage.show();
}

    public static void main(String[] args) {
        Application.launch(args);
    }


}
