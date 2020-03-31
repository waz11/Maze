package algorithms.search;

import javax.swing.plaf.nimbus.State;
import java.util.PriorityQueue;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    protected PriorityQueue<AState> openList;
    int numberOfNodesEvaluated;


    public ASearchingAlgorithm() {
        openList = new PriorityQueue<AState>();
        numberOfNodesEvaluated = 0;
    }

    public int getNumberOfNodesEvaluated() {
        return numberOfNodesEvaluated;
    }
}
