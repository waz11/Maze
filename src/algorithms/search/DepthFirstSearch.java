package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {
    public DepthFirstSearch() {
        this.Name = "DFS";
    }

    @Override
    public Solution solve(ISearchable s) {
        Solution finalSolution = new Solution();
        Stack<AState> toVisit = new Stack<>();
        LinkedList<AState> visited = new LinkedList<>();

        AState start = s.getStartState();
        AState goal = s.getGoalState();
        toVisit.push(start);

        while(!toVisit.isEmpty()){
            AState curr = toVisit.pop();
            if (curr.equals(goal)){
                finalSolution = createSolution(curr, start);
            }
            else{
                if (!visited.contains(curr)) {
                    this.numberOfNodesEvaluated++;
                    visited.add(curr);
                }
                ArrayList<AState> possible = s.getAllSuccessors(curr);
                for (int i=0; i<possible.size(); i++){
                    if(!(visited.contains(possible.get(i))))
                        toVisit.add(possible.get(i));
                }
            }
        }
        return finalSolution;
    }

    protected Solution createSolution (AState curr, AState start){
        Solution finalSolution = new Solution();
        LinkedList<AState> route = new LinkedList<>();
        while (!(curr.getCameFrom() == null)){
            route.add(curr);
            curr = curr.getCameFrom();
        }
        route.add(start);
        for (int i=route.size()-1; i>=0; i--)
            finalSolution.addToSolution(route.get(i));

        return finalSolution;
    }
}
