package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ViewTestController {

    @FXML
    private void openRoleSelection(ActionEvent event) {
        openView(event, ViewNavigator.ROLE_SELECTION);
    }

    @FXML
    private void openStudentLogin(ActionEvent event) {
        openView(event, ViewNavigator.STUDENT_LOGIN);
    }

    @FXML
    private void openStudentDashboard(ActionEvent event) {
        openView(event, ViewNavigator.STUDENT_DASHBOARD);
    }

    @FXML
    private void openCreateAccountStudent(ActionEvent event) {
        openView(event, ViewNavigator.CREATE_ACCOUNT_STUDENT);
    }

    @FXML
    private void openEvaluatorLogin(ActionEvent event) {
        openView(event, ViewNavigator.EVALUATOR_LOGIN);
    }

    @FXML
    private void openEvaluatorDashboard(ActionEvent event) {
        openView(event, ViewNavigator.EVALUATOR_DASHBOARD);
    }

    @FXML
    private void openCreateAccountEvaluator(ActionEvent event) {
        openView(event, ViewNavigator.CREATE_ACCOUNT_EVALUATOR);
    }
    
    @FXML
    private void openScholarshipMatches(ActionEvent event) {
        openView(event, ViewNavigator.SCHOLARSHIP_MATCHES);
    }
    
    @FXML
    private void openEvaluatorApplications(ActionEvent event) {
        openView(event, ViewNavigator.EVALUATOR_APPLICATIONS);
    }
    
    @FXML
    private void openViewTestMenu(ActionEvent event) {
        openView(event, "/com/example/prueba_javafx/fxml/view-test-menu.fxml");
    }

    private void openView(ActionEvent event, String fxmlPath) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ViewNavigator.navigateTo(stage, fxmlPath, 1280, 800);
            stage.setMaximized(true);
        } catch (IOException e) {
            System.err.println("Error opening view: " + fxmlPath);
            e.printStackTrace();
        }
    }
}
