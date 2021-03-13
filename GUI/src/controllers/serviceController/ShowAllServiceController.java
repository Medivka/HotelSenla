package controllers.serviceController;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import api.IController;
import api.enums.RoomStatus;
import fasad.FasadService;
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
import model.Room;
import model.Service;

public class ShowAllServiceController  implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private TableView<Service> tableService;

    @FXML
    private TableColumn<Service, Integer> idColumn;

    @FXML
    private TableColumn<Service, String> nameColumn;

    @FXML
    private TableColumn<Service, Integer> priceColumn;

    @FXML
    void initialize() {
        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        idColumn.setCellValueFactory(new PropertyValueFactory<Service, Integer>("id"));

        nameColumn.setCellValueFactory(new PropertyValueFactory<Service, String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Service, Integer>("price"));


        ObservableList<Service> services = FXCollections.observableArrayList(fasadService.showAllService());
       tableService.setItems(services);

    }

    FasadService fasadService=FasadService.getInstance();
    String backFieldPath = "/resources/serviceMenu.fxml";

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
}

