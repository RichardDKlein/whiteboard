package arrays;

import java.util.Arrays;

/**
 * Shuffle an array.
 */
public final class ShuffleArray {
    private ShuffleArray() {}

    /**
     * Shuffle an array, as if it represented a deck of card.
     *
     * Algorithm: Iterate thru the array, swapping each element
     * with an element randomly chosen from the array elements
     * not yet visited.
     *
     * Running time: O(n)
     *
     * @param a The array to be shuffled.
     * @return The shuffled array.
     */
    public static int[] shuffleArray(int[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            int j = random(i + 1, a.length - 1);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        return a;
    }

    /**
     * Return a random int in a given closed interval [min, max].
     */
    /**
     * Return a random int in a given closed interval
     * [min, max].
     *
     * @param min The start of the interval.
     * @param max The end of the interval.
     * @return A random int in the closed interval [min, max].
     */
    private static int random(int min, int max) {
        int scaleFactor = max - min;
        double random0to1 = Math.random();
        double randomMinToMax = random0to1 * scaleFactor;
        int roundedRandomMinToMax = (int)Math.round(randomMinToMax);
        int offset = min + roundedRandomMinToMax;
        return offset;
    }

    public static void test() {
        final int NUM_CARDS = 52;

        System.out.println();
        System.out.println("Test ShuffleArray:");
        System.out.println("==================");

        int[] deck = new int[NUM_CARDS];
        for (int i = 0; i < NUM_CARDS; ++i) {
            deck[i] = i;
        }

        System.out.println("Unshuffled deck = " + Arrays.toString(deck));
        for (int i = 0; i < 10; i++) {
            deck = shuffleArray(deck);
            System.out.println("Shuffled   deck = " + Arrays.toString(deck));
        }
    }
}
