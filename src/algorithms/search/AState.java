package algorithms.search;

public abstract class AState implements Comparable<AState>{
    private int cost;
    private AState source;

    public AState(int cost, AState source) {
        this.cost = cost;
        this.source = source;
    }

    public int getCost() {
        return cost;
    }

    public AState getSource() {
        return source;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setSource(AState source) {
        this.source = source;
    }

    public int compareTo(AState o){
        if (this.getCost() > o.getCost())
            return 1;
        else if (this.getCost() < o.getCost())
            return -1;
        return 0;
    }
}
