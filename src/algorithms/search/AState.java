package algorithms.search;

import java.util.Objects;

public abstract class AState {
    private double cost;
    private AState cameFrom;

    public AState(double cost, AState cameFrom) {
        this.cost = cost;
        this.cameFrom = cameFrom;
    }

    public double getCost() {
        return cost;
    }

    public AState getCameFrom() {
        return cameFrom;
    }
}
