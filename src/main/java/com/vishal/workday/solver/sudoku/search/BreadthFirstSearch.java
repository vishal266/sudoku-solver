package com.vishal.workday.solver.sudoku.search;

import com.vishal.workday.solver.sudoku.exception.SudokuBoardInvalidException;
import com.vishal.workday.solver.sudoku.exception.SudokuBoardNullException;
import com.vishal.workday.solver.sudoku.exception.SudokuBoardSizeException;
import com.vishal.workday.solver.sudoku.node.frontier.FrontierNodeSetQueueImpl;
import com.vishal.workday.solver.sudoku.node.frontier.FrontierNodeSet;
import com.vishal.workday.solver.sudoku.node.SearchNode;

/**
 * BFS technique that extends the default or provided abstract class Search.
 * Candidate list is constructed here based on queue data structure.
 */
public class BreadthFirstSearch extends Search {

    BreadthFirstSearch() {
        super();
        this.candidateList = new FrontierNodeSetQueueImpl();
    }

    @Override
    public SolveStatus solve() throws SudokuBoardSizeException, SudokuBoardNullException, SudokuBoardInvalidException {
        this.getCandidateList().add(this.getRoot());
        return super.solve();
    }

    @Override
    public void updateGlobalMetrics(SearchNode searchNode) {
        super.updateGlobalMetrics(searchNode);
    }

    public SearchNode getRoot() {
        return this.root;
    }

    public void setRoot(SearchNode root) {
        this.root = root;
    }

    public FrontierNodeSet getCandidateList() {
        return this.candidateList;
    }
}
