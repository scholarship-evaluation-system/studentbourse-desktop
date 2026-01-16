package com.studentbourse.controller;

import com.studentbourse.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class StudentApplicationsController {

    @FXML private TextField searchField;
    @FXML private VBox cardList;
    @FXML private ComboBox<String> semesterSelect;

    @FXML private Button matchesBtn;
    @FXML private Button pickedBtn;
    @FXML private Button inProcessBtn;
    @FXML private Button submittedBtn;

    @FXML
    public void initialize() {

        semesterSelect.getItems().setAll(
                "2025 Fall",
                "2025 Spring",
                "2024 Fall"
        );
        semesterSelect.setValue("2025 Fall");

        populateSubmittedApplications();
    }

    private void populateSubmittedApplications() {
        cardList.getChildren().clear();

        for (int i = 1; i <= 3; i++) {
            cardList.getChildren().add(
                    createApplicationCard(
                            "Submitted Application " + i,
                            "Undergraduate",
                            "5,000 €",
                            "Submitted",
                            "Approved"
                    )
            );
        }
    }

    private HBox createApplicationCard(
            String title,
            String level,
            String award,
            String status,
            String decision
    ) {
        HBox card = new HBox(15);
        card.getStyleClass().add("sch-card");
        card.setPadding(new Insets(20));
        card.setAlignment(Pos.CENTER_LEFT);

        StackPane imageBox = new StackPane();
        imageBox.getStyleClass().add("sch-img");
        imageBox.setPrefSize(80, 80);

        VBox info = new VBox(6);
        HBox.setHgrow(info, Priority.ALWAYS);

        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("sch-title");

        Label req = new Label("5 Requirements: 2 Essays, 3 Documents");
        req.getStyleClass().add("sch-req");

        Label tag = new Label(level);
        tag.getStyleClass().add("tag");

        info.getChildren().addAll(titleLabel, req, tag);

        VBox statusBox = new VBox(4);
        statusBox.setAlignment(Pos.CENTER_RIGHT);

        Label statusLabel = new Label(status);
        statusLabel.getStyleClass().add("stat-num");

        Label decisionLabel = new Label(decision);
        decisionLabel.getStyleClass().add("stat-label");

        statusBox.getChildren().addAll(statusLabel, decisionLabel);

        card.getChildren().addAll(imageBox, info, statusBox);
        return card;
    }

    @FXML
    private void onMyScholarshipsClick() {
        MainApp.show("student-dashboard.fxml", "Student Dashboard");
    }

    @FXML
    private void onMatchesClick() {
        MainApp.show("scholarship-list.fxml", "Scholarship Matches");
    }

    @FXML
    private void onPickedClick() {
        MainApp.show("picked-applications.fxml", "Picked Applications");
    }

    @FXML
    private void onInProcessClick() {
        MainApp.show("in-process.fxml", "In Process");
    }

    @FXML
    private void onSubmittedClick() {
        System.out.println("Already on Submitted Applications page");
    }

    @FXML
    private void onHomeClick() {
        MainApp.show("cover-page.fxml", "StudentBourse");
    }
}
