package arrays;

import java.util.*;

/**
 * Given a set of 2D points, finds the number of lines
 * that can be drawn thru at least three points.
 */
public final class LinesThruPoints {
    /**
     * Represents a 2D point.
     */
    private static class Point {
        private double x;
        private double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Represents a line in the X-Y plane. (Since this class will be
     * used as the Key in a Map, we need to override the equals() and
     * hashCode() methods.)
     */
    private static class Line {
        private double slope;     // Double.MAX_VALUE if vertical
        private double intercept; // x-coord if vertical

        Line(double slope, double intercept) {
            this.slope = slope;
            this.intercept = intercept;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Line)) {
                return false;
            }
            Line other = (Line)obj;
            if (slope == Double.MAX_VALUE) {
                return this.intercept == other.intercept;
            } else {
                // Ignore small differences in slope and intercept,
                // by comparing them as floats rather than doubles.
                return (float)this.slope == (float)other.slope
                        && (float)this.intercept == (float)other.intercept;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(slope, intercept);
        }
    }

    /**
     * The given set of 2D points.
     */
    private static Set<Point> points;

    /**
     * A map of <Line, Integer> entries, mapping each Line
     * that can be drawn thru a pair of points to the number
     * of occurrences of that line.
     */
    private static Map<Line, Integer> lines = new HashMap<>();

    /**
     * Private constructor, so the class cannot be instantiated.
     */
    private LinesThruPoints() {
    }

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

    /**
     * Find all the lines that can be drawn thru each pair of 2D
     * points.
     */
    private static void findLinesThruPairs() {
        Set<Point> otherPoints = new HashSet<>(points);
        for (Point point1 : points) {
            otherPoints.remove(point1);
            for (Point point2 : otherPoints) {
                double x1 = point1.x;
                double y1 = point1.y;
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

    /**
     * Iterate thru the Map of lines that can be drawn thru each
     * pair of 2D points, and count how many lines appear more than
     * once. Since each such line passes thru two or more pairs of
     * points, it must pass thru at least three points.
     *
     * @return The number of lines that appear more than once.
     */
    private static int countRepeatedLines() {
        int count = 0;
        for (Map.Entry<Line, Integer> entry : lines.entrySet()) {
            if (entry.getValue() > 1) {
                ++count;
            }
        }
        return count;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test linesThruPoints():");
        System.out.println("=======================");

        Point[] points = new Point[9];

        points[0] = new Point(-1, -1);
        points[1] = new Point( 0, -1);
        points[2] = new Point( 1, -1);

        points[3] = new Point(-1,  0);
        points[4] = new Point( 0,  0);
        points[5] = new Point( 1,  0);

        points[6] = new Point(-1,  1);
        points[7] = new Point( 0,  1);
        points[8] = new Point( 1,  1);

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
        for (Point point : points) {
            System.out.println("\t(" + point.x + ", " + point.y + ")");
        }
        System.out.println();

        Set<Point> testPoints = new HashSet<>(Arrays.asList(points));
        int numLines = LinesThruPoints.linesThruPoints(testPoints);
        System.out.println("Number of lines = " + numLines);
    }
}
