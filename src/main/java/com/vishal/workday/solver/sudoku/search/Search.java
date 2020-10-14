package com.vishal.workday.solver.sudoku.search;

import com.vishal.workday.solver.sudoku.exception.SudokuBoardInvalidException;
import com.vishal.workday.solver.sudoku.exception.SudokuBoardNullException;
import com.vishal.workday.solver.sudoku.exception.SudokuBoardSizeException;
import com.vishal.workday.solver.sudoku.helper.SudokuHelper;
import com.vishal.workday.solver.sudoku.model.SimpleMetrics;
import com.vishal.workday.solver.sudoku.model.SudokuBoard;
import com.vishal.workday.solver.sudoku.node.frontier.FrontierNodeSet;
import com.vishal.workday.solver.sudoku.node.SearchNode;
import com.vishal.workday.solver.sudoku.node.SearchNodeImpl;
import javafx.util.Pair;
import org.apache.log4j.Logger;

import java.util.Arrays;

import static com.vishal.workday.solver.sudoku.model.SudokuBoard.SUDOKU_BOARD_SIZE;

/**
 * A Generic State Space Search framework, allow one to implement a variety of
 * search strategies for any chosen domain.
 */

public abstract class Search {

    protected SearchNode root;
    protected SearchNode solutionLeafNode;
    protected FrontierNodeSet candidateList;
    private SudokuHelper sudokuHelper;
    private SimpleMetrics simpleMetrics;

    private Logger log = Logger.getLogger(Search.class);

    public enum SolveStatus {
        SOLUTION_FOUND, NO_SOLUTION, TIME_OUT, REACHED_RESOURCE_LIMIT
    }

    protected Search() {
        this.solutionLeafNode = null;
        this.sudokuHelper = new SudokuHelper();
        this.simpleMetrics = new SimpleMetrics();
    }

    /**
     *
     * @return The leaf solution node. It can be null if a solution has not
     *     been found yet.
     */
    public SearchNode getSolutionNode() {
        return this.solutionLeafNode;
    }

    /**
     * Default implementation of a generate state space search. Many search
     * strategies can be achieved by varying the sorting order of the
     * "candidateList" or by implementing how global metrics is updated
     * and how a search branch is pruned.
     *
     * @return SolveStatus.SOLUTION_FOUND when a solution is found
     *                   SolveStatus.NO_SOLUTION when there is no feasible solution
     *                   Other solve status if time out and resource limit is
     *                   implemented
     */
    public SolveStatus solve() throws SudokuBoardSizeException, SudokuBoardNullException, SudokuBoardInvalidException {
        while (!candidateList.isEmpty()) {
            SearchNode theNode = candidateList.removeNextOne();
            if (theNode.isGoal()) {
                findSolution(theNode);
                return SolveStatus.SOLUTION_FOUND;
            } else {
                updateGlobalMetrics(theNode);
                if (!pruneNode(theNode)) {
                    candidateList.add(theNode.expand());
                }
            }
        }
        return SolveStatus.NO_SOLUTION;
    }

    /**
     * Default doing nothing implementation of updating the global metrics after
     * one node is evaluated. Need to override this to implement A*, Alpha-Beta
     * pruning, branch and bound, etc.
     * @param theNode - the node just evaluated with potential fresh metrics
     */
    public void updateGlobalMetrics(SearchNode theNode) {
        long startTime = simpleMetrics.getStartTime();
        long endTime = simpleMetrics.getEndTime();
        long currTime = System.currentTimeMillis();
        if(endTime == 0) {
            startTime = currTime;
            endTime = currTime;
        } else {
            endTime = currTime;
        }
        simpleMetrics.setStartTime(startTime);
        simpleMetrics.setEndTime(endTime);
        simpleMetrics.setTimeTaken(endTime - startTime);
        long noOfIterations = simpleMetrics.getNoOfIterations();
        noOfIterations += 1;
        simpleMetrics.setNoOfIterations(noOfIterations);
    }

    /**
     * Default implementation of not pruning branch after a node evaluation.
     * @param theNode - the node just evaluated, potentially to be pruned
     * @return True if the branch starting at "theNode" is pruned,
     *                   false otherwise.
     */
    public boolean pruneNode(SearchNode theNode) throws SudokuBoardSizeException,
            SudokuBoardNullException, SudokuBoardInvalidException {
        int[][] matrix = ((SearchNodeImpl) theNode).getSudokuBoard().getMatrix();
        if(log.isDebugEnabled()) {
            log.debug("Current matrix state: ");
            StringBuilder curr = new StringBuilder();
            curr.append("\n");
            for(int[] row : matrix) {
                curr.append(Arrays.toString(row));
                log.debug(curr);
            }
        }
        int[][] copy;
        Pair<Integer, Integer> rowCol = sudokuHelper.getNextRowColToProcess((SearchNodeImpl) theNode);
        if(rowCol == null) {
            copy = sudokuHelper.copyMatrix(matrix);
            solutionLeafNode = new SearchNodeImpl(new SudokuBoard(copy, 0, 0));
            ((SearchNodeImpl) solutionLeafNode).setLastNode(true);
            ((SearchNodeImpl) theNode).addToNextState(solutionLeafNode);
            return false;
        }
        int row = rowCol.getKey();
        int col = rowCol.getValue();
        for(int i=1; i<=SUDOKU_BOARD_SIZE; i++) {
            copy = sudokuHelper.copyMatrix(matrix);
            copy[row][col] = i;
            if(sudokuHelper.isValid(matrix, row, col, i)) {
                ((SearchNodeImpl) theNode).addToNextState(new SearchNodeImpl(new SudokuBoard(copy, row, col)));
            }
        }
        return false;
    }

    /**
     * Default doing nothing implementation of the find solution method.
     * @param theNode - the node just evaluated, potentially to be pruned
     */
    public void findSolution(SearchNode theNode) {
        StringBuilder res = new StringBuilder();
        res.append("The solved puzzle is: \n");
        int[][] matrix = ((SearchNodeImpl)theNode).getSudokuBoard().getMatrix();
        for(int i = 0; i<SUDOKU_BOARD_SIZE; i++) {
            for(int j = 0; j<SUDOKU_BOARD_SIZE; j++) {
                res.append(matrix[i][j]).append("\t");
            }
            res.append("\n");
        }
        log.info(res.toString());
        log.info("Time taken (in ms): " + simpleMetrics.getTimeTaken());
        log.info("Number of iterations: " + simpleMetrics.getNoOfIterations());
        simpleMetrics = new SimpleMetrics(); // reset metrics
    }
}