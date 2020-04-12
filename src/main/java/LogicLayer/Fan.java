package LogicLayer;

import DataLayer.IDataManager;
import ServiceLayer.IController;

import java.util.ArrayList;
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
}
