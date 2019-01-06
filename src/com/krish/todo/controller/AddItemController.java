package com.krish.todo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class created by Krish
 */

public class AddItemController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView addButton;

    @FXML
    private Label noTaskLabel;

    @FXML
    private TextField task1;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private TextField task2;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private TextField task3;

    @FXML
    private CheckBox checkBox4;

    @FXML
    private TextField task4;

    @FXML
    private CheckBox checkBox3;

    @FXML
    private TextField task5;

    @FXML
    private CheckBox checkBox5;

    @FXML
    private TextField task6;

    @FXML
    private CheckBox checkBox6;

    private List<TextField[]> tasks = new ArrayList<>();
    private Map<TextField, CheckBox> map = new HashMap<>();
    private boolean found = false;
    private boolean visible = false;

    @SuppressWarnings("Duplicates")
    @FXML
    void initialize() {

        tasks.add(new TextField[]{task5, task6, task1, task2, task3, task4});
        tasks.add(new TextField[]{task4, task5, task1, task2, task3});
        tasks.add(new TextField[]{task3, task4, task1, task2});
        tasks.add(new TextField[]{task2, task3, task1});
        tasks.add(new TextField[]{task1, task2, task1});

        map.put(task1, checkBox1);
        map.put(task2, checkBox2);
        map.put(task3, checkBox3);
        map.put(task4, checkBox4);
        map.put(task5, checkBox5);
        map.put(task6, checkBox6);


        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            noTaskLabel.setVisible(false);

//            for (TextField[] task : tasks) {
//                if (task[0].isVisible()) {
//                    for (int i = 2; i < task.length; i++) {
//                        if (!task[i].isVisible()) {
//                            task[i].setVisible(true);
//                            map.get(task[i]).setVisible(true);
//                            found = true;
//                            break;
//                        }
//                    }
//                    if (!found) {
//                        task[1].setVisible(true);
//                        map.get(task[1]).setVisible(true);
//                        break;
//                    }
//                    visible = true;
//                }
//                found = false;
//            }
//            if (!visible) {
//                task1.setVisible(true);
//                checkBox1.setVisible(true);
//            }

            if (task5.isVisible()) {
                if (!task1.isVisible()) {
                    task1.setVisible(true);
                    checkBox1.setVisible(true);
                } else if (!task2.isVisible()) {
                    task2.setVisible(true);
                    checkBox2.setVisible(true);
                } else if (!task3.isVisible()) {
                    task3.setVisible(true);
                    checkBox3.setVisible(true);
                } else if (!task4.isVisible()) {
                    task4.setVisible(true);
                    checkBox4.setVisible(true);
                } else {
                    task6.setVisible(true);
                    checkBox6.setVisible(true);
                }
            } else if (task4.isVisible()) {
                if (!task1.isVisible()) {
                    task1.setVisible(true);
                    checkBox1.setVisible(true);
                } else if (!task2.isVisible()) {
                    task2.setVisible(true);
                    checkBox2.setVisible(true);
                } else if (!task3.isVisible()) {
                    task3.setVisible(true);
                    checkBox3.setVisible(true);
                } else {
                    task5.setVisible(true);
                    checkBox5.setVisible(true);
                }
            } else if (task3.isVisible()) {
                if (!task1.isVisible()) {
                    task1.setVisible(true);
                    checkBox1.setVisible(true);
                } else if (!task2.isVisible()) {
                    task2.setVisible(true);
                    checkBox2.setVisible(true);
                } else {
                    task4.setVisible(true);
                    checkBox4.setVisible(true);
                }
            } else if (task2.isVisible()) {
                if (!task1.isVisible()) {
                    task1.setVisible(true);
                    checkBox1.setVisible(true);
                } else {
                    task3.setVisible(true);
                    checkBox3.setVisible(true);
                }
            } else if (task1.isVisible()) {
                task2.setVisible(true);
                checkBox2.setVisible(true);
            } else {
                task1.setVisible(true);
                checkBox1.setVisible(true);
            }
        });

        map.forEach((k, v) -> v.setOnAction(event -> {
            k.setText("");
            k.setVisible(false);
            v.setVisible(false);
            v.setSelected(false);
        }));

    }

}
