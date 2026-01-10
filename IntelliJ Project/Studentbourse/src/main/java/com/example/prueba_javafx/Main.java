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
        // Cambiar a view-test.fxml para probar todas las vistas
        // Cargar el FXML relativo al paquete: "fxml/view-test.fxml" -> /com/example/prueba_javafx/fxml/view-test.fxml
        URL fxmlUrl = getClass().getResource("fxml/view-test.fxml");
        if (fxmlUrl == null) {
            throw new IllegalStateException("Cannot find /fxml/view-test.fxml");
        }
        Parent root = FXMLLoader.load(fxmlUrl);
        // Use a laptop-friendly default size so layouts match target designs
        Scene scene = new Scene(root, 1280, 800);
        // Añadir BootstrapFX globalmente (si la dependencia está presente)
        try {
            scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
        } catch (Exception ignored) {
            // Si no está en el classpath, no hacemos nada
        }
        primaryStage.setTitle("StudentBourse - View Tester");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
