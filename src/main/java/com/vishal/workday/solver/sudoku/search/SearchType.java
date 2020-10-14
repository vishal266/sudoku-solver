package com.vishal.workday.solver.sudoku.search;

/**
 * Various search strategies for solving sudoku
 * 2 kinds of searches namely exhaustive search and heuristic search can be employed.
 * This solver currently supports only DFS and BFS. But in future, support can be added for heuristic searches too.
 */
public enum SearchType {
    DFS,
    BFS,
    AStar,
    AlphaBeta,
    BranchBound,
}
