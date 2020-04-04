public class Game {

    private Season season;
    private Team home;
    private Team away;
    private Referee line;
    private Referee main;
    private GameEventCalender gameEventCalender;

    public Game(Season season, Team home, Team away, Referee line, Referee main, GameEventCalender gameEventCalender) {
        this.season = season;
        this.home = home;
        this.away = away;
        this.line = line;
        this.main = main;
        this.gameEventCalender = gameEventCalender;
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

    public GameEventCalender getGameEventCalender() {
        return gameEventCalender;
    }

    public void setGameEventCalender(GameEventCalender gameEventCalender) {
        this.gameEventCalender = gameEventCalender;
    }
}
