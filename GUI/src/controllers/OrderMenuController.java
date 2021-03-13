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

public class OrderMenuController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button createNewOrderButton;

    @FXML
    private Button showOrder;

    @FXML
    private Button backFiled;

    @FXML
    void initialize() {

      backFiled.setOnAction(actionEvent -> {
        try {
            openNewScene(backFieldPath, backFiled);
        } catch (IOException e) {
            e.printStackTrace();
        }
    });


    }
    private String backFieldPath = "/resources/Main.fxml";
    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
}
