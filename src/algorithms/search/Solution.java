package algorithms.search;

import java.util.ArrayList;

public class Solution {
    ArrayList<AState> solutionPath = new ArrayList<>();

    public ArrayList<AState> getSolutionPath() {
        return solutionPath;
    }

    public void addToSolution(AState newState){
        solutionPath.add(newState);
    }
}
