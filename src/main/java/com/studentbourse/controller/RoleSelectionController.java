package com.studentbourse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import com.studentbourse.MainApp;

public class RoleSelectionController {

    @FXML
    private HBox headerIcons;

    @FXML
    private HBox roleMain;

    @FXML
    private StackPane roleImagePane;

    @FXML
    private ImageView roleImageView;

    @FXML
    private VBox roleContainer;

    @FXML
    private void initialize() {
        System.out.println("RoleSelectionController initialized");
    }

    @FXML
    public void onStudentClick(ActionEvent event) {
        System.out.println("Student role selected");
        MainApp.show("student-login.fxml", "Student Login");
    }

    @FXML
    public void onEvaluatorClick(ActionEvent event) {
        System.out.println("Evaluator role selected");
        MainApp.show("evaluator-login.fxml", "Evaluator Login");
    }
}
