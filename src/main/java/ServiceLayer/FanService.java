package ServiceLayer;
import LogicLayer.Fan;
import LogicLayer.Page;
import java.io.IOException;
import java.util.List;

public class FanService extends AUserService{
    Fan fan;

    public FanService(Fan fan) {
        this.fan = fan;
    }

    /**
     * USE CASE - 3.2
     * add new pages to follow
     * @param newPages
     * @throws IOException
     */
    @Override
    public void addPages(List<Page> newPages) throws IOException {
        fan.addPages(newPages);
    }

    /**
     * USE CASE - 3.5
     * returns fan's search history
     * @return
     * @throws IOException
     */
    @Override
    public List<String> retrieveHistory() throws IOException {
        return fan.getHistory();
    }
}
