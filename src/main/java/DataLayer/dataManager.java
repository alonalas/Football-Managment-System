package DataLayer;
import LogicLayer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class dataManager implements IDataManager {

    private List<Guest> guestsList;
    private List<User> userList;
    private Map<User, List<Alert>> Alerts;
    private Map<User, List<Complaint>> complaint;
    private List<League> leagueList;
    private List<Season> seasonList;
    private List<Team> teamList;
    private List<Page> pageList;
    private List<Game> gameList;


    public boolean checkIfEmailExists(String email) {
        for (User user : userList){
            if (user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public void addNewUser(User newUser) {
        userList.add(newUser);
    }

    public User getUser(String email, String password){
        for (User user : userList){
            if (user.getEmail().equals(email)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public List<Guest> getGuestsList() {
        return guestsList;
    }

    public void setGuestsList(List<Guest> guestsList) {
        this.guestsList = guestsList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Map<User, List<Alert>> getAlerts() {
        return Alerts;
    }

    public void setAlerts(Map<User, List<Alert>> alerts) {
        Alerts = alerts;
    }

    public Map<User, List<Complaint>> getComplaint() {
        return complaint;
    }

    public void setComplaint(Map<User, List<Complaint>> complaint) {
        this.complaint = complaint;
    }

    public List<League> getLeagueList() {
        return leagueList;
    }

    public void setLeagueList(List<League> leagueList) {
        this.leagueList = leagueList;
    }

    public List<Season> getSeasonList() {
        return seasonList;
    }

    public void setSeasonList(List<Season> seasonList) {
        this.seasonList = seasonList;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public List<Page> getPageList() {
        return pageList;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public List<Coach> getCoaches() {
        List<Coach>coaches = new ArrayList<Coach>();
        for (User user: userList){
            List<Role>userRoles = user.getRoles();
            for (Role role: userRoles){
                if (role instanceof Coach){
                    coaches.add((Coach)role);
                }
            }
        }
        return coaches;
    }

    public List<Owner> getOwners() {
        List<Owner>owners = new ArrayList<Owner>();
        for (User user: userList){
            List<Role>userRoles = user.getRoles();
            for (Role role: userRoles){
                if (role instanceof Coach){
                    owners.add((Owner) role);
                }
            }
        }
        return owners;
    }

    public List<Manager> getManagers() {
        List<Manager>managers = new ArrayList<Manager>();
        for (User user: userList){
            List<Role>userRoles = user.getRoles();
            for (Role role: userRoles){
                if (role instanceof Coach){
                    managers.add((Manager) role);
                }
            }
        }
        return managers;
    }

    public List<Player> getPlayers() {
        List<Player>players = new ArrayList<Player>();
        for (User user: userList){
            List<Role>userRoles = user.getRoles();
            for (Role role: userRoles){
                if (role instanceof Coach){
                    players.add((Player) role);
                }
            }
        }
        return players;
    }

    public User searchUserByName(String name) {
        String[] splitted = name.split(" ");
        for (User user: userList){
            if (user.getFirstName().equals(splitted[0]) && user.getLastName().equals(splitted[1])){
                return user;
            }
        }
        return null;
    }

    @Override
    public League searchLeagueByName(String leagueName) {
        for (League league: leagueList){
            if (league.getName().toLowerCase().equals(leagueName.toLowerCase())){
                return league;
            }
        }
        return null;
    }

    @Override
    public Team searchTeamByName(String teamName) {
        for (Team team: teamList){
            if (team.getName().toLowerCase().equals(teamName.toLowerCase())){
                return team;
            }
        }
        return null;
    }
}


