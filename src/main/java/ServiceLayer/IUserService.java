package ServiceLayer;
import LogicLayer.Page;

import java.io.IOException;

public interface IUserService {

    void addPage(Page newPage) throws IOException;
}
