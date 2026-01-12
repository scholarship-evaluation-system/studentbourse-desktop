package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;

public class CreateAccountStudentController {

    @FXML
    private HBox headerIcons;

    @FXML
    private HBox loginMain;

    @FXML
    private StackPane imagePane;

    @FXML
    private ImageView loginImageView;

    @FXML
    private VBox formContainer;

    @FXML
    private Label subtitleLabel;

    @FXML
    private void initialize() {
        try {
            java.net.URL imgUrl = getClass().getResource("/com/example/prueba_javafx/icons/home.png");
            if (imgUrl != null) {
                javafx.scene.image.ImageView iv = new javafx.scene.image.ImageView(new Image(imgUrl.toExternalForm()));
                iv.setFitHeight(28);
                iv.setPreserveRatio(true);
                iv.getStyleClass().add("sb-icon-img");
                iv.setOnMouseClicked(e -> goToCoverPage());
                headerIcons.getChildren().add(iv);
            } else {
                FontIcon home = new FontIcon("fas-home");
                home.getStyleClass().add("sb-header-icon");
                home.setOnMouseClicked(e -> goToCoverPage());
                headerIcons.getChildren().add(home);
            }
        } catch (Exception ignored) {
        }

        try {
            if (loginMain != null && loginImageView != null && formContainer != null) {
                loginImageView.fitWidthProperty().bind(loginMain.widthProperty().multiply(0.45));
                loginImageView.fitHeightProperty().bind(loginMain.heightProperty());
                formContainer.prefWidthProperty().bind(loginMain.widthProperty().multiply(0.55));
                formContainer.prefHeightProperty().bind(loginMain.heightProperty());
                try {
                    if (subtitleLabel != null) {
                        subtitleLabel.setWrapText(true);
                        subtitleLabel.setTextOverrun(OverrunStyle.CLIP);
                        subtitleLabel.prefWidthProperty().bind(formContainer.widthProperty().subtract(40));
                        subtitleLabel.maxWidthProperty().bind(formContainer.widthProperty().subtract(40));
                        subtitleLabel.setMaxHeight(Double.MAX_VALUE);
                        subtitleLabel.setMinHeight(javafx.scene.layout.Region.USE_PREF_SIZE);
                        subtitleLabel.setPrefHeight(javafx.scene.layout.Region.USE_COMPUTED_SIZE);
                    }
                } catch (Exception ignored) {
                }
            }
        } catch (Exception ignored) {
        }
    }

    private void goToCoverPage() {
        try {
            URL fxmlUrl = getClass().getResource("fxml/cover-page.fxml");
            if (fxmlUrl == null) {
                System.err.println("Cannot find fxml/cover-page.fxml");
                return;
            }
            Parent root = FXMLLoader.load(fxmlUrl);
            Stage stage = (Stage) headerIcons.getScene().getWindow();
            Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
            stage.setScene(scene);
            stage.setMaximized(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToStudentLogin() {
        try {
            URL fxmlUrl = getClass().getResource("fxml/student-login.fxml");
            if (fxmlUrl == null) {
                System.err.println("Cannot find fxml/student-login.fxml");
                return;
            }
            Parent root = FXMLLoader.load(fxmlUrl);
            Stage stage = (Stage) headerIcons.getScene().getWindow();
            Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
            stage.setScene(scene);
            stage.setMaximized(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
