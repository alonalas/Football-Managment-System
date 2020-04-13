package LogicLayer;

import ServiceLayer.IController;

import java.util.Date;

public class Alert {

    private Role user;
    private IController system;
    private String description;
    private String date;
    // hour is missing

    public Alert(Role user, IController system, String description, String date) {
        this.user = user;
        this.system = system;
        this.description = description;
        this.date = date;
    }

    public Alert(Role user, String description, String date) {
        this.user = user;
        this.description = description;
        this.date = date;
    }

    public Role getUser() {
        return user;
    }

    public void setUser(Role user) {
        this.user = user;
    }

    public IController getSystem() {
        return system;
    }

    public void setSystem(IController system) {
        this.system = system;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
