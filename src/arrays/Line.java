package arrays;

/**
 * Represent a line in the X-Y plane.
 */
public class Line {
    private static final double TOLERANCE = 0.0001;
    public double slope;        // Double.MAX_VALUE if vertical
    public double intercept;    // x-coord if vertical

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
            return Math.abs(this.slope - other.slope) < TOLERANCE &&
                Math.abs(this.intercept - other.intercept) < TOLERANCE;
        }
    }

    @Override
    public int hashCode() {
        int h1 = ((Double)slope).hashCode();
        int h2 = ((Double)intercept).hashCode();
        return h1 ^ (h2 << 1);
    }
}
