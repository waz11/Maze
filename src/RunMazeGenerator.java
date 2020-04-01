
import algorithms.mazeGenerators.*;
import algorithms.search.AState;
import algorithms.search.DepthFirstSearch;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;

import java.util.ArrayList;

/**
 * Created by Aviadjo on 3/22/2017.
 */
public class RunMazeGenerator {
    public static void main(String[] args) {
        MyMazeGenerator pm = new MyMazeGenerator();
        Maze m = pm.generate(5, 5);
        SearchableMaze searchable = new SearchableMaze(m);

        DepthFirstSearch dfs = new DepthFirstSearch();
        Solution sol = dfs.solve(searchable);
        System.out.println(dfs.getName());
        m.print();
        System.out.println(dfs.getNumberOfNodesEvaluated());
        ArrayList<AState> solutionPath = sol.getSolutionPath();
        for (int i=0; i<solutionPath.size(); i++)
            System.out.println(String.format("%s. %s",i,solutionPath.get(i)));    }
}