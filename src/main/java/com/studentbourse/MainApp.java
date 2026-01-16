package com.studentbourse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class MainApp extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        show("cover-page.fxml", "StudentBourse");
    }

    public static void show(String fxml, String title) {
        try {
            URL fxmlUrl = MainApp.class.getResource("/fxml/" + fxml);
            if (fxmlUrl == null) {
                throw new RuntimeException("FXML not found: /fxml/" + fxml);
            }

            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            Scene scene = new Scene(root);

            String cssFile = fxml.replace(".fxml", ".css");
            URL cssUrl = MainApp.class.getResource("/css/" + cssFile);
            if (cssUrl != null) {
                scene.getStylesheets().add(cssUrl.toExternalForm());
            }

            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            System.err.println("FAILED TO LOAD VIEW: " + fxml);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
