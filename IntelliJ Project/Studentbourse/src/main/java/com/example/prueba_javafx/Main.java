package com.example.prueba_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cambiar a view-test-menu.fxml para ver todas las vistas disponibles
        URL fxmlUrl = getClass().getResource("fxml/view-test-menu.fxml");
        if (fxmlUrl == null) {
            throw new IllegalStateException("Cannot find /fxml/view-test-menu.fxml");
        }
        Parent root = FXMLLoader.load(fxmlUrl);
        Scene scene = new Scene(root, 1280, 800);
        primaryStage.setTitle("StudentBourse - View Navigation Menu");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
