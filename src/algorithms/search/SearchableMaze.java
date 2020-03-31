package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {
    Maze maze;

    @Override
    public AState getStartState() {
        Position start = maze.getStart();
        MazeState startState = new MazeState(start.toString(), 0, null, start);
        return startState;
    }

    @Override
    public AState getGoalState() {
        return null;
    }


    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        return null;
    }
}
