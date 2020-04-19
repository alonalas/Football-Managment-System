package ServiceLayer;

import LogicLayer.Guest;
import LogicLayer.User;

public interface IController {

    void addUser(User newUser);

    void addGuest(Guest newGuest);

    void removeGuest(Guest guestToRemove);

    void removeUser(User userToRemove);

    void removeUserService(User user);
}
