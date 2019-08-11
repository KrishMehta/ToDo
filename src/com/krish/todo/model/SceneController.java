package com.krish.todo.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

/**
 * Class created by Krish
 */

public class SceneController {

    private static final String BASE_PATH = "";

    private Pane pane;
    private HashMap<String, Pane> screenMap = new HashMap<>() {{

    }};

    public SceneController(Pane pane) {
        this.pane = pane;
    }

    public void addScreen(String name) throws IOException {
        screenMap.put(name, FXMLLoader.load(getClass().getResource(BASE_PATH + WordUtils.capitalize(name) + ".fxml")));
    }

    public void removeScreen(String name) {
        screenMap.remove(name);
    }

    public void activate(String name) {
        activate(name, 600, 400);
    }

    public void activate(String name, int width, int height) {
        Pane window = screenMap.get(name);
        pane.getChildren().setAll(window);
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setTitle(WordUtils.capitalize(name));
    }

}
