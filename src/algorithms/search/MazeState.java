package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState {
    Position state;

    public MazeState(Position state, AState p_state, int cost) {
        super(p_state, cost);
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MazeState))
            return false;
        MazeState mState = (MazeState) o;
        return this.state.equals(((MazeState) o).state);
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
