package com.studentbourse.controller;

import com.studentbourse.MainApp;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class EvaluatorApplicationsController {

    @FXML private ComboBox<String> universitySelect;
    @FXML private ComboBox<String> semesterSelect;
    @FXML private TextField searchField;
    @FXML private GridPane applicationsGrid;
    @FXML private Button applicationsBtn;
    @FXML private Button reviewsBtn;

    @FXML
    public void initialize() {

        if (universitySelect != null) {
            universitySelect.getItems().addAll(
                    "University of Vienna",
                    "Sorbonne University",
                    "University of Bologna"
            );
            universitySelect.setValue("University of Vienna");
        }

        if (semesterSelect != null) {
            semesterSelect.getItems().addAll(
                    "2025 Fall",
                    "2025 Spring",
                    "2024 Fall"
            );
            semesterSelect.setValue("2025 Fall");
        }

        populateApplicationsGrid();
    }

    private void populateApplicationsGrid() {
        applicationsGrid.getChildren().clear();

        int col = 0;
        int row = 0;
        int maxCols = 2;

        for (int i = 1; i <= 8; i++) {
            HBox card = createApplicationCard("Application #" + i);
            applicationsGrid.add(card, col, row);

            col++;
            if (col == maxCols) {
                col = 0;
                row++;
            }
        }
    }

    private HBox createApplicationCard(String title) {
        HBox card = new HBox();
        card.getStyleClass().add("sb-application-card");
        card.setAlignment(Pos.CENTER_LEFT);
        card.setSpacing(10);

        Label label = new Label(title);
        label.getStyleClass().add("application-title");

        HBox spacer = new HBox();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label arrow = new Label("→");
        arrow.getStyleClass().add("application-arrow");

        card.getChildren().addAll(label, spacer, arrow);

        card.setOnMouseClicked(e ->
                System.out.println("Clicked on: " + title)
        );

        return card;
    }

    @FXML
    private void onDashboardClick() {
        MainApp.show("evaluator-dashboard.fxml", "Evaluator Dashboard");
    }

    @FXML
    private void onApplicationsClick() {
        System.out.println("Already on Applications page");
    }

    @FXML
    private void onReviewsClick() {
        MainApp.show("evaluator-reviews.fxml", "Evaluator Reviews");
    }

    @FXML
    private void onHomeClick() {
        MainApp.show("role-selection.fxml", "StudentBourse");
    }
}
