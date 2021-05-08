package main.actions;

import com.api.fasad.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public abstract class AbstractFasad {
    protected Logger LOGGER= Logger.getLogger(AbstractFasad.class.getName());

  @Autowired
    protected IFasadRoom fasadRoom ;
@Autowired
    protected IFasadGuest fasadGuest;
@Autowired
    protected IFasadService fasadService;
@Autowired
    protected IFasadOrder fasadOrder;
@Autowired
    protected IFasadHistory fasadHistory;
}
