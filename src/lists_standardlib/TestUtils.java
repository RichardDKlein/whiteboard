package lists_standardlib;

import java.util.List;

/**
 * Test utilities for the lists_standardlib package.
 */
public class TestUtils {
    private TestUtils() {}

    public static <T> void printList(List<T> list) {
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
}
