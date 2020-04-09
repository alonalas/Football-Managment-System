package LogicLayer;

public class Manager extends RoleHolder{

    private String name;
    private Team team;

    public Manager(User user, String name, Team team) {
        super(user);
        this.name = name;
        this.team = team;
    }

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
}
