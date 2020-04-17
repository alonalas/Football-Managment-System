package LogicLayer;

import DataLayer.IDataManager;
import DataLayer.dataManager;
import ServiceLayer.IController;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class League implements Serializable {


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof League){
            return this.getType() == ((League) obj).getType() ;
        }
        return false;
    }

    public enum LeagueType{
        MAJOR_LEAGUE, SECOND_LEAGUE, LEAGUE_A,LEAGUE_B, LEAGUE_C
    }

    private IController system;
    private LeagueType type;
    private List<Referee> refereeList;
    private List<Season> seasonList;
    private Map<Season,Policy> policyList;
    private static IDataManager data = DataComp.getInstance();
    private String name;

    public League( LeagueType type, List<Referee> refereeList, List<Season> seasonList, Map<Season, Policy> policyList) {
        this.type = type;
        this.refereeList = refereeList;
        this.seasonList = seasonList;
        this.policyList = policyList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public League(LeagueType leagueType){
        this.type = leagueType;
        data.addLeague(this);
    }
    /**
     * id: League@1
     * check if League already exist
     * @param leagueType
     * @return League if existing , null if not
     */
    public static League checkIfLeagueExist(LeagueType leagueType){
        return data.SearchLeagueByType(leagueType);
    }

    /**
     * id: League@2
     * show all existing Leagues
     * @return all system leagues
     */
    public static List<League> ShowAllLeagues(){
        return data.getLeagueList();
    }

    /**
     * id: League@3
     * add new league
     * @param leagueType
     * @return if success/unsuccessful operation
     * @throws Exception if league type illegal
     */
    public static boolean addLeague(League.LeagueType leagueType) throws IOException{
        if(leagueType==null){
            throw new IOException("illegal league type");
        }
        League league= League.checkIfLeagueExist(leagueType);
        if(league != null){
            return false ;
        }
        data.addLeague(new League(leagueType));
        return true;
    }

    public LeagueType getType() {
        return type;
    }

    public void setType(LeagueType type) {
        this.type = type;
    }

    public List<Referee> getRefereeList() {
        return refereeList;
    }

    public void setRefereeList(List<Referee> refereeList) {
        this.refereeList = refereeList;
    }

    public List<Season> getSeasonList() {
        return seasonList;
    }

    public void setSeasonList(List<Season> seasonList) {
        this.seasonList = seasonList;
    }

    public Map<Season, Policy> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(Map<Season, Policy> policyList) {
        this.policyList = policyList;
    }
}
