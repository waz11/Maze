package algorithms.search;

public abstract class AState implements Comparable<AState>{
    private int cost;
    private AState comeFrom;

    public AState(int cost, AState comeFrom) {
        this.cost = cost;
        this.comeFrom = comeFrom;
    }

    public int getCost() {
        return cost;
    }

    public AState getComeFrom() {
        return comeFrom;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setComeFrom(AState comeFrom) {
        this.comeFrom = comeFrom;
    }

    public int compareTo(AState o){
        if (this.getCost() > o.getCost())
            return 1;
        else if (this.getCost() < o.getCost())
            return -1;
        return 0;
    }
}
