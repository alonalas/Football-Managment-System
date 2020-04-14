package ServiceLayer;

import LogicLayer.Player;

public class PlayerService extends AUserService {
    private Player player;
    private IController system;

    public PlayerService(Player player, IController system) {
        this.player = player;
        this.system = system;
    }




}
