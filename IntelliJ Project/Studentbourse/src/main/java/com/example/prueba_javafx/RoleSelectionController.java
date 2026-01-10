package com.example.prueba_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;

public class RoleSelectionController {

    @FXML
    private HBox headerIcons;

    @FXML
    private HBox roleMain;

    @FXML
    private ImageView roleImageView;

    @FXML
    private VBox roleContainer;

    @FXML
    private void initialize() {
        try {
            // Prefer a PNG home icon from resources; fall back to Ikonli font icon
            java.net.URL imgUrl = getClass().getResource("/com/example/prueba_javafx/icons/home.png");
            if (imgUrl != null) {
                ImageView iv = new ImageView(new Image(imgUrl.toExternalForm()));
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
            // If ikonli or pack not available, ignore and leave header blank
        }
        // Bind image/form proportions so image spans header->footer and content
        try {
            if (roleMain != null && roleImageView != null && roleContainer != null) {
                roleImageView.fitWidthProperty().bind(roleMain.widthProperty().multiply(0.45));
                roleImageView.fitHeightProperty().bind(roleMain.heightProperty());
                roleContainer.prefWidthProperty().bind(roleMain.widthProperty().multiply(0.55));
                roleContainer.prefHeightProperty().bind(roleMain.heightProperty());
            }
        } catch (Exception ignored) {
        }
    }

    @FXML
    private void onStudentClick(ActionEvent event) {
        try {
            URL fxmlUrl = getClass().getResource("/fxml/student-login.fxml");
            if (fxmlUrl == null) {
                System.err.println("Cannot find /fxml/student-login.fxml");
                return;
            }
            Parent root = FXMLLoader.load(fxmlUrl);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onEvaluatorClick(ActionEvent event) {
        try {
            URL fxmlUrl = getClass().getResource("/fxml/evaluator-login.fxml");
            if (fxmlUrl == null) {
                System.err.println("Cannot find /fxml/evaluator-login.fxml");
                return;
            }
            Parent root = FXMLLoader.load(fxmlUrl);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
