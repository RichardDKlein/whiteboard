package com.whiteboard.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayHopscotch {
    /**
     * <p>Play a game of "array hopscotch".</p>
     *
     * <p>The game is played as follows. Given an array 'a'
     * containing integers greater than or equal to zero,
     * and a starting index 'iStart', hop left and right in
     * the array by the distance contained in a[iStart]. Then
     * repeat the process for the new elements you land on.</p>
     *
     * <p>Continue in this manner until you either land on a
     * zero element (i.e. you win the game), or you realize
     * that it is not possible to land on a zero element
     * (i.e. you lose the game).</p>
     *
     * <p>We shall use a recursive algorithm to play the game,
     * keeping track of elements we have visited. If we land
     * on a zero, we win. If, regardless of whether we hop
     * left or right, we land on an element we have already
     * visited, then we are stuck in an infinite loop, and
     * we lose.</p>
     *
     * <p>Since each element in the array is visited at most
     * once, the execution time is O(n), worst case.</p>
     *
     * @param a The array in which we are to play our game of
     *          array hopscotch.
     * @param iStart The starting index for our game.
     * @return A Set containing all the winning paths. Each
     * winning path is a List containing a sequence of hop
     * indices that lead to a zero element. (If there are
     * no winning paths, then the Set will be empty.)
     */
    public static Set<List<Integer>> arrayHopscotch(int[] a, int iStart) {
        return helper(a, iStart, new HashSet<>());
    }

    /**
     * Helper function to perform loop detection.
     *
     * @param a (Same as in main function.)
     * @param iStart (Same as in main function.)
     * @param visited A Set of indices that have already been
     *                visited during our game of array hopscotch.
     *                Do not continue to explore any paths that
     *                land on any of these indices.
     * @return (Same as in main function.)
     */
    private static Set<List<Integer>> helper(
            int[] a, int iStart, Set<Integer> visited) {
        Set<List<Integer>> result = new HashSet<>();
        // error checking
        if (iStart < 0 || iStart >= a.length || a[iStart] < 0) {
            return result;
        }
        // loop detection
        if (visited.contains(iStart)) {
            return result;
        }
        // base case
        if (a[iStart] == 0) {
            List<Integer> path = new ArrayList<>();
            path.add(iStart);
            result.add(path);
            return result;
        }
        // recursive step
        visited.add(iStart); // don't revisit starting index
        for (int iHop : new int[] {iStart - a[iStart], iStart + a[iStart]}) {
            Set<List<Integer>> remainingPaths = helper(a, iHop, visited);
            for (List<Integer> path : remainingPaths) {
                path.add(0, iStart);
                result.add(path);
            }
        }
        visited.remove(iStart); // ok to revisit starting index
        return result;
    }
}
