package algorithms.search;

import java.util.Stack;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    String Name;
    int length;

    public ASearchingAlgorithm() {
        this.Name = this.getClass().toString();
        this.length = 0;
    }

    public String getName() {
        return this.Name;
    }

    public int getLength() {
        return length;
    }

    protected Solution createSolution(AState state, AState start) {
        Solution sol = new Solution();
        Stack<AState> states = new Stack<>();
        while (state.getSource() != null) {
            states.add(state);
            state = state.getSource();
        }
        states.add(start);
        while (!states.isEmpty())
            sol.addState(states.pop());
        return sol;
    }

}
