package java.com.whiteboard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

class RemoveDupsFromListTest {
    @Test
    public void removeDupsFromListTest() {
        System.out.println();
        System.out.println("Test RemoveDupsFromList:");
        System.out.println("========================");

        ListNode<Character> listWithDups = ListTestUtils.createList(new ArrayList<>(
                Arrays.asList('a','b','c','a','d','e','b','f','d','g','c','e','g')));

        ListNode<Character> listWithoutDups = ListTestUtils.createList(new ArrayList<>(
                Arrays.asList('a','b','c','d','e','f','g')));

        ListTestUtils.printList(listWithDups);
        System.out.println("Removing duplicates:");
        RemoveDupsFromList.removeDupsFromList(listWithDups);
        assert(ListTestUtils.listsAreEqual(listWithDups, listWithoutDups));
        ListTestUtils.printList(listWithDups);
    }
}
