package ServiceLayer;
import LogicLayer.Complaint;
import LogicLayer.Fan;
import LogicLayer.Guest;
import LogicLayer.Page;
import java.io.IOException;
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
        fan.addPages(newPages);
    }

    /**
     * USE CASE - 3.5
     * returns fan's search history
     * @return
     * @throws IOException
     */
    @Override
    public void retrieveHistory() throws IOException {
        List<String>searchHistory =  fan.getHistory();
        for (int i = 1; i <=searchHistory.size() ; i++) {
            System.out.println("search " + (i) +": " + searchHistory.get(i-1) );
        }
    }

    @Override
    public void searchInformation(Interest interested) throws IOException {
        Guest guest = new Guest(fan.getDataManager());
        GuestService guestService = new GuestService(guest, system);
        guestService.searchInformation(Criteria.Category, interested.toString());
    }

    public FanService(Controller control) {
        super(control);
    }
    @Override
    public void searchInformation(String name) throws IOException {
        Guest guest = new Guest(fan.getDataManager());
        GuestService guestService = new GuestService(guest, system);
        guestService.searchInformation(Criteria.Name, name);
    }

    @Override
    public void searchInformationByKeyWord(String query) throws IOException {
        Guest guest = new Guest(fan.getDataManager());
        GuestService guestService = new GuestService(guest, system);
        guestService.searchInformation(Criteria.KeyWord, query);
        fan.addSearchHistory(fan,query);
    }

    /**
     * USE CASE - 3.4
     * add new complaint due to wrong information
     * @param description
     * @throws IOException
     */
    @Override
    public void report(String description) throws IOException {
        Complaint newComplaint = new Complaint(fan.getUser(),system,description,new Date());
        fan.addComplaintToDataManager(newComplaint);
    }
}
