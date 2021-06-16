package test;

import com.senla.api.enums.GuestGender;
import com.senla.api.enums.RoomStatus;
import com.senla.dto.apiDTO.MappingDTO;

import com.senla.fasad.FasadGuest;
import com.senla.fasad.FasadOrder;
import com.senla.fasad.FasadRoom;
import com.senla.fasad.FasadService;
import com.senla.model.Guest;
import com.senla.model.Order;
import com.senla.model.Room;
import com.senla.model.Service;
import com.senla.springWeb.WebConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.time.LocalDate;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class FasadTest {
    @Resource
    FasadGuest fasadGuest;
    @Resource
    FasadRoom fasadRoom;
    @Resource
    FasadOrder fasadOrder;
    @Resource
    FasadService fasadService;
    @Resource
    MappingDTO mappingDTO;

    @Test
    public void findByIdGuest() {
        Integer id = 1;
        Guest guest = fasadGuest.findById(id);
        Assert.assertNotNull(guest);
        Assert.assertEquals(id, guest.getGuestNumber());
    }

    @Test
    public void updateGuest() {
        Integer id = 1;
        String name = "Olia";
        Guest guest = fasadGuest.findById(1);
        guest.setName(name);
        fasadGuest.updateGuest(guest);
        Assert.assertNotNull(guest);
        Assert.assertEquals(fasadGuest.findById(1).getName(), name);
    }

    @Test
    public void createNewGuest() {
        Assert.assertNotNull(fasadGuest.createNewGuest("name", "lastname", 23, "12312312", GuestGender.MALE, "asdasda", "asdasd"));
    }

    @Test
    public void getAllGuest() {
        Assert.assertNotNull(fasadGuest.showAllGuests());
    }

    @Test
    public void findByIdRoom() {
        Integer id = 1;
        Room room = fasadRoom.findById(1);
        Assert.assertNotNull(room);
        Assert.assertEquals(id, room.getId());
    }

    @Test
    public void createNewRoom() {
        Assert.assertNotNull(fasadRoom.createRoom(RoomStatus.BUSY, 23, 23, 2));
    }

    @Test
    public void getAllRoom() {
        Assert.assertNotNull(fasadRoom.showAllRoom());
    }

    @Test
    public void updateRoom() {
        Integer id = 1;
        Integer price = 6000;
        Room room = fasadRoom.findById(1);
        room.setPrice(price);
        fasadRoom.updateRoom(room);
        Assert.assertNotNull(room);
        Assert.assertEquals(id, room.getId());
    }

    @Test
    public void findByIdService() {
        Integer id = 1;
        Service service = fasadService.findById(id);
        Assert.assertNotNull(service);
        Assert.assertEquals(service.getId(), id);
    }

    @Test
    public void updateService() {
        Integer id = 1;
        Integer price = 2000;
        Service service = fasadService.findById(1);
        service.setPrice(price);
        fasadService.updateService(service);
        Assert.assertNotNull(service);
        Assert.assertEquals(service.getId(), id);
    }

    @Test
    public void getAllService() {
        Assert.assertNotNull(fasadService.showAllService());
    }

    @Test
    public void createNewService() {
        Assert.assertNotNull(fasadService.createNewService("GOGOGO", 400));
    }

    @Test
    public void findByIdOrder() {
        Integer id = 1;
        Order order = fasadOrder.findByID(id);
        Assert.assertNotNull(order);
        Assert.assertEquals(order.getId(), id);
    }

    @Test
    public void getAllOrder() {
        Assert.assertNotNull(fasadOrder.showAllOrder());
    }

    @Test
    public void updateOrder() {
        Integer id = 1;
        Order order = fasadOrder.findByID(id);
        Integer days = 60;
        order.setDaysOfStay(days);
        fasadOrder.updateOrder(order);
        Assert.assertNotNull(order);
        Assert.assertEquals(fasadOrder.findByID(id).getDaysOfStay(), days);
    }

    @Test
    public void createNewOrder() {
        Service service = fasadService.createNewService("GOGOGO", 400);
        Guest guest = fasadGuest.createNewGuest("name", "lastname", 23, "12312312", GuestGender.MALE, "asdasda", "asdasd");
        Room room = fasadRoom.createRoom(RoomStatus.BUSY, 23, 23, 2);
        Assert.assertNotNull(fasadOrder.createNewOrder(guest, room, service, LocalDate.now(), 20));
    }
    @Test
    public void mappingDTO(){
        Integer id=1;
        Assert.assertNotNull(mappingDTO.mapGuestToGuestDTO(fasadGuest.findById(id)));
        Assert.assertNotNull(mappingDTO.mapRoomToRoomDTO(fasadRoom.findById(id)));
        Assert.assertNotNull(mappingDTO.mapServiceToServiceDTO(fasadService.findById(id)));
        Assert.assertNotNull(mappingDTO.mapOrderToOrderDTO(fasadOrder.findByID(id)));
    }


}
