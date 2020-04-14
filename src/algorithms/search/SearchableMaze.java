package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

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
     * @param state - a source position
     * @return - list of all the successors positions from this source state (= legal and path positions)
     */
    @Override
    public LinkedList<AState> getAllPossibleStates(AState state) {
        LinkedList<AState> successors = new LinkedList<>();
        MazeState ms = (MazeState) state;

        int sourceRow = ms.state.getRowIndex();
        int sourceCol = ms.state.getColumnIndex();

        for (int row = -1; row <= 1; row++) {
            for (int col = -1; col <= 1; col++) {
                if ((row != 0) || (col != 0)) {
                    Position position = new Position(sourceRow + row, sourceCol + col);
                    if ((maze.isLegalPosition(position)) && (maze.isPath(position))) {
                        int cost = ms.getCost();
                        // diagonal = two side move
                        if ((row != 0) && (col != 0)) {
                            if(diagonalPathExist(position, row, col)){
                                cost += 15;
                                MazeState successor = new MazeState(cost, state, position);
                                successors.add(successor);
                            }
                        }
                        // one side move
                        else {
                            cost += 10;
                            MazeState successor = new MazeState(cost, state, position);
                            successors.add(successor);
                        }
                    }
                }
            }
        }
        return successors;
    }


    private boolean diagonalPathExist(Position position, int row, int col) {
        int sourceRow = position.getRowIndex();
        int sourceCol = position.getColumnIndex();
        Position position1 = new Position(sourceRow+row, sourceCol);
        Position position2 = new Position(sourceRow, sourceCol+col);
        boolean path1 = maze.isLegalPosition(position1) && maze.isPath(position1);
        boolean path2 = maze.isLegalPosition(position2) && maze.isPath(position2);
        boolean ans = path1 || path2;
        return ans;
    }
}
