package com.whiteboard;

import org.junit.Test;

public class LinesThruPointsTest {
    @Test
    public void linesThruPointsTest() {
        System.out.println();
        System.out.println("Test LinesThruPoints:");
        System.out.println("=====================");

        double[] x = {
                -1,
                0,
                1,
                -1,
                0,
                1,
                -1,
                0,
                1
        };

        double[] y = {
                -1,
                -1,
                -1,
                0,
                0,
                0,
                1,
                1,
                1
        };

        System.out.println("             y                 ");
        System.out.println("             |                 ");
        System.out.println("             |                 ");
        System.out.println("             |                 ");
        System.out.println("             |                 ");
        System.out.println(" (-1, 1) *---*---* (1, 1)      ");
        System.out.println("         | \\ | / |            ");
        System.out.println("---------*---*---*--------- x  ");
        System.out.println("         | / | \\ |            ");
        System.out.println("(-1, -1) *---*---* (1, -1)     ");
        System.out.println("             |                 ");
        System.out.println("             |                 ");
        System.out.println("             |                 ");
        System.out.println("             |                 ");
        System.out.println();

        System.out.println("Points = ");
        for (int i = 0; i < x.length; ++i) {
            System.out.println("\t(" + x[i] + ", " + y[i] + ")");
        }
        System.out.println();

        int numLines = LinesThruPoints.linesThruPoints(x, y);
        assert(numLines == 8);
        System.out.println("Number of lines = " + numLines);
    }
}
