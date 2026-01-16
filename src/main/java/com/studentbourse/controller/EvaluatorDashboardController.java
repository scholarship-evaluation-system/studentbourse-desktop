package com.studentbourse.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import com.studentbourse.MainApp;

public class EvaluatorDashboardController {

    @FXML private ComboBox<String> universityDropdown;
    @FXML private ComboBox<String> semesterDropdown;
    @FXML private TextField searchField;
    @FXML private BarChart<String, Number> barChart;
    @FXML private ImageView homeIcon;

    @FXML
    public void initialize() {
        if (universityDropdown != null) {
            universityDropdown.getItems().addAll(
                    "University of Vienna",
                    "Sorbonne University",
                    "University of Amsterdam"
            );
            universityDropdown.getSelectionModel().selectFirst();
        }

        if (semesterDropdown != null) {
            semesterDropdown.getItems().addAll(
                    "2026 Spring",
                    "2025 Fall",
                    "2025 Spring"
            );
            semesterDropdown.getSelectionModel().selectFirst();
        }

        System.out.println("EvaluatorDashboardController initialized");
    }

    @FXML
    private void onApplicationsClick() {
        System.out.println("Applications clicked");
    }

    @FXML
    public void onProfileClick(MouseEvent event) {
        MainApp.show("evaluator-profile.fxml", "Evaluator Profile");
    }

    @FXML
    public void onNotificationsClick(MouseEvent event) {
        MainApp.show("evaluator-notifications.fxml", "Notifications");
    }

    @FXML
    public void onHomeClick(MouseEvent event) {
        MainApp.show("role-selection.fxml", "StudentBourse");
    }

    @FXML
    private void onReviewsClick() {
        System.out.println("Reviews clicked");
    }
}
