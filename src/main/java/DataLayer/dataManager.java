package DataLayer;
import LogicLayer.*;

import java.util.ArrayList;
import java.util.HashMap;
//import com.sun.org.apache.xml.internal.security.encryption.ReferenceList;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Map;

public class dataManager implements IDataManager , Serializable {

    private HashMap<Fan,List<String>>fanSearchHistory;
    private List<Guest> guestsList;
    private List<User> userList;
    private Map<User, List<LogicLayer.Alert>> Alerts;
    private Map<User, List<Complaint>> complaints;
    private List<League> leagueList;
    private List<Season> seasonList;
    private List<Team> teamList;
    private List<Page> pageList;
    private List<Game> gameList;
    private LinkedList<Referee> RefereeList;
    private static final Logger systemLoger = Logger.getLogger(dataManager.class);

    public dataManager() {
        fanSearchHistory = new HashMap<>();
        guestsList = new ArrayList<>();
        userList = new ArrayList<>();
        Alerts = new HashMap<>();
        complaint = new HashMap<>();
        leagueList = new ArrayList<>();
        seasonList = new ArrayList<>();
        teamList = new ArrayList<>();
        pageList = new ArrayList<>();
        gameList = new ArrayList<>();
        RefereeList = new LinkedList<>();
    }

    public void TestReset (){
        this.guestsList =  new LinkedList<>();
        this.userList = new LinkedList<>();
        this.Alerts = new HashMap<>();
        this.complaints = new HashMap<>();
        this.leagueList = new LinkedList<>();
        this.seasonList = new LinkedList<>();
        this.pageList = new LinkedList<>();
        this.RefereeList = new LinkedList<>();
    }


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


    public User getUserByPassword(String userName, String password){
        for (User user : userList){
            if (user.getUserName().equals(userName)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public User getUserByMail(String userName, String email){
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

    /**
     * id: dataManager@1
     * Search League by league type
     * @param leagueType
     * @return League if existing
     */
    public League SearchLeagueByType(League.LeagueType leagueType) {
        for (League league:
             leagueList) {
            if(league.getType() == leagueType){
                return  league;
            }
        }
        return null;
    }

    /**
     * id: dataManager@2
     * add New League To Data
     * @param league to add
     */
    public void addLeague(League league){
        if(SearchLeagueByType(league.getType())==null) {
            leagueList.add(league);
            systemLoger.info("league been added , type:" + league.getType());
        }
    }

    /**
     * id: dataManager@3
     * Search Season by start and end dates
     * @param start date of season
     * @param End date of season
     * @return Season if found, else null
     */
    public Season SearchSeason(String start , String End) {
        for (Season season:
                seasonList) {
            if(season.getEnd().equals(End) && season.getStart().equals(start)  ){
                return  season;
            }
        }
        return null;
    }

    /**
     *id: dataManager@4
     * add new season to data
     * @param season season to add
     */
    public void addSeason(Season season){
        if(SearchSeason(season.getStart() , season.getEnd())==null) {
            seasonList.add(season);
            systemLoger.info("Season been added , linked to League:" + " , Start date:" + season.getStart() +
                    " , End date:" + season.getEnd());
        }else if(SearchSeason(season.getStart() , season.getEnd()).getLeagueList().contains(season.getLeagueList())){
            systemLoger.info("Season Linked to existing League:" + " , Start date:" + season.getStart() +
                    " , End date:" + season.getEnd());
        }
    }

    /**
     * id: dataManager@6
     * add New Referee To Data
     * @param referee
     * @return if added successfully, if not -> already contains the element
     */
    public boolean addReferee(Referee referee){
        if(! RefereeList.contains(referee)){
            RefereeList.add(referee);
            systemLoger.info("new Referee been added , belong to user : "+ referee.getUser().getUserName());
            return true;
        }
        return false;
    }

    /**
      id: dataManager@7
     * remove referee from data
     * @param referee
     * @return
     */
    public boolean removeReferee(Referee referee){
        if(RefereeList.contains(referee)){
            RefereeList.remove(referee);
            systemLoger.info("Referee been removed , belong to user : "+ referee.getUser().getUserName());
            return true;
        }
        return false;
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

    public List<Referee> getRefereeList() {
        return RefereeList;
    }
    /**
     * id: dataManager@10
     * @param user
     * @param alert
     */
    public void addAlert(User user,Alert alert) {
        if (!Alerts.containsKey(user)) {
            List<Alert>alerts = new LinkedList<>();
            alerts.add(alert);
            Alerts.put(user,alerts);
        }
        else
            Alerts.get(user).add(alert);
    }


    public static void writeData(IDataManager data , File file){
        try {
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(data);

            o.close();
            f.close();
        }catch (Exception e){}

    }
    public static IDataManager readData(File file){
        IDataManager Mdata = null;
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
             Mdata = (IDataManager) oi.readObject();

            oi.close();
            fi.close();
        }catch (Exception e){}
        return Mdata;
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

    public List<User> searchUserByName(String name) {
        List<User>retrievedUsers = new ArrayList<>();
        String[] splitted = name.split(" ");
        for (User user: userList){
            if (user.getFirstName().equals(splitted[0]) && user.getLastName().equals(splitted[1])){
                retrievedUsers.add(user);
            }
        }
        return retrievedUsers;
    }

    @Override
    public List<String> getHistory(Fan fan) {
        List<String>searchHistory = fanSearchHistory.get(fan);
        return searchHistory;
    }

    @Override
    public void addSearchHistory(Fan fan, String query) {
        fanSearchHistory.get(fan).add(query);
    }

    @Override
    public void addComplaint(User user, Complaint newComplaint) {
        complaint.get(user).add(newComplaint);
    }

    @Override
    public List<League> searchLeagueByName(String leagueName) {
        List<League> retrievedLeagues = new ArrayList<>();
        for (League league: leagueList){
            if (league.getName().toLowerCase().equals(leagueName.toLowerCase())){
                retrievedLeagues.add(league);
            }
        }
        return retrievedLeagues;
    }

    @Override
    public List<Team> searchTeamByName(String teamName) {
        List<Team> retrievedTeams = new ArrayList<>();
        for (Team team: teamList){
            if (team.getName().toLowerCase().equals(teamName.toLowerCase())){
                retrievedTeams.add(team);
            }
        }
        return retrievedTeams;
    }
}


