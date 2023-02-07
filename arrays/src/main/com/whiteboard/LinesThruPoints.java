package com.whiteboard;

import java.util.*;

/**
 * Given a set of 2D points, finds the number of lines
 * that can be drawn thru at least three points.
 */
public final class LinesThruPoints {
    private LinesThruPoints() {
    }

    static class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point other)) {
                return false;
            }
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Line {
        private float slope; // Float.MAX_VALUE if line is vertical
        private float intercept; // x-coordinate if line is vertical

        Line(Point p1, Point p2) {
            if ((float)p1.x == (float)p2.x) {
                slope = Float.MAX_VALUE;
                intercept = (float)p1.x;
            } else {
                slope = (float)((p2.y - p1.y) / (p2.x - p1.x));
                intercept = (float)(p1.y - (slope * p1.x));
            }
        }

        @Override
        public boolean equals(Object o) {
            Line other = (Line)o;
            return (this.slope == other.slope) && (this.intercept == other.intercept);
        }

        @Override
        public int hashCode() {
            return Objects.hash(slope, intercept);
        }
    }

    private static Point[] points;
    private static Map<Line, Integer> lines = new HashMap<>();

    /**
     * Given a set of 2D points, finds the number of lines
     * that can be drawn thru at least three points.
     *
     * The algorithm proceeds in two phases. In Phase 1,
     * we compute the line thru each pair of points, adding
     * it to the 'lines' Map if it's not already there, or
     * bumping its count if it is.
     *
     * In Phase 2, we iterate thru the 'lines' Map, counting
     * the number of lines that appear more than once. (Lines
     * that appear more than once pass thru two or more pairs
     * of points, hence must pass thru at least three points.)
     *
     * Running time = O(n * n) + O(n) = O(n * n).
     *
     * @return The number of lines that can be drawn thru at
     * least three of the given 2D points.
     */
    public static int linesThruPoints(int[] x, int[] y) {
        saveCallingParameters(x, y);
        findLinesThruPairs();
        return countRepeatedLines();
    }

    private static void saveCallingParameters(int[] x, int[] y) {
        points = new Point[x.length];
        for (int i = 0; i < x.length; ++i) {
            points[i] = new Point(x[i], y[i]);
        }
    }

    private static void findLinesThruPairs() {
        for (int i = 0; i < points.length - 1; ++i) {
            Point p1 = points[i];
            for (int j = i + 1; j < points.length; ++j) {
                Point p2 = points[j];
                Line line = new Line(p1, p2);
                Integer count = lines.get(line);
                if (count == null) {
                    lines.put(line, 1);
                } else {
                    lines.put(line, count + 1);
                }
            }
        }
    }

    private static int countRepeatedLines() {
        int result = 0;
        for (Map.Entry<Line, Integer> entry : lines.entrySet()) {
            if (entry.getValue() > 1) {
                ++result;
            }
        }
        return result;
    }
}
