package LogicLayer;

import java.util.LinkedList;
import java.util.List;

public class Manager extends RoleHolder{

    private String name;
    private Team team;
    private List<Alert> alerts;

    public Manager(User user, String name, Team team) {
        super(user);
        this.name = name;
        this.team = team;
        this.alerts = new LinkedList<>();
    }

    public Manager() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;

    }

    /**
     * ID: Manager@1
     * add a new alert to thr alert list
     * @param alert the new alert
     */
    public void addAlert(Alert alert){
        getAlerts().add(alert);
    }
}
