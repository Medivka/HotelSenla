package main.actions;


import com.senla.api.fasad.*;
import main.springConfig.SpringBeans;

import java.util.logging.Logger;

public abstract class AbstractFasad {
    protected Logger LOGGER= Logger.getLogger(AbstractFasad.class.getName());


    protected IFasadRoom fasadRoom = SpringBeans.fasadRoom;

    protected IFasadGuest fasadGuest=SpringBeans.fasadGuest;

    protected IFasadService fasadService=SpringBeans.fasadService;

    protected IFasadOrder fasadOrder=SpringBeans.fasadOrder;

    protected IFasadHistory fasadHistory=SpringBeans.fasadHistory;
}
