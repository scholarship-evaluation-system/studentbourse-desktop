package com.studentbourse.controller;

import com.studentbourse.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

public class EvaluatorReviewsController {

    @FXML private ComboBox<String> universitySelect;
    @FXML private ComboBox<String> semesterSelect;
    @FXML private TextField searchField;
    @FXML private GridPane applicationsGrid;
    @FXML private Button applicationsBtn;
    @FXML private Button reviewsBtn;

    @FXML
    public void initialize() {

        universitySelect.getItems().setAll(
                "ABC University",
                "XYZ University",
                "DEF College"
        );
        universitySelect.setValue("ABC University");

        semesterSelect.getItems().setAll(
                "2025 Fall",
                "2025 Spring",
                "2024 Fall"
        );
        semesterSelect.setValue("2025 Fall");

        populateReviewsGrid();
    }

    private void populateReviewsGrid() {
        applicationsGrid.getChildren().clear();

        int col = 0;
        int row = 0;

        for (int i = 1; i <= 10; i++) {
            HBox card = createReviewCard("Reviewed Application " + i);
            applicationsGrid.add(card, col, row);

            col++;
            if (col == 2) {
                col = 0;
                row++;
            }
        }
    }

    private HBox createReviewCard(String title) {
        HBox card = new HBox(10);
        card.setAlignment(Pos.CENTER_LEFT);
        card.getStyleClass().add("sb-application-card");

        Label label = new Label(title);
        Label arrow = new Label("→");

        HBox spacer = new HBox();
        HBox.setHgrow(spacer, javafx.scene.layout.Priority.ALWAYS);

        card.getChildren().addAll(label, spacer, arrow);

        card.setOnMouseClicked(e ->
                System.out.println("Clicked review: " + title)
        );

        return card;
    }

    @FXML
    private void onDashboardClick() {
        MainApp.show("evaluator-dashboard.fxml", "Evaluator Dashboard");
    }

    @FXML
    private void onApplicationsClick() {
        MainApp.show("evaluator-applications.fxml", "Evaluator Applications");
    }

    @FXML
    private void onReviewsClick() {
        System.out.println("Already on Reviews page");
    }

    @FXML
    private void onHomeClick() {
        MainApp.show("cover-page.fxml", "StudentBourse");
    }
}
