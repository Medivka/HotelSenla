package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
createNewOrderField.setOnAction(actionEvent -> openNewWindow(orderMenuPath) );
historyMenuField.setOnAction(actionEvent -> openNewWindow(historyMenuPath) );
serviceMenuField.setOnAction(actionEvent -> openNewWindow(serviceMenuPath));
guestMenuField.setOnAction(actionEvent -> openNewWindow(guestMenuPath));
orderMenuField.setOnAction(actionEvent -> openNewWindow(orderMenuPath));
roomMenuField.setOnAction(actionEvent -> openNewWindow(roomMenuPath));
    }
    private String guestMenuPath="/resourses/guestMenu.fxml";
    private String orderMenuPath="/resourses/orderMenu.fxml";
    private String roomMenuPath="/resourses/roomMenu.fxml";
    private  String historyMenuPath="/resourses/historyMenu.fxml";
    private  String serviceMenuPath="/resourses/serviceMenu.fxml";

    public void openNewWindow(String window){
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }
}
