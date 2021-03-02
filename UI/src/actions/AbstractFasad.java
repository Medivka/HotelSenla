package actions;

import fasad.*;
import service.GuestService;

import java.util.logging.Logger;

public abstract class AbstractFasad {
    protected Logger LOGGER= Logger.getLogger(AbstractFasad.class.getName());
    protected FasadRoom fasadRoom = FasadRoom.getInstance();
    protected FasadGuest fasadGuest = FasadGuest.getInstance();
    protected FasadService fasadService = FasadService.getInstance();
    protected FasadOrder fasadOrder = FasadOrder.getInstance();
    protected FasadHistory fasadHistory = FasadHistory.getInstance();
}
