package com.vishal.workday.solver.sudoku.node.frontier;

import com.vishal.workday.solver.sudoku.node.SearchNode;

import java.util.*;

/**
 * Queue data structure for candidate list
 */
public class FrontierNodeSetQueueImpl implements FrontierNodeSet {
    private Queue<SearchNode> q = new LinkedList<>();

    public boolean isEmpty() {
        return this.q.isEmpty();
    }

    public void add(SearchNode aNode) {
        if(aNode == null) {
            return;
        }
        this.q.add(aNode);
    }

    public void add(List<? extends SearchNode> nodeList) {
        this.q.addAll(nodeList);
    }

    public SearchNode removeNextOne() {
        if(this.q == null || this.q.isEmpty()) {
            return null;
        }
        return this.q.poll();
    }
}
