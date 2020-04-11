package LogicLayer;

import ServiceLayer.IController;

import java.util.List;
import java.util.Map;

public class League {

    enum LeagueType{
        MAJOR_LEAGUE, SECOND_LEAGUE, LEAGUE_A,LEAGUE_B, LEAGUE_C
    }

    private LeagueType type;
    private List<Referee> refereeList;
    private List<Season> seasonList;
    private Map<Season,Policy> policyList;

    public League( LeagueType type, List<Referee> refereeList, List<Season> seasonList, Map<Season, Policy> policyList) {
        this.type = type;
        this.refereeList = refereeList;
        this.seasonList = seasonList;
        this.policyList = policyList;
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
