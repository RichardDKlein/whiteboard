package com.whiteboard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import com.whiteboard.SolveMaze.RowCol;

class SolveMazeTest {
    @Test
    void solveMaze() {
        System.out.println();
        System.out.println("Test SolveMaze:");
        System.out.println("===============");

        char[][] maze = {
                {'@',' ','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@',},
                {'@',' ',' ',' ','@',' ',' ',' ',' ',' ',' ',' ','@',' ','@',' ','@',' ',' ',' ',' ',' ',' ',' ','@',},
                {'@',' ','@',' ','@',' ','@','@','@','@','@',' ','@',' ','@',' ','@',' ','@','@','@','@','@',' ','@',},
                {'@',' ','@',' ','@',' ','@',' ',' ',' ',' ',' ','@',' ','@',' ','@',' ','@',' ',' ',' ',' ',' ','@',},
                {'@',' ','@',' ','@',' ','@',' ','@','@','@','@','@',' ','@',' ','@',' ','@',' ','@','@','@','@','@',},
                {'@',' ','@',' ','@',' ','@',' ','@',' ',' ',' ','@',' ','@',' ','@',' ','@',' ',' ',' ',' ',' ','@',},
                {'@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@','@','@','@','@',' ','@',},
                {'@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ',' ',' ',' ',' ','@',},
                {'@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@','@','@','@','@',},
                {'@',' ','@',' ',' ',' ','@',' ',' ',' ','@',' ','@',' ',' ',' ','@',' ','@',' ',' ',' ',' ',' ','@',},
                {'@',' ','@','@','@','@','@','@','@','@','@',' ','@',' ','@',' ','@',' ','@','@','@','@','@',' ','@',},
                {'@',' ','@',' ',' ',' ',' ',' ',' ',' ',' ',' ','@',' ','@',' ','@',' ','@',' ',' ',' ',' ',' ','@',},
                {'@',' ','@',' ','@','@','@','@','@','@','@','@','@',' ','@',' ','@',' ','@','@','@',' ','@','@','@',},
                {'@',' ','@',' ','@',' ',' ',' ',' ',' ',' ',' ','@',' ','@',' ','@',' ',' ',' ','@',' ','@',' ','@',},
                {'@',' ','@',' ','@',' ','@','@','@','@','@',' ','@',' ','@',' ','@','@','@',' ','@',' ','@',' ','@',},
                {'@',' ','@',' ','@',' ','@',' ',' ',' ',' ',' ','@',' ','@',' ',' ',' ','@',' ','@',' ','@',' ','@',},
                {'@',' ','@',' ','@',' ','@',' ','@','@','@','@','@',' ','@','@','@',' ','@',' ','@',' ','@',' ','@',},
                {'@',' ','@',' ','@',' ','@',' ',' ',' ',' ',' ','@',' ',' ',' ','@',' ','@',' ','@',' ','@',' ','@',},
                {'@',' ','@',' ','@',' ','@','@','@','@','@',' ','@','@','@',' ','@',' ','@',' ','@',' ',' ',' ','@',},
                {'@',' ','@',' ',' ',' ','@',' ',' ',' ',' ',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',},
                {'@',' ','@',' ','@',' ','@',' ','@','@','@','@','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',},
                {'@',' ','@',' ','@',' ','@',' ',' ',' ',' ',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',},
                {'@',' ','@',' ','@',' ','@','@','@','@','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',' ','@',},
                {'@',' ','@',' ','@',' ','@',' ',' ',' ',' ',' ',' ',' ',' ',' ','@',' ',' ',' ','@',' ','@',' ','@',},
                {'@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@','@',' ','@',},
        };

        List<RowCol> expected = new ArrayList<>();
        expected.add(new RowCol(0, 1));
        expected.add(new RowCol(1, 1));
        expected.add(new RowCol(1, 2));
        expected.add(new RowCol(1, 3));
        expected.add(new RowCol(2, 3));
        expected.add(new RowCol(3, 3));
        expected.add(new RowCol(4, 3));
        expected.add(new RowCol(5, 3));
        expected.add(new RowCol(6, 3));
        expected.add(new RowCol(7, 3));
        expected.add(new RowCol(8, 3));
        expected.add(new RowCol(9, 3));
        expected.add(new RowCol(9, 4));
        expected.add(new RowCol(9, 5));
        expected.add(new RowCol(8, 5));
        expected.add(new RowCol(7, 5));
        expected.add(new RowCol(6, 5));
        expected.add(new RowCol(5, 5));
        expected.add(new RowCol(4, 5));
        expected.add(new RowCol(3, 5));
        expected.add(new RowCol(2, 5));
        expected.add(new RowCol(1, 5));
        expected.add(new RowCol(1, 6));
        expected.add(new RowCol(1, 7));
        expected.add(new RowCol(1, 8));
        expected.add(new RowCol(1, 9));
        expected.add(new RowCol(1, 10));
        expected.add(new RowCol(1, 11));
        expected.add(new RowCol(2, 11));
        expected.add(new RowCol(3, 11));
        expected.add(new RowCol(3, 10));
        expected.add(new RowCol(3, 9));
        expected.add(new RowCol(3, 8));
        expected.add(new RowCol(3, 7));
        expected.add(new RowCol(4, 7));
        expected.add(new RowCol(5, 7));
        expected.add(new RowCol(6, 7));
        expected.add(new RowCol(7, 7));
        expected.add(new RowCol(8, 7));
        expected.add(new RowCol(9, 7));
        expected.add(new RowCol(9, 8));
        expected.add(new RowCol(9, 9));
        expected.add(new RowCol(8, 9));
        expected.add(new RowCol(7, 9));
        expected.add(new RowCol(6, 9));
        expected.add(new RowCol(5, 9));
        expected.add(new RowCol(5, 10));
        expected.add(new RowCol(5, 11));
        expected.add(new RowCol(6, 11));
        expected.add(new RowCol(7, 11));
        expected.add(new RowCol(8, 11));
        expected.add(new RowCol(9, 11));
        expected.add(new RowCol(10, 11));
        expected.add(new RowCol(11, 11));
        expected.add(new RowCol(11, 10));
        expected.add(new RowCol(11, 9));
        expected.add(new RowCol(11, 8));
        expected.add(new RowCol(11, 7));
        expected.add(new RowCol(11, 6));
        expected.add(new RowCol(11, 5));
        expected.add(new RowCol(11, 4));
        expected.add(new RowCol(11, 3));
        expected.add(new RowCol(12, 3));
        expected.add(new RowCol(13, 3));
        expected.add(new RowCol(14, 3));
        expected.add(new RowCol(15, 3));
        expected.add(new RowCol(16, 3));
        expected.add(new RowCol(17, 3));
        expected.add(new RowCol(18, 3));
        expected.add(new RowCol(19, 3));
        expected.add(new RowCol(19, 4));
        expected.add(new RowCol(19, 5));
        expected.add(new RowCol(18, 5));
        expected.add(new RowCol(17, 5));
        expected.add(new RowCol(16, 5));
        expected.add(new RowCol(15, 5));
        expected.add(new RowCol(14, 5));
        expected.add(new RowCol(13, 5));
        expected.add(new RowCol(13, 6));
        expected.add(new RowCol(13, 7));
        expected.add(new RowCol(13, 8));
        expected.add(new RowCol(13, 9));
        expected.add(new RowCol(13, 10));
        expected.add(new RowCol(13, 11));
        expected.add(new RowCol(14, 11));
        expected.add(new RowCol(15, 11));
        expected.add(new RowCol(15, 10));
        expected.add(new RowCol(15, 9));
        expected.add(new RowCol(15, 8));
        expected.add(new RowCol(15, 7));
        expected.add(new RowCol(16, 7));
        expected.add(new RowCol(17, 7));
        expected.add(new RowCol(17, 8));
        expected.add(new RowCol(17, 9));
        expected.add(new RowCol(17, 10));
        expected.add(new RowCol(17, 11));
        expected.add(new RowCol(18, 11));
        expected.add(new RowCol(19, 11));
        expected.add(new RowCol(19, 10));
        expected.add(new RowCol(19, 9));
        expected.add(new RowCol(19, 8));
        expected.add(new RowCol(19, 7));
        expected.add(new RowCol(20, 7));
        expected.add(new RowCol(21, 7));
        expected.add(new RowCol(21, 8));
        expected.add(new RowCol(21, 9));
        expected.add(new RowCol(21, 10));
        expected.add(new RowCol(21, 11));
        expected.add(new RowCol(22, 11));
        expected.add(new RowCol(23, 11));
        expected.add(new RowCol(23, 12));
        expected.add(new RowCol(23, 13));
        expected.add(new RowCol(23, 14));
        expected.add(new RowCol(23, 15));
        expected.add(new RowCol(22, 15));
        expected.add(new RowCol(21, 15));
        expected.add(new RowCol(20, 15));
        expected.add(new RowCol(19, 15));
        expected.add(new RowCol(18, 15));
        expected.add(new RowCol(17, 15));
        expected.add(new RowCol(17, 14));
        expected.add(new RowCol(17, 13));
        expected.add(new RowCol(16, 13));
        expected.add(new RowCol(15, 13));
        expected.add(new RowCol(14, 13));
        expected.add(new RowCol(13, 13));
        expected.add(new RowCol(12, 13));
        expected.add(new RowCol(11, 13));
        expected.add(new RowCol(10, 13));
        expected.add(new RowCol(9, 13));
        expected.add(new RowCol(9, 14));
        expected.add(new RowCol(9, 15));
        expected.add(new RowCol(10, 15));
        expected.add(new RowCol(11, 15));
        expected.add(new RowCol(12, 15));
        expected.add(new RowCol(13, 15));
        expected.add(new RowCol(14, 15));
        expected.add(new RowCol(15, 15));
        expected.add(new RowCol(15, 16));
        expected.add(new RowCol(15, 17));
        expected.add(new RowCol(16, 17));
        expected.add(new RowCol(17, 17));
        expected.add(new RowCol(18, 17));
        expected.add(new RowCol(19, 17));
        expected.add(new RowCol(20, 17));
        expected.add(new RowCol(21, 17));
        expected.add(new RowCol(22, 17));
        expected.add(new RowCol(23, 17));
        expected.add(new RowCol(23, 18));
        expected.add(new RowCol(23, 19));
        expected.add(new RowCol(22, 19));
        expected.add(new RowCol(21, 19));
        expected.add(new RowCol(20, 19));
        expected.add(new RowCol(19, 19));
        expected.add(new RowCol(18, 19));
        expected.add(new RowCol(17, 19));
        expected.add(new RowCol(16, 19));
        expected.add(new RowCol(15, 19));
        expected.add(new RowCol(14, 19));
        expected.add(new RowCol(13, 19));
        expected.add(new RowCol(13, 18));
        expected.add(new RowCol(13, 17));
        expected.add(new RowCol(12, 17));
        expected.add(new RowCol(11, 17));
        expected.add(new RowCol(10, 17));
        expected.add(new RowCol(9, 17));
        expected.add(new RowCol(8, 17));
        expected.add(new RowCol(7, 17));
        expected.add(new RowCol(6, 17));
        expected.add(new RowCol(5, 17));
        expected.add(new RowCol(4, 17));
        expected.add(new RowCol(3, 17));
        expected.add(new RowCol(2, 17));
        expected.add(new RowCol(1, 17));
        expected.add(new RowCol(1, 18));
        expected.add(new RowCol(1, 19));
        expected.add(new RowCol(1, 20));
        expected.add(new RowCol(1, 21));
        expected.add(new RowCol(1, 22));
        expected.add(new RowCol(1, 23));
        expected.add(new RowCol(2, 23));
        expected.add(new RowCol(3, 23));
        expected.add(new RowCol(3, 22));
        expected.add(new RowCol(3, 21));
        expected.add(new RowCol(3, 20));
        expected.add(new RowCol(3, 19));
        expected.add(new RowCol(4, 19));
        expected.add(new RowCol(5, 19));
        expected.add(new RowCol(5, 20));
        expected.add(new RowCol(5, 21));
        expected.add(new RowCol(5, 22));
        expected.add(new RowCol(5, 23));
        expected.add(new RowCol(6, 23));
        expected.add(new RowCol(7, 23));
        expected.add(new RowCol(7, 22));
        expected.add(new RowCol(7, 21));
        expected.add(new RowCol(7, 20));
        expected.add(new RowCol(7, 19));
        expected.add(new RowCol(8, 19));
        expected.add(new RowCol(9, 19));
        expected.add(new RowCol(9, 20));
        expected.add(new RowCol(9, 21));
        expected.add(new RowCol(9, 22));
        expected.add(new RowCol(9, 23));
        expected.add(new RowCol(10, 23));
        expected.add(new RowCol(11, 23));
        expected.add(new RowCol(11, 22));
        expected.add(new RowCol(11, 21));
        expected.add(new RowCol(12, 21));
        expected.add(new RowCol(13, 21));
        expected.add(new RowCol(14, 21));
        expected.add(new RowCol(15, 21));
        expected.add(new RowCol(16, 21));
        expected.add(new RowCol(17, 21));
        expected.add(new RowCol(18, 21));
        expected.add(new RowCol(18, 22));
        expected.add(new RowCol(18, 23));
        expected.add(new RowCol(19, 23));
        expected.add(new RowCol(20, 23));
        expected.add(new RowCol(21, 23));
        expected.add(new RowCol(22, 23));
        expected.add(new RowCol(23, 23));
        expected.add(new RowCol(24, 23));

        TestUtils testUtils = new TestUtils();

        System.out.println("\nMaze to solve:\n");
        testUtils.printBitmap(maze);

        int rows = maze.length;
        int cols = maze[0].length;

        RowCol start = new RowCol(0, 1);
        RowCol exit = new RowCol(rows - 1, cols - 2);

        char[][] copy = new char[rows][cols];
        testUtils.copyBitmap(maze, copy);

        List<RowCol> path = SolveMaze.solveMaze(copy, start, exit);
        assert(path.equals(expected));

        System.out.println("\nSolution:\n");
        for (RowCol rowCol : path) {
            int row = rowCol.row;
            int col = rowCol.col;
            expected.add(new RowCol(0,1));
            maze[row][col] = '.';
        }
        testUtils.printBitmap(maze);
    }
}
