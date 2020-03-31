package algorithms.search;

import java.util.Objects;

public abstract class AState  {
    private String showState;
    private double cost;
    private AState cameFrom;

    public AState(String showState, double cost, AState cameFrom) {
        this.showState = showState;
        this.cost = cost;
        this.cameFrom = cameFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AState aState = (AState) o;
        return Double.compare(aState.cost, cost) == 0 &&
                Objects.equals(showState, aState.showState) &&
                Objects.equals(cameFrom, aState.cameFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showState, cost, cameFrom);
    }
}
