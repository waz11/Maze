import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import algorithms.search.AState;
import algorithms.search.MazeState;
import algorithms.search.SearchableMaze;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchableMazeTest {
    @Test
    void test1(){
        Maze maze = new Maze(3, 3);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        Position position = new Position(1, 1);
        AState state = new MazeState(position, null, 0);
        LinkedList<AState> actual = searchableMaze.getAllPossibleStates(state);
        String[] expected = {"{0,0}", "{0,1}", "{0,2}", "{1,0}", "{1,2}", "{2,0}", "{2,1}", "{2,2}"};
        List<String> expectedList = Arrays.asList(expected);

        assertEquals(expected.length, actual.size());
        for (AState st : actual)
                assertTrue(expectedList.contains("" + st.toString()), st.toString()+" is wrong");
    }
}