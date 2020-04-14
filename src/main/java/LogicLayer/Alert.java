package LogicLayer;

import ServiceLayer.IController;

import java.io.Serializable;
import java.util.Date;

public class Alert implements Serializable {

    private User user;
    private IController system;
    private String description;
    Date date;
    // hour is missing

    public Alert(User user, IController system, String description, Date date) {
        this.user = user;
        this.system = system;
        this.description = description;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
