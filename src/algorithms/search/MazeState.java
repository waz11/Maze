package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

public class MazeState extends AState {
    Position state;

    public MazeState(double cost, AState cameFrom, Position state) {
        super(cost, cameFrom);
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        MazeState mState = (MazeState) o;
        return this.state.equals(((MazeState) o).state);
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
