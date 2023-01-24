package java.com.whiteboard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthToLastInListTest {
    @Test
    public void kthToLastInListTest() {
        System.out.println();
        System.out.println("Test KthToLastInList:");
        System.out.println("=====================");

        List<Character> listData = new ArrayList<>(Arrays.asList(
                'a','b','c','d','e','f','g'));
        ListNode<Character> list = ListTestUtils.createList(listData);

        ListTestUtils.printList(list);

        for (int k = 1; k <= 8; ++k) {
            ListNode<Character> kthToLast = KthToLastInList.kthToLastInList(list, k);
            if (k == 8) {
                assert(kthToLast == null);
            } else {
                assert(kthToLast.data == listData.get(listData.size() - k));
            }
            System.out.println("kth to last element (k = " + k + ") is " +
                    ((kthToLast != null) ? kthToLast.data : "undefined"));
        }
    }
}
