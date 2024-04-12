package com.whiteboard.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SolveMaze {
    /**
     * Solve a 2D maze.
     *
     * Our algorithm searches recursively for a solution
     * by looking for paths that start at each cell that
     * is adjacent to the specified start cell.
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
     * @return A list containing the {row, column} indices
     * of a path leading from the start to the exit. (If no
     * such path exists, then the list will be empty.)
     */
    public static List<int[]> solveMaze(char[][] maze, int[] start, int[] exit) {
        List<int[]> result = new ArrayList<>();
        // error checking
        int startRow = start[0];
        int startCol = start[1];
        int numRows = maze.length;
        int numCols = maze[0].length;
        if (startRow < 0 || startRow >= numRows || startCol < 0 || startCol >= numCols) {
            return result;
        }
        // wall or already visited
        if (maze[startRow][startCol] == '@') {
            return result;
        }
        // base case
        if (Arrays.equals(start, exit)) {
            result.add(start);
            return result;
        }
        // recursive step
        maze[startRow][startCol] = '@';
        int[] goLeft = {startRow, startCol - 1};
        int[] goUp = {startRow - 1, startCol};
        int[] goRight = {startRow, startCol + 1};
        int[] goDown = {startRow + 1, startCol};
        int[][] moves = {goLeft, goUp, goRight, goDown};
        for (int[] move : moves) {
            List<int[]> remainingPath = solveMaze(maze, move, exit);
            if (!remainingPath.isEmpty()) {
                result.add(start);
                result.addAll(remainingPath);
                return result;
            }
        }
        // no solution
        return result;
    }
}
