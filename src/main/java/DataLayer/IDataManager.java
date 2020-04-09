package DataLayer;
import LogicLayer.*;

public interface IDataManager {

    User getUser(String userName, String password);
}
