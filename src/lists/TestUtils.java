package lists;

import java.util.List;

/**
 * Test utilities for the lists package.
 */
public class TestUtils {
    private TestUtils() {}

    public static <E> void printList(List<E> list) {
        boolean atHead = true;
        for (E element : list) {
            if (!atHead) {
                System.out.print("->");
            } else {
                atHead = false;
            }
            System.out.print(element);
        }
        System.out.println();
    }

    public static <E> void printList(List<E> list, int max) {
        int count = 0;
        boolean atHead = true;
        for (E element : list) {
            if (!atHead) {
                System.out.print("->");
            } else {
                atHead = false;
            }
            System.out.print(element);
            ++count;
            if (count >= max) {
                break;
            }
        }
        System.out.println();
    }
}
