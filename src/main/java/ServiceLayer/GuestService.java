package ServiceLayer;

import LogicLayer.Guest;
import LogicLayer.User;

public class GuestService extends AUserService{
    private Guest guest;

    public GuestService(Controller control) {
        super(control);
    }


    private void signIn(String g, String f){
        User user = guest.signIn(g,f);
    }
}
