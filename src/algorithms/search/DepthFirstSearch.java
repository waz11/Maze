package algorithms.search;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {

    @Override
    public Solution solve(ISearchable s) {
        Solution finalSolution = new Solution();
        Stack<AState> toVisit = new Stack<>();
        Hashtable<String, AState> visited = new Hashtable<>();

        if (s==null)
            return finalSolution;

        AState start = s.getStartState();
        AState goal = s.getGoalState();
        toVisit.push(start);

        while(!toVisit.isEmpty()){
            AState curr = toVisit.pop();
            if (curr.equals(goal)){
                finalSolution = createSolution(curr, start);
            }
            else{
                if (!visited.containsKey(curr.toString())) {
                    visited.put(curr.toString(), curr);
                    this.numberOfNodesEvaluated++;
                }
                ArrayList<AState> possible = s.getAllSuccessors(curr);
                for (int i=0; i<possible.size(); i++){
                    if(!(visited.containsKey(possible.get(i).toString())))
                        toVisit.add(possible.get(i));
                }
            }
        }
        return finalSolution;
    }
}
