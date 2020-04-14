package algorithms.search;

import java.util.*;

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
            states.push(start);
            while (!states.isEmpty()) {
                AState state = states.peek();
                    paintGray(state);
                if (state.equals(goal)) {
                    solution = createSolution(state, start);
                    break;
                }
                else {
                    this.numberOfNodesEvaluated++;
                    LinkedList<AState> possible = s.getAllPossibleStates(state);
                    boolean newStateFound = false;
                    for (AState st : possible) {
                        if (isWhite(st)) {
                            states.push(st);
                            newStateFound=true;
                            break;
                        }
                    }
                    if(newStateFound==false)
                        states.pop();
                }
            }
        }
        return solution;
    }
}
