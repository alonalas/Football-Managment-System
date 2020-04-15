package ServiceLayer;

import LogicLayer.Player;

import java.io.IOException;

public class PlayerService extends AUserService {
    private Player player;
    private IController system;

    public PlayerService(Player player, IController system) {
        this.player = player;
        this.system = system;
    }

    /**
     * USE CASE - 4.2
     * Add content to page
     * @param update
     */
    @Override
    public void addUpdate(String update) throws IOException {
        player.getPage().addUpdate(update);
    }
}
