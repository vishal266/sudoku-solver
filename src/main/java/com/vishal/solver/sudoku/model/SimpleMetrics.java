package com.vishal.solver.sudoku.model;

/**
 * A Simple metrics class to capture start time, end time, total time taken and number of iterations.
 * This will be computed for both kinds of search strategies - DFS and BFS
 */
public class SimpleMetrics {
    private long startTime;
    private long endTime;
    private long timeTaken;
    private long noOfIterations;

    public SimpleMetrics() {
        this.startTime = 0;
        this.endTime = 0;
        this.timeTaken = 0;
        this.noOfIterations = 0;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }

    public long getNoOfIterations() {
        return noOfIterations;
    }

    public void setNoOfIterations(long noOfIterations) {
        this.noOfIterations = noOfIterations;
    }
}
