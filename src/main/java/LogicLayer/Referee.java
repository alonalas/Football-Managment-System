package LogicLayer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Referee extends Role{

    private String qualification;
    private String name;
    private League league;
    private List<Game> main;
    private  List<Game> line;

    public Referee(User user, String qualification, String name, League league) {
        super(user);
        this.qualification = qualification;
        this.name = name;
        this.league = league;
        this.main = new LinkedList<>();
        this.line = new LinkedList<>();
    }



    public Referee(User user, String qualification, String name) {
        super(user);
        this.qualification = qualification;
        this.name = name;
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


    public void addAGameMain(Game game){
        getMain().add(game);
    }

    public void addAGameLine(Game game){
        getLine().add(game);
    }
}
