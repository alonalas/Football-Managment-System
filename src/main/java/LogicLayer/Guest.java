package LogicLayer;

import DataLayer.IDataManager;

public class Guest {

    private system system;
    private IDataManager data;

    public Guest(system system, IDataManager data) {
        this.data = data;
        this.system = system;
    }

    public system getSystem() {
        return system;
    }

    public User signIn(String userName, String password){
        User user = data.getUser(userName, password);
        return user;
    }

}
