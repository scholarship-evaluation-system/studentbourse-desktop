package com.studentbourse.controller;

import com.studentbourse.MainApp;
import com.studentbourse.model.Application;
import com.studentbourse.service.ApplicationService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class StudentDashboardController {

    @FXML private ComboBox<String> semesterDropdown;

    @FXML private Label submittedCount;
    @FXML private Label inProcessCount;
    @FXML private Label pickedCount;

    private final ApplicationService applicationService = new ApplicationService();

    private final int CURRENT_USER_ID = 1;

    @FXML
    public void initialize() {
        semesterDropdown.getItems().addAll(
                "2025 Fall",
                "2025 Spring",
                "2024 Fall"
        );
        semesterDropdown.setValue("2025 Fall");

        loadStats();
    }

    private void loadStats() {
        List<Application> apps =
                applicationService.getApplicationsForStudent(CURRENT_USER_ID);

        long submitted =
                apps.stream().filter(a -> "submitted".equals(a.status)).count();
        long inProcess =
                apps.stream().filter(a -> "in_process".equals(a.status)).count();
        long picked =
                apps.stream().filter(a -> "picked".equals(a.status)).count();

        if (submittedCount != null) submittedCount.setText(String.valueOf(submitted));
        if (inProcessCount != null) inProcessCount.setText(String.valueOf(inProcess));
        if (pickedCount != null) pickedCount.setText(String.valueOf(picked));
    }

    @FXML
    public void onMatchesClick(MouseEvent event) {
        MainApp.show("scholarship-list.fxml", "Scholarship Matches");
    }

    @FXML
    public void onPickedClick(MouseEvent event) {
        MainApp.show("picked-applications.fxml", "Picked Applications");
    }

    @FXML
    public void onInProcessClick(MouseEvent event) {
        MainApp.show("in-process.fxml", "In Process Applications");
    }

    @FXML
    public void onSubmittedClick(MouseEvent event) {
        MainApp.show("submitted-applications.fxml", "Submitted Applications");
    }

    @FXML
    public void onFinalResultsClick(MouseEvent event) {
        MainApp.show("student-final-results.fxml", "Final Results");
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
