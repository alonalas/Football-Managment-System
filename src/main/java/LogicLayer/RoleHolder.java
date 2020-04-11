package LogicLayer;

public abstract class RoleHolder extends Role {

    public RoleHolder(User user) {
        super(user);
    }

    public RoleHolder() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RoleHolder) {
            RoleHolder roleHolder = (RoleHolder)obj;
            if ( this.getUser().equals(roleHolder.getUser())) {
                return true;
            }
        }
        return false;
    }
}
