import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import algorithms.search.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JunitTestingBestFirstSearch {
    @Test
    void test1() {
        ISearchingAlgorithm searcher = new BestFirstSearch();
        Solution solution = searcher.solve(null);
        assertEquals("[]", solution.getSolutionPath().toString());
    }

    @Test
    void test2() {
        Maze maze = new Maze(3, 4);
        Position start = new Position(2,3);
        Position goal = new Position(0,0);
        maze.setStart(start);
        maze.setGoal(goal);
        maze.setWall(1,0);
        maze.setWall(1,1);

        SearchableMaze searchableMaze = new SearchableMaze(maze);
        ISearchingAlgorithm searcher = new BestFirstSearch();
        Solution solution = searcher.solve(searchableMaze);
        ArrayList<AState> solutionPath = solution.getSolutionPath();
        String[] ans = {"{2,3}","{1,2}","{0,1}","{0,0}"};
        for(int i=0; i<ans.length; i++) {
            assertEquals(ans[i], String.format("%s", solutionPath.get(i)));
        }
    }

}