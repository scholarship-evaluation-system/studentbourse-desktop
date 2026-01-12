package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * View Test Controller - Central hub to navigate to all implemented views
 */
public class ViewTestMenuController {

    @FXML
    private GridPane viewsGrid;

    @FXML
    private void initialize() {
        setupViewButtons();
    }

    private void setupViewButtons() {
        if (viewsGrid == null) return;

        String[][] views = {
            {"Cover Page", ViewNavigator.COVER_PAGE},
            {"Role Selection", ViewNavigator.ROLE_SELECTION},
            {"Student Login", ViewNavigator.STUDENT_LOGIN},
            {"Evaluator Login", ViewNavigator.EVALUATOR_LOGIN},
            {"Create Account Student", ViewNavigator.CREATE_ACCOUNT_STUDENT},
            {"Create Account Evaluator", ViewNavigator.CREATE_ACCOUNT_EVALUATOR},
            {"Student Dashboard", ViewNavigator.STUDENT_DASHBOARD},
            {"Evaluator Dashboard", ViewNavigator.EVALUATOR_DASHBOARD},
            {"Scholarship Matches", ViewNavigator.SCHOLARSHIP_MATCHES},
            {"Evaluator Applications", ViewNavigator.EVALUATOR_APPLICATIONS}
        };

        int row = 0;
        int col = 0;
        int maxCols = 3;

        for (String[] view : views) {
            VBox card = createViewCard(view[0], view[1]);
            viewsGrid.add(card, col, row);
            
            col++;
            if (col >= maxCols) {
                col = 0;
                row++;
            }
        }
    }

    private VBox createViewCard(String title, String fxmlPath) {
        VBox card = new VBox(10);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(20));
        card.setStyle("-fx-background-color: white; -fx-border-color: #222; -fx-border-width: 2;");
        card.setPrefSize(250, 150);

        Label label = new Label(title);
        label.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        Button button = new Button("Open View");
        button.setStyle("-fx-background-color: #7fb069; -fx-text-fill: white; -fx-padding: 10 20;");
        button.setOnAction(event -> navigateToView(fxmlPath));

        card.getChildren().addAll(label, button);
        
        // Hover effect
        card.setOnMouseEntered(event -> 
            card.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #222; -fx-border-width: 2;")
        );
        card.setOnMouseExited(event -> 
            card.setStyle("-fx-background-color: white; -fx-border-color: #222; -fx-border-width: 2;")
        );

        return card;
    }

    private void navigateToView(String fxmlPath) {
        try {
            Stage stage = (Stage) viewsGrid.getScene().getWindow();
            ViewNavigator.navigateTo(stage, fxmlPath, 1280, 800);
            stage.setMaximized(true);
        } catch (IOException e) {
            System.err.println("Error navigating to view: " + fxmlPath);
            e.printStackTrace();
        }
    }
}
