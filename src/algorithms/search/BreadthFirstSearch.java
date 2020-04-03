package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    /*
    private Solution solution;
    private Stack<AState> states;
    private Hashtable<String, AState> grayStates;
    */


    public Solution solve(ISearchable s) {
        Solution solution = new Solution();
        Hashtable<String, AState> gratStates = new Hashtable<>();
        Queue<AState> toVisit = new LinkedList<>();

        if (s == null)
            return solution;

        AState start = s.getStartState();
        AState goal = s.getGoalState();
        toVisit.add(start);

        while (toVisit.size() != 0) {
            AState curr = toVisit.poll();
            if (curr.equals(goal)) {
                solution = createSolution(curr, start);
            } else {
                this.length++;

                LinkedList<AState> possible = s.getAllSuccessors(curr);
                for (int i = 0; i < possible.size(); i++) {
                    if (!(gratStates.containsKey(possible.get(i).toString()))) {
                        gratStates.put(possible.get(i).toString(), possible.get(i));
                        toVisit.add(possible.get(i));
                    }
                }
            }
        }
        return solution;
    }
}
