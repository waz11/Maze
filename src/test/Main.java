package test;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        IMazeGenerator m = new MyMazeGenerator();
        Maze maze = m.generate(3,8);
        maze.print();

        SearchableMaze searchableMaze = new SearchableMaze(maze);
        ISearchingAlgorithm searcher = new DepthFirstSearch();
        Solution solution = searcher.solve(searchableMaze);
        ArrayList<AState> solutionPath = solution.getSolutionPath();
        for (int i = 0; i < solutionPath.size(); i++) {
            System.out.println(String.format("%s. %s",i,solutionPath.get(i)));
        }
       // System.out.println("num of nodes:"+searcher.getNumberOfNodesEvaluated());
    }
}
