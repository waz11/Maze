package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState {
    Position state;

    public MazeState(double cost, AState cameFrom, Position state) {
        super(cost, cameFrom);
        this.state = state;
    }
}
