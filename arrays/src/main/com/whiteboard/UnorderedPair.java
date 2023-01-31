package com.whiteboard;

public class UnorderedPair {
    int first;
    int second;

    UnorderedPair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    // Following methods needed only for unit test.
    @Override
    public int hashCode() {
        return first + second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UnorderedPair)) {
            return false;
        }
        UnorderedPair other = (UnorderedPair)o;
        return (this.first == other.first && this.second == other.second)
                || (this.first == other.second && this.second == other.first);
    }
}
