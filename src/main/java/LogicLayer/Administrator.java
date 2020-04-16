package LogicLayer;

import ServiceLayer.IController;

import java.util.List;

public class Administrator extends User{

    public Administrator(String email, String password, String firstName, String lastName) {
        super(email, password, firstName,lastName,null);
    }
}
