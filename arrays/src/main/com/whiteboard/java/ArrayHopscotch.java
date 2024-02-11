package com.whiteboard.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayHopscotch {
    /**
     * <p>Play a game of "array hopscotch".</p>
     *
     * <p>The game is played as follows. Given an array 'a' containing
     * integers greater than or equal to zero, and a starting index
     * 'iStart', hop left or right in the array by the distance contained
     * in a[iStart]. Then repeat the hopping process for the new element
     * you land on: Hop left or right by the distance contained in that
     * new element.
     *
     * There are two important restrictions on the hopping process:
     *
     * (1) If a hop would take you beyond the bounds of the array, that is
     * not a legal hop; and
     *
     * (2) If a hop would take you to an element you have already visited,
     * that is not a legal hop.</p>
     *
     * <p>Continue in this manner until you either land on a zero element
     * (i.e., you win the game), or you land on an element from which there
     * are no legal hops (i.e., you lose the game).</p>
     *
     * <p>The goal of the game is to find not just one winning path, but all
     * possible winning paths.</p>
     *
     * <p>Since there are at most `n` indices in each winning path, where
     * `n` is the length of the array, and since there are only `k` winning
     * paths, the execution time is O(k * n) = O(n), worst case.</p>
     *
     * @param a The array in which we are to play our game of array hopscotch.
     * @param iStart The starting index for our game.
     * @return A Set containing all the winning paths. Each winning path is a
     * List containing a sequence of unique hop indices that lead to a zero
     * element. (If there are no winning paths, then the Set will be empty.)
     */
    public static Set<List<Integer>> arrayHopscotch(int[] a, int iStart) {
        return helper(a, iStart, new HashSet<>());
    }

    /**
     * Helper function to perform loop detection.
     *
     * @param a (Same as in main function.)
     * @param iStart (Same as in main function.)
     * @param visited A Set of indices that have already been visited during
     *                our game of array hopscotch. Do not continue to explore
     *                any paths that land on any of these indices.
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
