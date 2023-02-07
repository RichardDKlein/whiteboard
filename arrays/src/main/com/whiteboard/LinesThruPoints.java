package com.whiteboard;

import java.util.*;

/**
 * Given a set of 2D points, finds the number of lines
 * that can be drawn thru at least three points.
 */
public final class LinesThruPoints {
    private LinesThruPoints() {
    }

    private static class Line {
        private float slope; // Float.MAX_VALUE if vertical
        private float intercept; // x-coordinate if vertical

        Line(double x1, double y1, double x2, double y2) {
            if ((float)x1 == (float)x2) {
                slope = Float.MAX_VALUE;
                intercept = (float)x1;
            } else {
                slope = (float)((y2 - y1) / (x2 - x1));
                intercept = (float)(y1 - slope * x1);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Line other)) {
                return false;
            }
            return this.slope == other.slope && this.intercept == other.intercept;
        }

        @Override
        public int hashCode() {
            return Objects.hash(slope, intercept);
        }
    }

    private static double[] x;
    private static double[] y;

    private static Map<Line, Integer> lines = new HashMap<>();

    /**
     * Given a collection of 2D points, finds the number of
     * lines that can be drawn thru at least three points.
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
     * @param x The x-coordinates of the 2D points.
     * @param y The y-coordinates of the 2D points.
     * @return The number of lines that can be drawn thru at
     * least three of the given 2D points.
     */
    public static int linesThruPoints(double[] x, double[] y) {
        saveCallingParameters(x, y);
        findLinesThruPairsOfPoints();
        return countRepeatedLines();
    }

    private static void saveCallingParameters(double[] x, double[] y) {
        LinesThruPoints.x = x;
        LinesThruPoints.y = y;
    }

    private static void findLinesThruPairsOfPoints() {
        for (int i = 0; i < x.length - 1; ++i) {
            for (int j = i + 1; j < x.length; ++j) {
                Line line = new Line(x[i], y[i], x[j], y[j]);
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
        for (int count : lines.values()) {
            if (count > 1) {
                ++result;
            }
        }
        return result;
    }
}
