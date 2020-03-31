package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {
    @Override
    public Solution search(ISearchable s) {
        AState start = s.getStartState();
        AState goal = s.getGoalState();

        Stack<AState> toVisit = new Stack<>();
        LinkedList<AState> visited = new LinkedList<>();

        toVisit.push(start);

        while(!toVisit.isEmpty()){
            AState curr = toVisit.pop();
            if (curr.equals(goal)){
                //what do we do?
            }
            else{
                if (!visited.contains(curr))
                    visited.add(curr);
                ArrayList<AState> possible = s.getAllSuccessors(curr);
                for (int i=0; i<possible.size(); i++){
                    if(!visited.contains(possible.get(i)))
                        toVisit.add(possible.get(i));
                }
            }
        }


        return null;
    }
}
