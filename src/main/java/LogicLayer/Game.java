package LogicLayer;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Game {

    private Season season;
    private Team home;
    private Team away;
    private Referee line;
    private Referee main;
    private List<GameEventCalender> gameEventCalender;
    private String date; // format "2019-04-09"
    private String startTime; // format (13:50)
    private String endTime;


    public Game(Season season, Team home, Team away, Referee line, Referee main, List<GameEventCalender> gameEventCalender,String date, String start, String end) {
        this.season = season;
        this.home = home;
        this.away = away;
        this.line = line;
        this.main = main;
        this.gameEventCalender = gameEventCalender;
        this.date=date;
        this.startTime=start;
        this.endTime=end;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public Referee getLine() {
        return line;
    }

    public void setLine(Referee line) {
        this.line = line;
    }

    public Referee getMain() {
        return main;
    }

    public void setMain(Referee main) {
        this.main = main;
    }

    public List<GameEventCalender> getGameEventCalender() {
        return gameEventCalender;
    }

    public void setGameEventCalender(List<GameEventCalender> gameEventCalender) {
        this.gameEventCalender = gameEventCalender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void addEventGame(GameEventCalender event){
        gameEventCalender.add(event);
    }
}
