package controllers.historyController;

import com.model.Guest;
import com.model.History;
import com.model.Room;
import com.model.Service;
import interfaceController.IController;
import com.fasad.FasadHistory;
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

import java.io.IOException;
import java.time.LocalDate;

public class ShowAllHistoryController implements IController {

    @FXML
    private Button backFiled;


    @FXML
    private TableView<History> historyTable;

    @FXML
    private TableColumn<History, Integer> idColumn;

    @FXML
    private TableColumn<History, Guest> guestColumn;

    @FXML
    private TableColumn<History, Room> roomColumn;

    @FXML
    private TableColumn<History, Service> servicesColumn;

    @FXML
    private TableColumn<History, Integer> daysOfStayColumn;

    @FXML
    private TableColumn<History, LocalDate> daySettlingColumn;


    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<History, Integer>("id"));
        guestColumn.setCellValueFactory(new PropertyValueFactory<History, Guest>("guests"));
        roomColumn.setCellValueFactory(new PropertyValueFactory<History, Room>("rooms"));
        servicesColumn.setCellValueFactory(new PropertyValueFactory<History, Service>("services"));
        daysOfStayColumn.setCellValueFactory(new PropertyValueFactory<History, Integer>("daysOfStay"));
        daySettlingColumn.setCellValueFactory(new PropertyValueFactory<History, LocalDate>("localDate"));
        ObservableList<History> historyObservableList = FXCollections.observableArrayList(fasadHistory.getAllHistory());
        historyTable.setItems(historyObservableList);
        backFiled.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backFiled);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    FasadHistory fasadHistory = FasadHistory.getInstance();
    private String backFieldPath = "/resources/historyMenu.fxml";

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }

    public void openNewSceneshow(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 1184, 801));
    }
}
