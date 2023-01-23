package java.com.whiteboard;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
    }

    static class Line {
        double slope;     // Double.MAX_VALUE if vertical
        double intercept; // x-coord if vertical

        Line(double slope, double intercept) {
            this.slope = slope;
            this.intercept = intercept;
        }
        @Override
        public boolean equals(Object obj) {
            Line other = (Line)obj;
            // Ignore small differences in slope and intercept,
            // by comparing them as floats rather than doubles.
            return (float)this.slope == (float)other.slope
                    && (float)this.intercept == (float)other.intercept;
        }
        @Override
        public int hashCode() {
            return Objects.hash(slope, intercept);
        }
    }

    private static Set<Point> points;
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
    public static int linesThruPoints(Set<Point> thePoints) {
        points = thePoints;
        findLinesThruPairs();
        return countRepeatedLines();
    }

    private static void findLinesThruPairs() {
        Point[] pointArray = new Point[points.size()];
        pointArray = points.toArray(pointArray);
        for (int i = 0; i < pointArray.length; ++i) {
            Point point1 = pointArray[i];
            double x1 = point1.x;
            double y1 = point1.y;
            for (int j = i + 1; j < pointArray.length; ++j) {
                Point point2 = pointArray[j];
                double x2 = point2.x;
                double y2 = point2.y;
                double slope, intercept;
                // Ignore small differences in x1 and x2, by
                // comparing them as floats rather than doubles.
                if ((float)x1 == (float)x2) {
                    slope = Double.MAX_VALUE;
                    intercept = x1;
                } else {
                    slope = (y2 - y1) / (x2 - x1);
                    intercept = y1 - (slope * x1);
                }
                Line line = new Line(slope, intercept);
                Integer count = lines.get(line);
                if (count == null) {
                    lines.put(line, 1);
                } else {
                    lines.replace(line, count + 1);
                }
            }
        }
    }

    private static int countRepeatedLines() {
        int count = 0;
        for (Map.Entry<Line, Integer> entry : lines.entrySet()) {
            if (entry.getValue() > 1) {
                ++count;
            }
        }
        return count;
    }
}
