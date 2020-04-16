package LogicLayer;

import java.util.Objects;

public class Manager extends RoleHolder{
import java.io.Serializable;

public class Manager extends RoleHolder implements Serializable {

    private String name;
    private Team team;

    public Manager(User user, String name, Team team) {
        super(user);
        this.name = name;
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(name, manager.name) &&
                Objects.equals(team, manager.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, team);
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
}
