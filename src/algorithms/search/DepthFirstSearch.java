package algorithms.search;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {
    private Solution solution;
    private Stack<AState> states;
    private Hashtable<String, AState> grayStates;

    public DepthFirstSearch() {
        this.solution = new Solution();
        this.states = new Stack<>();
        this.grayStates = new Hashtable<>();
    }

    @Override
    public Solution solve(ISearchable s) {
        if(s != null) {
            AState start = s.getStartState();
            AState goal = s.getGoalState();
            states.push(start);

            while (!states.isEmpty()) {
                AState state = states.pop();
                if (state.equals(goal))
                    solution = createSolution(state, start);
                else {
                    if (isWhite(state)) {
                        paintGray(state);
                        this.numberOfNodesEvaluated++;
                    }
                    LinkedList<AState> possible = s.getAllPossibleStates(state);
                    for (AState st : possible) {
                        if (isWhite(st))
                            states.add(st);
                    }
                }
            }
        }
        return solution;
    }

    private boolean isWhite(AState state){
        return !grayStates.containsKey(state.toString());
    }
    private boolean isGray(AState state){
        return grayStates.containsKey(state.toString());
    }
    private void paintGray(AState state) {
        grayStates.put(state.toString(), state);
    }

}
