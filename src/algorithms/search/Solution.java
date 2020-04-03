package algorithms.search;

import java.util.ArrayList;

public class Solution {
    ArrayList<AState> solution = new ArrayList<>();

    public ArrayList<AState> getSolution() {
        return solution;
    }

    public boolean addState(AState state){
        return solution.add(state);
    }
}
