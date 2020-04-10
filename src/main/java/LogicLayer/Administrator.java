package LogicLayer;

import ServiceLayer.IController;

import java.util.List;

public class Administrator extends User{
    public Administrator(String email, String password, String userName, IController system, List<Role> roles) {
        super(email,password,userName);
    }
}
