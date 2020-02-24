package com.whiteboard;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 * Solve a 2D maze.
 */
public class SolveMaze {
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
    public List<Pair<Integer, Integer>> solveMaze(
            char[][] maze,
            Pair<Integer, Integer> start,
            Pair<Integer, Integer> exit) {

        List<Pair<Integer, Integer>> path = new ArrayList<>();

        if (start.equals(exit)) {
            path.add(start);
            return path;
        }
        int rowStart = start.getKey();
        int colStart = start.getValue();
        int numRows = maze.length;
        int numCols = maze[0].length;

        if (rowStart < 0 || colStart < 0 || rowStart >= numRows || colStart >= numCols) {
            return path;
        }
        if (maze[rowStart][colStart] == '@') {
            return path;
        }
        // Turn this cell into a wall wo we don't revisit it.
        maze[rowStart][colStart] = '@';

        List<Pair<Integer, Integer>> remainingPath;
        remainingPath = solveMaze(maze, new Pair<>(rowStart - 1, colStart), exit);
        if (!remainingPath.isEmpty()) {
            path.add(start);
            path.addAll(remainingPath);
            return path;
        }
        remainingPath = solveMaze(maze, new Pair<>(rowStart, colStart - 1), exit);
        if (!remainingPath.isEmpty()) {
            path.add(start);
            path.addAll(remainingPath);
            return path;
        }
        remainingPath = solveMaze(maze, new Pair<>(rowStart + 1, colStart), exit);
        if (!remainingPath.isEmpty()) {
            path.add(start);
            path.addAll(remainingPath);
            return path;
        }
        remainingPath = solveMaze(maze, new Pair<>(rowStart, colStart + 1), exit);
        if (!remainingPath.isEmpty()) {
            path.add(start);
            path.addAll(remainingPath);
            return path;
        }
        return path;
    }
}
