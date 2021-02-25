package actions;

import fasad.*;

public abstract class AbstractFasad {

    protected FasadRoom fasadRoom=FasadRoom.getInstance();
    protected FasadGuest fasadGuest=FasadGuest.getInstance();
    protected FasadService fasadService=FasadService.getInstance();
    protected FasadOrder fasadOrder=FasadOrder.getInstance();
    protected FasadHistory fasadHistory=FasadHistory.getInstance();




}
