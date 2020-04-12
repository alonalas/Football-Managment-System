package LogicLayer;

import DataLayer.IDataManager;
import ServiceLayer.IController;

import java.util.List;

public class Guest {

    private IController system;
    private IDataManager data;

    public Guest(IController system, IDataManager data) {
        this.data = data;
        this.system = system;
    }

    public IController getSystem() {
        return system;
    }

    public User signIn(String email, String password){
        User signedInUser = data.getUser(email, password);
        return signedInUser;
    }

    public boolean checkIfEmailExists(String email) {
        return data.checkIfEmailExists(email);
    }

    public void addNewUser(User newUser,boolean isNewUser) {
        if (isNewUser){
            data.addNewUser(newUser);
        }
        system.addUser(newUser);
        system.removeGuest(this);
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

    public User SearchUserByName(String name) {
        return data.searchUserByName(name);
    }

    public League SearchLeagueByName(String league) {
        return data.searchLeagueByName(league);
    }

    public Team SearchTeamByName(String team) {
        return  data.searchTeamByName(team);
    }
}
