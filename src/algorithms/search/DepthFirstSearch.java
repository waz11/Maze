package algorithms.search;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {

    @Override
    public Solution solve(ISearchable s) {
        Solution solution = new Solution();
        Stack<AState> toVisit = new Stack<>();
        Hashtable<String, AState> visited = new Hashtable<>();

        if (s==null)
            return solution;

        AState start = s.getStartState();
        AState goal = s.getGoalState();
        toVisit.push(start);

        while(!toVisit.isEmpty()){
            AState state = toVisit.pop();
            if (state.equals(goal)){
                solution = createSolution(state, start);
            }
            else{
                if (!visited.containsKey(state.toString())) {
                    visited.put(state.toString(), state);
                    this.numberOfNodesEvaluated++;
                }
                LinkedList<AState> possible = s.getAllSuccessors(state);
                for (int i=0; i<possible.size(); i++){
                    if(!(visited.containsKey(possible.get(i).toString())))
                        toVisit.add(possible.get(i));
                }
            }
        }
        return solution;
    }
}
