package lists_homegrown;

import lists_standardlib.TestUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Reverse a list.
 */
public class ReverseListIterative {
    private ReverseListIterative() {}

    /**
     *
     * Reverse a list.
     * @param list The list of interest.
     */
    public static <E> List<E> reverseListIterative(List<E> list) {
        List<E> rev = new LinkedList<>();
        ListIterator<E> iter = list.listIterator(list.size());
        while (iter.hasPrevious()) {
            E previous = iter.previous();
            rev.add(previous);
        }
        return rev;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test reverseListIterative():");
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

        System.out.println("Reversing list iteratively:");
        List<Character> rev = reverseListIterative(list);
        TestUtils.printList(rev);
    }
}
