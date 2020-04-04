import java.util.Date;

public class Complaint {

    private User user;
    private System system;
    private String description;
    Date date;
    //Hour is missing

    public Complaint(User user, System system, String description, Date date) {
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

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
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
