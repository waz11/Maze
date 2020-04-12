package algorithms.search;

import java.util.Hashtable;
import java.util.Stack;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    String Name;
    int numberOfNodesEvaluated;

    protected Solution solution;
    protected Hashtable<String, AState> grayStates;

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
        while (state.getComeFrom() != null){
            states.add(state);
            state = state.getComeFrom();
        }
        states.add(start);
        while (!states.isEmpty())
            solution.addState(states.pop());
        return solution;
    }


    protected boolean isWhite(AState state) {
        return !grayStates.containsKey(state.toString());
    }

    protected boolean isGray(AState state) {
        return grayStates.containsKey(state.toString());
    }

    protected void paintGray(AState state) {
        grayStates.put(state.toString(), state);
    }
}
