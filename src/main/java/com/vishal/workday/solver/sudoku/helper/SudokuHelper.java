package com.vishal.workday.solver.sudoku.helper;

import com.vishal.workday.solver.sudoku.exception.SudokuBoardInvalidException;
import com.vishal.workday.solver.sudoku.exception.SudokuBoardNullException;
import com.vishal.workday.solver.sudoku.exception.SudokuBoardSizeException;
import com.vishal.workday.solver.sudoku.node.SearchNodeImpl;
import javafx.util.Pair;
import org.apache.log4j.Logger;

import static com.vishal.workday.solver.sudoku.model.SudokuBoard.SUDOKU_BOARD_SIZE;

/**
 * Helper methods to perform checks for valid sudoku board, to process the next row-col pair,
 * and to copy the current sudoku board content.
 */
public class SudokuHelper {
    private Logger log = Logger.getLogger(SudokuHelper.class);

    public boolean isValid(int[][] matrix, int i, int j, int val) {
        int row = i - i % 3, column = j - j % 3;
        for(int x=0; x<SUDOKU_BOARD_SIZE; x++) {
            if(x != i && matrix[x][j] == val) {
                return false;
            }
        }
        for(int y=0; y<SUDOKU_BOARD_SIZE; y++) {
            if(y != j && matrix[i][y] == val) {
                return false;
            }
        }
        for(int x=0; x<3; x++) {
            for(int y=0; y<3; y++) {
                if(i != row + x && j != column + y && matrix[row + x][column + y] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public Pair<Integer, Integer> getNextRowColToProcess(SearchNodeImpl searchNode) throws SudokuBoardNullException,
            SudokuBoardInvalidException, SudokuBoardSizeException {
        int[][] matrix = searchNode.getSudokuBoard().getMatrix();

        if(matrix == null) {
            log.error("Matrix is null...");
            throw new SudokuBoardNullException("Matrix is null...");
        }

        if(matrix.length != SUDOKU_BOARD_SIZE || matrix[0].length != SUDOKU_BOARD_SIZE) {
            log.error("The matrix size is incorrect...");
            throw new SudokuBoardSizeException("The matrix size is incorrect...");
        }

        int r = searchNode.getSudokuBoard().getRow();
        int c = searchNode.getSudokuBoard().getCol() + 1;

        if(c == 9) {
            r = r + 1;
            c = 0;
        }
        if(r == 9) {
            return null;
        }

        if(matrix[r][c] < 0 || matrix[r][c] > SUDOKU_BOARD_SIZE) {
            log.error("Invalid entry in sudoku board... at row : " + r + " and column: " + c);
            throw new SudokuBoardInvalidException("Invalid entry in sudoku board... at row : " + r + " and column: " + c);
        }

        if(matrix[r][c] == 0) {
            return new Pair<>(r, c);
        } else {
            searchNode.getSudokuBoard().setRow(r);
            searchNode.getSudokuBoard().setCol(c);
            return getNextRowColToProcess(searchNode);
        }
    }

    public int[][] copyMatrix(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        for (int i=0; i < matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++)
            copy[i][j] = matrix[i][j];
        }
        return copy;
    }
}