import java.util.Date;

public class Alert {

    private User user;
    private system system;
    private String description;
    Date date;
    // hour is missing

    public Alert(User user, system system, String description, Date date) {
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

    public system getSystem() {
        return system;
    }

    public void setSystem(system system) {
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
