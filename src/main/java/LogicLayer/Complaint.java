package LogicLayer;

import ServiceLayer.IController;

import java.util.Date;

public class Complaint {

    private User user;
    private String description;
    Date date;
    //Hour is missing

    public Complaint(User user,  String description, Date date) {
        this.user = user;
        this.description = description;
        this.date = date;
    }

    public User getUser() {
        int i =2;
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
