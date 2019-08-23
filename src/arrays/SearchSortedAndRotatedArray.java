package arrays;

import java.util.Arrays;

/**
 * Search a sorted and rotated one-dimensional array.
 */
public class SearchSortedAndRotatedArray {
    private SearchSortedAndRotatedArray() {}

    /**
     * Search a one-dimensional array that has been sorted and then
     * rotated, so that there is a discontinuity in the array where
     * it wraps around from the largest to the smallest element.
     *
     * The algorithm is basically the same as a binary search, with
     * one complication: When you subdivide the remaining interval
     * to be searched, one half of that interval will contain the
     * wraparound discontinuity, and the other half will not. We
     * want always to search (and subdivide) the half WITHOUT the
     * discontinuity, since that is the half where the binary search
     * algorithm is valid.
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
            if (a[left] < a[mid]) { // if left half is normally ordered
                if (a[left] <= target && target <= a[mid]) {
                    right = mid - 1; // search left
                } else {
                    left = mid + 1; // search right
                }
            } else { // right half is normally ordered
                if (a[mid] <= target && target <= a[right]) {
                    left = mid + 1; // search right
                } else {
                    right = mid - 1; // search left
                }
            }
        }
        return -1;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test searchSortedAndRotatedArray():");
        System.out.println("===================================");
        int a[] = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        System.out.println(Arrays.toString(a));

        for (int target : a) {
            int index = SearchSortedAndRotatedArray.searchSortedAndRotatedArray(a, target);
            System.out.println("target = " + target + ", index = " + index);
        }

        int target = 999;
        int index = SearchSortedAndRotatedArray.searchSortedAndRotatedArray(a, target);
        System.out.println("target = " + target + ", index = " + index);
    }
}
