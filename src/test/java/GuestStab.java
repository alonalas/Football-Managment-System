import DataLayer.IDataManager;
import LogicLayer.Game;
import LogicLayer.Guest;
import LogicLayer.Player;
import LogicLayer.User;

import java.util.ArrayList;
import java.util.List;

public class GuestStab extends Guest {
    List<Game> listG;
    List<Player> listP;

    public GuestStab(IDataManager data) {
        super(data);
        init();
    }

    private void init() {
        listG = new ArrayList<>();
        listG.add(new Game(null,null,null, null, null, null));
        listG.add(new Game(null,null,null, null, null, null));
        listP = new ArrayList<>();
        listP.add(new Player(null, null, null, "David", null));
        listP.add(new Player(null, null, null, "Or", null));
        listP.add(new Player(null, null, null, "Raul", null));
    }

    @Override
    public List<Game> retrieveGames() {
        return listG;
    }

    @Override
    public List<Player> retrievePlayers() {
        return listP;
    }

    @Override
    public List<User> SearchUserByName(String name) {
        List<User> list = new ArrayList<>();
        list.add(new User(null, null, name, name, null));
        return list;
    }
}
