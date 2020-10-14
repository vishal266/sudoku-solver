package com.vishal.workday.solver.sudoku.node.frontier;

import com.vishal.workday.solver.sudoku.node.SearchNode;

import java.util.*;

/**
 * Stack data structure for candidate list
 */
public class FrontierNodeSetStackImpl implements FrontierNodeSet {
    private Deque<SearchNode> s = new ArrayDeque<>();

    public boolean isEmpty() {
        return this.s.isEmpty();
    }

    public void add(SearchNode aNode) {
        if(aNode == null) {
            return;
        }
        this.s.add(aNode);
    }

    public void add(List<? extends SearchNode> nodeList) {
        if(nodeList == null || nodeList.isEmpty()) {
            return;
        }
        for(SearchNode aNode : nodeList) {
            this.s.push(aNode);
        }
    }

    public SearchNode removeNextOne() {
        if(this.s == null || this.s.isEmpty()) {
            return null;
        }
        return this.s.pop();
    }
}
