package lists_standardlib;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Find the kth to last element in a list.
 */
public class KthToLastInList {
    private KthToLastInList() {}

    /**
     * Return the kth to last element in a list, or
     * null if the list does not contain k elements.
     *
     * @param list The list of interest.
     * @param k A positive integer.
     * @return The kth to last element in the list,
     * or null if the list does not contain k elements.
     */
    public static <T> T kthToLastInList(List<T> list, int k) {
        if (k > list.size()) {
            return null;
        }
        Iterator<T> lead = list.iterator();
        for (int i = 0; i < k - 1; ++i) {
            lead.next();
        }
        T kthFromLast = null;
        Iterator<T> lag = list.iterator();
        while (lead.hasNext()) {
            lead.next();
            kthFromLast = lag.next();
        }
        return kthFromLast;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test kthToLastInList():");
        System.out.println("=======================");

        List<Character> list = new LinkedList<>();

        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');
        list.add('f');
        list.add('g');

        TestUtils.printList(list);

        for (int k = 1; k <= 8; ++k) {
            System.out.println("kth to last element (k = "
                    + k + ") is " + kthToLastInList(list, k));
        }
    }
}
