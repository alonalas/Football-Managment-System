package LogicLayer;

import DataLayer.dataManager;

import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
     * team's owner adds a team asset (player, manager, stadium, coach) to it's own team
     * @param team
     * @param roleHolder- the asset to be added
     * @param user- the user assigned to the asset
     * @throws IOException
     */
    public RoleHolder insertNewAssetType(Team team, RoleHolder roleHolder,User user) {

            Page page = new Page();
            List <String> details;
            switch (roleHolder.getClass().getSimpleName()) {
                case "Coach":
                    details = fillCoachDetails();
                    Coach coach = new Coach(user,details.get(0),details.get(1),details.get(2),page,team);
                    team.setCoach(coach);
                    return coach;
                case "Player":
                    details = fillPlayerDetails();
                    Date date = new Date(Integer.parseInt(details.get(2)),Integer.parseInt(details.get(3)),Integer.parseInt(details.get(4)));
                    Player player = new Player(user,details.get(0),team,details.get(1),date,page);
                    team.setPlayer(player);
                    return player;
                case "Manager":
                    String name = fillManagerName();
                    Manager manager = new Manager(user,name,team);
                    team.setManager(manager);
                    return manager;
            }
        return null;
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

    /**
     * returns the requiered team
     * @param team
     * @return Team
     */
    public Team getTeam(Team team) {
        for ( Team t : teamList ) {
            if (t.equals(team))
                return t;
        }
        return null;
    }

    /**
     * assigns a stadium to a team
     * @param team
     * @param stadiumName
     */
    public void setStadiumToTeam(Team team, String stadiumName) {
        if (!(team == null))
            getTeam(team).setStadium(stadiumName);
    }

    /**
     * fill new stadium's name
     * @return stadium name
     */
    public String fillStadiumName() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Stadium name");
        String stadiumName = myObj.nextLine();
        return stadiumName;
    }

    /**
     * retrieves a team from the owner's team list
     * @return Team
     */
    public Team selectTeam() {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Insert team's name: ");
        String teamName = myObj.nextLine();

        for (Team team : teamList) {
            if (team.getName().equals(teamName))
                return team;
        }

        return null;
    }

    /**
     * @return an input from the user- the requiered asset type
     */
    public String InsertAssetType() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Insert asset type: ");
        String assetType = myObj.nextLine();
        return assetType;
    }

    /**
     * retrieves the user list from the dataManager and returns the requiered user
     * @return user list
     */
    public User getAssetUser() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Insert user name of the intended asset");
        String userName = myObj.nextLine();
        System.out.println("Select the email of the intended asset");
        String userEmail = myObj.nextLine();
        User user = DM.getUser(userName,userEmail);
        if (user != null)
            return user;
        return null;
    }

    /**
     * @return List of string details:
     * [0] Name
     * [1] Qualification
     * [2] Job
     */
    private List<String> fillCoachDetails() {
        List<String> details = new LinkedList<>();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter coach's name");
        details.add(myObj.nextLine());
        System.out.println("Enter coach's qualification");
        details.add(myObj.nextLine());
        System.out.println("Enter the coach's role");
        details.add(myObj.nextLine());
        return details;
    }

    /**
     * @return List of string details:
     * [0]- Position
     * [1]- Name
     * [2]- Year
     * [3]- Month
     * [4]- Day
     */
    private List<String> fillPlayerDetails() {

        List<String> details = new LinkedList<>();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter player's position");
        details.add(myObj.nextLine());
        System.out.println("Enter player's name");
        details.add(myObj.nextLine());

        fillBirthDate(details);


        return details;
    }

    /**
     * fills a VALID birth date
     * @param details
     */
    private void fillBirthDate(List<String> details) {
        int date;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Year of birth");
        date = Integer.parseInt(myObj.nextLine());
        while (!(date > 1900 && date < 2020 )) {
            System.out.println("please insert valid year between 1900 and 2020");
            date = Integer.parseInt(myObj.nextLine());
        }
        details.add(String.valueOf(date));
        System.out.println("Enter Month of birth");
        date = Integer.parseInt(myObj.nextLine());
        while (!(date > 0 && date < 13 )) {
            System.out.println("please insert valid month between 1 and 12");
            date = Integer.parseInt(myObj.nextLine());
        }
        details.add(String.valueOf(date));
        System.out.println("Enter day of birth");
        date = Integer.parseInt(myObj.nextLine());
        while (!(date > 0 && date < 32 )) {
            System.out.println("please insert valid day between 1 and 31");
            date = Integer.parseInt(myObj.nextLine());
        }
        details.add(String.valueOf(date));
    }

    /**
     * fill new manager name
     * @return manager name
     */
    private String fillManagerName() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter manager name");
        String managerName = myObj.nextLine();
        return managerName;
    }

    public void addTeam(Team team) {
        if (!teamList.contains(team))
            this.teamList.add(team);
    }



}
