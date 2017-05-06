package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setTitle("JavaFxCustomWindow");
        primaryStage.setScene(new Scene(root, 770, 550));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("flower.png")));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
