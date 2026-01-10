package com.example.prueba_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/cover-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        scene.getStylesheets().add(getClass().getResource("css/cover-page.css").toExternalForm());
        stage.setTitle("StudentBourse");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
