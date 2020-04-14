package ServiceLayer;

import LogicLayer.Coach;

public class CoachService extends AUserService {
    private Coach coach;
    private IController system;

    public CoachService(Coach coach, IController system) {
        this.coach = coach;
        this.system = system;
    }
}
