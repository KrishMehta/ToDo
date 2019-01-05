package com.krish.todo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import com.krish.todo.animation.Shaker;
import com.krish.todo.database.Database;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController extends Database {

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
        signInButton.setOnAction(event -> signIn());

        signUpButton.setOnAction(event -> {
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/com/krish/todo/view/SignUp.fxml"));
                anchorPane.getChildren().setAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void signIn() {
        if (getUsername().equals("") || getPassword().equals("")) {
            shake();
        } else if (!database.containsKey(getUsername()) || !database.containsValue(getPassword())) {
            shake();
        } else {
            signInButton.getScene().getWindow().hide();
            switchScene("/com/krish/todo/view/AddItem.fxml");
        }
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

    private void shake() {
        Shaker user = new Shaker(username);
        Shaker pass = new Shaker(password);
        user.shake();
        pass.shake();
    }

}
