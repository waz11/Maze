package test;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.*;

import java.util.ArrayList;

/**
 * Created by Aviadjo on 3/22/2017.
 */
public class Main {
    public static void main(String[] args) {
        /*
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(3, 4);
        SearchableMaze searchableMaze = new SearchableMaze(maze);

        //solveProblem(searchableMaze, new BreadthFirstSearch());
        solveProblem(searchableMaze, new DepthFirstSearch());
       // solveProblem(searchableMaze, new BestFirstSearch());
       */

        Maze maze = new Maze(3, 4);
        Position start = new Position(2, 3);
        Position goal = new Position(0, 0);
        maze.setStart(start);
        maze.setGoal(goal);
        maze.setWall(1, 0);
        maze.setWall(1, 1);
        maze.print();
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        //solveProblem(searchableMaze, new DepthFirstSearch());
        solveProblem(searchableMaze, new BreadthFirstSearch());
        //solveProblem(searchableMaze, new BestFirstSearch());
    }

    private static void solveProblem(ISearchable domain, ISearchingAlgorithm searcher) {
        //Solve a searching problem with a searcher
        Solution solution = searcher.solve(domain);
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", searcher.getName(), searcher.getNumberOfNodesEvaluated()));
        //Printing Solution Path
        System.out.println("Solution path:");
        ArrayList<AState> solutionPath = solution.getSolutionPath();
        for (int i = 0; i < solutionPath.size(); i++) {
            System.out.println(String.format("%s. %s", i, solutionPath.get(i)));
        }
    }
}

