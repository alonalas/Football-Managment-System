package LogicLayer;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class RoleHolder extends Role {

    public RoleHolder(User user) {
        super(user);
    }

    public RoleHolder() {
        super();
    }

    public String showRoleDetails() {
        String details = "";
        Field[] declaredFields = getClass().getDeclaredFields();
        for (Field f : declaredFields) {
            details = details + f.getName() + " : " + f.toString() + "\n";
        }
        return details;
    }
}
