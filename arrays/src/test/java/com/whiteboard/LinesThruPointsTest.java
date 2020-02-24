package com.whiteboard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class LinesThruPointsTest {
    @Test
    void linesThruPoints() {
        System.out.println();
        System.out.println("Test LinesThruPoints:");
        System.out.println("=====================");

        LinesThruPoints.Point[] points = new LinesThruPoints.Point[9];

        points[0] = new LinesThruPoints.Point(-1, -1);
        points[1] = new LinesThruPoints.Point( 0, -1);
        points[2] = new LinesThruPoints.Point( 1, -1);

        points[3] = new LinesThruPoints.Point(-1,  0);
        points[4] = new LinesThruPoints.Point( 0,  0);
        points[5] = new LinesThruPoints.Point( 1,  0);

        points[6] = new LinesThruPoints.Point(-1,  1);
        points[7] = new LinesThruPoints.Point( 0,  1);
        points[8] = new LinesThruPoints.Point( 1,  1);

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
        for (LinesThruPoints.Point point : points) {
            System.out.println("\t(" + point.x + ", " + point.y + ")");
        }
        System.out.println();

        Set<LinesThruPoints.Point> testPoints = new HashSet<>(Arrays.asList(points));
        int numLines = new LinesThruPoints().linesThruPoints(testPoints);
        System.out.println("Number of lines = " + numLines);
    }
}
