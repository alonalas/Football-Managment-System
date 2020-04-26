package ServiceLayer;

        import LogicLayer.Coach;

        import java.io.IOException;

public class CoachService extends AUserService {
    private Coach coach;
    private IController system;

    public CoachService(Coach coach, IController system) {
        this.coach = coach;
        this.system = system;
    }

    /**
     * id: CoachService@1
     * USE CASE - 5.2
     * Add content to page
     * @param update
     */
    @Override
    public void addUpdate(String update) throws IOException {
        coach.addUpdateToPage(update);
    }
}
