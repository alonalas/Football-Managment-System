package DataLayer;
import LogicLayer.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class dataManager implements IDataManager {

    private List<Guest> guestsList;
    private List<User> userList;
    private Map<User, List<LogicLayer.Alert>> Alerts;
    private Map<User, List<Complaint>> complaints;
    private List<League> leagueList;
    private List<Season> seasonList;
    private List<Team> teamList;
    private List<Page> pageList;

    public dataManager() {
        this.guestsList =  new LinkedList<>();
        this.userList = new LinkedList<>();
        this.Alerts = new HashMap<>();
        this.complaints = new HashMap<>();
        this.leagueList = new LinkedList<>();
        this.seasonList = new LinkedList<>();
        this.pageList = new LinkedList<>();
    }

    public User getUser(String userName, String email){
        for (User user : userList){
            if (user.getUserName().equals(userName)&&user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        if(!userList.contains(user))
            userList.add(user);
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

    public Map<User, List<LogicLayer.Alert>> getAlerts() {
        return Alerts;
    }

    public void setAlerts(Map<User, List<Alert>> alerts) {
        Alerts = alerts;
    }

    public Map<User, List<Complaint>> getComplaint() {
        return complaints;
    }

    public void setComplaint(Map<User, List<Complaint>> complaint) {
        this.complaints = complaint;
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

}


