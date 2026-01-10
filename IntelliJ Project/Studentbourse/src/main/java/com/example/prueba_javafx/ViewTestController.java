package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class ViewTestController {

    @FXML
    private void openRoleSelection() {
        openView("fxml/role-selection.fxml", "Role Selection");
    }

    @FXML
    private void openStudentLogin() {
        openView("fxml/student-login.fxml", "Student Login");
    }

    @FXML
    private void openStudentDashboard() {
        openView("fxml/student-dashboard.fxml", "Student Dashboard");
    }

    @FXML
    private void openCreateAccountStudent() {
        openView("fxml/createaccount-student.fxml", "Create Account - Student");
    }

    @FXML
    private void openEvaluatorLogin() {
        openView("fxml/evaluator-login.fxml", "Evaluator Login");
    }

    @FXML
    private void openEvaluatorDashboard() {
        openView("fxml/evaluator-dashboard.fxml", "Evaluator Dashboard");
    }

    private void openView(String fxmlPath, String title) {
        try {
            // Try as relative resource first (relative to this package)
            URL url = getClass().getResource(fxmlPath);
            // If not found, try absolute path under package root
            if (url == null) {
                String alt = "/com/example/prueba_javafx" + (fxmlPath.startsWith("/") ? fxmlPath : "/" + fxmlPath);
                url = getClass().getResource(alt);
            }
            if (url == null) {
                System.err.println("FXML resource not found: " + fxmlPath);
                return;
            }
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            // Open windows at a consistent laptop-friendly default so they don't
            // appear in awkward sizes or cover window controls. The user can
            // still maximize the window afterwards.
            Scene scene = new Scene(root, 1280, 800);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println("Error loading view: " + fxmlPath);
            e.printStackTrace();
        }
    }
}
