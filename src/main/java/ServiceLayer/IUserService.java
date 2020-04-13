package ServiceLayer;
import LogicLayer.*;

import java.io.IOException;
import java.util.List;

public interface IUserService {

    void addPage(Page newPage) throws IOException;
    List<User> getSystemUsers() ;

}
