package DataLayer;
import LogicLayer.*;
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
}


