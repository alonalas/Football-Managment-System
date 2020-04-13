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

    public FanService(Fan fan) {
        this.fan = fan;
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
    public List<String> retrieveHistory() throws IOException {
        return fan.getHistory();
    }

    @Override
    public void searchInformation(Interest interested) throws IOException {
        Guest guest = new Guest(fan.getSystem(), fan.getDataManager());
        GuestService guestService = new GuestService(guest);
        guestService.searchInformation(Criteria.Category, interested.toString());
    }

    @Override
    public void searchInformation(String name) throws IOException {
        Guest guest = new Guest(fan.getSystem(), fan.getDataManager());
        GuestService guestService = new GuestService(guest);
        guestService.searchInformation(Criteria.Name, name);
    }

    @Override
    public void searchInformationByKeyWord(String query) throws IOException {
        Guest guest = new Guest(fan.getSystem(), fan.getDataManager());
        GuestService guestService = new GuestService(guest);
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
        Complaint newComplaint = new Complaint(fan.getUser(),fan.getUser().getSystem(),description,new Date());
        fan.addComplaintToDataManager(newComplaint);
    }
}
