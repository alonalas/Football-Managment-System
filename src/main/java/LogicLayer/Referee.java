package LogicLayer;

import DataLayer.IDataManager;
import DataLayer.dataManager;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Referee extends Role{

    private String qualification;
    private String name;
    private League league;
    private static IDataManager data = DataComp.getInstance();
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

    /**
     * id: Referee@1
     * make a user a referee
     * @param user of referee
     * @param qualification of referee
     * @param name of referee
     * @return true if added successfully, else if already exists
     */
    public static boolean MakeUserReferee(User user, String qualification, String name){
           Referee referee = new Referee( user,  qualification,  name);
           boolean res =  user.addRole(referee);
           if(res) res =data.addReferee(referee) ;
           return res;
    }

    /**
     * id: Referee@2
     * Remove a user a referee
     * @param
     * @return true if removed successfully, else if already removed
     */
    public static boolean RemoveUserReferee(Referee referee){
        if(referee.getUser().removeRole(referee)!=null) {
            return data.removeReferee(referee);
        }
        return false;
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Referee){
            Referee other = (Referee)obj;
            return (((User)(other.getUser())).equals(this.getUser()));
        }
        return false;
    }


    public void addAGameMain(Game game){
        getMain().add(game);
    }

    public void addAGameLine(Game game){
        getLine().add(game);
    }
}
