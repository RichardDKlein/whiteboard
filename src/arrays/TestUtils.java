package arrays;

import java.util.ArrayList;

/**
 * Test utilities for the arrays package.
 */
public final class TestUtils {
    public static ArrayList<Integer> intArrayToArrayList(int[] a) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length; ++i) {
            result.add(a[i]);
        }
        return result;
    }

    public static Integer[] intArrayToIntegerArray(int[] a) {
        Integer[] result = new Integer[a.length];
        for (int i = 0; i < a.length; ++i) {
            result[i] = a[i];
        }
        return result;
    }

    public static int[] IntegerArrayToIntArray(Integer[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            result[i] = a[i];
        }
        return result;
    }
}
