package com.studentbourse.controller;

import com.studentbourse.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class StudentDashboardController {

    @FXML private HBox matchesMenuItem;
    @FXML private HBox pickedMenuItem;
    @FXML private HBox inProcessMenuItem;
    @FXML private HBox submittedMenuItem;

    @FXML private ComboBox<String> semesterDropdown;

    @FXML
    public void initialize() {
        semesterDropdown.getItems().addAll(
                "2025 Fall",
                "2025 Spring",
                "2024 Fall"
        );
        semesterDropdown.setValue("2025 Fall");

        semesterDropdown.setOnAction(e -> {
            String selected = semesterDropdown.getValue();
            System.out.println("Semester changed to: " + selected);
        });
    }

    @FXML
    public void onMatchesClick(MouseEvent event) {
        System.out.println("Matches clicked");
        MainApp.show("scholarship-list.fxml", "Scholarship Matches");
    }

    @FXML
    public void onPickedClick(MouseEvent event) {
        System.out.println("Picked clicked");
        MainApp.show("picked-applications.fxml", "Picked Applications");
    }

    @FXML
    public void onInProcessClick(MouseEvent event) {
        System.out.println("In Process clicked");
        MainApp.show("in-process.fxml", "In Process Applications");
    }

    @FXML
    public void onSubmittedClick(MouseEvent event) {
        System.out.println("Submitted clicked");
        MainApp.show("student-applications.fxml", "Submitted Applications");
    }

    @FXML
    public void onHomeClick(MouseEvent event) {
        MainApp.show("role-selection.fxml", "StudentBourse");
    }

    @FXML
    public void onProfileClick(MouseEvent event) {
        MainApp.show("student-profile.fxml", "Student Profile");
    }

    @FXML
    public void onNotificationsClick(MouseEvent event) {
        MainApp.show("student-notifications.fxml", "Notifications");
    }
}
