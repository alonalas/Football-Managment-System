package LogicLayer;

import ServiceLayer.IController;

import java.util.Date;

public class Complaint {

    private User user;
    private IController system;
    private String description;
    private String commentAdmin;
    private String date; // format: "2010-12-12"
    //Hour is missing

    public Complaint(User user, IController system, String description, String date) {
        this.user = user;
        this.system = system;
        this.description = description;
        this.date = date;
    }

//    public User getUser() {
//        int i =2;
//        return user;
//    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCommentAdmin(String commentAdmin) {
        this.commentAdmin = commentAdmin;
    }

    public String getCommentAdmin() {
        return commentAdmin;
    }
}
