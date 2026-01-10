package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.io.IOException;

public class CoverPageController {

    @FXML
    private void handleNextButton(ActionEvent event) {
        try {
            // Load the role selection page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/role-selection.fxml"));
            Parent root = loader.load();
            
            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Create and set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading role selection page: " + e.getMessage());
        }
    }
}
