package ServiceLayer;

import LogicLayer.Page;

import java.io.IOException;

public abstract class AUserService implements IUserService{

    public void addPage(Page newPage) throws IOException {
        throw new IOException("Eitan");
    }
}
