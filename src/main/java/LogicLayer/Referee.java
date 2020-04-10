package LogicLayer;

import java.util.List;
import java.util.Scanner;

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


//    public void showDetails(){
//        System.out.println("Name of referee: " + getName());
//        System.out.println("Qualification: " + getQualification());
//    }

//    public void changeDetails(String newName, String newCualif){
//        setName(newName);
//        setQualification(newCualif);
//    }

//    public void displayGames(){
//        System.out.println("main games:");
//        for(Game game : main){
//            System.out.println(game.toString());
//        }
//        System.out.println("line games: ");
//        for(Game game : line){
//            System.out.println(game.toString());
//        }
//
//    }

    public boolean getPremission() {
        System.out.println("Are you sure?");
        System.out.println("Please enter 'yes' or 'no'");
        Scanner sc = new Scanner(System.in);
        String ans = null;
        ans = sc.next();

        if (ans.equals("yes"))
            return true;
        else {
            return false;
        }

    }
}