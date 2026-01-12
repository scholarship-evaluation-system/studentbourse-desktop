package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class EvaluatorDashboardController {

    @FXML
    private ImageView homeIcon;
    
    @FXML
    private ComboBox<String> universityDropdown;
    
    @FXML
    private ComboBox<String> semesterDropdown;
    
    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private void initialize() {
        // Initialize university dropdown
        if (universityDropdown != null) {
            universityDropdown.getItems().addAll(
                "ABC University",
                "XYZ University",
                "State University"
            );
            universityDropdown.setValue("ABC University");
        }
        
        // Initialize semester dropdown
        if (semesterDropdown != null) {
            semesterDropdown.getItems().addAll(
                "2025 Fall",
                "2025 Spring",
                "2024 Fall"
            );
            semesterDropdown.setValue("2025 Fall");
        }
        
        // Initialize bar chart
        if (barChart != null) {
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Students");
            
            // Add sample data for weeks W1-W12
            series.getData().add(new XYChart.Data<>("W1", 280));
            series.getData().add(new XYChart.Data<>("W2", 310));
            series.getData().add(new XYChart.Data<>("W3", 350));
            series.getData().add(new XYChart.Data<>("W4", 380));
            series.getData().add(new XYChart.Data<>("W5", 420));
            series.getData().add(new XYChart.Data<>("W6", 450));
            series.getData().add(new XYChart.Data<>("W7", 480));
            series.getData().add(new XYChart.Data<>("W8", 520));
            series.getData().add(new XYChart.Data<>("W9", 550));
            series.getData().add(new XYChart.Data<>("W10", 590));
            series.getData().add(new XYChart.Data<>("W11", 620));
            series.getData().add(new XYChart.Data<>("W12", 650));
            
            barChart.getData().add(series);
            barChart.setLegendVisible(false);
        }
        
        // Setup home icon click handler
        if (homeIcon != null) {
            homeIcon.setOnMouseClicked(event -> showLogoutConfirmation());
        }
    }
    
    private void showLogoutConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log Out");
        alert.setHeaderText("Are you sure you want to log out?");
        alert.setContentText("You will be returned to the home page.");
        
        // Customize buttons
        ButtonType continueButton = new ButtonType("Continue");
        ButtonType cancelButton = new ButtonType("Cancel");
        alert.getButtonTypes().setAll(continueButton, cancelButton);
        
        // Apply custom styling
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/com/example/prueba_javafx/css/alert-style.css").toExternalForm());
        dialogPane.getStyleClass().add("custom-alert");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == continueButton) {
            goToCoverPage();
        }
    }
    
    private void goToCoverPage() {
        try {
            URL fxmlLocation = getClass().getResource("/com/example/prueba_javafx/fxml/cover-page.fxml");
            Parent root = FXMLLoader.load(fxmlLocation);
            Stage stage = (Stage) homeIcon.getScene().getWindow();
            stage.setMaximized(false);
            Scene scene = new Scene(root, 1280, 800);
            stage.setScene(scene);
            stage.setMaximized(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
