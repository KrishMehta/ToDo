package com.krish.todo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class created by Krish
 */

public class AddItemInfoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField addTask;

    @FXML
    private TextField addDescription;

    @FXML
    private Button saveTask;

    @FXML
    void initialize() {
        saveTask.setOnAction(event -> {
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/com/krish/todo/view/AddItem.fxml"));
                anchorPane.getChildren().setAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
