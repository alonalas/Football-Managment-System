package ServiceLayer;
import LogicLayer.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class FanService extends AUserService{
    Fan fan;
    private IController system;

    public FanService(Fan fan, IController system) {
        this.fan = fan;
        this.system = system;
    }

    /**
     * USE CASE - 3.2
     * add new pages to follow
     * @param newPages
     * @throws IOException
     */
    @Override
    public void addPages(List<Page> newPages) throws IOException {
        fan.addPages(newPages);
    }

    /**
     * USE CASE - 3.3
     * add Games to the follow list of a Fan
     * @param games
     */
    public void followOnGames(List<Observable> games){
        games.forEach(game -> game.addObserver(this.fan));
    }

    @SuppressWarnings("unchecked")
    private List<Observable> getIncomingGames() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        List<Observable> games;
        games = (List<Observable>) DataComp.getInstance().getGameList().stream().filter(game -> {
            try {
                return today.compareTo(format.parse(game.getDate())) < 0;
            } catch (ParseException e) {
                return false;
            }
        });
        return games;
    }

    /**
     * USE CASE - 3.4
     * add new complaint due to wrong information
     * @param description
     * @throws IOException
     */
    @Override
    public void report(String description) throws IOException {
        fan.addComplaintToDataManager(description);
    }

    /**
     * USE CASE - 3.5
     * returns fan's search history
     * @return
     * @throws IOException
     */
    @Override
    public void retrieveHistory(Criteria criteria) throws IOException {
        List<String>searchHistory = fan.retrieveSearchHistory(criteria);
        for (String search: searchHistory){
            System.out.println(search);
        }
    }

    @Override
    public void searchInformation(Criteria criteria, String query) throws IOException {
        if (query!=null && criteria!=null){
            Guest guest = new Guest();
            GuestService guestService = new GuestService(guest,system);
            guestService.searchInformation(criteria,query);
            fan.addSearchHistory(criteria,query);
        }
    }
}
