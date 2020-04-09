package LogicLayer;

import java.util.List;

public class Referee extends Role{

    private String qualification;
    private String name;
    private League league;
    List<Game> main;
    List<Game> line;

    public Referee(User user, String qualification, String name, League league, List<Game> main, List<Game> line) {
        super(user);
        this.qualification = qualification;
        this.name = name;
        this.league = league;
        this.main = main;
        this.line = line;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public List<Game> getMain() {
        return main;
    }

    public void setMain(List<Game> main) {
        this.main = main;
    }

    public List<Game> getLine() {
        return line;
    }

    public void setLine(List<Game> line) {
        this.line = line;
    }
}
