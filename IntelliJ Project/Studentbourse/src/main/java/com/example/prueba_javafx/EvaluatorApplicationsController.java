package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EvaluatorApplicationsController {

    @FXML
    private ComboBox<String> universitySelect;
    
    @FXML
    private ComboBox<String> semesterSelect;
    
    @FXML
    private TextField searchField;
    
    @FXML
    private GridPane applicationsGrid;

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
        
        // Populate the applications grid with sample data
        populateApplicationsGrid();
    }

    private void populateApplicationsGrid() {
        if (applicationsGrid != null) {
            int row = 0;
            int col = 0;
            int maxCols = 3; // 3 columns

            for (int i = 1; i <= 12; i++) {
                StackPane card = createApplicationCard("Application " + i);
                applicationsGrid.add(card, col, row);
                
                col++;
                if (col >= maxCols) {
                    col = 0;
                    row++;
                }
            }
        }
    }

    private StackPane createApplicationCard(String title) {
        StackPane card = new StackPane();
        card.getStyleClass().add("sb-application-card");
        
        Label label = new Label(title + " →");
        label.setAlignment(Pos.CENTER);
        card.getChildren().add(label);
        
        card.setOnMouseClicked(event -> onApplicationClick(title));
        
        return card;
    }

    private void onApplicationClick(String applicationName) {
        System.out.println("Clicked on: " + applicationName);
        // TODO: Navigate to application details view
    }

    @FXML
    private void onApplicationsClick() {
        // Already on applications page
        System.out.println("Already on Applications page");
    }

    @FXML
    private void onReviewsClick() {
        // TODO: Create evaluator-reviews.fxml and controller
        System.out.println("Reviews view not implemented yet. Create evaluator-reviews.fxml to enable this feature.");
        // Uncomment when view is ready:
        // try {
        //     navigateToView("/com/example/prueba_javafx/fxml/evaluator-reviews.fxml");
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

    private void navigateToView(String fxmlPath) throws IOException {
        Stage stage = (Stage) applicationsGrid.getScene().getWindow();
        ViewNavigator.navigateTo(stage, fxmlPath, 1280, 800);
        stage.setMaximized(true);
    }
}
