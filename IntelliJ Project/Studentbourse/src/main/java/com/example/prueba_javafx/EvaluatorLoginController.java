package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;

public class EvaluatorLoginController {

    @FXML
    private TextField emailField;
    
    @FXML
    private PasswordField passwordField;

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
        // add header icon
        try {
            java.net.URL imgUrl = getClass().getResource("/com/example/prueba_javafx/icons/home.png");
            if (imgUrl != null) {
                javafx.scene.image.ImageView iv = new javafx.scene.image.ImageView(new Image(imgUrl.toExternalForm()));
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

        // Responsive bindings for large desktop screens
        try {
            if (loginMain != null && loginImageView != null && formContainer != null) {
                // image takes ~45% of the HBox width, form ~55%
                loginImageView.fitWidthProperty().bind(loginMain.widthProperty().multiply(0.45));
                // make image fill the available center height so its right border runs from header to footer
                loginImageView.fitHeightProperty().bind(loginMain.heightProperty());
                formContainer.prefWidthProperty().bind(loginMain.widthProperty().multiply(0.55));
                formContainer.prefHeightProperty().bind(loginMain.heightProperty());
                // Ensure subtitle wraps and never shows ellipsis by binding its max width
                try {
                    if (subtitleLabel != null) {
                        subtitleLabel.setWrapText(true);
                        subtitleLabel.setTextOverrun(OverrunStyle.CLIP);
                        // bind preferred width so label actually wraps instead of ellipsizing
                        subtitleLabel.prefWidthProperty().bind(formContainer.widthProperty().subtract(40));
                        subtitleLabel.maxWidthProperty().bind(formContainer.widthProperty().subtract(40));
                        // allow the label to grow vertically so it can display multiple lines
                        subtitleLabel.setMaxHeight(Double.MAX_VALUE);
                        subtitleLabel.setMinHeight(Region.USE_PREF_SIZE);
                        subtitleLabel.setPrefHeight(Region.USE_COMPUTED_SIZE);
                        // prevent the VBox from clipping the label height
                        VBox.setVgrow(subtitleLabel, Priority.NEVER);
                    }
                } catch (Exception ignored) {
                }
            }
        } catch (Exception ignored) {
        }
    }

    @FXML
    private void onLoginClick() {
        // Login logic here
        System.out.println("Evaluator login clicked");
    }

    @FXML
    private void onCreateAccountClick() {
        try {
            URL fxmlUrl = getClass().getResource("fxml/createaccount-evaluator.fxml");
            if (fxmlUrl == null) {
                System.err.println("Cannot find fxml/createaccount-evaluator.fxml");
                return;
            }
            Parent root = FXMLLoader.load(fxmlUrl);
            Stage stage = (Stage) headerIcons.getScene().getWindow();
            stage.setMaximized(false);
            Scene scene = new Scene(root, 1280, 800);
            stage.setScene(scene);
            stage.setMaximized(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
