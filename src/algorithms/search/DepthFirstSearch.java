package algorithms.search;

import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {
    private Stack<AState> states;

    public DepthFirstSearch() {
        this.solution = new Solution();
        this.states = new Stack<>();
        this.grayStates = new Hashtable<>();
    }

    @Override
    public Solution solve(ISearchable s) {
        if(s != null) {
            AState start = s.getStartState();
            AState goal = s.getGoalState();
            paintGray(start);
            states.push(start);

            while (!states.isEmpty()) {
                AState state = states.peek();
                if (state.equals(goal)) {
                    solution = createSolution(state, start);
                    break;
                }
                else {
                    this.numberOfNodesEvaluated++;
                    LinkedList<AState> possible = s.getAllPossibleStates(state);
                    Collections.shuffle(possible);
                    boolean b = false;
                    for (AState st : possible) {
                        if (isWhite(st)) {
                            paintGray(st);
                            states.add(st);
                            b=true;
                            break;
                        }
                    }
                    if(b==false)
                        states.pop();
                }
            }
        }
        return solution;
    }
}
