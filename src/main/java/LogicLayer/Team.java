package LogicLayer;

import ServiceLayer.IController;

import java.util.LinkedList;
import java.util.List;

public class Team {

    private String name;
    private String stadium;
    private Page page;
    private List<Player> playerList;
    private Manager manager;
    private List<Owner> ownerList;
    private List<Game> away;
    private List<Game> home;
    private League league;
    private List<Coach> coachList;
    //private IController system;

    public Team(String stadium, String name, Page page, Manager manager) {
        this.name = name;
        this.stadium = stadium;
        this.page = page;
        this.manager = manager;
        playerList = new LinkedList<>();
        ownerList = new LinkedList<>();
        away = new LinkedList<>();
        home = new LinkedList<>();
        coachList = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addOwner(Owner owner) {

    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    public List<Game> getAway() {
        return away;
    }

    public void setAway(List<Game> away) {
        this.away = away;
    }

    public List<Game> getHome() {
        return home;
    }

    public void setHome(List<Game> home) {
        this.home = home;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public void setPlayer(Player player){
        playerList.add(player);
    }

    public void setCoach(Coach coach) {
        coachList.add(coach);
    }

    public List<Coach> getCoachList() {
        return coachList;
    }

    public void setCoachList(List<Coach> coachList) {
        this.coachList = coachList;
    }

}
