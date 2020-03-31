package algorithms.search;

import java.util.ArrayList;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    String Name;
    int numberOfNodesEvaluated;

    public ASearchingAlgorithm() {
        this.numberOfNodesEvaluated = 0;
    }

    public String getName(){return this.Name;}

    public int getNumberOfNodesEvaluated() {
        return numberOfNodesEvaluated;
    }

}
