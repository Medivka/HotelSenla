package controllers.roomControllers;


import api.IController;

import fasad.FasadRoom;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FindRoomController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private Button findRoom;

    @FXML
    private TextField enterRoomNumber;

    @FXML
    private Label label;

    @FXML
    void initialize() {

        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        findRoom.setOnAction(actionEvent -> {
            Integer roomNumber = Integer.parseInt(enterRoomNumber.getText());
            if(roomNumber<=fasadRoom.showAllRoom().size()&&roomNumber>0){
            label.setText(fasadRoom.findById(roomNumber).toString())

            ;}else label.setText("room not found");
        });
    }

    String backFieldPath = "/resources/roomMenu.fxml";
    FasadRoom fasadRoom = FasadRoom.getInstance();

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
}
