package LogicLayer;

import DataLayer.dataManager;

import java.awt.image.VolatileImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
     * id: Owner@1
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
     * id: Owner@2
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
     * id: Owner@3
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
        String date = day+"-"+month+"-"+year;
        Page page = new Page();
        Player player = new Player(user,position,team,name, date ,page);
        team.setPlayer(player);
        player.setTeam(team);
        team.setPlayer(player);
        user.setRole(player);
        team.getRoleHolders().add(player);
    }

    /**
     * id: Owner@4
     * uploads the team's stadium
     * @param team
     * @param stadium
     */
    public void insertNewStadium(Team team, String stadium) {
        team.setStadium(stadium);
    }

    /**
     * id: Owner@5
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
     * id: Owner@6
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
     * id: 0wner@7
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
     * id: Owner@8
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
     * id: Owner@9
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
     * id: Owner@10
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
     * id: Owner@11
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
     * id: Owner@12
     * deletes the stadium of the chosen team, replace its value with "NO_STADIUM"
     * @param teamName
     * @param stadium
     */
    public void deleteStadium(String teamName, String stadium) {
        Team team = getTeam(teamName);
        if (team.getStadium().toLowerCase().equals(stadium.toLowerCase()))
            team.setStadium("NO_STADIUM");
    }
    /**
     * id: Owner@13
     * adds a new team to the owne's teamList
     * @param team
     */
    public void addTeam(Team team) {
        if (!teamList.contains(team))
            this.teamList.add(team);
    }

    /////////////////////////////////////////////////////////////////////////////////// uc2
    /**
     * id: Owner@14
     * nominates a new owner to the team
     * @param user
     * @param teamName
     * @param name
     * @throws IOException
     */
    public void nominateNewOwner(User user, String teamName, String name) throws IOException {
        if (checkNewOwnerValidity(user,teamName))
            assignOwnerPremission(user,getTeam(teamName),name);
    }

    /**
     * id: Owner@15
     * checks whether the new owner has a valid account
     * checks whether the owner owes the chosen team
     * @param user
     * @param teamName
     * @return
     * @throws IOException
     */
    private boolean checkNewOwnerValidity(User user, String teamName) throws IOException {
        if (DM.getUserList().contains(user)) {
            Team team = getTeam(teamName);
            if(team != null) {
                if (team.getOwner(user) != null)
                    throw new IOException("User is allready nominated as owner in this team");
                else
                    return true;
            }
            else
                throw new IOException("Owner doest not owe the selected team");
        }
        else {
            throw new IOException("User does not exist in the data base");
        }
    }

    /**
     * id: Owner@16
     * add a new owner to the selected team in term he is not an owner allready
     * @param user
     * @param team
     * @param name
     */
    private void assignOwnerPremission(User user, Team team, String name) {
        Owner newOwner = new Owner(user,name,DM);
        user.setRole(newOwner);
        newOwner.addTeam(team);
        team.addOwner(newOwner);
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

    ////////////////////////////////////// 6.1.3 uc

    /**
     * id: Owner@17
     * checks whether the new owner has a valid account
     * checks whether the owner owes the chosen team
     * @param user
     * @param teamName
     * @return
     * @throws IOException
     */
    private boolean checkMembership(User user, String teamName) throws IOException {
        if (DM.getUserList().contains(user)) {
            Team team = getTeam(teamName);
            if( team != null ) {
                RoleHolder roleHolder = team.getRoleHolder(this,user.getUserName(),user.getEmail());
                if (roleHolder != null ) {
                    return true;
                }
                else
                    throw new IOException("Selected user is not a team member in the selected team");
            }
            else
                throw new IOException("Owner doest not owe the selected team");
        }
        else {
            throw new IOException("User does not exist in the data base");
        }
    }

    /**
     * id: Owner@18
     * update a set of attributes which selected by the owner, in term that the selected team member
     * is an existing and valid member of the owner's selected team
     * @param teamName
     * @param roleHolder
     * @param attributes
     * @throws IOException in the cases that were checked in Owner@17
     */
    public void updateAssetAttributes(String teamName, RoleHolder roleHolder,
                                      Map<String, String> attributes) throws IOException {

        if (checkMembership(roleHolder.getUser(),teamName)) {
            for ( String attribute : attributes.keySet() ) {
                switch (roleHolder.getClass().getSimpleName().toLowerCase()) {
                    case "player":
                        Player player = (Player)roleHolder;
                        switch (attribute.toLowerCase()) {
                            case "birthdate":
                                player.setBirthDate(attributes.get(attribute));
                                break;
                            case "position":
                                player.setPosition(attributes.get(attribute));
                                break;
                            default:
                                throw new IOException("Invalid attribute selected: " + attribute);
                        }
                        break;
                    case "coach":
                        Coach coach = (Coach)roleHolder;
                        switch (attribute.toLowerCase()) {
                            case "qualification":
                                coach.setQualification(attributes.get(attribute));
                                break;
                            case "job":
                                coach.setJob(attributes.get(attribute));
                                break;
                            default: throw new IOException("Invalid attribute selected: " + attribute);
                        }
                        break;
                    case "manager":
                        throw new IOException("Owner can not update a manager details");
                }
            }
        }
    }

}

