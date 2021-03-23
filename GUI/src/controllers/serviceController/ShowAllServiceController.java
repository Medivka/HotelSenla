package controllers.serviceController;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import interfaceController.IController;
import com.fasad.FasadService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import com.model.Service;

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
    private Button deleteButton;
    @FXML
    private TextField idServiceField;


    @FXML
    void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<Service, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Service, String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Service, Integer>("price"));
        ObservableList<Service> services = FXCollections.observableArrayList(fasadService.showAllService());
        tableService.setItems(services);

        deleteButton.setOnAction(actionEvent -> {

            FasadService.getInstance().deleteService(Integer.parseInt(idServiceField.getText()));
            try {
                openNewScene(showAllServicePath,deleteButton);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });



        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });



    }

    FasadService fasadService=FasadService.getInstance();
    String backFieldPath = "/resources/serviceMenu.fxml";
    private String showAllServicePath = "/resources/service/showAllService.fxml";

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
}

