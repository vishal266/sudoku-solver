package com.vishal.workday.solver.sudoku;

import com.vishal.workday.solver.sudoku.exception.SearchNotSupportedException;
import com.vishal.workday.solver.sudoku.exception.SudokuBoardInvalidException;
import com.vishal.workday.solver.sudoku.exception.SudokuBoardNullException;
import com.vishal.workday.solver.sudoku.exception.SudokuBoardSizeException;
import com.vishal.workday.solver.sudoku.helper.SudokuTestHelper;
import com.vishal.workday.solver.sudoku.model.SudokuBoard;
import com.vishal.workday.solver.sudoku.node.SearchNode;
import com.vishal.workday.solver.sudoku.node.SearchNodeImpl;
import com.vishal.workday.solver.sudoku.search.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SudokuDfsSolverTest {
    private static SudokuBoard nullBoard;
    private static SudokuBoard incorrectSizeBoard;
    private static SudokuBoard invalidBoard;
    private static SudokuBoard noSolutionBoard;
    private static SudokuBoard easyBoard;
    private static SudokuBoard difficultBoard;
    private static int[][] expectedEasySolution;
    private static int[][] expectedDifficultSolution;

    @BeforeClass
    public static void setUp() {
        nullBoard = SudokuTestHelper.getNullBoard();
        incorrectSizeBoard = SudokuTestHelper.getIncorrectSizeBoard();
        invalidBoard = SudokuTestHelper.getInvalidBoard();
        noSolutionBoard = SudokuTestHelper.getNoSolutionBoard();
        easyBoard = SudokuTestHelper.getEasyBoard();
        difficultBoard = SudokuTestHelper.getDifficultBoard();
        expectedEasySolution = SudokuTestHelper.getExpectedEasySolution();
        expectedDifficultSolution = SudokuTestHelper.getExpectedDifficultSolution();
    }

    // ALL INVALID CASES
    @Test(expected = SudokuBoardNullException.class)
    public void testDfsSolveNullBoard() throws SearchNotSupportedException, SudokuBoardNullException, SudokuBoardSizeException, SudokuBoardInvalidException {
        Search search = SearchFactory.getSearch(SearchType.DFS);
        DepthFirstSearch dfs = (DepthFirstSearch) search;
        SearchNode root = new SearchNodeImpl(nullBoard);
        dfs.setRoot(root);
        dfs.solve();
    }

    @Test(expected = SudokuBoardSizeException.class)
    public void testDfsSolveIncorrectSizeBoard() throws SearchNotSupportedException, SudokuBoardNullException, SudokuBoardSizeException, SudokuBoardInvalidException {
        Search search = SearchFactory.getSearch(SearchType.DFS);
        DepthFirstSearch dfs = (DepthFirstSearch) search;
        SearchNode root = new SearchNodeImpl(incorrectSizeBoard);
        dfs.setRoot(root);
        dfs.solve();
    }

    @Test(expected = SudokuBoardInvalidException.class)
    public void testDfsSolveInvalidBoard() throws SearchNotSupportedException, SudokuBoardNullException, SudokuBoardSizeException, SudokuBoardInvalidException {
        Search search = SearchFactory.getSearch(SearchType.DFS);
        DepthFirstSearch dfs = (DepthFirstSearch) search;
        SearchNode root = new SearchNodeImpl(invalidBoard);
        dfs.setRoot(root);
        dfs.solve();
    }

    // NO SOLUTION CASE
    @Test
    public void testDfsSolveNoSolutionBoard() throws SearchNotSupportedException, SudokuBoardNullException, SudokuBoardSizeException, SudokuBoardInvalidException {
        Search search = SearchFactory.getSearch(SearchType.DFS);
        DepthFirstSearch dfs = (DepthFirstSearch) search;
        SearchNode root = new SearchNodeImpl(noSolutionBoard);
        dfs.setRoot(root);
        Search.SolveStatus res = dfs.solve();
        assertEquals(res, Search.SolveStatus.NO_SOLUTION);
    }

    // VALID TEST CASES
    @Test
    public void testDfsSolveEasyBoard() throws SudokuBoardNullException, SudokuBoardSizeException, SudokuBoardInvalidException, SearchNotSupportedException {
        Search search = SearchFactory.getSearch(SearchType.DFS);
        DepthFirstSearch dfs = (DepthFirstSearch) search;
        SearchNode root = new SearchNodeImpl(easyBoard);
        dfs.setRoot(root);
        Search.SolveStatus res = dfs.solve();
        assertEquals(res, Search.SolveStatus.SOLUTION_FOUND);
        SearchNodeImpl resNode = (SearchNodeImpl) dfs.getSolutionNode();
        for(int i=0; i<easyBoard.getMatrix().length; i++) {
            for(int j=0; j<easyBoard.getMatrix()[0].length; j++) {
                assertEquals(expectedEasySolution[i][j], resNode.getSudokuBoard().getMatrix()[i][j]);
            }
        }
    }

    @Test
    public void testDfsSolveDifficultBoard() throws SudokuBoardNullException, SudokuBoardSizeException, SudokuBoardInvalidException, SearchNotSupportedException {
        Search search = SearchFactory.getSearch(SearchType.DFS);
        DepthFirstSearch dfs = (DepthFirstSearch) search;
        SearchNode root = new SearchNodeImpl(difficultBoard);
        dfs.setRoot(root);
        Search.SolveStatus res = dfs.solve();
        assertEquals(res, Search.SolveStatus.SOLUTION_FOUND);
        SearchNodeImpl resNode = (SearchNodeImpl) dfs.getSolutionNode();
        for(int i=0; i<difficultBoard.getMatrix().length; i++) {
            for(int j=0; j<difficultBoard.getMatrix()[0].length; j++) {
                assertEquals(expectedDifficultSolution[i][j], resNode.getSudokuBoard().getMatrix()[i][j]);
            }
        }
    }
}