package ServiceLayer;

import LogicLayer.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// New System
public class Controller implements IController{

    private List<Guest> currentGuestsList;
    private Map<Guest,IGuestService> GuestServices;
    private List<User> currentUserList;
    private Map<User,List<IUserService>> UserServices;
    private Representitive representitive;
    private Administrator administrator;


    public Controller(Representitive representitive, Administrator administrator) {
        this.representitive = representitive;
        this.administrator = administrator;
        currentGuestsList = new ArrayList<Guest>();
        currentUserList = new ArrayList<User>();
    }

    /**
     * displays the team's asset's details to the screen
     * @param roleHolder
     * @param stadium
     */
    public void displayForm(RoleHolder roleHolder, boolean stadium) {

        if (stadium)
            System.out.println("Name : String");
        else {
            Field[] declaredFields = roleHolder.getClass().getDeclaredFields();
            for (Field f : declaredFields) {
                System.out.println(f.getName() + " : " + f.getType().getSimpleName());
            }
        }
    }

    public List<Guest> getGuestsList() {
        return currentGuestsList;
    }

    public void setGuestsList(List<Guest> guestsList) {
        this.currentGuestsList = guestsList;
    }

    public List<User> getUserList() {
        return currentUserList;
    }

    public void setUserList(List<User> userList) {
        this.currentUserList = userList;
    }


    public RoleHolder getRoleHolder(String assetType) {
        switch (assetType) {
            case "Player":
                return new Player();
            case "Coach":
                return new Coach();
            case "Manager":
                return new Manager();
            default:
                return null;
        }
    }
}
