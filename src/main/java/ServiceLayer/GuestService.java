package ServiceLayer;

import LogicLayer.Fan;
import LogicLayer.Guest;
import LogicLayer.User;

public class GuestService implements IGuestService{
    private Guest guest;

    public GuestService(Guest guest) {
        this.guest = guest;
    }

    public void register(String firstName, String lastName, String email, String password){
        for (char c : password.toCharArray()){
            if (!((c>='a' && c<='Z')||(c>='0' && c<='9'))){
                System.out.println("## Password can contain only digits and letters. ##");
                return;
            }
        }
        boolean isExists = guest.checkIfEmailExists(email);
        if (isExists == true){
            System.out.println("## user with this email exists in system. ##");
            return;
        }
        User newUser = new User(email, password, firstName, lastName);
        Fan fan = new Fan(newUser,firstName);
        newUser.getRoles().add(fan);
        guest.addNewUser(newUser);
        System.out.println("## Registered to system successfully ##");
    }
}
