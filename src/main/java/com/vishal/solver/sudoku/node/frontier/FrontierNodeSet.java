package com.vishal.solver.sudoku.node.frontier;

import com.vishal.solver.sudoku.node.SearchNode;

import java.util.List;

/**
 * A collection of nodes to be explored. It should be stored in a way
 * that is effective for the search strategy used.
 */

public interface FrontierNodeSet {
    /**
     *
     * @return True if no more node to explore.
     */
    boolean isEmpty();

    /**
     * Add one SearchNode to the collection.
     * @param aNode - a node to be added
     */
    void add(SearchNode aNode);

    /**
     * Add a list of SearchNodes to the collection.
     * @param nodeList - a list of nodes to be added
     */
    void add(List<? extends SearchNode> nodeList);

    /**
     * Removed one node from the collection to further evaluate/explore.
     * If the collection is sorted, it will remove node according to
     * sorting order.
     * @return The next search node to evaluate/explore.
     */
    SearchNode removeNextOne();
}