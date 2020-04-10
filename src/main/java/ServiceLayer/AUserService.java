package ServiceLayer;

import LogicLayer.*;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;

public abstract class AUserService implements IUserService{

    Controller control;

    public AUserService(Controller control) {
        this.control = control;
    }

    public void addPage(Page newPage) throws IOException {
        throw new IOException("Eitan");
    }

}
