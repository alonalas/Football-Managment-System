package LogicLayer;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import DataLayer.IDataManager;
import ServiceLayer.*;

public class User implements Serializable {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String userName;
    List<Role> roles;
    private static IDataManager data = DataComp.getInstance();

    public static void setData(IDataManager data) {
        User.data = data;
    }

    public User(User other) {
        this.email = other.password;
        this.password = other.password;
        this.userName = other.userName;
        this.roles = other.getRoles();
    }


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
        return email.equals(user.email) &&
                password.equals(user.password) &&
                userName.equals(user.userName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, userName);
    }

    /**
     * id: User@2
     * add new Role
     * @param role
     * @return true if added successfully , else if already exists
     */
    public boolean addRole(Role role){
        if(!roles.contains(role)) {
            roles.add(role);
            return true;
        }
        return false ;
    }

    /**
     * id: User@3
     * remove Role
     * @param role
     * @return Object that been removed , null if object removed before
     */
    public Object removeRole(Role role){
        if(roles.contains(role)) {
            return roles.remove(role);
        }
        return null ;
    }


    /**
     * id: User@4
     * find RefereeRoleIfExist  , else return null
     * @return
     */
    public Referee ifUserRoleIncludeReferee(){
        for(Role r : roles){
            if(r instanceof Referee){
                return (Referee)r ;
            }
        }
        return null;
    }

    public User(String email, String password, String firstName, String lastName, IDataManager data) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = new ArrayList<Role>();
        this.data = data;
    }

    public static List<User> getAllUsers(){
        return data.getUserList();
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
        //if (!roles.contains(role))
            this.roles.add(role);
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void updatePersonalInformation(String firstName, String lastName, String email){
        if (firstName !=null && lastName != null && email != null){
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }
    }

    public List<String> getPersonalDetails() {
        List<String> personalDetails = new ArrayList<>();
        personalDetails.add(firstName);
        personalDetails.add(lastName);
        personalDetails.add(email);
        return personalDetails;
    }

}
