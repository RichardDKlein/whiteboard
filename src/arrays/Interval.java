package arrays;

/**
 * Represent a closed interval [left, right] of integers.
 */
public class Interval {
    private int left_;
    private int right_;

    public Interval(int left, int right) {
        left_ = left;
        right_ = right;
    }

    public Interval() {
        left_ = 0;
        right_ = 0;
    }

    public int left() {
        return left_;
    }

    public int right() {
        return right_;
    }

    public int length() {
        return right_ - left_ + 1;
    }

    public boolean valid() {
        return (left_ >= 0) && (right_ >= 0) && (right_ >= left_);
    }
}
