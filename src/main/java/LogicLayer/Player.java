package LogicLayer;

import java.util.Date;

public class Player extends RoleHolder{

    private String position;
    private Team team;
    private String name;
    Date birthDate;
    private Page page;

    public Player(User user, String position, Team team, String name, Date birthDate, Page page) {
        super(user);
        this.position = position;
        this.team = team;
        this.name = name;
        this.birthDate = birthDate;
        this.page = page;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
