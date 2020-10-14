package com.vishal.solver.sudoku.node;

import com.vishal.solver.sudoku.model.SudokuBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the SearchNode interface
 * Encapsulated the current state and the next state of the Sudoku board to solve the puzzle.
 */
public class SearchNodeImpl implements SearchNode {
    private SudokuBoard sudokuBoard;
    private List<SearchNode> nextState;
    private boolean isLastNode = false;

    public SearchNodeImpl(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        this.nextState = new ArrayList<>();
    }

    public SudokuBoard getSudokuBoard() {
        return this.sudokuBoard;
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public boolean isLastNode() {
        return this.isLastNode;
    }

    public void setLastNode(boolean lastNode) {
        this.isLastNode = lastNode;
    }

    public boolean isGoal() {
        return this.isLastNode;
    }

    public List<? extends SearchNode> expand() {
        return this.nextState;
    }

    public void addToNextState(SearchNode searchNode) {
        this.nextState.add(searchNode);
    }
}