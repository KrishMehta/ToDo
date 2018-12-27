package sample.controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.animation.Shaker;
import sample.database.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends Database {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    private String getUsername() {
        return username.getText();
    }

    private String getPassword() {
        return password.getText();
    }

    @FXML
    void initialize() {
        signInButton.setOnAction(event -> logIn());

        signUpButton.setOnAction(event -> {
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/sample/view/SignUp.fxml"));
                anchorPane.getChildren().setAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void switchScene(String path) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    private void logIn() {
        if (getUsername().equals("") || getPassword().equals("")) {
            shake();
        } else if (!database.containsKey(getUsername()) || !database.containsValue(getPassword())) {
            shake();
        } else if (database.get(getUsername()).equals(getPassword())) {
            signInButton.getScene().getWindow().hide();
            switchScene("/sample/view/AddItem.fxml");
        } else {
            shake();
        }
    }

    private void shake() {
        Shaker user = new Shaker(username);
        Shaker pass = new Shaker(password);
        user.shake();
        pass.shake();
    }

}
