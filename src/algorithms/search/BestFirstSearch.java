package algorithms.search;

import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch {
    private Solution solution;
    private Hashtable<String, AState> grayStates;
    private PriorityQueue<AState> states;

    public BestFirstSearch() {
        this.solution = new Solution();
        this.grayStates = new Hashtable<>();
        this.states = new PriorityQueue<>();
    }

    public Solution solve(ISearchable s) {
        if (s != null) {
            AState start = s.getStartState();
            AState goal = s.getGoalState();
            states.add(start);

            while (states.size() != 0) {
                AState state = states.poll();
                if (state.equals(goal)) {
                    solution = createSolution(state, start);
                } else {
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
