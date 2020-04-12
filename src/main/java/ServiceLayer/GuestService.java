package ServiceLayer;

import LogicLayer.*;

import java.util.List;

public class GuestService implements IGuestService{
    private Guest guest;

    public GuestService(Guest guest) {
        this.guest = guest;
    }

    /**Use Case - 2.1
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
    //Need to implement tostrings!

    public void showInformationByCategory(Interest interestIn){
        switch (interestIn) {
            case Games:
                List<Game> gamesInfo = guest.retrieveGames();
                for (Game game: gamesInfo){
                    System.out.println(game.toString());
                }
                break;
            case Players:
                List<Player> playersInfo = guest.retrievePlayers();
                for (Player player: playersInfo){
                    System.out.println(player.toString());
                }
                break;
            case Leagues:
                List<League> leaguesInfo = guest.retrieveLeagues();
                for (League league: leaguesInfo){
                    System.out.println(league.toString());
                }
                break;
            case Teams:
                List<Team> teamsInfo = guest.retrieveTeams();
                for (Team team: teamsInfo){
                    System.out.println(team.toString());
                }
                break;
            case Seasons:
                List<Season> seasonsInfo = guest.retrieveSeasons();
                for (Season season: seasonsInfo){
                    System.out.println(season.toString());
                }
                break;
            case Coaches:
                List<Coach> coachesInfo = guest.retrieveCoaches();
                for (Coach coach: coachesInfo){
                    System.out.println(coach.toString());
                }
                break;
            case Owners:
                List<Owner> ownersInfo = guest.retrieveOwners();
                for (Owner owner: ownersInfo){
                    System.out.println(owner.toString());
                }
                break;
            case Managers:
                List<Manager> managersInfo = guest.retrieveManagers();
                for (Manager manager: managersInfo){
                    System.out.println(manager.toString());
                }
                break;
        }
    }

    /**
     * USE CASE - 2.4
     * Search Information By Name
     * @param name
     */
    public void searchInformation(String name){
        User retrievedUser =  guest.SearchUserByName(name);
        if(retrievedUser == null){
            System.out.println("## There is no person with this name ##");
            return;
        }
        System.out.println(retrievedUser.toString());
    }

    /**
     * USE CASE - 2.4
     * Search Information By Category
     * @param interested
     */
    public void searchInformation(Interest interested){
        showInformationByCategory(interested);
    }

    /**
     * USE CASE - 2.4
     * Search Information By Keywords
     * @param query
     */
    public void searchInformationByKeyWord(String query){
        switch (query.toLowerCase()){
            case "coaches":
                searchInformation(Interest.Coaches);
                break;
            case "games":
                searchInformation(Interest.Games);
                break;
            case "managers":
                searchInformation(Interest.Managers);
                break;
            case "owners":
                searchInformation(Interest.Owners);
                break;
            case "players":
                searchInformation(Interest.Players);
                break;
            case "seasons":
                searchInformation(Interest.Seasons);
                break;
            case "teams":
                searchInformation(Interest.Teams);
                break;
            case "leagues":
                searchInformation(Interest.Leagues);
                break;
            default:
                // Users (players, coaches, etc.)
                searchInformation(query);
                // Teams
                searchTeams(query);
                // Leagues
                searchLeagues(query);
        }
    }

    private void searchLeagues(String league) {
        League retrievedLeague =  guest.SearchLeagueByName(league);
        if(retrievedLeague == null){
            System.out.println("## There is no person with this name ##");
            return;
        }
        System.out.println(retrievedLeague.toString());
    }

    private void searchTeams(String team) {
        Team retrievedTeam =  guest.SearchTeamByName(team);
        if(retrievedTeam == null){
            System.out.println("## There is no person with this name ##");
            return;
        }
        System.out.println(retrievedTeam.toString());
    }


}
