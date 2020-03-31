package algorithms.search;

import java.util.ArrayList;

public interface ISearchable {
    AState getInitialState();
    AState getFinalState();
    ArrayList<AState> getAllPossibleStates(AState s);
}
