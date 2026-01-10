package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;

public class EvaluatorDashboardController {

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
    }
}
