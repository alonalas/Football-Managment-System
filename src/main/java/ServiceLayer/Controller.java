package ServiceLayer;

import LogicLayer.Administrator;
import LogicLayer.Guest;
import LogicLayer.Representitive;
import LogicLayer.User;
import com.sun.corba.se.impl.ior.JIDLObjectKeyTemplate;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
    private static String configurationPath = "configurations.txt";

    public Controller() {
        try{
            FileInputStream configurationFile = new FileInputStream(new File(configurationPath));
            init(configurationFile);
        }catch(IOException IOE){
            System.out.println("## There is no conf. file ##");
            IOE.printStackTrace();
        }
    }

    private void init(FileInputStream configuration) {

        this.representitive = representitive;
        this.administrator = administrator;
        currentGuestsList = new ArrayList<Guest>();
        GuestServices = new HashMap<Guest, IGuestService>();
        UserServices = new HashMap<User, List<IUserService>>();
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
