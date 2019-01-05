package com.krish.todo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import com.krish.todo.database.Database;

import java.io.IOException;

/**
 * Class created by Krish
 */

public class SignUpController extends Database {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField username;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private CheckBox male;

    @FXML
    private CheckBox female;

    @FXML
    private Button signUpButton;

    public String getFirstName() {
        return firstName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getUsername() {
        return username.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getGender() {
        if (male.isSelected()) {
            return "Male";
        } else {
            return "Female";
        }
    }

    @FXML
    void initialize() {
        signUpButton.setOnAction(event -> createUser());
    }

    private void createUser() {
        database.put(getUsername(), getPassword());
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/com/krish/todo/view/Login.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
