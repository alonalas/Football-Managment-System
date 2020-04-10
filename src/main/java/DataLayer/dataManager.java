package DataLayer;
import LogicLayer.*;
import org.apache.log4j.Logger;

import java.util.Date;
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
    private static final Logger systemLoger = Logger.getLogger(dataManager.class);

    public User getUser(String userName, String password){
        for (User user : userList){
            if (user.getUserName().equals(userName)&&user.getPassword().equals(password)){
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
     * @return
     */
    public Season SearchSeason( Date start ,Date End) {
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


