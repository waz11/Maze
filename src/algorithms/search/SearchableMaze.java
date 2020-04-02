package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.LinkedList;

public class SearchableMaze implements ISearchable {
    Maze maze;

    public SearchableMaze(Maze maze) {
        this.maze = maze;
    }

    @Override
    public AState getStartState() {
        Position start = maze.getStartPosition();
        MazeState startState = new MazeState(0, null, start);
        return startState;
    }

    @Override
    public AState getGoalState() {
        Position goal = maze.getGoalPosition();
        MazeState goalState = new MazeState(0, null, goal);
        return goalState;
    }

    /**
     *
     * @param state - a source position
     * @return - list of all the successors positions from this source state (= legal and path positions)
     */
    @Override
    public LinkedList<AState> getAllSuccessors(AState state) {
        LinkedList<AState> successors = new LinkedList<>();
        MazeState ms = (MazeState) state;

        int sourceRow = ms.state.getRow();
        int sourceCol = ms.state.getCol();

        for(int row = -1; row <= 1; row++){
            for(int col = -1; col <= 1; col++){
                if((row != 0) && (col != 0)){
                    Position position = new Position(row, col);
                    if((maze.isLegalPosition(position)) && (maze.isPath(position))){
                        int cost = 10;
                        if((row != sourceRow) && (col != sourceCol))
                            cost = 15;
                        MazeState successor = new MazeState(cost, state, position);
                        successors.add(successor);
                    }
                }
            }
        }
        return successors;
    }
}
