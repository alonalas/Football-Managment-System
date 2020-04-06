public class Policy {

    private League league;
    private Season season;

    public Policy(League league, Season season) {
        this.league = league;
        this.season = season;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
