import LogicLayer.Administrator;
import LogicLayer.Guest;
import LogicLayer.Representitive;
import LogicLayer.User;
import ServiceLayer.Controller;
import ServiceLayer.IController;
import ServiceLayer.IGuestService;
import ServiceLayer.IUserService;
import org.junit.BeforeClass;

import java.util.List;

public class SystemInitTest {

    private static IController system;

    @BeforeClass
    public static void beforeClass() throws Exception {
        Administrator administrator = new Administrator("A","B","C");
        User user = new User("AA","BB","CC");
        Representitive representative = new Representitive(user, "lama name");
        user.addRole(representative);
        system = new Controller(representative, administrator);
        Guest guest = new Guest();
        system.addGuest(guest);
        IGuestService guestService = system.getGuestServices().get(guest);
        guestService.register("David","Fadida","a@a.a","password");
        User newUser = guestService.signIn("A@a.a","password");
        List<IUserService> userService = system.getUserServices().get(newUser);
    }


}
