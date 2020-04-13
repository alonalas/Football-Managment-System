package LogicLayer;

public abstract class RoleHolder extends Role {
    protected Team team;

    public RoleHolder(User user) {
        super(user);
    }

    public Team getTeam() {
        return team;
    }
}
