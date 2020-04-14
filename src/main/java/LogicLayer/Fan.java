package LogicLayer;

import java.io.Serializable;

public class Fan extends Role implements Serializable {

    private String name;

    public Fan(User user, String name) {
        super(user);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
