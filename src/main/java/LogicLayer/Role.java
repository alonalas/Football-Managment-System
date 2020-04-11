package LogicLayer;

import java.util.Objects;

public abstract class Role  {

    private User user;

    public Role(User user) {
        this.user = user;
    }

    public Role() {}

    //cant get user, right?
    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(user, role.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    public void setUser(User user) {
        this.user = user;
    }

}
