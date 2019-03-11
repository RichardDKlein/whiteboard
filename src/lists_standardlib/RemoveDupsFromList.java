package lists_standardlib;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Remove duplicates from a list.
 */
public class RemoveDupsFromList {
    private RemoveDupsFromList() {}

    /**
     * Remove duplicates from a list.
     * @param list The list of interest.
     */
    public static <E> void removeDupsFromList(List<E> list) {
        HashSet<E> seen = new HashSet<>();
        Iterator<E> iter = list.iterator();
        while (iter.hasNext()) {
            E element = iter.next();
            if (seen.contains(element)) {
                iter.remove();
            } else {
                seen.add(element);
            }
        }
    }

    public static void test() {
        System.out.println();
        System.out.println("Test removeDupsFromList():");
        System.out.println("==========================");

        List<Character> list = new LinkedList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('a');
        list.add('d');
        list.add('e');
        list.add('b');
        list.add('f');
        list.add('d');
        list.add('g');
        list.add('c');
        list.add('e');
        list.add('g');
        TestUtils.printList(list);

        System.out.println("Removing duplicates:");
        removeDupsFromList(list);
        TestUtils.printList(list);
    }
}
