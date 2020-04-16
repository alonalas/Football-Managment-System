package LogicLayer;

import DataLayer.IDataManager;
import ServiceLayer.IController;

import java.util.List;

public class Guest {

    private IDataManager data;

    public Guest(IDataManager data) {
        this.data = data;
    }

    public User createNewUser(String email, String password, String firstName, String lastName){
        User newUser = new User(email, password, firstName, lastName,data);
        Fan fan = new Fan(newUser,firstName);
        newUser.getRoles().add(fan);
        addNewUser(newUser,true);
        return newUser;
    }

    public User signIn(String email, String password){
        User signedInUser = data.getUser(email, password);
        return signedInUser;
    }

    public boolean checkIfEmailExists(String email) {
        return data.checkIfEmailExists(email);
    }

    public void addNewUser(User newUser,boolean isNewUser) {
        if (isNewUser && newUser != null){
            data.addNewUser(newUser);
        }
    }

    public boolean Authentication(String password){
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

    public List<Game> retrieveGames() {
        return data.getGameList();
    }

    public List<Player> retrievePlayers() {
        return data.getPlayers();
    }

    public List<League> retrieveLeagues() {
        return data.getLeagueList();
    }

    public List<Team> retrieveTeams() {
        return data.getTeamList();
    }

    public List<Season> retrieveSeasons(){
        return data.getSeasonList();
    }

    public List<Coach> retrieveCoaches() {
        return data.getCoaches();
    }

    public List<Owner> retrieveOwners() {
        return data.getOwners();
    }

    public List<Manager> retrieveManagers() {
        return data.getManagers();
    }

    public List<User> SearchUserByName(String name) {
        return data.searchUserByName(name);
    }

    public List<League> SearchLeagueByName(String league) {
        return data.searchLeagueByName(league);
    }

    public List<Team> SearchTeamByName(String team) {
        return  data.searchTeamByName(team);
    }
}
