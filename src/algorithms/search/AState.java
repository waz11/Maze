package algorithms.search;

import java.util.Objects;

public abstract class AState implements Comparable<AState>{
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

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCameFrom(AState cameFrom) {
        this.cameFrom = cameFrom;
    }

    public int compareTo(AState o){
        if (this.getCost() > o.getCost())
            return 1;
        else if (this.getCost() < o.getCost())
            return -1;
        return 0;
    }
}
