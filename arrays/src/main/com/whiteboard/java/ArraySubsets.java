package com.whiteboard.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraySubsets {
    /**
     * Partition an array `a` of integers into disjoint
     * subarrays `arrA` and `arrB` such that `arrA` is
     * the smallest possible subarray whose elements sum
     * to a greater number than the elements of `arrB`.
     * (Note that neither `arrA` nor `arrB` need consist
     * of consecutive elements from `a`.)
     *
     * Our strategy will be to first sort the given array in
     * descending order. Then, starting from the first element,
     * keep adding elements to `arrA` until the running total
     * of the elements in `arrA` exceeds the running total of
     * the remaining elements (in `arrB`).
     *
     * Performance is O(n*log(n)), due to the sorting operation.
     *
     * @param a The array to be partitioned.
     * @return The subarray `arrA`, with its elements in
     * ascending order.
     */
    public static List<Integer> arraySubsets(List<Integer> a) {
        List<Integer> result = new ArrayList<>();
        if (a == null || a.isEmpty()) {
          return result;
        }
        a.sort(Collections.reverseOrder());
        long sumA = 0;
        long sumB = a.stream().mapToInt(Integer::intValue).sum();
        for (int n : a) {
            result.add(n);
            sumA += n;
            sumB -= n;
            if (sumA > sumB) {
                break;
            }
        }
        Collections.sort(result);
        return result;
    }
}
