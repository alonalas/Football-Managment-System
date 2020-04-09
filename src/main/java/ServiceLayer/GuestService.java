package ServiceLayer;

import LogicLayer.Guest;
import LogicLayer.User;

public class GuestService extends AUserService{
    private Guest guest;


    private void signIn(String g, String f){
        User user = guest.signIn(g,f);
    }
}
