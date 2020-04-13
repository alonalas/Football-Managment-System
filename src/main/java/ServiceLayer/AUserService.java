package ServiceLayer;

import LogicLayer.Page;

import java.io.IOException;

public abstract class AUserService implements IUserService{

    public void addPage(Page newPage) throws IOException {
        throw new IOException("not possible");
    }

    public void logOut() throws IOException {
        throw new IOException("not possible");
    }

    // Test Merging
}
