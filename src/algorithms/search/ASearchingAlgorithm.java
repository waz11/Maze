package algorithms.search;

import java.util.LinkedList;
import java.util.Stack;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    String Name;
    int numberOfNodesEvaluated;


    public ASearchingAlgorithm() {
        this.Name = this.getClass().toString();
        this.numberOfNodesEvaluated = 0;
    }

    public String getName(){return this.Name;}

    public int getNumberOfNodesEvaluated() {
        return numberOfNodesEvaluated;
    }

    protected Solution createSolution (AState state, AState start){
        Solution solution = new Solution();
        Stack<AState> states = new Stack<>();
        while (state.getSource() != null){
            states.add(state);
            state = state.getSource();
        }
        states.add(start);
        while (!states.isEmpty())
            solution.addState(states.pop());
        return solution;
    }
}
