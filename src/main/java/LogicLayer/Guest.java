package LogicLayer;

import DataLayer.IDataManager;
import ServiceLayer.IController;

import java.io.Serializable;
import java.util.List;

public class Guest implements Serializable {

    private IDataManager data(){
        return DataComp.getInstance();
    }

    public Guest() { }

    public User createNewUser(String email, String password, String firstName, String lastName){
        User newUser = new User(email, password, firstName, lastName);
        Fan fan = new Fan(newUser,firstName);
        newUser.getRoles().add(fan);
        addNewUser(newUser,true);
        return newUser;
    }

    public User signIn(String email, String password){
        User signedInUser = data().getUser(email, password);
        return signedInUser;
    }

    public boolean checkIfEmailExists(String email) {
        return data().checkIfEmailExists(email);
    }

    public void addNewUser(User newUser,boolean isNewUser) {
        if (isNewUser && newUser != null){
            data().addNewUser(newUser);
        }
    }

    public List<Game> retrieveGames() {
        return data().getGameList();
    }

    public List<Player> retrievePlayers() {
        return data().getPlayers();
    }

    public List<League> retrieveLeagues() {
        return data().getLeagueList();
    }

    public List<Team> retrieveTeams() {
        return data().getTeamList();
    }

    public List<Season> retrieveSeasons(){
        return data().getSeasonList();
    }

    public List<Coach> retrieveCoaches() {
        return data().getCoaches();
    }

    public List<Owner> retrieveOwners() {
        return data().getOwners();
    }

    public List<Manager> retrieveManagers() {
        return data().getManagers();
    }

    public List<User> SearchUserByName(String name) {
        return data().searchUserByName(name);
    }

    public List<League> SearchLeagueByName(String league) {
        return data().searchLeagueByName(league);
    }

    public List<Team> SearchTeamByName(String team) {
        return  data().searchTeamByName(team);
    }
}
