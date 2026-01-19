package com.studentbourse.controller;

import com.studentbourse.model.Application;
import com.studentbourse.service.ApplicationService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SubmittedApplicationsController {

    @FXML private TableView<Application> applicationsTable;
    @FXML private TableColumn<Application, Integer> scholarshipCol;
    @FXML private TableColumn<Application, String> statusCol;
    @FXML private TableColumn<Application, Float> scoreCol;

    private final ApplicationService applicationService = new ApplicationService();

    private static final int CURRENT_USER_ID = 1;

    @FXML
    public void initialize() {
        scholarshipCol.setCellValueFactory(
                new PropertyValueFactory<>("scholarshipId"));
        statusCol.setCellValueFactory(
                new PropertyValueFactory<>("status"));
        scoreCol.setCellValueFactory(
                new PropertyValueFactory<>("totalScore"));

        applicationsTable.setItems(
                FXCollections.observableArrayList(
                        applicationService.getApplicationsForStudent(CURRENT_USER_ID)
                )
        );
    }
}
