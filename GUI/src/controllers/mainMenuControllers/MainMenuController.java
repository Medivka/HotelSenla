package controllers.mainMenuControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.dao.GuestDao;
import com.dao.OrderDao;
import com.inputOutput.*;
import com.model.Guest;
import com.model.Order;
import com.model.Room;
import com.model.Service;
import interfaceController.IController;
import com.fasad.FasadGuest;
import com.fasad.FasadOrder;
import com.fasad.FasadRoom;
import com.fasad.FasadService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainMenuController implements IController {
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
    private Button createNewOrder;

    @FXML
    private Button saveDataBase;

    @FXML
    private Button loadDataBase;
    @FXML
    private Label saveReadLAbel;

    @FXML
    void initialize() {


        historyMenuField.setOnAction(actionEvent -> {
            try {
                openNewScene(historyMenuPath, historyMenuField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serviceMenuField.setOnAction(actionEvent -> {
            try {
                openNewScene(serviceMenuPath, serviceMenuField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        guestMenuField.setOnAction(actionEvent -> {
            try {
                openNewScene(guestMenuPath, guestMenuField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        orderMenuField.setOnAction(actionEvent -> {
            try {
                openNewScene(orderMenuPath, orderMenuField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        roomMenuField.setOnAction(actionEvent -> {
            try {
                openNewScene(roomMenuPath, roomMenuField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        createNewOrder.setOnAction(actionEvent -> {
            try {
                openNewSceneOrder(createNewOrderPath, createNewOrder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        saveDataBase.setOnAction(actionEvent -> {
            Serializer.getInstance().write(orderPathInFile, FasadOrder.getInstance().showAllOrder());
            Serializer.getInstance().write(guestPathInFile, FasadGuest.getInstance().showAllGuests());
            Serializer.getInstance().write(roomPathInFile, FasadRoom.getInstance().showAllRoom());
            Serializer.getInstance().write(servicePathInFile, FasadService.getInstance().showAllService());
            saveReadLAbel.setText("Save!!!");
        });
        loadDataBase.setOnAction(actionEvent -> {
            FasadOrder.getInstance().setOrderList(Serializer.getInstance().read(orderPathInFile, Order.class));
            FasadRoom.getInstance().setRoomList(Serializer.getInstance().read(roomPathInFile, Room.class));
            FasadService.getInstance().setServiceList(Serializer.getInstance().read(servicePathInFile, Service.class));
            FasadGuest.getInstance().setGuestList(Serializer.getInstance().read(guestPathInFile,Guest.class));

            saveReadLAbel.setText("Load !!!");
        });

    }

    private String guestPathInFile = "src/main/java/com/hdd/guests.dat";
    private String orderPathInFile = "src/main/java/com/hdd/orders.dat";
    private String roomPathInFile = "src/main/java/com/hdd/rooms.dat";
    private String servicePathInFile = "src/main/java/com/hdd/services.dat";

    private String createNewOrderPath = "/resources/order/createNewOrder.fxml";
    private String guestMenuPath = "/resources/guestMenu.fxml";
    private String orderMenuPath = "/resources/orderMenu.fxml";
    private String roomMenuPath = "/resources/roomMenu.fxml";
    private String historyMenuPath = "/resources/historyMenu.fxml";
    private String serviceMenuPath = "/resources/serviceMenu.fxml";


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
    }

}