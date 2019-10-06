package arrays;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 * Solve a 2D maze.
 */
public final class SolveMaze {
    private SolveMaze() {}

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
    public static List<Pair<Integer, Integer>> solveMaze(
            char[][] maze,
            Pair<Integer, Integer> start,
            Pair<Integer, Integer> exit) {
        List<Pair<Integer, Integer>> path = new ArrayList<>();
        if (start == exit) {
            path.add(start);
            return path;
        }
        int row = start.getKey();
        int col = start.getValue();
        if (maze[row][col] == '@') {
            return path;
        }
        int rows = maze.length;
        int cols = maze[0].length;
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            return path;
        }
        // Turn this cell into a wall wo we don't revisit it.
        maze[row][col] = '@';

        List<Pair<Integer, Integer>> remainingPath;
        remainingPath = solveMaze(maze, new Pair(row - 1, col), exit);
        if (!remainingPath.isEmpty()) {
            path.add(start);
            path.addAll(remainingPath);
            return path;
        }
        remainingPath = solveMaze(maze, new Pair(row, col - 1), exit);
        if (!remainingPath.isEmpty()) {
            path.add(start);
            path.addAll(remainingPath);
            return path;
        }
        remainingPath = solveMaze(maze, new Pair(row + 1, col), exit);
        if (!remainingPath.isEmpty()) {
            path.add(start);
            path.addAll(remainingPath);
            return path;
        }
        remainingPath = solveMaze(maze, new Pair(row, col + 1), exit);
        if (!remainingPath.isEmpty()) {
            path.add(start);
            path.addAll(remainingPath);
            return path;
        }
        return path;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test solveMaze():");
        System.out.println("=================");
    }
}
