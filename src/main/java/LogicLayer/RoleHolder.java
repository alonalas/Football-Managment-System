package LogicLayer;

public abstract class RoleHolder extends Role {

    public RoleHolder(User user) {
        super(user);
    }

    public RoleHolder() {
        super();
    }

    public boolean equals(Role obj) {
        if (obj instanceof RoleHolder) {
            RoleHolder roleHolder = (RoleHolder)obj;
            if ( this.getUser().equals(roleHolder.getUser())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
