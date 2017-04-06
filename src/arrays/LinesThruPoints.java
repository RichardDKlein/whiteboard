package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of 2D points, find the number of lines
 * that can be drawn through at least three points.
 */
public class LinesThruPoints {
    private static final double TOLERANCE = 0.0001;
    private Point[] points_;
    private ArrayList<Line> linesThruPairs_ = new ArrayList<>();
    private HashMap<Line, Integer> lineTally_ = new HashMap<>();
    private int count_ = 0;

    public LinesThruPoints(Point[] points) {
        points_ = points;
    }

    public int compute() {
        findLinesThruPairs();
        tallyLinesThruPairs();
        countRepeatedLinesThruPairs();
        return count_;
    }

    private void findLinesThruPairs() {
        for (int i = 0; i < points_.length; ++i) {
            for (int j = i + 1; j < points_.length; ++j) {
                double x1 = points_[i].x;
                double y1 = points_[i].y;
                double x2 = points_[j].x;
                double y2 = points_[j].y;
                double slope, intercept;
                if (Math.abs(x1 - x2) < TOLERANCE) {
                    slope = Double.MAX_VALUE;
                    intercept = x1;
                } else {
                    slope = (y2 - y1) / (x2 - x1);
                    intercept = y1 - (slope * x1);
                }
                linesThruPairs_.add(new Line(slope, intercept));
            }
        }
    }

    private void tallyLinesThruPairs() {
        for (Line line : linesThruPairs_) {
            Integer tally = lineTally_.get(line);
            lineTally_.put(line, tally == null ? 1 : tally + 1);
        }
    }

    private void countRepeatedLinesThruPairs() {
        for (Map.Entry<Line, Integer> entry : lineTally_.entrySet()) {
            if (entry.getValue() > 1) {
                ++count_;
            }
        }
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

        int numLines = new LinesThruPoints(points).compute();
        System.out.println("Number of lines = " + numLines);
    }
}
