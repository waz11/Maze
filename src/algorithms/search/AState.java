package algorithms.search;

import java.util.Objects;

public abstract class AState  {
    private String state;
    private double cost;
    private AState cameFrom;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AState aState = (AState) o;
        return Double.compare(aState.cost, cost) == 0 &&
                Objects.equals(state, aState.state) &&
                Objects.equals(cameFrom, aState.cameFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, cost, cameFrom);
    }
}
