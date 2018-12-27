package sample.controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import sample.animation.Shaker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class created by Krish
 */

public class AddItemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView addButton;

    @FXML
    private Label noTaskLabel;

    @FXML
    void initialize() {
        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Shaker shaker = new Shaker(addButton);
            shaker.shake();

            FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000), addButton);
            FadeTransition labelTrasition = new FadeTransition(Duration.millis(2000), noTaskLabel);

            addButton.relocate(0, 0);
            addButton.setOpacity(0);
            noTaskLabel.relocate(0, 0);
            noTaskLabel.setOpacity(0);

            fadeTransition.setFromValue(1f);
            fadeTransition.setToValue(0f);
            fadeTransition.setCycleCount(1);
            fadeTransition.setAutoReverse(false);
            fadeTransition.play();

            labelTrasition.setFromValue(1f);
            labelTrasition.setToValue(0f);
            labelTrasition.setCycleCount(1);
            labelTrasition.setAutoReverse(false);
            labelTrasition.play();

            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/sample/view/AddItemInfo.fxml"));
                anchorPane.getChildren().setAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }


}
