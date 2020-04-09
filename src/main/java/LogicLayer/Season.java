package LogicLayer;

import ServiceLayer.IController;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Season {

    private IController system;
    private Date start;
    private Date end;
    private List<Game> gameList;
    private List<League> leagueList;
    private Map<League, Policy> Policies;

    public Season(IController system, Date start, Date end, List<Game> gameList, List<League> leagueList, Map<League, Policy> policies) {
        this.system = system;
        this.start = start;
        this.end = end;
        this.gameList = gameList;
        this.leagueList = leagueList;
        Policies = policies;
    }

    public IController getSystem() {
        return system;
    }

    public void setSystem(IController system) {
        this.system = system;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public List<League> getLeagueList() {
        return leagueList;
    }

    public void setLeagueList(List<League> leagueList) {
        this.leagueList = leagueList;
    }

    public Map<League, Policy> getPolicies() {
        return Policies;
    }

    public void setPolicies(Map<League, Policy> policies) {
        Policies = policies;
    }
}
