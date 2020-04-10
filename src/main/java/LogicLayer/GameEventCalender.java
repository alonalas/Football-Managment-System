package LogicLayer;

public class GameEventCalender {

    private Game game;
    private String hour; // format (13:50)
    private String date; // format "2019-04-09"
    private eventType type;
    private String description;
    private int minute;


    enum eventType{
        goal, offside,offense, redCard, yellowCard, injury,playerReplacement
    }

    public GameEventCalender(Game game, String hour, String date, String type, String description, int minute) {
        this.game = game;
        this.hour = hour;
        this.date = date;
        this.type = eventType.valueOf(type);
        this.description = description;
        this.minute = minute;

    }

    public GameEventCalender(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
