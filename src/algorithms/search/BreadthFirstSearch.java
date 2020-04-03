package algorithms.search;

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

            while (states.size() != 0) {
                AState state = states.poll();
                if (state.equals(goal)) {
                    solution = createSolution(state, start);
                } else {
                    this.length++;

                    LinkedList<AState> possible = s.getAllSuccessors(state);
                    for (int i = 0; i < possible.size(); i++) {
                        if (!(grayStates.containsKey(possible.get(i).toString()))) {
                            grayStates.put(possible.get(i).toString(), possible.get(i));
                            states.add(possible.get(i));
                        }
                    }
                }
            }
        }
        return solution;
    }
}