package arrays;

import java.util.Arrays;

/**
 * Shuffle an array, as if it represented a deck of cards.
 */
public class ShuffleArray<T> {
    private static final int NUM_CARDS = 52;
    private T[] a_;

    public ShuffleArray(T[] a) {
        a_ = a;
    }

    public T[] compute() {
        for (int i = 0; i < a_.length - 1; ++i) {
            int j = random(i + 1, a_.length - 1);
            T temp = a_[i];
            a_[i] = a_[j];
            a_[j] = temp;
        }
        return a_;
    }

    /**
     * @brief Return a random int in a given closed interval [min, max].
     */
    private static int random(int min, int max) {
        int scaleFactor = max - min;
        double random0to1 = Math.random();
        double scale = random0to1 * scaleFactor;
        int roundedScale = (int)Math.round(scale);
        int offset = min + roundedScale;
        return offset;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test shuffleArray():");
        System.out.println("====================");

        Integer[] deck = new Integer[NUM_CARDS];
        for (int i = 0; i < NUM_CARDS; ++i) {
            deck[i] = i;
        }

        System.out.println("Unshuffled deck = " + Arrays.toString(deck));
        ShuffleArray<Integer> shuffleArray = new ShuffleArray<>(deck);
        for (int i = 0; i < 10; i++) {
            deck = shuffleArray.compute();
            System.out.println("Shuffled   deck = " + Arrays.toString(deck));
        }
    }
}
