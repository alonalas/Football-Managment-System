package LogicLayer;

import DataLayer.dataManager;
import java.sql.Date;
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

    public void nominateManager(Team team, String managerName, String userName ,String email) {
        User user = getAssetUser(userName,email);
        Manager manager = new Manager(user,managerName,team);
        assignPremissions(manager);
        team.setManager(manager);
        manager.setTeam(team);
        user.setRole(manager);
    }

    public void insertNewCoach(Team team, String name, String qualification, String job, String userName,
                               String email) {
        User user = getAssetUser(userName,email);
        Page page = new Page();
        Coach coach = new Coach(user,name,qualification,job,page,team);
        coach.setTeam(team);
        team.setCoach(coach);
        user.setRole(coach);
    }

    //TODO
    private void assignPremissions(Manager manager) {

    }

    public void insertNewStadium(Team team, String stadium) {
        team.setStadium(stadium);
    }

    public void insertNewPlayer(Team team, String name, String position, int day ,
                                 int month, int year ,String userName,String email) {
        Date date = new Date(day,month,year); // check why it's not working
        User user = getAssetUser(userName,email);
        Page page = new Page();
        Player player = new Player(user,position,team,name,date,page);
        team.addPlayer(player);
        player.setTeam(team);
        team.addPlayer(player);
        user.setRole(player);
    }

    /**
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
     * retrieves the user list from the dataManager and returns the requiered user
     * @return user list
     */
    public User getAssetUser(String userName, String userEmail) {
        User user = DM.getUser(userName,userEmail);
        if (user != null)
            return user;
        return null;
    }

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
