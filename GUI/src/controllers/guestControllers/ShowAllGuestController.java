package controllers.guestControllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import api.IController;
import fasad.FasadGuest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Guest;

public class ShowAllGuestController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private TableView<Guest> tableGuest;

    @FXML
    private TableColumn<Guest, Integer> idColumn;

    @FXML
    private TableColumn<Guest, String > nameColumn;

    @FXML
    private TableColumn<Guest, Integer> ageColumn;

    @FXML
    void initialize() {
        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        idColumn.setCellValueFactory(new PropertyValueFactory<Guest,Integer>("guestNumber"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Guest,String>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Guest,Integer>("age"));
        ObservableList<Guest> guests= FXCollections.observableArrayList(fasadGuest.showAllGuests());
        tableGuest.setItems(guests);
    }
    FasadGuest fasadGuest= FasadGuest.getInstance();
    String backFieldPath = "/resources/guestMenu.fxml";
    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
}
