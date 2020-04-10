package ServiceLayer;
import LogicLayer.*;

import java.io.IOException;

public interface IUserService {

    void addPage(Page newPage) throws IOException;

    void insertNewAssetType (Owner owner) throws IOException;
}
