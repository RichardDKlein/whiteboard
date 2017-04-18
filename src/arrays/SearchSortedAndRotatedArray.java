package arrays;

import java.util.Arrays;

/**
 * Search a sorted and rotated array.
 */
public class SearchSortedAndRotatedArray {
    private SearchSortedAndRotatedArray() {}

    /**
     * @return The index, in a, of target (-1 => not found).
     */
    public static int search(int[] a, int target) {
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
            int index = SearchSortedAndRotatedArray.search(a, target);
            System.out.println("target = " + target + ", index = " + index);
        }

        int target = 999;
        int index = SearchSortedAndRotatedArray.search(a, target);
        System.out.println("target = " + target + ", index = " + index);
    }
}
