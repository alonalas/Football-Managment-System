package ServiceLayer;

import LogicLayer.User;

import java.io.IOException;

public class UserService extends AUserService {
    User user;

    public UserService(User user) {
        this.user = user;
    }

    @Override
    public void logOut() throws IOException {
        user.logOut();
    }
}
