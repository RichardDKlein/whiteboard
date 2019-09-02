package arrays;

import java.util.*;

/**
 * Play a game of "array hopscotch".
 */
public final class ArrayHopscotch {
    private ArrayHopscotch() {}

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
     * We shall use a naive recursive algorithm to play the
     * game, keeping track of elements we have visited. If
     * we land on a zero, we win. If we land on an element
     * we have already visited, we are stuck in an infinite
     * loop, and we lose.
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
        Set<Integer> visitedIndices = new HashSet<>();
        return hopscotchHelper(a, iStart, visitedIndices);
    }

    private static List<Integer>
    hopscotchHelper(int[] a, int i, Set<Integer> visitedIndices) {
        List<Integer> winningHops = new ArrayList<>();
        // We landed on a zero -- we win!
        if (a[i] == 0) {
            winningHops.add(i);
            return winningHops;
        }
        // We already visited this index -- we lose
        if (visitedIndices.contains(i)) {
            return winningHops;
        }
        visitedIndices.add(i);
        int hopDistance = a[i];
        int iHopLeft = i - hopDistance;
        int iHopRight = i + hopDistance;
        List<Integer> remainingWinningHops;

        // Try hopping to the left
        if (iHopLeft >= 0) {
            remainingWinningHops = hopscotchHelper(a, iHopLeft,
                    visitedIndices);
            if (!remainingWinningHops.isEmpty()) {
                winningHops.add(i);
                winningHops.addAll(remainingWinningHops);
                return winningHops;
            }
        }
        // Try hopping to the right
        if (iHopRight < a.length) {
            remainingWinningHops = hopscotchHelper(a, iHopRight,
                    visitedIndices);
            if (!remainingWinningHops.isEmpty()) {
                winningHops.add(i);
                winningHops.addAll(remainingWinningHops);
                return winningHops;
            }
        }
        // Can't win hopping to the left or right -- we lose
        return winningHops;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test arrayHopscotch():");
        System.out.println("======================");

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
