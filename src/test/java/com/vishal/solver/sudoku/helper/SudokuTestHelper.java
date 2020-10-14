package com.vishal.solver.sudoku.helper;

import com.vishal.solver.sudoku.model.SudokuBoard;

public class SudokuTestHelper {
    private static int[][] nullPuzzle = null;

    private static int[][] incorrectSizePuzzle = {
            {5, 3, 0, 0, 7, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}};

    private static int[][] invalidPuzzle = {
            {0, 0, 0, 60, 0, 0, 4, 0, 0},
            {-7, 0, 0, 0, 0, 3, 6, 0, 0},
            {0, 0, 0, 0, 9, 19, 0, 8, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 5, 0, 1, 8, 0, 0, 0, 3},
            {0, 0, 0, 3, 0, 63, 0, 4, 5},
            {0, 4, 0, 2, 0, 0, 0, 6, 0},
            {9, 0, 3, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 1, 0, 0}};

    private static int[][] noSolutionPuzzle = {
            {5, 1, 6, 8, 4, 9, 7, 3, 2},
            {3, 0, 7, 6, 0, 5, 0, 0, 0},
            {8, 0, 9, 7, 0, 0, 0, 6, 5},
            {1, 3, 5, 0, 6, 0, 9, 0, 7},
            {4, 7, 2, 5, 9, 1, 0, 0, 6},
            {9, 6, 8, 3, 7, 0, 0, 5, 0},
            {2, 5, 3, 1, 8, 6, 0, 7, 4},
            {6, 8, 4, 2, 0, 7, 5, 0, 0},
            {7, 9, 1, 0, 5, 0, 6, 0, 8}};

    private static int[][] eazyPuzzle = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}};

    private static int[][] difficultPuzzle = {
            {0, 0, 0, 6, 0, 0, 4, 0, 0},
            {7, 0, 0, 0, 0, 3, 6, 0, 0},
            {0, 0, 0, 0, 9, 1, 0, 8, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 5, 0, 1, 8, 0, 0, 0, 3},
            {0, 0, 0, 3, 0, 6, 0, 4, 5},
            {0, 4, 0, 2, 0, 0, 0, 6, 0},
            {9, 0, 3, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 1, 0, 0}};

    private static int[][] expectedEasySolution = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}};

    private static int[][] expectedDifficultSolution = {
            {5, 8, 1, 6, 7, 2, 4, 3, 9},
            {7, 9, 2, 8, 4, 3, 6, 5, 1},
            {3, 6, 4, 5, 9, 1, 7, 8, 2},
            {4, 3, 8, 9, 5, 7, 2, 1, 6},
            {2, 5, 6, 1, 8, 4, 9, 7, 3},
            {1, 7, 9, 3, 2, 6, 8, 4, 5},
            {8, 4, 5, 2, 1, 9, 3, 6, 7},
            {9, 1, 3, 7, 6, 8, 5, 2, 4},
            {6, 2, 7, 4, 3, 5, 1, 9, 8}};

    private static SudokuBoard nullBoard = new SudokuBoard(nullPuzzle);
    private static SudokuBoard incorrectSizeBoard = new SudokuBoard(incorrectSizePuzzle);
    private static SudokuBoard invalidBoard = new SudokuBoard(invalidPuzzle);
    private static SudokuBoard noSolutionBoard = new SudokuBoard(noSolutionPuzzle);
    private static SudokuBoard easyBoard = new SudokuBoard(eazyPuzzle);
    private static SudokuBoard difficultBoard = new SudokuBoard(difficultPuzzle);

    public static SudokuBoard getNullBoard() {
        return nullBoard;
    }

    public static SudokuBoard getIncorrectSizeBoard() {
        return incorrectSizeBoard;
    }

    public static SudokuBoard getInvalidBoard() {
        return invalidBoard;
    }

    public static SudokuBoard getNoSolutionBoard() {
        return noSolutionBoard;
    }

    public static SudokuBoard getEasyBoard() {
        return easyBoard;
    }

    public static SudokuBoard getDifficultBoard() {
        return difficultBoard;
    }

    public static int[][] getExpectedEasySolution() {
        return expectedEasySolution;
    }

    public static int[][] getExpectedDifficultSolution() {
        return expectedDifficultSolution;
    }
}
