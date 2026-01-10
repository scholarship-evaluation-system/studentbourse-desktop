package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class StudentDashboardController {

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
    }
}
