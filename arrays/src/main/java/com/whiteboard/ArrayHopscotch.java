package com.whiteboard;

import java.util.*;

/**
 * Play a game of "array hopscotch".
 */
public final class ArrayHopscotch {
    private ArrayHopscotch() {}

    private static Set<Integer> visitedIndices = new HashSet<>();

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
     *              hopscotch.
     * @return A list containing a winning sequence of
     * indices that led to a zero. (If no such winning
     * sequence exists, then the list will be empty.)
     */
    public static List<Integer>
    arrayHopscotch(int[] a, int iStart) {
        List<Integer> winningHops = new ArrayList<>();
        if (a[iStart] == 0) {
            winningHops.add(iStart);
            return winningHops;
        }
        if (visitedIndices.contains(iStart)) {
            return winningHops;
        } else {
            visitedIndices.add(iStart);
        }

        int iHopLeft = iStart - a[iStart];
        if (iHopLeft >= 0) {
            List<Integer> remainingWinningHops = arrayHopscotch(a, iHopLeft);
            if (!remainingWinningHops.isEmpty()) {
                winningHops.add(iStart);
                winningHops.addAll(remainingWinningHops);
                return winningHops;
            }
        }
        int iHopRight = iStart + a[iStart];
        if (iHopRight < a.length) {
            List<Integer> remainingWinningHops = arrayHopscotch(a, iHopRight);
            if (!remainingWinningHops.isEmpty()) {
                winningHops.add(iStart);
                winningHops.addAll(remainingWinningHops);
                return winningHops;
            }
        }
        return winningHops;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test ArrayHopscotch:");
        System.out.println("====================");

        int[][] a = {
                {2, 3, 1, 0, 5},
                {2, 2, 2, 0, 2},
                {1, 1, 1, 3, 1, 2, 0, 3}
        };

        int[] iStart = {
                0,
                0,
                5
        };
        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(a[i]) + ", start = " + iStart[i]);
            List<Integer> winningHops = arrayHopscotch(a[i], iStart[i]);
            System.out.println("Winning hops = " + winningHops);
        }
    }
}
