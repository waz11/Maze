package algorithms.search;

import java.util.LinkedList;

public class Solution {
    LinkedList<AState> solution = new LinkedList<>();

    public LinkedList<AState> getSolution() {
        return solution;
    }

    public boolean addState(AState state){
        return solution.add(state);
    }
}
