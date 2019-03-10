package lists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Reverse a list.
 */
public class ReverseListRecursive {
    private ReverseListRecursive() {}

    /**
     *
     * Reverse a list.
     * @param list The list of interest.
     */
    public static <E> List<E> reverseListRecursive(List<E> list) {
        List<E> rev = new LinkedList<>();
        Iterator<E> iter = list.iterator();
        if (!iter.hasNext()) {
            return rev;
        }
        E head = iter.next();
        iter.remove();
        rev = reverseListRecursive(list);
        rev.add(head);
        return rev;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test reverseListRecursive():");
        System.out.println("============================");

        List<Character> list = new LinkedList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');
        list.add('f');
        list.add('g');
        TestUtils.printList(list);

        System.out.println("Reversing list recursively:");
        List<Character> rev = reverseListRecursive(list);
        TestUtils.printList(rev);
    }
}
