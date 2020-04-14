package LogicLayer;


import java.util.ArrayList;
import java.util.List;

public class Page {
    private List<User> followers;
    private RoleHolder roleHolder;
    private List<String> updates;

    public Page(RoleHolder roleHolder) {
        followers = new ArrayList<>();
        updates = new ArrayList<>();
        this.roleHolder = roleHolder;

    }



}
