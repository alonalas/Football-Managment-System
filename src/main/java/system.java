import java.util.ArrayList;
import java.util.List;


public class system {

    private List<Guest> currentGuestsList;
    private List<User> currentUserList;
    private Representitive representitive;
    private Administrator administrator;


    public system(Representitive representitive, Administrator administrator) {
        this.representitive = representitive;
        this.administrator = administrator;
        currentGuestsList = new ArrayList<Guest>();
        currentUserList = new ArrayList<User>();
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


}
