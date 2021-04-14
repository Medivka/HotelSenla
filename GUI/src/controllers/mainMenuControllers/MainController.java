package controllers.mainMenuControllers;


import com.api.enums.GuestGender;
import com.api.enums.RoomStatus;
import com.fasad.*;
import com.inputOutput.Serializer;
import com.model.Guest;
import com.model.Order;
import com.model.Room;
import com.model.Service;
import interfaceController.IController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements IController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button logInButton;

    @FXML
    private ImageView senlaHome;

    @FXML
    private TableView<Order> orderTable;

    @FXML
    private TableColumn<Order, Integer> idOrderColumn;

    @FXML
    private TableColumn<Order, Guest> guestsOrderColumn;

    @FXML
    private TableColumn<Order, Room> roomOrderColumn;

    @FXML
    private TableColumn<Order, Service> serviceOrderColumn;

    @FXML
    private TableColumn<Order, Integer> dayOrderColumn;

    @FXML
    private TableColumn<Order, LocalDate> dayOfSettlingOrderColumn;

    @FXML
    private TableColumn<Order, Integer> AllAmountOrderColumn;

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

    @FXML
    private TextField enterGuestIdOrderTextField;

    @FXML
    private Button findGuestOrderButton;

    @FXML
    private TextField enterRoomIdOrderTextField;

    @FXML
    private Button findRoomOrderButton;

    @FXML
    private TextField enterServiceIDOrderTextFiled;

    @FXML
    private Button findServiceOrderButton;

    @FXML
    private TextField enterOrderIDTextField;

    @FXML
    private Button findOrderButton;

    @FXML
    private Button addGuestOrderButton;

    @FXML
    private TextField enterDaysOfStayOrderTextField;

    @FXML
    private Label orderInfoLabel;

    @FXML
    private Label guestInfoOrderLabel;

    @FXML
    private Label roomInfoOrderLabel;

    @FXML
    private Label serviceInfoOrderLabel;

    @FXML
    private Label loadSaveLabel;

    @FXML
    private Button addServiceOrderButton;

    @FXML
    private Button deleteOrderButton;

    @FXML
    private Button updateOrderButton;

    @FXML
    private Button createOrderButton;

    @FXML
    private TableView<Guest> guestTable;

    @FXML
    private TableColumn<Guest, Integer> idGuestColumn;

    @FXML
    private TableColumn<Guest, String> nameGuestColumn;

    @FXML
    private TableColumn<Guest, String> lastNameGuestColumn;

    @FXML
    private TableColumn<Guest, Integer> ageGuestColumn;

    @FXML
    private TableColumn<Guest, GuestGender> genderguestColumn;

    @FXML
    private TableColumn<Guest, String> phoneGuestColumn;

    @FXML
    private TableColumn<Guest, String> emailGuestColumn;

    @FXML
    private TableColumn<Guest, String> addressGuestColumn;

    @FXML
    private TextField guestNameTextField;

    @FXML
    private TextField LastNameTextField;

    @FXML
    private TextField AgeTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField guestIdTextField;

    @FXML
    private Button findGuestButton;

    @FXML
    private Button createGuestButton;

    @FXML
    private Button updateGuestButton;

    @FXML
    private Button deleteGuestButton;

    @FXML
    private Label guestInfoLabel;
    @FXML
    private ComboBox<GuestGender> genderGuestComboBox;


    @FXML
    private TableView<Room> roomTable;

    @FXML
    private TableColumn<Room, Integer> idRoomColumn;

    @FXML
    private TableColumn<Room, Integer> capacityRoomColumn;

    @FXML
    private TableColumn<Room, Integer> starsRoomColumn;

    @FXML
    private TableColumn<Room, RoomStatus> roomStatusColumn;

    @FXML
    private TableColumn<Room, Integer> priceRoomColumn;

    @FXML
    private TextField enterRoomIdTextField;

    @FXML
    private Button findRoomButton;

    @FXML
    private Label roomInfoLabel;

    @FXML
    private TextField capacityRoomTextField;

    @FXML
    private ComboBox<Integer> roomStarsComboBox;

    @FXML
    private TextField priceRoomTextField;

    @FXML
    private RadioButton maleGuestRadioButton;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton femaleGuestRadioButton;

    @FXML
    private Button deleteRoomButton;

    @FXML
    private Button updateRoomButton;

    @FXML
    private Button createRoomButton;
    @FXML
    private ComboBox<RoomStatus> roomStatusComboBox;


    @FXML
    private TableView<Service> serviceTable;

    @FXML
    private TableColumn<Service, Integer> idServiceColumn;

    @FXML
    private TableColumn<Service, String> nameServiceColumn;

    @FXML
    private TableColumn<Service, Integer> priceServiceColumn;

    @FXML
    private TextField enterServiceIDTextField;

    @FXML
    private Button findServiceButton;

    @FXML
    private Label serviceInfoLabel;

    @FXML
    private TextField serviceNameTextField;

    @FXML
    private TextField servicePriceTextField;

    @FXML
    private Button deleteServiceButton;

    @FXML
    private Button updateServiceButton;

    @FXML
    private Button createServiceButton;

    @FXML
    private Button exitButton;
    @FXML
    private Tab orderMenuTab;
    @FXML
    private Tab GuestMenuTab;
    @FXML
    private Tab roomMenuTab;
    @FXML
    private Tab ServiceMenuTab;
    @FXML
    private Tab historyMenuTab;
    @FXML
    private Label historyInfoLabel;

    @FXML
    private Button getAllHistoryButton;

    @FXML
    private TextField enterRoomHistoryTextField;

    @FXML
    private Button getLastFreeGuestInRoomButton;

    @FXML
    private TextField enterGuestIdHistoryTextField;

    @FXML
    private Button showAllRoomGuestButton;


    @FXML
    void initialize() {
            refreshOrderTable();
            refreshRoomTable();
            refreshGuestTable();
            refreshTableService();

        /**
         * order page
         */
        saveButton.setOnAction(actionEvent -> {
            Serializer.getInstance().write(orderPathInFile, FasadOrder.getInstance().showAllOrder());
            Serializer.getInstance().write(guestPathInFile, FasadGuest.getInstance().showAllGuests());
            Serializer.getInstance().write(roomPathInFile, FasadRoom.getInstance().showAllRoom());
            Serializer.getInstance().write(servicePathInFile, FasadService.getInstance().showAllService());
            Serializer.getInstance().write(historyPathInFile, FasadHistory.getInstance().getAllHistory());
            refreshTableService();
            refreshOrderTable();
            refreshGuestTable();
            loadSaveLabel.setText("Save!!!");

        });
        loadButton.setOnAction(actionEvent -> {
            FasadOrder.getInstance().setOrderList(Serializer.getInstance().read(orderPathInFile, Order.class));
            FasadRoom.getInstance().setRoomList(Serializer.getInstance().read(roomPathInFile, Room.class));
            FasadService.getInstance().setServiceList(Serializer.getInstance().read(servicePathInFile, Service.class));
            FasadHistory.getInstance().setHistoryList(Serializer.getInstance().read(historyPathInFile, Order.class));
            FasadGuest.getInstance().setGuestList(Serializer.getInstance().read(guestPathInFile, Guest.class));

            loadSaveLabel.setText("Load!!!");
            refreshTableService();
            refreshOrderTable();
            refreshRoomTable();
            refreshGuestTable();


        });
        findOrderButton.setOnAction(actionEvent -> {
            if (Integer.parseInt(enterOrderIDTextField.getText()) <= fasadOrder.showAllOrder().size() && Integer.parseInt(enterOrderIDTextField.getText()) > 0) {
                Order order = FasadOrder.getInstance().findByID(Integer.parseInt(enterOrderIDTextField.getText()));
                orderInfoLabel.setText(order.toString());
                guestInfoOrderLabel.setText(order.getGuest().toString());
                roomInfoOrderLabel.setText(order.getRoom().toString());
                serviceInfoOrderLabel.setText(order.getServices().toString());
                refreshOrderTable();
                /**
                 * auto-fill
                 */
                enterDaysOfStayOrderTextField.setText(order.getDaysOfStay().toString());
                enterGuestIdOrderTextField.setText(String.valueOf(order.getGuest().getGuestNumber()));
                enterRoomIdOrderTextField.setText(String.valueOf(order.getRoom().getRoomNumber()));
                enterServiceIDOrderTextFiled.setText("1");
            } else
                orderInfoLabel.setText("order not found");

        });
        createOrderButton.setOnAction(actionEvent -> {
            Order order = fasadOrder.createNewOrder(
                    fasadGuest.findById(Integer.parseInt(enterGuestIdOrderTextField.getText())),
                    fasadRoom.findById(Integer.parseInt(enterRoomIdOrderTextField.getText())),
                    fasadService.findById(Integer.parseInt(enterServiceIDOrderTextFiled.getText())),
                    localDate,
                    Integer.parseInt(enterDaysOfStayOrderTextField.getText()));
            enterOrderIDTextField.setText(order.getId().toString());
            orderInfoLabel.setText(order.toString());
            refreshOrderTable();

        });
        updateOrderButton.setOnAction(actionEvent -> {
            Order order = fasadOrder.findByID(Integer.parseInt(enterOrderIDTextField.getText()));
            order.setGuest(fasadGuest.findById(Integer.parseInt(enterGuestIdOrderTextField.getText())));
            order.setRoom(fasadRoom.findById(Integer.parseInt(enterRoomIdOrderTextField.getText())));
            order.setDaysOfStay(Integer.parseInt(enterDaysOfStayOrderTextField.getText()));
            order.setAllAmount(fasadOrder.getAllAmount(order.getId()));
            fasadOrder.updateOrder(order);
            refreshOrderTable();
            orderInfoLabel.setText("update order: \n" + order);

        });
        deleteOrderButton.setOnAction(actionEvent -> {
            fasadOrder.deleteOrder(Integer.parseInt(enterOrderIDTextField.getText()));
            orderInfoLabel.setText("order delete" + Integer.parseInt(enterOrderIDTextField.getText()));
            refreshOrderTable();

        });

        findGuestOrderButton.setOnAction(actionEvent -> {
            if (Integer.parseInt(enterGuestIdOrderTextField.getText()) <= fasadGuest.showAllGuests().size() && Integer.parseInt(enterGuestIdOrderTextField.getText()) > 0)
                guestInfoOrderLabel.setText(fasadGuest.findById(Integer.parseInt(enterGuestIdOrderTextField.getText())).toString());
            else guestInfoOrderLabel.setText("guest not found");

        });
        findRoomOrderButton.setOnAction(actionEvent -> {
            if (Integer.parseInt(enterRoomIdOrderTextField.getText()) <= fasadRoom.showAllRoom().size() && Integer.parseInt(enterRoomIdOrderTextField.getText()) > 0)
                roomInfoOrderLabel.setText(fasadRoom.findById(Integer.parseInt(enterRoomIdOrderTextField.getText())).toString());
            else roomInfoOrderLabel.setText("room not found");
        });
        findServiceOrderButton.setOnAction(actionEvent -> {
            if (Integer.parseInt(enterServiceIDOrderTextFiled.getText()) <= fasadService.showAllService().size() && Integer.parseInt(enterServiceIDOrderTextFiled.getText()) > 0)
                serviceInfoOrderLabel.setText(fasadService.findById(Integer.parseInt(enterServiceIDOrderTextFiled.getText())).toString());
            else serviceInfoOrderLabel.setText("service not found");
        });
        addServiceOrderButton.setOnAction(actionEvent -> {
            fasadOrder.addServiceInOrder(fasadOrder.findByID(Integer.parseInt(enterOrderIDTextField.getText())), fasadService.findById(Integer.parseInt(enterServiceIDOrderTextFiled.getText())));
            orderInfoLabel.setText(fasadOrder.findByID(Integer.parseInt(enterOrderIDTextField.getText())).toString());
            refreshOrderTable();
        });


        /**
         * guest page
         */


        findGuestButton.setOnAction(actionEvent -> {

            Guest guest = fasadGuest.findById(Integer.parseInt(guestIdTextField.getText()));
            guestInfoLabel.setText(guest.toString());
            /*
            auto-fill
             */

            guestNameTextField.setText(guest.getName());
            LastNameTextField.setText(guest.getLastName());
            AgeTextField.setText(guest.getAge().toString());
            phoneTextField.setText(guest.getPhone());
            emailTextField.setText(guest.getEmail());
            addressTextField.setText(guest.getAddress());
            refreshGuestTable();


        });
        deleteGuestButton.setOnAction(actionEvent -> {
            fasadGuest.deleteGuest(Integer.parseInt(guestIdTextField.getText()));
            guestInfoLabel.setText("delete");
            refreshGuestTable();
        });
        createGuestButton.setOnAction(actionEvent -> {
            GuestGender guestGender = GuestGender.MALE;
            if (maleGuestRadioButton.isSelected())
                guestGender = GuestGender.MALE;
            if (femaleGuestRadioButton.isSelected())
                guestGender = GuestGender.FEMALE;
            Guest guest = fasadGuest.createNewGuest(
                    guestNameTextField.getText()
                    , LastNameTextField.getText()
                    , Integer.parseInt(AgeTextField.getText())
                    , phoneTextField.getText()
                    , guestGender
                    , emailTextField.getText()
                    , addressTextField.getText());
            guestInfoLabel.setText(guest.toString());
            guestIdTextField.setText(guest.getGuestNumber().toString());
            refreshGuestTable();

        });
        updateGuestButton.setOnAction(actionEvent -> {
            GuestGender guestGender = GuestGender.MALE;
            if (maleGuestRadioButton.isSelected())
                guestGender = GuestGender.MALE;
            if (femaleGuestRadioButton.isSelected())
                guestGender = GuestGender.FEMALE;
            Guest guest = fasadGuest.findById(Integer.parseInt(guestIdTextField.getText()));
            guest.setName(guestNameTextField.getText());
            guest.setLastName(LastNameTextField.getText());
            guest.setAge(Integer.parseInt(AgeTextField.getText()));
            guest.setGuestGender(guestGender);
            guest.setPhone(phoneTextField.getText());
            guest.setEmail(emailTextField.getText());
            guest.setAddress(addressTextField.getText());
            fasadGuest.updateGuest(guest);
            refreshGuestTable();

        });


        /**
         * room page
         */
        roomStarsComboBox.getItems().addAll(1, 2, 3, 4, 5);
        roomStatusComboBox.getItems().add(RoomStatus.FREE);
        roomStatusComboBox.getItems().add(RoomStatus.REPAIRS);
        roomStatusComboBox.getItems().add(RoomStatus.BUSY);

        findRoomButton.setOnAction(actionEvent -> {

            Integer roomNumber = Integer.parseInt(enterRoomIdTextField.getText());
            if (roomNumber <= fasadRoom.showAllRoom().size() && roomNumber > 0) {
                Room room = fasadRoom.findById(roomNumber);
                roomInfoLabel.setText(room.toString());
                capacityRoomTextField.setText(room.getCapacity().toString());
                priceRoomTextField.setText(room.getPrice().toString());
                roomStarsComboBox.getSelectionModel().select(3);
                roomStatusComboBox.getSelectionModel().select(1);
            } else roomInfoLabel.setText("room not found");
            refreshRoomTable();
        });

        deleteRoomButton.setOnAction(actionEvent -> {
            Integer roomNumber = Integer.parseInt(enterRoomIdTextField.getText());
            if (roomNumber <= fasadRoom.showAllRoom().size() && roomNumber > 0) {
                fasadRoom.deleteRoom(roomNumber);
                roomInfoLabel.setText("delete room");
            } else roomInfoLabel.setText("room not found");
            refreshRoomTable();
        });

        createRoomButton.setOnAction(actionEvent -> {
            RoomStatus roomStatus;
            roomStatus = roomStatusComboBox.getValue();
            Room room = fasadRoom.createRoom(roomStatus
                    , Integer.parseInt(capacityRoomTextField.getText())
                    , Integer.parseInt(priceRoomTextField.getText())
                    , roomStarsComboBox.getValue());
            roomInfoLabel.setText(room.toString());
            enterRoomIdTextField.setText(room.getRoomNumber().toString());
            refreshRoomTable();

        });

        updateRoomButton.setOnAction(actionEvent -> {
            Integer roomNumber = Integer.parseInt(enterRoomIdTextField.getText());
                Room room = fasadRoom.findById(roomNumber);
                room.setRoomStatus(roomStatusComboBox.getValue());
                room.setPrice(Integer.parseInt(priceRoomTextField.getText()));
                room.setCopacity(Integer.parseInt(capacityRoomTextField.getText()));
                room.setStars(roomStarsComboBox.getValue());
                fasadRoom.updateRoom(room);
           refreshRoomTable();
        });


        /**
         * service page
         */
        findServiceButton.setOnAction(actionEvent -> {
            refreshTableService();
            Integer serviceId = Integer.parseInt(enterServiceIDTextField.getText());
            if (serviceId <= fasadService.showAllService().size() && serviceId > 0) {
                serviceInfoLabel.setText(fasadService.findById(Integer.parseInt(enterServiceIDTextField.getText())).toString());
                /*
                auto fill
                 */
                enterServiceIDTextField.setText(fasadService.findById(serviceId).getId().toString());
                serviceNameTextField.setText(fasadService.findById(serviceId).getName().toString());
                servicePriceTextField.setText(fasadService.findById(serviceId).getPrice().toString());
            } else serviceInfoLabel.setText("Service not found");

        });
        createServiceButton.setOnAction(actionEvent -> {
            serviceInfoLabel.setText(fasadService.createNewService(serviceNameTextField.getText(), Integer.parseInt(servicePriceTextField.getText())).toString());
            refreshTableService();


        });
        updateServiceButton.setOnAction(actionEvent -> {
            Service service = fasadService.findById(Integer.parseInt(enterServiceIDTextField.getText()));
            service.setName(serviceNameTextField.getText());
            service.setPrice(Integer.parseInt(servicePriceTextField.getText()));
            fasadService.updateService(service);
            refreshTableService();
        });
        deleteServiceButton.setOnAction(actionEvent -> {
            Integer serviceId = Integer.parseInt(enterServiceIDTextField.getText());
            fasadService.deleteService(serviceId);
            serviceInfoLabel.setText("delete service ");
            refreshTableService();
        });



        /**
         * history page
         */
        getAllHistoryButton.setOnAction(actionEvent -> {
            historyInfoLabel.setText(fasadHistory.getAllHistory().toString());
        });
        getLastFreeGuestInRoomButton.setOnAction(actionEvent -> {
            historyInfoLabel.setText(fasadHistory.getLastThreeGuestInRoom(Integer.parseInt(enterRoomHistoryTextField.getText())).toString());
        });
        showAllRoomGuestButton.setOnAction(actionEvent -> {
            historyInfoLabel.setText(fasadHistory.showAllRoomGuest(Integer.parseInt(enterGuestIdHistoryTextField.getText())).toString());
        });


        exitButton.setOnAction(actionEvent -> {
            System.exit(0);
        });

    }


    FasadService fasadService = FasadService.getInstance();
    FasadGuest fasadGuest = FasadGuest.getInstance();
    FasadRoom fasadRoom = FasadRoom.getInstance();
    FasadOrder fasadOrder = FasadOrder.getInstance();
    FasadHistory fasadHistory = FasadHistory.getInstance();
    LocalDate localDate = LocalDate.now();

    private String mainPath = "/resources/Main.fxml";

    private String guestPathInFile = "src/main/java/com/hdd/guests.dat";
    private String orderPathInFile = "src/main/java/com/hdd/orders.dat";
    private String roomPathInFile = "src/main/java/com/hdd/rooms.dat";
    private String servicePathInFile = "src/main/java/com/hdd/services.dat";
    private String historyPathInFile = "src/main/java/com/hdd/history.dat";


    public void refreshGuestTable() {
        idGuestColumn.setCellValueFactory(new PropertyValueFactory<Guest, Integer>("guestNumber"));
        nameGuestColumn.setCellValueFactory(new PropertyValueFactory<Guest, String>("name"));
        lastNameGuestColumn.setCellValueFactory(new PropertyValueFactory<Guest, String>("lastName"));
        ageGuestColumn.setCellValueFactory(new PropertyValueFactory<Guest, Integer>("age"));
        genderguestColumn.setCellValueFactory(new PropertyValueFactory<Guest, GuestGender>("guestGender"));
        phoneGuestColumn.setCellValueFactory(new PropertyValueFactory<Guest, String>("phone"));
        emailGuestColumn.setCellValueFactory(new PropertyValueFactory<Guest, String>("email"));
        addressGuestColumn.setCellValueFactory(new PropertyValueFactory<Guest, String>("address"));
        ObservableList<Guest> guests = FXCollections.observableArrayList(fasadGuest.showAllGuests());
        guestTable.setItems(guests);


    }

    public void refreshRoomTable() {
        idRoomColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>("roomNumber"));
        roomStatusColumn.setCellValueFactory(new PropertyValueFactory<Room, RoomStatus>("roomStatus"));
        priceRoomColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>("price"));
        capacityRoomColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>("capacity"));
        starsRoomColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>("stars"));
        ObservableList<Room> rooms = FXCollections.observableArrayList(fasadRoom.showAllRoom());
        roomTable.setItems(rooms);
    }

    public void refreshOrderTable() {

        idOrderColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("id"));
        guestsOrderColumn.setCellValueFactory(new PropertyValueFactory<Order, Guest>("guest"));
        roomOrderColumn.setCellValueFactory(new PropertyValueFactory<Order, Room>("room"));
        serviceOrderColumn.setCellValueFactory(new PropertyValueFactory<Order, Service>("services"));
        dayOrderColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("daysOfStay"));
        dayOfSettlingOrderColumn.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("localDate"));
        AllAmountOrderColumn.setCellValueFactory(new PropertyValueFactory<Order,Integer>("allAmount"));

        ObservableList<Order> orders = FXCollections.observableArrayList(FasadOrder.getInstance().showAllOrder());
        orderTable.setItems(orders);

    }

    public void refreshTableService() {
        idServiceColumn.setCellValueFactory(new PropertyValueFactory<Service, Integer>("id"));
        nameServiceColumn.setCellValueFactory(new PropertyValueFactory<Service, String>("name"));
        priceServiceColumn.setCellValueFactory(new PropertyValueFactory<Service, Integer>("price"));
        ObservableList<Service> services = FXCollections.observableArrayList(fasadService.showAllService());
        serviceTable.setItems(services);
    }


    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 1249, 882));
    }
}
