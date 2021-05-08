package main.actions;

import com.springConfig.SpringBeans;
import com.api.fasad.*;

import java.util.logging.Logger;

public abstract class AbstractFasad {
    protected Logger LOGGER= Logger.getLogger(AbstractFasad.class.getName());


    protected IFasadRoom fasadRoom = SpringBeans.fasadRoom;

    protected IFasadGuest fasadGuest=SpringBeans.fasadGuest;

    protected IFasadService fasadService=SpringBeans.fasadService;

    protected IFasadOrder fasadOrder=SpringBeans.fasadOrder;

    protected IFasadHistory fasadHistory=SpringBeans.fasadHistory;
}
