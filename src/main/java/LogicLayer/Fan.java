package LogicLayer;

import DataLayer.IDataManager;
import ServiceLayer.IController;

import java.util.ArrayList;
import java.util.List;

public class Fan extends Role{

    private List<Page> pages;
    private String name;
    IDataManager dataManager;

    public Fan(User user, String name) {
        super(user);
        this.name = name;
        pages = new ArrayList<>();
    }

    public List<Page> getPages() {
        return pages;
    }

    public IDataManager getDataManager() {
        return dataManager;
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

    public List<String> getHistory() {
        return dataManager.getHistory(this);
    }

    public void addSearchHistory(Fan fan, String query) {
        dataManager.addSearchHistory(this, query);
    }

    public void addComplaintToDataManager(Complaint newComplaint) {
        dataManager.addComplaint(super.getUser(),newComplaint);
    }
}
