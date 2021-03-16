package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import api.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HistoryMenuController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private Button showAllHistory;

    @FXML
    private Button showAllRoomGuest;

    @FXML
    void initialize() {

        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        showAllHistory.setOnAction(actionEvent -> {
            try {
                openNewSceneshow(showAllHistoryPath, showAllHistory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        showAllRoomGuest.setOnAction(actionEvent -> {
            try {
                openNewScene(showAllRoomGuestPath, showAllRoomGuest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }

    private String backFieldPath = "/resources/Main.fxml";
    private String showAllHistoryPath = "/resources/history/showAllHistory.fxml";
    private String showAllRoomGuestPath = "/resources/orderMenu.fxml";

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
    public void openNewSceneshow(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 1184, 801));
    }
}
