package DataLayer;
import LogicLayer.*;

import java.util.List;
import java.util.Map;

public interface IDataManager {

    User getUser(String userName, String password);

    boolean checkIfEmailExists(String email);

    void addNewUser(User newUser);

    List<Guest> getGuestsList();

    void setGuestsList(List<Guest> guestsList);

    List<User> getUserList();

    void setUserList(List<User> userList);

    Map<User, List<Alert>> getAlerts();

    void setAlerts(Map<User, List<Alert>> alerts);

    Map<User, List<Complaint>> getComplaint();

    void setComplaint(Map<User, List<Complaint>> complaint);

    List<League> getLeagueList();

    void setLeagueList(List<League> leagueList);

    List<Season> getSeasonList();

    void setSeasonList(List<Season> seasonList);

    List<Team> getTeamList();

    void setTeamList(List<Team> teamList);

    List<Page> getPageList();

    List<Game> getGameList();

    List<Coach> getCoaches();

    List<Owner> getOwners();

    List<Manager> getManagers();

    List<Player> getPlayers();

    List<User> searchUserByName(String name);

    List<String> getHistory(Fan fan);

    void addComplaint(User user, Complaint newComplaint);

    List<League> searchLeagueByName(String league);

    List<Team> searchTeamByName(String team);

    void addNameHistory(Fan fan, String query);

    void addKeyWordHistory(Fan fan, String query);

    void addCategoryHistory(Fan fan, String query);

    List<String> getCategorySearchHistory(Fan fan);

    List<String> getKeyWordSearchHistory(Fan fan);

    List<String> getNameSearchHistory(Fan fan);
}
