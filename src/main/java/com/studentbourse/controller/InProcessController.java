package com.studentbourse.controller;

import com.studentbourse.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class InProcessController {

    @FXML private TextField searchField;
    @FXML private VBox cardList;
    @FXML private ComboBox<String> semesterSelect;

    @FXML private Button matchesBtn;
    @FXML private Button pickedBtn;
    @FXML private Button inProcessBtn;
    @FXML private Button submittedBtn;

    @FXML
    public void initialize() {

        semesterSelect.getItems().addAll(
                "2025 Fall",
                "2025 Spring",
                "2024 Fall"
        );
        semesterSelect.setValue("2025 Fall");

        populateScholarshipCards();
    }

    private void populateScholarshipCards() {
        cardList.getChildren().clear();

        for (int i = 1; i <= 5; i++) {
            cardList.getChildren().add(
                    createScholarshipCard(
                            "Scholarship " + i,
                            "Undergraduate",
                            "5,000 €",
                            "25",
                            "75"
                    )
            );
        }
    }

    private HBox createScholarshipCard(
            String title,
            String level,
            String award,
            String daysLeft,
            String applicants
    ) {
        HBox card = new HBox(15);
        card.getStyleClass().add("sch-card");
        card.setPadding(new Insets(20));
        card.setAlignment(Pos.CENTER_LEFT);

        StackPane img = new StackPane();
        img.getStyleClass().add("sch-img");
        img.setPrefSize(80, 80);

        VBox info = new VBox(6);
        HBox.setHgrow(info, Priority.ALWAYS);

        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("sch-title");

        Label req = new Label("5 Requirements: 2 Essays, 3 Documents");
        req.getStyleClass().add("sch-req");

        Label tag = new Label(level);
        tag.getStyleClass().add("tag");

        info.getChildren().addAll(titleLabel, req, tag);

        HBox stats = new HBox(15);
        stats.setAlignment(Pos.CENTER_RIGHT);

        stats.getChildren().addAll(
                createStatBox(award, "in Awards"),
                createStatBox(daysLeft, "Days Left"),
                createStatBox(applicants, "Applicants")
        );

        card.getChildren().addAll(img, info, stats);
        return card;
    }

    private VBox createStatBox(String value, String label) {
        VBox box = new VBox(4);
        box.getStyleClass().add("stat-box");
        box.setAlignment(Pos.CENTER);
        box.setPrefWidth(110);

        Label num = new Label(value);
        num.getStyleClass().add("stat-num");

        Label text = new Label(label);
        text.getStyleClass().add("stat-label");

        box.getChildren().addAll(num, text);
        return box;
    }

    @FXML
    private void onMyScholarshipsClick() {
        MainApp.show("student-dashboard.fxml", "Student Dashboard");
    }

    @FXML
    private void onMatchesClick() {
        MainApp.show("scholarship-matches.fxml", "Matches");
    }

    @FXML
    private void onPickedClick() {
        MainApp.show("picked-applications.fxml", "Picked");
    }

    @FXML
    private void onInProcessClick() {
        System.out.println("Already on In Process page");
    }

    @FXML
    private void onSubmittedClick() {
        MainApp.show("submitted-applications.fxml", "Submitted");
    }

    @FXML
    private void onHomeClick() {
        MainApp.show("cover-page.fxml", "StudentBourse");
    }
}
