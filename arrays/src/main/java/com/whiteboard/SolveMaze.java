package com.whiteboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Solve a 2D maze.
 */
public final class SolveMaze {
    private SolveMaze() {
    }

    static class RowCol {
        int row;
        int col;

        RowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof RowCol)) {
                return false;
            }
            RowCol other = (RowCol)o;
            return this.row == other.row && this.col == other.col;
        }
    }

    /**
     * Solve a 2D maze.
     *
     * Our algorithm searches recursively for a solution
     * by looking for paths that start at each cell that
     * is adjacent to the specified start cell.
     *
     * Execution time is O(n) [worst case], where n is
     * the number of cells in the maze.
     *
     * @param maze A 2D array representing the maze to
     *             be solved. Each element of the array
     *             contains either a '@', representing
     *             part of a wall, or a ' ', representing
     *             part of a corridor.
     * @param start The (row, column) indices of the starting
     *              cell.
     * @param exit The (row, column) indices of the maze
     *             exit that we are trying to reach.
     * @return A list containing the (row, column) indices
     * of a path leading from the start to the exit. (If no
     * such path exists, then the list will be empty.)
     */
    public static List<RowCol>
    solveMaze(char[][] maze, RowCol start, RowCol exit) {

        List<RowCol> result = new ArrayList<>();

        // error checking
        int numRows = maze.length;
        int numCols = maze[0].length;
        if (start.row < 0 || start.row >= numRows || start.col < 0 || start.col >= numCols) {
            return result;
        }
        if (maze[start.row][start.col] == '@') {
            return result;
        }
        // base case
        if (start.equals(exit)) {
            result.add(start);
            return result;
        }
        // recursive step
        maze[start.row][start.col] = '@';
        List<RowCol> remainingPath;
        remainingPath = solveMaze(maze, new RowCol(start.row, start.col - 1), exit);
        if (!remainingPath.isEmpty()) {
            result.add(start);
            result.addAll(remainingPath);
            return result;
        }
        remainingPath = solveMaze(maze, new RowCol(start.row - 1, start.col), exit);
        if (!remainingPath.isEmpty()) {
            result.add(start);
            result.addAll(remainingPath);
            return result;
        }
        remainingPath = solveMaze(maze, new RowCol(start.row, start.col + 1), exit);
        if (!remainingPath.isEmpty()) {
            result.add(start);
            result.addAll(remainingPath);
            return result;
        }
        remainingPath = solveMaze(maze, new RowCol(start.row + 1, start.col), exit);
        if (!remainingPath.isEmpty()) {
            result.add(start);
            result.addAll(remainingPath);
            return result;
        }
        return result;
    }
}
