package UnitTests;

import LogicLayer.Game;
import LogicLayer.Table;
import LogicLayer.Team;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class tableTest {
    Table testTable = new Table(null);
    Team A = new Team("FCB", "A", null);
    Team B = new Team("RMCF", "B", null);
    Team C = new Team("ATM", "C", null);
    Team D = new Team("SFC", "D", null);

    @Before
    public void setUp() throws Exception {
        List<Team> teamList = new ArrayList<>();
        teamList.add(A);
        teamList.add(B);
        teamList.add(C);
        teamList.add(D);
        testTable.init(teamList);
    }

    @Test
    public void printTable() {
        assertTrue(testTable.getLeagueTableEntries().size()==4);
        testTable.printTable();
    }

    @Test
    public void updateTable() {
        Game game = new Game();
        game.setAway(A);
        game.setHome(B);
        game.setResult(new Pair<>(3,0));
        testTable.updateTable(game,3,1,0);
        assertEquals(4, testTable.getLeagueTableEntries().size());
        assertSame(testTable.getLeagueTableEntries().get(0).getTeam(), B);
        testTable.printTable();
        game.setAway(C);
        game.setHome(D);
        game.setResult(new Pair<>(2,2));
        testTable.updateTable(game,3,1,0);
        testTable.printTable();
    }
}
