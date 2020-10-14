package com.vishal.solver.sudoku.search;
import com.vishal.solver.sudoku.exception.SearchNotSupportedException;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SearchTypeTest {

    // INVALID CASES
    @Test(expected = SearchNotSupportedException.class)
    public void testNullSearchType() throws SearchNotSupportedException {
        Search search = SearchFactory.getSearch(null);
        assertNull(search);
    }

    @Test(expected = SearchNotSupportedException.class)
    public void testAStarSearchType() throws SearchNotSupportedException {
        Search search = SearchFactory.getSearch(SearchType.AStar);
        assertNull(search);
    }

    // VALID CASES
    @Test
    public void testDfsSearchType() throws SearchNotSupportedException {
        Search search = SearchFactory.getSearch(SearchType.DFS);
        assertTrue(search instanceof DepthFirstSearch);
    }

    @Test
    public void testBfsSearchType() throws SearchNotSupportedException {
        Search search = SearchFactory.getSearch(SearchType.BFS);
        assertTrue(search instanceof BreadthFirstSearch);
    }
}
