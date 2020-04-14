package algorithms.search;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {
    private Stack<AState> states;

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
            paintGray(start);
            states.push(start);

            while (!states.isEmpty()) {
                AState state = states.pop();
                if (state.equals(goal)) {
                    solution = createSolution(state, start);
                    break;
                }
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
}
