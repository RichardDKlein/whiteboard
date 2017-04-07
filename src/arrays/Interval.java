package arrays;

/**
 * Represent a closed interval [left, right] of integers.
 */
public class Interval {
    private int left;
    private int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public Interval() {
        left = 0;
        right = 0;
    }

    public int left() {
        return left;
    }

    public int right() {
        return right;
    }

    public int length() {
        return right - left + 1;
    }

    public boolean valid() {
        return (left >= 0) && (right >= 0) && (right >= left);
    }
}
