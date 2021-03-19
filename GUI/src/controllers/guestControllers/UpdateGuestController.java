package controllers.guestControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import api.IController;
import fasad.FasadGuest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateGuestController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private TextField idGuestField;

    @FXML
    private TextField newNameField;

    @FXML
    private TextField newAgeField;

    @FXML
    private Button findGuest;
    @FXML
    private Button updateButton;

    @FXML
    private Label findGuestLabel;

    @FXML
    void initialize() {
        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        findGuest.setOnAction(actionEvent -> {
            Integer guestId = Integer.parseInt(idGuestField.getText());
            if (guestId <= fasadGuest.showAllGuests().size() && guestId > 0) {
                findGuestLabel.setText(fasadGuest.findById(guestId).toString());
                newNameField.setText(FasadGuest.getInstance().findById(guestId).getName());
                newAgeField.setText(FasadGuest.getInstance().findById(guestId).getAge().toString());
            } else findGuestLabel.setText("Guest not found");
        });
        updateButton.setOnAction(actionEvent -> {
            Integer guestId = Integer.parseInt(idGuestField.getText());
            String newName = newNameField.getText();
            Integer newAge = Integer.parseInt(newAgeField.getText());
            fasadGuest.findById(guestId).setName(newName);
            fasadGuest.findById(guestId).setAge(newAge);
            System.out.println(fasadGuest.findById(guestId));
        });


    }

    FasadGuest fasadGuest = FasadGuest.getInstance();
    private String backFieldPath = "/resources/guestMenu.fxml";

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
}
