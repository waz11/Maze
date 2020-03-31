package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {
    Maze maze;

    public SearchableMaze(Maze maze) {
        this.maze = maze;
    }

    @Override
    public AState getStartState() {
        Position start = maze.getStart();
        MazeState startState = new MazeState(0, null, start);
        return startState;
    }

    @Override
    public AState getGoalState() {
        return null;
    }


    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        ArrayList<AState> successors = new ArrayList<>();
        MazeState ms = (MazeState) s;

        if (maze.isLegalPosition(new Position(ms.state.getRow()+1, ms.state.getCol())) && maze.isPath(new Position(ms.state.getRow()+1, ms.state.getCol())))
            successors.add(new MazeState(ms.getCost() + 10, s, new Position(ms.state.getRow()+1, ms.state.getCol())));
        if (maze.isLegalPosition(new Position(ms.state.getRow(), ms.state.getCol()+1)) && maze.isPath(new Position(ms.state.getRow(), ms.state.getCol()+1)))
            successors.add(new MazeState(ms.getCost() + 10, s, new Position(ms.state.getRow(), ms.state.getCol()+1)));
        if (maze.isLegalPosition(new Position(ms.state.getRow()-1, ms.state.getCol())) && maze.isPath(new Position(ms.state.getRow()-1, ms.state.getCol())))
            successors.add(new MazeState(ms.getCost() + 10, s, new Position(ms.state.getRow()-1, ms.state.getCol())));
        if (maze.isLegalPosition(new Position(ms.state.getRow(), ms.state.getCol()-1)) && maze.isPath(new Position(ms.state.getRow(), ms.state.getCol()-1)))
            successors.add(new MazeState(ms.getCost() + 10, s, new Position(ms.state.getRow(), ms.state.getCol()-1)));
        if (maze.isLegalPosition(new Position(ms.state.getRow()-1, ms.state.getCol()-1)) && maze.isPath(new Position(ms.state.getRow()-1, ms.state.getCol()-1)))
            successors.add(new MazeState(ms.getCost() + 15, s, new Position(ms.state.getRow()-1, ms.state.getCol()-1)));
        if (maze.isLegalPosition(new Position(ms.state.getRow()-1, ms.state.getCol()+1)) && maze.isPath(new Position(ms.state.getRow()-1, ms.state.getCol()+1)))
            successors.add(new MazeState(ms.getCost() + 15, s, new Position(ms.state.getRow()-1, ms.state.getCol()+1)));
        if (maze.isLegalPosition(new Position(ms.state.getRow()+1, ms.state.getCol()-1)) && maze.isPath(new Position(ms.state.getRow()+1, ms.state.getCol()-1)))
            successors.add(new MazeState(ms.getCost() + 15, s, new Position(ms.state.getRow()+1, ms.state.getCol()-1)));
        if (maze.isLegalPosition(new Position(ms.state.getRow()+1, ms.state.getCol()+1)) && maze.isPath(new Position(ms.state.getRow()+1, ms.state.getCol()+1)))
            successors.add(new MazeState(ms.getCost() + 15, s, new Position(ms.state.getRow()+1, ms.state.getCol()+1)));

        return successors;
    }

}
