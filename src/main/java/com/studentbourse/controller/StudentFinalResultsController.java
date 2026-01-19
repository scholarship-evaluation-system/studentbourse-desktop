package com.studentbourse.controller;

import com.studentbourse.dao.ApplicationDAO;
import com.studentbourse.model.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentFinalResultsController {

    @FXML private TableView<Application> resultsTable;
    @FXML private TableColumn<Application, Integer> applicationCol;
    @FXML private TableColumn<Application, Integer> scholarshipCol;
    @FXML private TableColumn<Application, Float> scoreCol;
    @FXML private TableColumn<Application, String> statusCol;

    private static final int CURRENT_USER_ID = 1;

    @FXML
    public void initialize() {
        applicationCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        scholarshipCol.setCellValueFactory(
                new PropertyValueFactory<>("scholarshipId"));
        scoreCol.setCellValueFactory(
                new PropertyValueFactory<>("totalScore"));
        statusCol.setCellValueFactory(
                new PropertyValueFactory<>("status"));

        resultsTable.setItems(
                FXCollections.observableArrayList(
                        ApplicationDAO.findByUser(CURRENT_USER_ID)
                                .stream()
                                .filter(a ->
                                        "picked".equals(a.status)
                                                || "rejected".equals(a.status))
                                .toList()
                )
        );
    }
}
