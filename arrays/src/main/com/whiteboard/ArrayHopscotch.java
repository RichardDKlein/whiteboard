package com.whiteboard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Play a game of "array hopscotch".
 */
public final class ArrayHopscotch {
    private ArrayHopscotch() {
    }

    /**
     * Play a game of "array hopscotch".
     *
     * The game is played as follows. Given an array 'a'
     * containing integers greater than or equal to zero,
     * and a starting index 'i', hop left and right in the
     * array by the distance contained in a[i]. Then repeat
     * the process for the new elements you land on.
     *
     * Continue in this manner until you either land on a
     * zero element (i.e. you win the game), or you realize
     * that it is not possible to land on a zero element
     * (i.e. you lose the game).
     *
     * We shall use a recursive algorithm to play the game,
     * keeping track of elements we have visited. If we land
     * on a zero, we win. If we land on an element we have
     * already visited, we are stuck in an infinite loop,
     * and we lose.
     *
     * Since each element in the array is visited at most
     * once, the execution time is O(n), worst case.
     *
     * @param a The array in which we are to play "array
     *          hopscotch". You may assume that all the
     *          elements in the array are greater than or
     *          equal to zero.
     * @param iStart The starting index for our game of
     *               hopscotch.
     * @return A list containing a winning sequence of
     * indices that led to a zero. (If no such winning
     * sequence exists, then the list will be empty.)
     */
    public static List<Integer> arrayHopscotch(int[] a, int iStart) {
        Set<Integer> visited = new HashSet<>();
        return arrayHopscotchHelper(a, iStart, visited);
    }

    private static List<Integer> arrayHopscotchHelper(int[] a, int iStart, Set<Integer> visited) {
        List<Integer> result = new ArrayList<>();
        // error checking
        if (iStart < 0 || iStart > a.length - 1) {
            return result;
        }
        // base case
        if (a[iStart] == 0) {
            result.add(iStart);
            return result;
        }
        // recursive step
        visited.add(iStart);
        int iHopLeft = iStart - a[iStart];
        if (!visited.contains(iHopLeft)) {
            List<Integer> remainingHops = arrayHopscotchHelper(a, iHopLeft, visited);
            if (!remainingHops.isEmpty()) {
                result.add(iStart);
                result.addAll(remainingHops);
                return result;
            }
        }
        int iHopRight = iStart + a[iStart];
        if (!visited.contains(iHopRight)) {
            List<Integer> remainingHops = arrayHopscotchHelper(a, iHopRight, visited);
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
