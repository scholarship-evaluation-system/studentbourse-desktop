package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class EvaluatorReviewsController {

    @FXML
    private ComboBox<String> universitySelect;
    
    @FXML
    private ComboBox<String> semesterSelect;
    
    @FXML
    private TextField searchField;
    
    @FXML
    private GridPane applicationsGrid;
    
    @FXML
    private Button applicationsBtn;
    
    @FXML
    private Button reviewsBtn;

    @FXML
    private void initialize() {
        // Initialize ComboBoxes
        if (universitySelect != null) {
            universitySelect.getItems().addAll("ABC University", "XYZ University", "DEF College");
            universitySelect.setValue("ABC University");
        }
        
        if (semesterSelect != null) {
            semesterSelect.getItems().addAll("2025 Fall", "2025 Spring", "2024 Fall");
            semesterSelect.setValue("2025 Fall");
        }
        
        // Setup navigation buttons with icons
        setupNavButton(applicationsBtn, "Applications", "applications.png");
        setupNavButton(reviewsBtn, "Reviews", "reviews.png");
        
        // Populate the applications grid with sample data
        populateApplicationsGrid();
    }
    
    private void setupNavButton(Button button, String text, String iconName) {
        if (button == null) return;
        
        try {
            ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/com/example/prueba_javafx/icons/" + iconName)));
            icon.setFitWidth(18);
            icon.setFitHeight(18);
            icon.setPreserveRatio(true);
            
            HBox content = new HBox(8);
            content.setAlignment(Pos.CENTER_LEFT);
            
            Label label = new Label(text);
            label.getStyleClass().add("nav-btn-label");
            
            content.getChildren().addAll(icon, label);
            button.setGraphic(content);
        } catch (Exception e) {
            button.setText(text);
        }
    }

    private void populateApplicationsGrid() {
        if (applicationsGrid != null) {
            int row = 0;
            int col = 0;
            int maxCols = 2; // 2 columns

            for (int i = 1; i <= 12; i++) {
                HBox card = createApplicationCard("Application " + i);
                applicationsGrid.add(card, col, row);
                
                col++;
                if (col >= maxCols) {
                    col = 0;
                    row++;
                }
            }
        }
    }

    private HBox createApplicationCard(String title) {
        HBox card = new HBox();
        card.getStyleClass().add("sb-application-card");
        card.setAlignment(Pos.CENTER_LEFT);
        
        Label label = new Label(title);
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: #222222;");
        
        HBox spacer = new HBox();
        HBox.setHgrow(spacer, javafx.scene.layout.Priority.ALWAYS);
        
        Label arrow = new Label("→");
        arrow.setStyle("-fx-font-size: 20px; -fx-text-fill: #222222;");
        
        card.getChildren().addAll(label, spacer, arrow);
        card.setOnMouseClicked(event -> onApplicationClick(title));
        
        return card;
    }

    private void onApplicationClick(String applicationName) {
        System.out.println("Clicked on: " + applicationName);
        // TODO: Navigate to application details view
    }

    @FXML
    private void onDashboardClick() {
        try {
            Stage stage = (Stage) searchField.getScene().getWindow();
            ViewNavigator.navigateTo(stage, ViewNavigator.EVALUATOR_DASHBOARD);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onApplicationsClick() {
        try {
            Stage stage = (Stage) searchField.getScene().getWindow();
            ViewNavigator.navigateTo(stage, ViewNavigator.EVALUATOR_APPLICATIONS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onReviewsClick() {
        // Already on reviews page
        System.out.println("Already on Reviews page");
    }
    
    @FXML
    private void onHomeClick() {
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
            try {
                Stage stage = (Stage) applicationsGrid.getScene().getWindow();
                ViewNavigator.navigateTo(stage, ViewNavigator.COVER_PAGE, 1280, 800);
                stage.setMaximized(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void navigateToView(String fxmlPath) throws IOException {
        Stage stage = (Stage) applicationsGrid.getScene().getWindow();
        ViewNavigator.navigateTo(stage, fxmlPath, 1280, 800);
        stage.setMaximized(true);
    }
}
