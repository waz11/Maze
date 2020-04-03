package algorithms.search;

import java.security.PrivateKey;
import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    private Solution solution;
    private Hashtable<String, AState> grayStates;
    private Queue<AState> states;

    public BreadthFirstSearch() {
        this.solution = new Solution();
        this.grayStates = new Hashtable<>();
        this.states = new LinkedList<>();
    }

    public Solution solve(ISearchable s) {
        if (s != null) {
            AState start = s.getStartState();
            AState goal = s.getGoalState();
            states.add(start);

            while (!states.isEmpty()) {
                AState state = states.poll();
                if (state.equals(goal))
                    solution = createSolution(state, start);
                else {
                    this.length++;
                    LinkedList<AState> possible = s.getAllSuccessors(state);
                    for (AState st : possible) {
                        if (isWhite(st)) {
                            paintGray(st);
                            states.add(st);
                        }
                    }
                }
            }
        }
        return solution;
    }

    private boolean isWhite(AState state) {
        return !grayStates.containsKey(state.toString());
    }

    private boolean isGray(AState state) {
        return grayStates.containsKey(state.toString());
    }

    private void paintGray(AState state) {
        grayStates.put(state.toString(), state);
    }
}