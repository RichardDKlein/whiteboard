package com.whiteboard;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
    public List<Point> solveMaze(
            char[][] maze,
            Point start,
            Point exit) {

        List<Point> path = new ArrayList<>();
        if (start.equals(exit)) {
            path.add(start);
            return path;
        }
        int startRow = start.x;
        int startCol = start.y;
        int numRows = maze.length;
        int numCols = maze[0].length;
        if (startRow < 0 || startCol < 0 || startRow >= numRows || startCol >= numCols) {
            return path;
        }
        if (maze[startRow][startCol] == '@') {
            return path;
        }
        maze[startRow][startCol] = '@';
        List<Point> remainingPath;
        remainingPath = solveMaze(maze, new Point(startRow, startCol - 1), exit);
        if (!remainingPath.isEmpty()) {
            path.add(start);
            path.addAll(remainingPath);
            return path;
        }
        remainingPath = solveMaze(maze, new Point(startRow - 1, startCol), exit);
        if (!remainingPath.isEmpty()) {
            path.add(start);
            path.addAll(remainingPath);
            return path;
        }
        remainingPath = solveMaze(maze, new Point(startRow, startCol + 1), exit);
        if (!remainingPath.isEmpty()) {
            path.add(start);
            path.addAll(remainingPath);
            return path;
        }
        remainingPath = solveMaze(maze, new Point(startRow + 1, startCol), exit);
        if (!remainingPath.isEmpty()) {
            path.add(start);
            path.addAll(remainingPath);
            return path;
        }
        return path;
    }
}
