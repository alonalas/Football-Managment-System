package ServiceLayer;
import LogicLayer.Complaint;
import LogicLayer.Fan;
import LogicLayer.Guest;
import LogicLayer.Page;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        if (newPages != null){
            fan.addPages(newPages);
        }
    }

    /**
     * USE CASE - 3.3
     * add new complaint due to wrong information
     * @param description
     */
    public void reportD(String description){
        fan.addComplaintToDataManager(description);
    }

    /**
     * USE CASE - 3.4
     * add new complaint due to wrong information
     * @param description
     * @throws IOException
     */
    @Override
    public void report(String description) throws IOException {
        if (description != null) {
            fan.addComplaintToDataManager(description);
        }else{
            System.out.println("## there is no content is description ##");
        }
    }

    /**
     * USE CASE - 3.5
     * returns fan's search history
     * @return
     * @throws IOException
     */
    @Override
    public List<String> retrieveHistory(Criteria criteria) throws IOException {
        List<String>searchHistory = fan.retrieveSearchHistory(criteria);
        if (searchHistory == null){
            System.out.println("## there is no search history ##");
            return null;
        }
        for (String search: searchHistory){
            System.out.println(search);
        }
        return searchHistory;
    }

    /**
     * returns all data from DB related to query
     * uses guest class to search information, this function added due to use case 3.5
     * @param criteria
     * @param query
     * @throws IOException
     */
    @Override
    public void searchInformation(Criteria criteria, String query) throws IOException {
        if (query != null && criteria != null){
            Guest guest = new Guest();
            GuestService guestService = new GuestService(guest,system);
            guestService.searchInformation(criteria,query);
            fan.addSearchHistory(criteria,query);
        }
    }
}
