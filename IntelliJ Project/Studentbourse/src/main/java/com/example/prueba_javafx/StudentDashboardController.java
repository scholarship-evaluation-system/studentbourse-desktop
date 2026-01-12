package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class StudentDashboardController {

    @FXML
    private ImageView homeIcon;
    
    @FXML
    private ComboBox<String> semesterDropdown;

    @FXML
    private void initialize() {
        // Initialize semester dropdown
        if (semesterDropdown != null) {
            semesterDropdown.getItems().addAll(
                "2025 Fall",
                "2025 Spring",
                "2024 Fall"
            );
            semesterDropdown.setValue("2025 Fall");
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
            Stage stage = (Stage) homeIcon.getScene().getWindow();
            ViewNavigator.navigateTo(stage, ViewNavigator.COVER_PAGE, 1280, 800);
            stage.setMaximized(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void onMatchesClick() {
        try {
            Stage stage = (Stage) homeIcon.getScene().getWindow();
            ViewNavigator.navigateTo(stage, ViewNavigator.SCHOLARSHIP_MATCHES, 1280, 800);
            stage.setMaximized(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void onRecommendedClick() {
        System.out.println("Recommended clicked - view not implemented yet");
    }
    
    @FXML
    private void onPickedClick() {
        try {
            Stage stage = (Stage) homeIcon.getScene().getWindow();
            ViewNavigator.navigateTo(stage, ViewNavigator.PICKED_APPLICATIONS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void onInProcessClick() {
        try {
            Stage stage = (Stage) homeIcon.getScene().getWindow();
            ViewNavigator.navigateTo(stage, ViewNavigator.IN_PROCESS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void onSubmittedClick() {
        try {
            Stage stage = (Stage) homeIcon.getScene().getWindow();
            ViewNavigator.navigateTo(stage, ViewNavigator.SUBMITTED_APPLICATIONS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
