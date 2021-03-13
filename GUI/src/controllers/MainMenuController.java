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

public class MainMenuController implements IController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button orderMenuField;

    @FXML
    private Button roomMenuField;

    @FXML
    private Button guestMenuField;

    @FXML
    private Button serviceMenuField;

    @FXML
    private Button historyMenuField;


    @FXML
    void initialize() {


        historyMenuField.setOnAction(actionEvent -> {
            try {
                openNewScene(historyMenuPath, historyMenuField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serviceMenuField.setOnAction(actionEvent -> {
            try {
                openNewScene(serviceMenuPath, serviceMenuField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        guestMenuField.setOnAction(actionEvent -> {
            try {
                openNewScene(guestMenuPath, guestMenuField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        orderMenuField.setOnAction(actionEvent -> {
            try {
                openNewScene(orderMenuPath, orderMenuField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        roomMenuField.setOnAction(actionEvent -> {
            try {
                openNewScene(roomMenuPath, roomMenuField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private String guestMenuPath = "/resources/guestMenu.fxml";
    private String orderMenuPath = "/resources/orderMenu.fxml";
    private String roomMenuPath = "/resources/roomMenu.fxml";
    private String historyMenuPath = "/resources/historyMenu.fxml";
    private String serviceMenuPath = "/resources/serviceMenu.fxml";


    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
}