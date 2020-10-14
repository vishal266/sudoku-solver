package com.vishal.solver.sudoku;

import com.vishal.solver.sudoku.exception.SearchNotSupportedException;
import com.vishal.solver.sudoku.exception.SudokuBoardInvalidException;
import com.vishal.solver.sudoku.exception.SudokuBoardNullException;
import com.vishal.solver.sudoku.exception.SudokuBoardSizeException;
import com.vishal.solver.sudoku.helper.SudokuTestHelper;
import com.vishal.solver.sudoku.model.SudokuBoard;
import com.vishal.solver.sudoku.search.BreadthFirstSearch;
import com.vishal.solver.sudoku.search.Search;
import com.vishal.solver.sudoku.search.SearchFactory;
import com.vishal.solver.sudoku.search.SearchType;
import com.vishal.solver.sudoku.node.SearchNode;
import com.vishal.solver.sudoku.node.SearchNodeImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SudokuBfsSolverTest {
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
    public void testBfsSolveNullBoard() throws SearchNotSupportedException, SudokuBoardNullException, SudokuBoardSizeException, SudokuBoardInvalidException {
        Search search = SearchFactory.getSearch(SearchType.BFS);
        BreadthFirstSearch bfs = (BreadthFirstSearch) search;
        SearchNode root = new SearchNodeImpl(nullBoard);
        bfs.setRoot(root);
        bfs.solve();
    }

    @Test(expected = SudokuBoardSizeException.class)
    public void testBfsSolveIncorrectSizeBoard() throws SearchNotSupportedException, SudokuBoardNullException, SudokuBoardSizeException, SudokuBoardInvalidException {
        Search search = SearchFactory.getSearch(SearchType.BFS);
        BreadthFirstSearch bfs = (BreadthFirstSearch) search;
        SearchNode root = new SearchNodeImpl(incorrectSizeBoard);
        bfs.setRoot(root);
        bfs.solve();
    }

    @Test(expected = SudokuBoardInvalidException.class)
    public void testBfsSolveInvalidBoard() throws SearchNotSupportedException, SudokuBoardNullException, SudokuBoardSizeException, SudokuBoardInvalidException {
        Search search = SearchFactory.getSearch(SearchType.BFS);
        BreadthFirstSearch bfs = (BreadthFirstSearch) search;
        SearchNode root = new SearchNodeImpl(invalidBoard);
        bfs.setRoot(root);
        bfs.solve();
    }

    // NO SOLUTION CASE
    @Test
    public void testBfsSolveNoSolutionBoard() throws SearchNotSupportedException, SudokuBoardNullException, SudokuBoardSizeException, SudokuBoardInvalidException {
        Search search = SearchFactory.getSearch(SearchType.BFS);
        BreadthFirstSearch bfs = (BreadthFirstSearch) search;
        SearchNode root = new SearchNodeImpl(noSolutionBoard);
        bfs.setRoot(root);
        Search.SolveStatus res = bfs.solve();
        assertEquals(res, Search.SolveStatus.NO_SOLUTION);
    }

    // VALID TEST CASES
    @Test
    public void testBfsSolveEasyBoard() throws SudokuBoardNullException, SudokuBoardSizeException, SudokuBoardInvalidException, SearchNotSupportedException {
        Search search = SearchFactory.getSearch(SearchType.BFS);
        BreadthFirstSearch bfs = (BreadthFirstSearch) search;
        SearchNode root = new SearchNodeImpl(easyBoard);
        bfs.setRoot(root);
        Search.SolveStatus res = bfs.solve();
        assertEquals(res, Search.SolveStatus.SOLUTION_FOUND);
        SearchNodeImpl resNode = (SearchNodeImpl) bfs.getSolutionNode();
        for(int i=0; i<easyBoard.getMatrix().length; i++) {
            for(int j=0; j<easyBoard.getMatrix()[0].length; j++) {
                assertEquals(expectedEasySolution[i][j], resNode.getSudokuBoard().getMatrix()[i][j]);
            }
        }
    }

    @Test
    public void testBfsSolveDifficultBoard() throws SudokuBoardNullException, SudokuBoardSizeException, SudokuBoardInvalidException, SearchNotSupportedException {
        Search search = SearchFactory.getSearch(SearchType.BFS);
        BreadthFirstSearch bfs = (BreadthFirstSearch) search;
        SearchNode root = new SearchNodeImpl(difficultBoard);
        bfs.setRoot(root);
        Search.SolveStatus res = bfs.solve();
        assertEquals(res, Search.SolveStatus.SOLUTION_FOUND);
        SearchNodeImpl resNode = (SearchNodeImpl) bfs.getSolutionNode();
        for(int i=0; i<difficultBoard.getMatrix().length; i++) {
            for(int j=0; j<difficultBoard.getMatrix()[0].length; j++) {
                assertEquals(expectedDifficultSolution[i][j], resNode.getSudokuBoard().getMatrix()[i][j]);
            }
        }
    }
}