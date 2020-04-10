package ServiceLayer;

import LogicLayer.Game;
import LogicLayer.Page;

import java.io.IOException;

public abstract class AUserService implements IUserService{
    public void addPage(Page newPage) throws IOException {
        throw new IOException("Eitan");
    }


    public void showDetails() throws IOException {
        throw new IOException("No details to be shown");
    }

    public void changeDetails(String newName, String newCualif)throws IOException{
        throw new IOException("No details to be changed");
    }

    public void displayGames()throws IOException{
        throw new IOException("no games");
    }

    public void addGameEvent(Game game ,String description, String eventType) throws IOException{
        throw new IOException("no games");
    }

    public void addGameEventAfterGame(Game game,String description, String eventType) throws IOException {
        throw new IOException("no games");
    }
}
