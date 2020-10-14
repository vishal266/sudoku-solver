package com.vishal.workday.solver.sudoku;

import com.vishal.workday.solver.sudoku.exception.SearchNotSupportedException;
import com.vishal.workday.solver.sudoku.exception.SudokuBoardInvalidException;
import com.vishal.workday.solver.sudoku.exception.SudokuBoardNullException;
import com.vishal.workday.solver.sudoku.exception.SudokuBoardSizeException;
import com.vishal.workday.solver.sudoku.model.SudokuBoard;
import com.vishal.workday.solver.sudoku.node.SearchNode;
import com.vishal.workday.solver.sudoku.node.SearchNodeImpl;
import com.vishal.workday.solver.sudoku.search.*;
import org.apache.log4j.Logger;

/**
 * Driver program to run and test Sudoku solver with 2 different input puzzles which are solvable.
 * It employs 2 different search strategies such as Depth First Search and Breadth First Search.
 * Compares the metrics for DFS and BFS with time taken to complete solving and iterations involved
 */
public class SudokuSolver {
    private static Logger log = Logger.getLogger(SudokuSolver.class);
    public static void main(String[] args) {
        int[][] puzzle1 = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};

        int[][] puzzle2 = {
                {0, 0, 0, 6, 0, 0, 4, 0, 0},
                {7, 0, 0, 0, 0, 3, 6, 0, 0},
                {0, 0, 0, 0, 9, 1, 0, 8, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 5, 0, 1, 8, 0, 0, 0, 3},
                {0, 0, 0, 3, 0, 6, 0, 4, 5},
                {0, 4, 0, 2, 0, 0, 0, 6, 0},
                {9, 0, 3, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 1, 0, 0}};

        SudokuBoard sudokuBoard1 = new SudokuBoard(puzzle1);
        SudokuBoard sudokuBoard2 = new SudokuBoard(puzzle2);

        try {
            log.info("Solving sudoku puzzle1 with DFS...");
            Search dfsSearchBoard1 = SearchFactory.getSearch(SearchType.DFS);
            DepthFirstSearch dfs = (DepthFirstSearch) dfsSearchBoard1;

            SearchNode rootBoard1 = new SearchNodeImpl(sudokuBoard1);

            dfs.setRoot(rootBoard1);
            Search.SolveStatus resDfsBoard1 = dfs.solve();
            log.info("DFS " + resDfsBoard1.toString() + " for puzzle 1");

            log.info("Solving sudoku puzzle1 with BFS...");

            Search bfsSearchBoard1 = SearchFactory.getSearch(SearchType.BFS);
            BreadthFirstSearch bfs = (BreadthFirstSearch) bfsSearchBoard1;

            bfs.setRoot(rootBoard1);
            Search.SolveStatus resBfsBoard1 = bfs.solve();
            log.info("BFS " + resBfsBoard1.toString() + " for puzzle 1");

            log.info("Solving sudoku puzzle2 with DFS...");

            SearchNode rootBoard2 = new SearchNodeImpl(sudokuBoard2);

            dfs.setRoot(rootBoard2);
            Search.SolveStatus resDfsBoard2 = dfs.solve();
            log.info("DFS " + resDfsBoard2.toString() + " for puzzle 2");

            log.info("Solving sudoku puzzle2 with BFS...");

            bfs.setRoot(rootBoard2);
            Search.SolveStatus resBfsBoard2 = dfs.solve();
            log.info("BFS " + resBfsBoard2.toString() + " for puzzle 2");
        } catch (SearchNotSupportedException | SudokuBoardSizeException | SudokuBoardNullException | SudokuBoardInvalidException e) {
            e.printStackTrace();
        }
    }
}