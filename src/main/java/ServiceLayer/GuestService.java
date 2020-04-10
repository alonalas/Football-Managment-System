package ServiceLayer;

import LogicLayer.Fan;
import LogicLayer.Guest;
import LogicLayer.User;

public class GuestService implements IGuestService{
    private Guest guest;

    public GuestService(Guest guest) {
        this.guest = guest;
    }

    /**
     * Use Case - 2.1
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     */
    public void register(String firstName, String lastName, String email, String password){
        boolean passwordIsOk = Authentication(password);
        if(passwordIsOk == false){
            return;
        }
        boolean isExists = guest.checkIfEmailExists(email);
        if (isExists == true){
            System.out.println("## user with this email exists in system. ##");
            return;
        }
        User newUser = new User(email, password, firstName, lastName);
        Fan fan = new Fan(newUser,firstName);
        newUser.getRoles().add(fan);
        guest.addNewUser(newUser,true);
        System.out.println("## Registered to system successfully ##");
    }

    /**
     * Use Case - 2.2
     * @param email
     * @param password
     */
    public void logIn(String email, String password){
        boolean passwordIsOk = Authentication(password);
        if(passwordIsOk == false){
            return;
        }
        User userToSignIn = guest.signIn(email, password);
        if (userToSignIn == null){
            System.out.println("## Wrong email or password ##");
            return;
        }
        guest.addNewUser(userToSignIn,false);
    }

    private boolean Authentication(String password){
        for (char c : password.toCharArray()){
            if (!((c>='a' && c<='Z')||(c>='0' && c<='9'))){
                System.out.println("## Password can contain only digits and letters. ##");
                return false;
            }
        }
        return true;
    }
}
