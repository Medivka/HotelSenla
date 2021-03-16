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
    private Button updateOrder;

    @FXML
    private Button getAmount;

    @FXML
    void initialize() {

        backFiled.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backFiled);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        createNewOrderButton.setOnAction(actionEvent -> {
            try {
                openNewSceneOrder(createNewOrderPath, createNewOrderButton);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        showOrder.setOnAction(actionEvent -> {
            try {
                openNewSceneShow(showOrderPath, showOrder);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        updateOrder.setOnAction(actionEvent -> {
            try {
                openNewSceneUpdate(updateOrderPath, updateOrder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        getAmount.setOnAction(actionEvent -> {
            try {
                openNewScene(getAllAmountPath, getAmount);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private String backFieldPath = "/resources/Main.fxml";
    private String showOrderPath = "/resources/order/showOrder.fxml";
    private String createNewOrderPath = "/resources/order/createNewOrder.fxml";
    private String updateOrderPath = "/resources/order/updateOrder.fxml";
    private String getAllAmountPath = "/resources/order/getAllAmount.fxml";

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }

    public void openNewSceneOrder(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 889, 690));
    } public void openNewSceneShow(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 1184, 801));
    }public void openNewSceneUpdate(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 1006, 771));
    }
}
