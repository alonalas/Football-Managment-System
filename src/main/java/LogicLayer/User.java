package LogicLayer;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import ServiceLayer.*;

public class User {

    private String email;
    private String password;
    private String userName;
    //private IController system;
    private List<Role> roles;

    public User(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.roles = new LinkedList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, userName, roles);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRole(Role role){
        if (!roles.contains(role))
            this.roles.add(role);
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
