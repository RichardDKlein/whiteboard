package com.whiteboard.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Play a game of "array hopscotch".
 */
public class ArrayHopscotch {
    /**
     * <p>Play a game of "array hopscotch".</p>
     *
     * <p>The game is played as follows. Given an array 'a'
     * containing integers greater than or equal to zero,
     * and a starting index 'i', hop left and right in the
     * array by the distance contained in a[i]. Then repeat
     * the process for the new elements you land on.</p>
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
     * @param a The array in which we are to play "array
     *          hopscotch".
     * @param iStart The starting index for our game of
     *               hopscotch.
     * @return A list containing a winning sequence of
     * indices that led to a zero. (If no such winning
     * sequence exists, then the list will be empty.)
     */
    public List<Integer> arrayHopscotch(int[] a, int iStart) {
        Set<Integer> visited = new HashSet<>();
        return arrayHopscotchWithLoopDetection(a, iStart, visited);
    }

    private static List<Integer> arrayHopscotchWithLoopDetection(
            int[] a, int iStart, Set<Integer> visited) {
        List<Integer> result = new ArrayList<>();
        // error checking
        if (iStart < 0 || iStart >= a.length) {
            return result;
        }
        int hop = a[iStart];
        if (hop < 0) {
            return result;
        }
        // base case
        if (hop == 0) {
            result.add(iStart);
            return result;
        }
        // recursive step
        visited.add(iStart);
        int iHopLeft = iStart - hop;
        if (iHopLeft >= 0 && !visited.contains(iHopLeft)) {
            List<Integer> remainingHops = arrayHopscotchWithLoopDetection(a, iHopLeft, visited);
            if (!remainingHops.isEmpty()) {
                result.add(iStart);
                result.addAll(remainingHops);
                return result;
            }
        }
        int iHopRight = iStart + hop;
        if (iHopRight < a.length && !visited.contains(iHopRight)) {
            List<Integer> remainingHops = arrayHopscotchWithLoopDetection(a, iHopRight, visited);
            if (!remainingHops.isEmpty()) {
                result.add(iStart);
                result.addAll(remainingHops);
                return result;
            }
        }
        // no solution
        return result;
    }
}
