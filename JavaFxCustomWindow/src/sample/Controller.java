package sample;


import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    double mousePressedX, mousePressedY;

    @FXML
    Pane headerPane;
    @FXML
    Parent root;
    @FXML
    JFXButton close;
    @FXML JFXButton minimize;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        headerPane.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mousePressedX = mouseEvent.getX();
                mousePressedY = mouseEvent.getY();
            }
        });
        headerPane.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double crrX = mouseEvent.getScreenX();
                double crrY = mouseEvent.getScreenY();
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setX(crrX - mousePressedX);
                stage.setY(crrY - mousePressedY);
            }
        });
        close.setOnMouseClicked((ActionEvent) -> {
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
        });
        minimize.setOnMouseClicked((ActionEvent) -> {
            Stage stage = (Stage) close.getScene().getWindow();
            stage.setIconified(true);
        });
    }
}
