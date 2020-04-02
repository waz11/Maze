package algorithms.search;

import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch {

    public Solution solve(ISearchable s) {
        Solution finalSolution = new Solution();
        Hashtable<String, AState> visited = new Hashtable<>();
        PriorityQueue<AState> toVisit = new PriorityQueue<>();

        if (s==null)
            return finalSolution;

        AState start = s.getStartState();
        AState goal = s.getGoalState();
        toVisit.add(start);

        while (toVisit.size() != 0){
            AState curr = toVisit.poll();
            if (curr.equals(goal)){
                finalSolution = createSolution(curr, start);
            }
            else{
                this.numberOfNodesEvaluated++;

                ArrayList<AState> possible = s.getAllSuccessors(curr);
                for (int i=0; i<possible.size(); i++){
                    if(!(visited.containsKey(possible.get(i).toString()))){
                        visited.put(possible.get(i).toString(), possible.get(i));
                        toVisit.add(possible.get(i));
                    }
                }
            }
        }
        return finalSolution;
    }

}
