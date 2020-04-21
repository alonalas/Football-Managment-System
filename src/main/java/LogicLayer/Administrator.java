package LogicLayer;

import java.io.Serializable;

public class Administrator extends User implements Serializable {
    public Administrator(String email, String password, String userName) {
        super(email,password,userName);
    }


}
