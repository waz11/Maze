package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    public BreadthFirstSearch(){
        this.Name = "BFS";
    }

    public Solution solve(ISearchable s) {
        Solution finalSolution = new Solution();
        LinkedList<AState> visited = new LinkedList<>();
        LinkedList<AState> toVisit = new LinkedList<>();

        AState start = s.getStartState();
        AState goal = s.getGoalState();
        toVisit.add(start);

        while (toVisit.size() != 0){
            AState curr = toVisit.poll();
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

}
