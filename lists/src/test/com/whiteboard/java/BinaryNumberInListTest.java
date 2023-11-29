package com.whiteboard.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BinaryNumberInListTest {
    @Test
    public void binaryNumberInListTest() {
        System.out.println();
        System.out.println("Test BinaryNumberInList:");
        System.out.println("========================");

        List<ListNode<Integer>> binary = new ArrayList<>();
        binary.add(ListTestUtils.createList(Arrays.asList()));
        binary.add(ListTestUtils.createList(Arrays.asList(0)));
        binary.add(ListTestUtils.createList(Arrays.asList(1)));
        binary.add(ListTestUtils.createList(Arrays.asList(1, 0, 1, 0)));
        binary.add(ListTestUtils.createList(Arrays.asList(1, 1, 1, 1)));
        binary.add(ListTestUtils.createList(Arrays.asList(1, 0, 1, 0, 1, 0, 1, 0)));
        binary.add(ListTestUtils.createList(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1)));

        int[] decimal = {
                0,
                0,
                1,
                10,
                15,
                170,
                255
        };

        for (int i = 0; i < binary.size(); ++i) {
            int result = BinaryNumberInList.binaryNumberInList(binary.get(i));
            assert(result == decimal[i]);
            System.out.printf("binary = %s, decimal = %d\n",
                    ListTestUtils.listToString(binary.get(i)), result);
        }
    }
}
