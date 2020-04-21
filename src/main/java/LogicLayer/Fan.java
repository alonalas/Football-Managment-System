package LogicLayer;

import java.io.Serializable;
import DataLayer.IDataManager;
import ServiceLayer.Criteria;

import java.util.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fan extends Role implements Serializable, Observer {

    private List<Page> pages;
    private List<Observable> games;
    private String name;

    public Fan(User user, String name) {
        super(user);
        this.name = name;
        pages = new ArrayList<>();
        games = new ArrayList<>();
    }

    /**
     * returns fan followed pages
     * @return List<Page>
     */
    public List<Page> getPages() {
        return pages;
    }

    /**
     * returns DB instance
     * @return IDataManager
     */
    public IDataManager getDataManager() {
        return DataComp.getInstance();
    }

    /**
     * name getter
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * name setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * add new pages to follow by fan
     * @param newPages
     */
    public void addPages(List<Page> newPages) {
        for(Page page: newPages){
            pages.add(page);
        }
    }

    /**
     * adds new search history by fan by 3 criterias
     * @param criteria
     * @param query
     */
    public void addSearchHistory(Criteria criteria ,String query) {
        if (query!=null){
            switch (criteria){
                case Name:
                    getDataManager().addNameHistory(this,query);
                    break;
                case KeyWord:
                    getDataManager().addKeyWordHistory(this,query);
                    break;
                case Category:
                    getDataManager().addCategoryHistory(this,query);
                    break;
            }
        }
    }

    /**
     * add new complaint to user in DB
     * @param description
     */
    public void addComplaintToDataManager(String description) {
        Complaint complaint = new Complaint(this.getUser(),description, LocalDate.now().toString());
        getDataManager().addComplaint(this.getUser(),complaint);
    }

    /**
     * category search history getter
     * @return List<String>
     */
    public List<String> getCategorySearchHistory() {
        return getDataManager().getCategorySearchHistory(this);
    }

    /**
     * keyWord search history getter
     * @return List<String>
     */
    public List<String> getKeyWordSearchHistory() {
        return getDataManager().getKeyWordSearchHistory(this);
    }

    /**
     * search by name history getter
     * @return List<String>
     */
    public List<String> getNameSearchHistory() {
        return getDataManager().getNameSearchHistory(this);
    }

    /**
     * retrieves search history made by fan
     * @param criteria
     * @return List<String>
     */
    public List<String> retrieveSearchHistory(Criteria criteria) {
        List<String>searchHistory = new ArrayList<>();
        switch (criteria) {
            case Category:
                searchHistory = getCategorySearchHistory();
                break;
            case KeyWord:
                searchHistory = getKeyWordSearchHistory();
                break;
            case Name:
                searchHistory = getNameSearchHistory();
                break;
        }
        return searchHistory;
    }

    /**
     * update - observer
     * @param game - Observable Game
     * @param event - update
     */
    @Override
    public void update(Observable game, Object event) throws ClassCastException{
        if (this.games.contains(game)){
            alertUser(event);
        }
    }

    /**
     * Alert user - in this version by printing to console
     * @param event - Game Event
     */
    private void alertUser(Object event) throws ClassCastException{
        try {
            ((GameEventCalender) event).displayEvents();
        } catch (NullPointerException e){

        }
    }

    public List<Observable> getGames() {
        return games;
    }
}
