package ServiceLayer;

import LogicLayer.*;

import java.util.List;

public class GuestService implements IGuestService{
    private Guest guest;

    public GuestService(Guest guest) {
        this.guest = guest;
    }

    /**
     * Use Case - 2.1
     * Register to the System
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
     * User Login
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
            if (!((c>='A' && c<='z')||(c>='0' && c<='9'))){
                System.out.println("## Password can contain only digits and letters. ##");
                return false;
            }
        }
        if(password.length()<8){
            System.out.println("## Password must has at least 8 characters. ##");
            return false;
        }
        return true;
    }


    /**
     * Use Case - 2.3
     * Show public information
     * @param interestIn
     */
    public void showInformation(Interest interestIn){
        switch (interestIn) {
            case Games:
                List<Game> gamesInfo = guest.retrieveGames();
                break;
            case Players:
                List<Player> playersInfo = guest.retrievePlayers();
                break;
            case Leagues:
                List<League> leaguesInfo = guest.retrieveLeagues();
                break;
            case Teams:
                List<Team> teamsInfo = guest.retrieveTeams();
                break;
        }
    }

    enum Interest {
        Players,
        Teams,
        Leagues,
        Games
    }


}
