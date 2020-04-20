package LogicLayer;

import java.io.Serializable;
import DataLayer.IDataManager;
import ServiceLayer.Criteria;

import java.util.*;

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

    public List<Page> getPages() {
        return pages;
    }

    public IDataManager getDataManager() {
        return DataComp.getInstance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPages(List<Page> newPages) {
        for(Page page: newPages){
            pages.add(page);
        }
    }

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

    public void addComplaintToDataManager(String description) {
        Complaint complaint = new Complaint(this.getUser(),description,new Date());
        getDataManager().addComplaint(this.getUser(),complaint);
    }

    public List<String> getCategorySearchHistory() {
        return getDataManager().getCategorySearchHistory(this);
    }

    public List<String> getKeyWordSearchHistory() {
        return getDataManager().getKeyWordSearchHistory(this);
    }

    public List<String> getNameSearchHistory() {
        return getDataManager().getNameSearchHistory(this);
    }

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
