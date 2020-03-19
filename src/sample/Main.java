package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //primaryStage.setTitle("Hello World");
        //primaryStage.setScene(new Scene(root, 1000, 700));
        //primaryStage.setFullScreen(true);
        //primaryStage.setResizable(false);
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        Rectangle player = new Rectangle(100, 100, 200, 300);
        root.getChildren().add(player);
        player.setOnMouseClicked(mouseEvent -> {
            System.out.println(mouseEvent);
            player.setX(player.getX() + 10);
        });

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
