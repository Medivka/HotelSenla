package controllers.orderControllers;

import java.io.IOException;
import java.time.LocalDate;

import interfaceController.IController;
import com.fasad.FasadOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import com.model.Guest;
import com.model.Order;
import com.model.Room;
import com.model.Service;


public class ShowOrderController implements IController {


    @FXML
    private Button backFiled;

    @FXML
    private Button orderDeleteButton;

    @FXML
    private TextField orderFindField;
    @FXML
    private TableView<Order> orderTable;

    @FXML
    private TableColumn<Order, Integer> idColumn;

    @FXML
    private TableColumn<Order, Guest> guestColumn;

    @FXML
    private TableColumn<Order, Room> roomColumn;

    @FXML
    private TableColumn<Order, Service> servicesColumn;

    @FXML
    private TableColumn<Order, Integer> daysOfStayColumn;

    @FXML
    private TableColumn<Order, LocalDate> daySettlingColumn;


    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("id"));
        guestColumn.setCellValueFactory(new PropertyValueFactory<Order, Guest>("guests"));
        roomColumn.setCellValueFactory(new PropertyValueFactory<Order, Room>("rooms"));
        servicesColumn.setCellValueFactory(new PropertyValueFactory<Order, Service>("services"));
        daysOfStayColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("daysOfStay"));
        daySettlingColumn.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("localDate"));
        ObservableList<Order> orders = FXCollections.observableArrayList(fasadOrder.showAllOrder());
        orderTable.setItems(orders);
        backFiled.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backFiled);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        orderDeleteButton.setOnAction(actionEvent -> {
            fasadOrder.deleteOrder(Integer.parseInt(orderFindField.getText()));
            try {
                openNewSceneshow(showOrderPath, orderDeleteButton);
            } catch (IOException e) {
                e.printStackTrace();
            }


        });

    }

    FasadOrder fasadOrder = FasadOrder.getInstance();
    private String showOrderPath = "/resources/order/showOrder.fxml";
    private String backFieldPath = "/resources/orderMenu.fxml";

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
