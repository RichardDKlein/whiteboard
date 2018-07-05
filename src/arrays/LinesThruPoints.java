package arrays;

import java.util.*;

/**
 * Given a set of 2D points, finds the number of lines
 * that can be drawn thru at least three points.
 */
public class LinesThruPoints {
    /**
     * The given set of 2D points.
     */
    private Set<Point> points;

    /**
     * A list of all the lines that can be drawn thru each
     * pair of points. (We use a List rather than a Set,
     * because lines drawn thru collinear pairs of points
     * will be equal.)
     */
    private List<Line> linesThruPairs = new ArrayList<>();

    /**
     * A map of <Line, Integer> entries, mapping each Line
     * in 'linesThruPairs' to the number of times that Line
     * appears in 'linesThruPairs'.
     */
    private Map<Line, Integer> lineTally = new HashMap<>();

    /**
     * Represents a 2D point.
     */
    public static class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Represents a line in the X-Y plane.
     */
    public static class Line {
        public double slope;     // Double.MAX_VALUE if vertical
        public double intercept; // x-coord if vertical

        public Line(double slope, double intercept) {
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
            // Ignore small differences in slope and intercept,
            // by hashing them as floats rather than doubles.
            int h1 = ((Float)(float)slope).hashCode();
            int h2 = ((Float)(float)intercept).hashCode();
            return h1 ^ (h2 << 1);
        }
    }

    /**
     * General constructor
     * @param points The set of 2D points of interest.
     */
    public LinesThruPoints(Set<Point> points) {
        this.points = points;
    }

    /**
     * Counts the number of lines that can be drawn thru at least
     * three of the given 2D points.
     *
     * @return The number of lines that can be drawn thru at least
     * three of the given 2D points.
     */
    public int countLines() {
        findLinesThruPairs();
        tallyLinesThruPairs();
        return countRepeatedLinesThruPairs();
    }

    /**
     * Find all the lines that can be drawn thru each pair of 2D
     * points. (Some of these lines may be the same, if the pairs
     * of points thru which they are drawn are collinear.)
     */
    private void findLinesThruPairs() {
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
                linesThruPairs.add(new Line(slope, intercept));
            }
        }
    }

    /**
     * Iterate thru all the lines that can be drawn thru each pair
     * of 2D points, and tally how many times each line appears.
     */
    private void tallyLinesThruPairs() {
        for (Line line : linesThruPairs) {
            Integer tally = lineTally.get(line);
            lineTally.put(line, tally == null ? 1 : tally + 1);
        }
    }

    /**
     * Iterate thru the tally of lines that can be drawn thru each
     * pair of 2D points, and count how many lines appear more than
     * once. Each such line passes thru at least two collinear pairs
     * of points, which means it passes thru at least three points.
     *
     * @return The number of lines that appear more than once.
     */
    private int countRepeatedLinesThruPairs() {
        int count = 0;
        for (Map.Entry<Line, Integer> entry : lineTally.entrySet()) {
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
        int numLines = new LinesThruPoints(testPoints).countLines();
        System.out.println("Number of lines = " + numLines);
    }
}
