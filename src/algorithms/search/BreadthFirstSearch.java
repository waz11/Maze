package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm {

    public Solution solve(ISearchable s) {
        Solution finalSolution = new Solution();
        Hashtable<String, AState> visited = new Hashtable<>();
        Queue<AState> toVisit = new LinkedList<>();

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
                this.length++;

                LinkedList<AState> possible = s.getAllSuccessors(curr);
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