package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

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
    private Button createNewOrderField;

    @FXML
    void initialize() {
createNewOrderField.setOnAction(actionEvent -> System.out.println("click createNewOrder") );
historyMenuField.setOnAction(actionEvent -> System.out.println("click history menu ") );

    }
}
