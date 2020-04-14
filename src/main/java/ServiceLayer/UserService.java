package ServiceLayer;
import LogicLayer.User;
import java.io.IOException;
import java.util.List;

public class UserService extends AUserService {
    private User user;
    private IController system;

    public UserService(User user, IController system) {
        this.user = user;
        this.system = system;
    }

    /**
     * USE CASE - 3.1
     * logOut from system
     */
    @Override
    public void logOut() throws IOException {
        system.removeUser(user);
        system.removeUserService(user);
    }

    /**
     * USE CASE - 3.6
     * show personal details
     * @return
     * @throws IOException
     */
     public List<String> showPersonalInformation() throws IOException {
        List<String> personalDetails = user.getPersonalDetails();
        return personalDetails;
     }


    /**
     * USE CASE - 3.7
     * edit personal details
     * @param firstName
     * @param lastName
     * @param email
     * @throws IOException
     */
    @Override
    public void editPersonalInformation(String firstName, String lastName, String email) throws IOException {
        user.updatePersonalInformation(firstName,lastName,email);
    }




}
