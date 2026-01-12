package com.example.prueba_javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Central navigation utility for all views in the StudentBourse application
 */
public class ViewNavigator {
    
    // View paths
    public static final String COVER_PAGE = "/com/example/prueba_javafx/fxml/cover-page.fxml";
    public static final String ROLE_SELECTION = "/com/example/prueba_javafx/fxml/role-selection.fxml";
    public static final String STUDENT_LOGIN = "/com/example/prueba_javafx/fxml/student-login.fxml";
    public static final String EVALUATOR_LOGIN = "/com/example/prueba_javafx/fxml/evaluator-login.fxml";
    public static final String CREATE_ACCOUNT_STUDENT = "/com/example/prueba_javafx/fxml/createaccount-student.fxml";
    public static final String CREATE_ACCOUNT_EVALUATOR = "/com/example/prueba_javafx/fxml/createaccount-evaluator.fxml";
    public static final String STUDENT_DASHBOARD = "/com/example/prueba_javafx/fxml/student-dashboard.fxml";
    public static final String EVALUATOR_DASHBOARD = "/com/example/prueba_javafx/fxml/evaluator-dashboard.fxml";
    public static final String SCHOLARSHIP_MATCHES = "/com/example/prueba_javafx/fxml/scholarship-matches.fxml";
    public static final String EVALUATOR_APPLICATIONS = "/com/example/prueba_javafx/fxml/evaluator-applications.fxml";
    public static final String PICKED_APPLICATIONS = "/com/example/prueba_javafx/fxml/picked-applications.fxml";
    public static final String IN_PROCESS = "/com/example/prueba_javafx/fxml/in-process.fxml";
    public static final String SUBMITTED_APPLICATIONS = "/com/example/prueba_javafx/fxml/submitted-applications.fxml";
    
    /**
     * Navigate to a new view
     * @param stage The current stage
     * @param fxmlPath The path to the FXML file
     * @throws IOException If the FXML file cannot be loaded
     */
    public static void navigateTo(Stage stage, String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(ViewNavigator.class.getResource(fxmlPath));
        Parent root = loader.load();
        stage.setMaximized(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.centerOnScreen();
    }
    
    /**
     * Navigate to a new view with a specific size
     * @param stage The current stage
     * @param fxmlPath The path to the FXML file
     * @param width The width of the new scene
     * @param height The height of the new scene
     * @throws IOException If the FXML file cannot be loaded
     */
    public static void navigateTo(Stage stage, String fxmlPath, double width, double height) throws IOException {
        FXMLLoader loader = new FXMLLoader(ViewNavigator.class.getResource(fxmlPath));
        Parent root = loader.load();
        stage.setMaximized(false);
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.centerOnScreen();
    }
    
    /**
     * Get the controller from a loaded view
     * @param stage The current stage
     * @param fxmlPath The path to the FXML file
     * @return The controller object
     * @throws IOException If the FXML file cannot be loaded
     */
    public static Object navigateToWithController(Stage stage, String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(ViewNavigator.class.getResource(fxmlPath));
        Parent root = loader.load();
        stage.setMaximized(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.centerOnScreen();
        return loader.getController();
    }
}
