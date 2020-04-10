package LogicLayer;

import DataLayer.IDataManager;
import ServiceLayer.IController;

public class Guest {

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
        User user = data.getUser(userName, password);
        return user;
    }

    public boolean checkIfEmailExists(String email) {
        return data.checkIfEmailExists(email);
    }

    public void addNewUser(User newUser) {
        data.addNewUser(newUser);
        system.addUser(newUser);
        system.removeGuest(this);
    }
}
