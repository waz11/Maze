package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState {
    Position state;

    public MazeState(String showState, double cost, AState cameFrom, Position state) {
        super(showState, cost, cameFrom);
        this.state = state;
    }
}
