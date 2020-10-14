package com.vishal.solver.sudoku.model;

/**
 * The sudoku board or puzzle containing the matrix with row and column
 * This is used in accordance with the current state to solve the puzzle.
 */
public class SudokuBoard {
    private int[][] matrix;
    private int row, col;
    public static final int SUDOKU_BOARD_SIZE = 9;

    public SudokuBoard(int[][] matrix) {
        this.matrix = matrix;
        this.row = 0;
        this.col = -1;
    }

    public SudokuBoard(int[][] matrix, int row, int col) {
        this.matrix = matrix;
        this.row = row;
        this.col = col;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return this.col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
