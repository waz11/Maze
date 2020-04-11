package algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JUnitTestingBestFirstSearch {

    @Test
    void solve() {
    }
    @Test
    void solve_Test1() {
        BestFirstSearch search = new BestFirstSearch();
        SearchableMaze searchableMaze = null;
        Solution solution = search.solve(searchableMaze);
        assertEquals(null, solution);
    }
}