package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import org.kordamp.ikonli.javafx.FontIcon;

public class StudentLoginController {

    @FXML
    private TextField emailField;
    
    @FXML
    private PasswordField passwordField;

    @FXML
    private HBox headerIcons;

    @FXML
    private void initialize() {
        try {
            java.net.URL imgUrl = getClass().getResource("/com/example/prueba_javafx/icons/home.png");
            if (imgUrl != null) {
                javafx.scene.image.ImageView iv = new javafx.scene.image.ImageView(new javafx.scene.image.Image(imgUrl.toExternalForm()));
                iv.setFitHeight(28);
                iv.setPreserveRatio(true);
                iv.getStyleClass().add("sb-icon-img");
                headerIcons.getChildren().add(iv);
            } else {
                FontIcon home = new FontIcon("fas-home");
                home.getStyleClass().add("sb-header-icon");
                headerIcons.getChildren().add(home);
            }
        } catch (Exception ignored) {
        }
    }

    @FXML
    private void onLoginClick() {
        // Login logic here
        System.out.println("Student login clicked");
    }

    @FXML
    private void onCreateAccountClick() {
        // Navigate to create account page
    }
}
