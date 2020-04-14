package algorithms.search;

import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch {
    public BestFirstSearch() {
        super.states = new PriorityQueue<>();
    }
}
