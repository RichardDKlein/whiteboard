package java.com.whiteboard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteNodeFromListTest {
    private ArrayList<Character> listData = new ArrayList<>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g'));

    @Test
    public void deleteNodeFromListTest() {
        System.out.println();
        System.out.println("Test DeleteNodeFromList:");
        System.out.println("================");

        List<ListNode<Character>> expected = new ArrayList<>();
        expected.add(ListTestUtils.createList(Arrays.asList('b', 'c', 'd', 'e', 'f', 'g')));
        expected.add(ListTestUtils.createList(Arrays.asList('a', 'c', 'd', 'e', 'f', 'g')));
        expected.add(ListTestUtils.createList(Arrays.asList('a', 'b', 'd', 'e', 'f', 'g')));
        expected.add(ListTestUtils.createList(Arrays.asList('a', 'b', 'c', 'e', 'f', 'g')));
        expected.add(ListTestUtils.createList(Arrays.asList('a', 'b', 'c', 'd', 'f', 'g')));
        expected.add(ListTestUtils.createList(Arrays.asList('a', 'b', 'c', 'd', 'e', 'g')));
        expected.add(ListTestUtils.createList(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g')));

        System.out.println("\nOriginal list:");
        ListNode<Character> list = createTestList();
        ListTestUtils.printList(list);

        for (int i = 0; i < listData.size(); ++i) {
            System.out.println("\nDeleting Node '" + listData.get(i) + "':");
            list = createTestList();
            ListNode<Character> node = ListTestUtils.findNode(list, listData.get(i));
            boolean result = DeleteNodeFromList.deleteNodeFromList(node);
            assert(ListTestUtils.listsAreEqual(list, expected.get(i)));
            assert(result == i < listData.size() - 1);
            ListTestUtils.printList(list);
            System.out.println(result ? "SUCCESS" : "FAILURE");
        }
    }

    private ListNode<Character> createTestList() {
        return ListTestUtils.createList(listData);
    }
}
