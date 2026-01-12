package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class ScholarshipMatchesController {

    @FXML
    private TextField searchField;
    
    @FXML
    private VBox cardList;
    
    @FXML
    private ComboBox<String> semesterSelect;
    
    @FXML
    private Button matchesBtn;
    
    @FXML
    private Button pickedBtn;
    
    @FXML
    private Button inProcessBtn;
    
    @FXML
    private Button submittedBtn;

    @FXML
    private void initialize() {
        // Initialize semester ComboBox
        if (semesterSelect != null) {
            semesterSelect.getItems().addAll("2025 Fall", "2025 Spring", "2024 Fall");
            semesterSelect.setValue("2025 Fall");
        }
        
        // Setup navigation buttons with icons
        setupNavButton(matchesBtn, "Matches", "scholarships.png");
        setupNavButton(pickedBtn, "Picked", "bookmark.png");
        setupNavButton(inProcessBtn, "In Process", "time.png");
        setupNavButton(submittedBtn, "Submitted", "applications.png");
        
        // Populate with sample scholarship cards
        populateScholarshipCards();
    }
    
    private void setupNavButton(Button button, String text, String iconName) {
        if (button == null) return;
        
        try {
            ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/com/example/prueba_javafx/icons/" + iconName)));
            icon.setFitWidth(18);
            icon.setFitHeight(18);
            icon.setPreserveRatio(true);
            
            HBox content = new HBox(8);
            content.setAlignment(Pos.CENTER_LEFT);
            
            Label label = new Label(text);
            label.setStyle("-fx-text-fill: inherit; -fx-font-size: inherit;");
            
            content.getChildren().addAll(icon, label);
            button.setGraphic(content);
        } catch (Exception e) {
            button.setText(text);
        }
    }

    private void populateScholarshipCards() {
        if (cardList != null) {
            String[] titles = {"Title1 Example", "Title2 Example", "Title3 Example", "Title4 Example", "Title5 Example"};
            String[] tags = {"Undergraduate", "Postgraduate", "PhD", "Undergraduate", "Postgraduate"};
            String[] awards = {"5,000 €", "2,000 €", "3,000 €", "5,000 €", "4,000 €"};
            String[] days = {"25", "17", "31", "25", "20"};
            String[] applicants = {"75", "50", "25", "75", "60"};
            
            for (int i = 0; i < 5; i++) {
                HBox card = createScholarshipCard(
                    titles[i],
                    tags[i],
                    awards[i],
                    days[i],
                    applicants[i]
                );
                cardList.getChildren().add(card);
            }
        }
    }

    private HBox createScholarshipCard(String title, String tag, String award, String daysLeft, String applicants) {
        HBox card = new HBox(15);
        card.getStyleClass().add("sch-card");
        card.setAlignment(Pos.CENTER_LEFT);
        card.setPadding(new Insets(20));
        
        // Image placeholder (square)
        StackPane imgPane = new StackPane();
        imgPane.getStyleClass().add("sch-img");
        imgPane.setPrefSize(80, 80);
        imgPane.setMinSize(80, 80);
        imgPane.setMaxSize(80, 80);
        
        // Main info section
        VBox mainInfo = new VBox(8);
        mainInfo.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(mainInfo, Priority.ALWAYS);
        
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("sch-title");
        
        Label reqLabel = new Label("5 Requirements: 2 Essays, 3 Documents");
        reqLabel.getStyleClass().add("sch-req");
        
        // Tags container
        HBox tagsBox = new HBox(5);
        Label tagLabel = new Label(tag);
        tagLabel.getStyleClass().add("tag");
        tagsBox.getChildren().add(tagLabel);
        
        mainInfo.getChildren().addAll(titleLabel, reqLabel, tagsBox);
        
        // Stats section - 3 boxes horizontally aligned
        HBox stats = new HBox(15);
        stats.getStyleClass().add("sch-stats");
        stats.setAlignment(Pos.CENTER_RIGHT);
        stats.getChildren().addAll(
            createStatBox(award, "in Awards", "awards.png"),
            createStatBox(daysLeft, "Days Left", "time.png"),
            createStatBox(applicants, "Applicants", "students.png")
        );
        
        card.getChildren().addAll(imgPane, mainInfo, stats);
        return card;
    }

    private VBox createStatBox(String num, String label, String iconName) {
        VBox box = new VBox(4);
        box.getStyleClass().add("stat-box");
        box.setAlignment(Pos.CENTER);
        box.setPrefWidth(110);
        box.setMinWidth(110);
        box.setMaxWidth(110);
        
        Label numLabel = new Label(num);
        numLabel.getStyleClass().add("stat-num");
        numLabel.setWrapText(false);
        
        // Create HBox for label with icon
        HBox labelBox = new HBox(3);
        labelBox.setAlignment(Pos.CENTER);
        labelBox.setMaxWidth(105);
        
        Label labelText = new Label(label);
        labelText.getStyleClass().add("stat-label");
        labelText.setWrapText(false);
        labelText.setAlignment(Pos.CENTER);
        
        // Add icon
        try {
            ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/com/example/prueba_javafx/icons/" + iconName)));
            icon.setFitWidth(12);
            icon.setFitHeight(12);
            icon.setPreserveRatio(true);
            labelBox.getChildren().addAll(labelText, icon);
        } catch (Exception e) {
            labelBox.getChildren().add(labelText);
        }
        
        box.getChildren().addAll(numLabel, labelBox);
        return box;
    }

    @FXML
    private void onMatchesClick() {
        // Already on matches page
        System.out.println("Already on Matches page");
    }

    @FXML
    private void onPickedClick() {
        System.out.println("Picked clicked - view not implemented yet");
    }

    @FXML
    private void onInProcessClick() {
        System.out.println("In Process clicked - view not implemented yet");
    }

    @FXML
    private void onSubmittedClick() {
        System.out.println("Submitted clicked - view not implemented yet");
    }
    
    @FXML
    private void onHomeClick() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log Out");
        alert.setHeaderText("Are you sure you want to log out?");
        alert.setContentText("You will be returned to the home page.");
        
        // Customize buttons
        ButtonType continueButton = new ButtonType("Continue");
        ButtonType cancelButton = new ButtonType("Cancel");
        alert.getButtonTypes().setAll(continueButton, cancelButton);
        
        // Apply custom styling
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/com/example/prueba_javafx/css/alert-style.css").toExternalForm());
        dialogPane.getStyleClass().add("custom-alert");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == continueButton) {
            try {
                Stage stage = (Stage) searchField.getScene().getWindow();
                ViewNavigator.navigateTo(stage, ViewNavigator.COVER_PAGE, 1280, 800);
                stage.setMaximized(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
