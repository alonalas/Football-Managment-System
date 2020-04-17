package LogicLayer;

import DataLayer.IDataManager;
import ServiceLayer.Criteria;
import ServiceLayer.IController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fan extends Role{

    private List<Page> pages;
    private String name;
    private IController system;
    IDataManager dataManager;

    public Fan(User user, String name) {
        super(user);
        this.name = name;
        pages = new ArrayList<>();
    }

    public List<Page> getPages() {
        return pages;
    }

    public IController getSystem() {
        return system;
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

    public void addSearchHistory(Criteria criteria ,String query) {
        switch (criteria){
            case Name:
                dataManager.addNameHistory(this,query);
                break;
            case KeyWord:
                dataManager.addKeyWordHistory(this,query);
                break;
            case Category:
                dataManager.addCategoryHistory(this,query);
                break;
        }
    }

    public void addComplaintToDataManager(String description) {
        Complaint complaint = new Complaint(this.getUser(),description,new Date());
        dataManager.addComplaint(this.getUser(),complaint);
    }

    public List<String> getCategorySearchHistory() {
        return dataManager.getCategorySearchHistory(this);
    }

    public List<String> getKeyWordSearchHistory() {
        return dataManager.getKeyWordSearchHistory(this);
    }

    public List<String> getNameSearchHistory() {
        return dataManager.getNameSearchHistory(this);
    }
}
