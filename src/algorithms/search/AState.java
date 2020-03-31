package algorithms.search;

import java.util.Objects;

public abstract class AState  {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AState aState = (AState) o;
        return Double.compare(aState.cost, cost) == 0 &&
                Objects.equals(cameFrom, aState.cameFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, cameFrom);
    }
}
