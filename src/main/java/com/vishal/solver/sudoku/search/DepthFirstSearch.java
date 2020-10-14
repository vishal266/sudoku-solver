package com.vishal.solver.sudoku.search;

import com.vishal.solver.sudoku.exception.SudokuBoardInvalidException;
import com.vishal.solver.sudoku.exception.SudokuBoardNullException;
import com.vishal.solver.sudoku.exception.SudokuBoardSizeException;
import com.vishal.solver.sudoku.node.frontier.FrontierNodeSet;
import com.vishal.solver.sudoku.node.frontier.FrontierNodeSetStackImpl;
import com.vishal.solver.sudoku.node.SearchNode;

/**
 * DFS technique that extends the default or provided abstract class Search.
 * Candidate list is constructed here based on stack data structure.
 */
public class DepthFirstSearch extends Search {

    DepthFirstSearch() {
        super();
        this.candidateList = new FrontierNodeSetStackImpl();
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
