package com.whiteboard.java;

import java.util.*;

public class ArrayHopscotch {
    /**
     * Play a game of "array hopscotch".</p>
     *
     * The game is played as follows. Given an array 'a' containing
     * integers greater than or equal to zero, and a starting index
     * 'iStart', hop left or right in the array by the distance contained
     * in a[iStart]. Then repeat the hopping process for the new element
     * you land on: Hop left or right by the distance contained in that
     * new element.</p>
     *
     * There are two important restrictions on the hopping process:</p>
     *
     * (1) If a hop would take you beyond the bounds of the array, that is
     * not a legal hop; and</p>
     *
     * (2) If a hop would take you to an element you have already visited,
     * that is not a legal hop.</p>
     *
     * Continue in this manner until you either land on a zero element
     * (i.e., you win the game), or you land on an element from which there
     * are no legal hops (i.e., you lose the game).</p>
     *
     * The goal of the game is to find not just one winning path, but all
     * possible winning paths.</p>
     *
     * Since there are at most `n` indices in each winning path, where
     * `n` is the length of the array, and since there are only `k` winning
     * paths, the execution time is O(k * n) = O(n), worst case.
     *
     * @param a The array in which we are to play our game of array hopscotch.
     * @param iStart The starting index for our game.
     * @return A Set containing all the winning paths. Each winning path is a
     * List containing a sequence of unique hop indices that lead to a zero
     * element. Note that the first element of a winning List must be `iStart`,
     * and the last element must be the index of a zero element in `a`. If there
     * are no winning paths, then the Set will be empty.
     */
    public static Set<List<Integer>> arrayHopscotch(int[] a, int iStart) {
        return helper(a, iStart, new HashSet<>());
    }

    /**
     * Helper function to perform loop detection.
     *
     * This function is called as we explore a potential winning path, to
     * find all possible remaining paths starting from the current index,
     * taking care not to visit any indices that have already been visited.
     *
     * @param a The array in which we are playing our game of array hopscotch.
     * @param iCurrent The index we are currently on in our game of array
     *                 hopscotch.
     * @param visited A Set of indices that have already been visited during
     *                our game of array hopscotch. Do not return any paths
     *                that contain any of these indices.
     * @return A Set containing all winning paths, starting from `iCurrent`.
     * Each winning path is a List containing a sequence of unique hop indices
     * that lead to a zero element. Note that the first element of a winning
     * List must be `iCurrent`, the last element must be the index of a zero
     * element in `a`, and none of the elements can be indices contained in
     * `visited`. If there are no winning paths, then the Set will be empty.
     */
    private static Set<List<Integer>> helper(int[] a, int iCurrent, Set<Integer> visited) {
        Set<List<Integer>> result = new HashSet<>();
        // error checking
        if (iCurrent < 0 || iCurrent >= a.length || a[iCurrent] < 0) {
            return result;
        }
        // loop detection
        if (visited.contains(iCurrent)) {
            return result;
        }
        // base case
        if (a[iCurrent] == 0) {
            result.add(Arrays.asList(iCurrent));
        }
        // recursive step
        visited.add(iCurrent);  // don't revisit current index
        for (int hop : new int[] {iCurrent - a[iCurrent], iCurrent + a[iCurrent]}) {
            Set<List<Integer>> remainingPaths = helper(a, hop, visited);
            for (List<Integer> remainingPath : remainingPaths) {
                List<Integer> path = new ArrayList<>();
                path.add(iCurrent);
                path.addAll(remainingPath);
                result.add(path);
            }
        }
        visited.remove(iCurrent);  // ok to revisit current index
        return result;
    }
}
