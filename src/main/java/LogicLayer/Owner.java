package LogicLayer;

import DataLayer.dataManager;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Owner extends RoleHolder {

    private String name;
    private List<Team> teamList;
    private dataManager DM;

    public Owner(User user, String name , dataManager dataManager) {
        super(user);
        this.name = name;
        this.teamList = new LinkedList<>();
        this.DM = dataManager;
    }

    /**
     * ID: 1
     * creates a new instance of manager without premissions with the following parameters
     * and connecting it to the requested team
     * @param team
     * @param managerName
     * @param userName
     * @param email
     */
    public void insertNewManager(Team team, String managerName, String userName, String email) {

        User user = this.getAssetUser(userName,email);
        Manager manager = new Manager(user,managerName,team);
        team.setManager(manager);
        manager.setTeam(team);
        user.setRole(manager);
        team.getRoleHolders().add(manager);
    }

    /**
     * ID: 2
     * creates a new instance of coach without with the following parameters
     * and connecting it to the requested team
     * @param team
     * @param name
     * @param qualification
     * @param job
     * @param userName
     * @param email
     */
    public void insertNewCoach(Team team, String name, String qualification, String job, String userName,
                               String email) {
        User user = this.getAssetUser(userName,email);
        Page page = new Page();
        Coach coach = new Coach(user,name,qualification,job,page,team);
        coach.setTeam(team);
        team.setCoach(coach);
        user.setRole(coach);
        team.getRoleHolders().add(coach);
    }

    /**
     * ID: 3
     * creates a new instance of player with the following parameters
     * and connecting it to the requested team
     * @param team
     * @param name
     * @param position
     * @param day
     * @param month
     * @param year
     * @param userName
     * @param email
     */
    public void insertNewPlayer(Team team, String name, String position, int day ,
                                int month, int year , String userName,String email) {
        User user = this.getAssetUser(userName,email);
        String date = day+"-"+month+"-"+year; // check why it's not working
        Page page = new Page();
        Player player = new Player(user,position,team,name, date ,page);
        team.setPlayer(player);
        player.setTeam(team);
        team.setPlayer(player);
        user.setRole(player);
        team.getRoleHolders().add(player);
    }

    /**
     * ID: 4
     * uploads the team's stadium
     * @param team
     * @param stadium
     */
    public void insertNewStadium(Team team, String stadium) {
        team.setStadium(stadium);
    }

    /**
     * ID: 5
     * deletes the player that owns the given user
     * @param teamName
     * @param userName
     * @param email
     */
    public void deletePlayer(String teamName,String userName,String email) {
        User user = getAssetUser(userName,email);
        Team team = getTeam(teamName);
        for ( Role role : user.getRoles() ) {
            if (role instanceof Player) {
                Player player = (Player)role;
                team.getPlayerList().remove(player);
                team.getRoleHolders().remove(player);
                deleteRole(user,player);
            }
        }
    }

    /**
     * ID: 6
     * delete coach only if there is at least one coach in the coachList
     * @param teamName
     * @param userName
     * @param email
     */
    public void deleteCoach(String teamName,String userName,String email) throws IOException {

        Team team = getTeam(teamName);
        if ( team.getCoachList().size() < 2 )
            throw new IOException("Cannot remove the last coach of the team");
        else {
            User user = getAssetUser(userName,email);
            for (Role role : user.getRoles()) {
                if (role instanceof Coach) {
                    Coach coach = (Coach) role;
                    team.getRoleHolders().remove(coach);
                    team.getCoachList().remove(coach);
                    deleteRole(user, coach);
                }
            }
        }
    }

    /**
     * ID: 7
     * Deletes a manager from the team's managerList iff there is more than one manager
     * @param teamName
     * @param userName
     * @param email
     * @throws IOException
     */
    public void deleteManager(String teamName,String userName,String email) throws IOException {

        Team team = getTeam(teamName);
        if (team.getManagerList().size() < 2 ) {
            throw new IOException("Cannot remove the last manager of the team");
        }
        else {
            User user = getAssetUser(userName,email);
            for ( Role role : user.getRoles() ) {
                if (role instanceof Manager) {
                    Manager manager = (Manager)role;
                    team.getManagerList().remove(manager);
                    team.getRoleHolders().remove(manager);
                    deleteRole(user,manager);
                }
            }
        }

    }

    /**
     * ID: 8
     * Deletes a role from the user's roleList
     * @param user
     * @param roleHolder
     */
    private void deleteRole(User user, RoleHolder roleHolder) {
        for ( Role role : user.getRoles()) {
            if (role.equals(roleHolder))
                user.getRoles().remove(role);
        }
    }

    /**
     * ID: 9
     * returns the requiered team
     * @String teamName
     * @return Team
     */
    public Team getTeam(String teamName) {
        for ( Team t : teamList ) {
            if (t.getName().equals(teamName))
                return t;
        }
        return null;
    }

    /**
     * ID: 10
     * retrieves the user list from the dataManager and returns the requiered user
     * @return user list
     */
    private User getAssetUser(String userName, String userEmail) {
        User user = DM.getUserByMail(userName,userEmail);
        if (user != null)
            return user;
        return null;
    }

    /**
     * ID: 11
     * Searches a user in the dataManager
     * @param userName
     * @param email
     * @return true if user exists, else otherwise
     */
    public boolean findUser(String userName, String email) {
        if (this.getAssetUser(userName,email) != null)
            return true;
        return false;
    }

    /**
     * ID: 12
     * deletes the stadium of the chosen team, replace its value with "NO_STADIUM"
     * @param teamName
     * @param stadium
     */
    public void deleteStadium(String teamName, String stadium) {
        Team team = getTeam(teamName);
        if (team.getStadium().toLowerCase().equals(stadium.toLowerCase()))
            team.setStadium("NO_STADIUMֹ");
    }

    /**
     * ID: 13
     * adds a new team to the owne's teamList
     * @param team
     */
    public void addTeam(Team team) {
        if (!teamList.contains(team))
            this.teamList.add(team);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }




}

