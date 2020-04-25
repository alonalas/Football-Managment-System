package LogicLayer;

import java.util.Comparator;

public class RankPolicy extends Policy{
    private final int WIN;
    private final int DRAW;
    private final int LOSE;

    public RankPolicy(League league, Season season){
        super(league, season);
        WIN = 3;
        DRAW = 1;
        LOSE = 0;
    }

    public RankPolicy(League league, Season season, int win, int draw, int lose) {
        super(league, season);
        WIN = win;
        DRAW = draw;
        LOSE = lose;
    }

    @Override
    public League getLeague() {
        return super.getLeague();
    }

    @Override
    public void setLeague(League league) {
        super.setLeague(league);
    }

    @Override
    public Season getSeason() {
        return super.getSeason();
    }

    @Override
    public void setSeason(Season season) {
        super.setSeason(season);
    }

    public void updatePoints(Game game){
        getLeague()
    }
}
