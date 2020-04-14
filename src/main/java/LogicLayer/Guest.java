package LogicLayer;

import DataLayer.IDataManager;
import ServiceLayer.IController;

import java.io.Serializable;

public class Guest implements Serializable {

    private IController system;
    private IDataManager data;

    public Guest(IController system, IDataManager data) {
        this.data = data;
        this.system = system;
    }

    public IController getSystem() {
        return system;
    }

    public User signIn(String userName, String password){
        User user = data.getUserByPassword(userName, password);
        return user;
    }

}
