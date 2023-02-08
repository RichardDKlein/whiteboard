package com.whiteboard;

/**
 * Search a sorted and rotated one-dimensional array.
 */
public final class SearchSortedAndRotatedArray {
    private SearchSortedAndRotatedArray() {
    }

    /**
     * Search a one-dimensional array that has been sorted and then
     * rotated, so that there is a discontinuity in the array where
     * it wraps around from the largest to the smallest element.
     *
     * The algorithm is similar to a binary search, with one wrinkle:
     * When dividing the search range in half, we have to handle the
     * possibility that one of the two resulting halves will contain
     * the discontinuity.
     *
     * Running time = log(n).
     *
     * @param a The sorted and rotated one-dimensional array.
     * @param target The target element to search for.
     * @return The array index of the target element if found,
     * or -1 if not found.
     */
    public static int searchSortedAndRotatedArray(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[left] <= a[mid]) {
                // left half is normally ordered
                if (a[left] <= target && target < a[mid]) {
                    // target is in left half
                    right = mid - 1;
                } else {
                    // target is in right half
                    left = mid + 1;
                }
            } else {
                // right half is normally ordered
                if (a[mid] < target && target <= a[right]) {
                    // target is in right half
                    left = mid + 1;
                } else {
                    // target is in left half
                    right = mid - 1;
                }
            }
        }
        // no solution
        return -1;
    }
}
