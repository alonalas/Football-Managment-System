package LogicLayer;

public class GameReport {
    private Game game;
    private String description;

    public GameReport(Game game,String description) {
        this.game = game;
        this.description=description;
    }

    public GameReport(Game game) {
        this.game = game;
        description="no Game report";
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void displayReport(){
        game.displayDetails();
        System.out.println("description: " +getDescription() );
    }
}
