package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GuestMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private Button createGuest;

    @FXML
    private Button findGuest;

    @FXML
    private Button showAllGuest;

    @FXML
    private Button changeGuest;

    @FXML
    void initialize() {
        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        createGuest.setOnAction(actionEvent -> {
            try {
                openNewScene(createGuestPath, createGuest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        findGuest.setOnAction(actionEvent -> {
            try {
                openNewScene(findGuestPath, findGuest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        showAllGuest.setOnAction(actionEvent -> {
            try {
                openNewScene(showAllGuestPath, showAllGuest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        changeGuest.setOnAction(actionEvent -> {
            try {
                openNewScene(changeGuestPath, changeGuest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private String backFieldPath = "/resourses/Main.fxml";
    private String createGuestPath = "/resourses/guest/createGuest.fxml";
    private String findGuestPath = "/resourses/guest/findGuest.fxml";
    private String showAllGuestPath = "/resourses/guest/showAllGuest.fxml";
    private String changeGuestPath = "src\\resourses\\guest\\changeGuest.fxml";


    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
}
