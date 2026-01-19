package com.studentbourse.controller;

import com.studentbourse.MainApp;
import com.studentbourse.dao.ApplicationDAO;
import com.studentbourse.model.Application;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.List;

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

        loadChart();
    }

    @FXML
    private void onApplicationsClick() {
        MainApp.show("evaluator-applications.fxml", "Evaluator Applications");
    }

    @FXML
    private void onReviewsClick() {
        MainApp.show("evaluator-reviews.fxml", "Evaluator Reviews");
    }

    @FXML
    public void onProfileClick(MouseEvent event) {
        MainApp.show("evaluator-profile.fxml", "Evaluator Profile");
    }

    @FXML
    public void onNotificationsClick(MouseEvent event) {
        MainApp.show("evaluator-notifications.fxml", "Notifications");
    }

    private void loadChart() {
        List<Application> apps = ApplicationDAO.findAll();

        long submitted = apps.stream().filter(a -> "submitted".equals(a.status)).count();
        long inProcess = apps.stream().filter(a -> "in_process".equals(a.status)).count();
        long picked = apps.stream().filter(a -> "picked".equals(a.status)).count();
        long rejected = apps.stream().filter(a -> "rejected".equals(a.status)).count();

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Applications");

        series.getData().add(new XYChart.Data<>("Submitted", submitted));
        series.getData().add(new XYChart.Data<>("In Process", inProcess));
        series.getData().add(new XYChart.Data<>("Picked", picked));
        series.getData().add(new XYChart.Data<>("Rejected", rejected));

        barChart.getData().clear();
        barChart.getData().add(series);
    }

    @FXML
    public void onHomeClick(MouseEvent event) {
        MainApp.show("role-selection.fxml", "StudentBourse");
    }
}
